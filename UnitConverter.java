import java.util.InputMismatchException;
import java.util.Scanner;

public class UnitConverter {
	
	//Arrays for units divided into their proper categories for measurement
	public final static String[] LENGTH = {"meters", "feet", "kilometers", "miles"};
	public final static String[] WEIGHT = {"kilograms", "pounds", "grams", "ounces"};
	public final static String[] TEMPERATURE = {"celsius", "fahrenheit", "kelvin"};
	public final static String[] CURRENCY = {"usd", "eur", "bitcoin"};
	public final static String[] SPEED = {"mph", "kmph"};
	public final static String[] VOLUME = {"liters", "gallons", "ounces"};
	
	//2D array for holding all arrays for future method use
	public final static String[][] UNITARR = {LENGTH, WEIGHT, TEMPERATURE, CURRENCY, SPEED, VOLUME};
	
	//main method just runs the runInterface method for executing the program with the methods
	public static void main(String[] args) {
		runInterface();
    }
	
	//convert will be the method for converting every possible unit conversion that is valid
	// if not valid, the program will throw an exception for the interface to catch
	public static double convert(String fromUnit, String toUnit, double value)
        throws InvalidConversionUnitException 
	{
		//initialize a value to be returned, giving this value -1.0 will make it obvious for when
		// a conversion has gone wrong
    	double newValue = -1.0;
		
    	
    	// to ensure that no negative values are entered for a weight conversion, 
    	//  nor a currency conversion, we must check if the units are in weight or currency,
    	//   then throw an exception if they are negative.
    	for(String item : WEIGHT) {
    		if(fromUnit.trim().equalsIgnoreCase(item) && value < 0) 
    			throw new IllegalArgumentException("Error: value cannot be negative.");
    	}
    	for(String item : CURRENCY) {
    		if(fromUnit.trim().equalsIgnoreCase(item) && value < 0) 
    			throw new IllegalArgumentException("Error: value cannot be negative.");
    	}
    	
    	
    	// additionally, we must check if the units are the same; in which case, the method throws
    	//  an exception for the interface to catch
    	if(fromUnit.trim().equalsIgnoreCase(toUnit.trim())) {
    		throw new InvalidConversionUnitException("Error: Cannot convert to the same unit");
    	}
    	
    	// if the units pass all of the previous tests, we move on to check if the units are
    	//  actually valid
		if(isValidUnit(fromUnit)) {
			if(isValidUnit(toUnit)) {
				
				// as long as both units are valid units, all that is left to check is if the
				//  units can convert into each other
				if(isValidConversion(fromUnit, toUnit)) {
					// if they can, then we can finally look for the correct conversion case
					
					
					//now, to check every single possible case for each conversion
						
					//lengths:
					//         meters
					if(fromUnit.equalsIgnoreCase(LENGTH[0].toString()))
					{	
							
						// meters to feet
						if(toUnit.equalsIgnoreCase(LENGTH[1].toString())) newValue = value * 3.28084;
							
						// meters to kilometers
						else if(toUnit.equalsIgnoreCase(LENGTH[2].toString())) newValue = value / 1000.0;
							
						// meters to miles
						else if(toUnit.equalsIgnoreCase(LENGTH[3].toString())) newValue = value / 1609.344;
							
					}
						
					//         feet
					else if(fromUnit.equalsIgnoreCase(LENGTH[1].toString())) 
					{	
							
						// feet to meters
						if(toUnit.equalsIgnoreCase(LENGTH[0].toString())) newValue = value * .3048;
							
						// feet to kilometers
						else if(toUnit.equalsIgnoreCase(LENGTH[2].toString())) newValue = value * .0003048;
							
						// feet to miles
						else if(toUnit.equalsIgnoreCase(LENGTH[3].toString())) newValue = value / 5280;
							
					}
						
					//        kilometers
					else if(fromUnit.equalsIgnoreCase(LENGTH[2].toString())) 
					{	
							
						// kilometers to meters
						if(toUnit.equalsIgnoreCase(LENGTH[0].toString())) newValue = value * 1000;
							
						// kilometers to feet
						else if(toUnit.equalsIgnoreCase(LENGTH[1].toString())) newValue = value * 3280.84;
							
						// kilometers to miles
						else if(toUnit.equalsIgnoreCase(LENGTH[3].toString())) newValue = value / 1.609344;
							
					}
						
						//        miles
					else if(fromUnit.equalsIgnoreCase(LENGTH[3].toString())) 
					{	
							
						// miles to meters
						if(toUnit.equalsIgnoreCase(LENGTH[0].toString())) newValue = value * 1609.344;
							
						// miles to feet
						else if(toUnit.equalsIgnoreCase(LENGTH[1].toString())) newValue = value * 5280;
							
						// miles to kilometers
						else if(toUnit.equalsIgnoreCase(LENGTH[2].toString())) newValue = value * 1.609344;
							
					}
					//  ========= completely checked for length units =========
						
					//weights:
					//         kilograms
					if(fromUnit.equalsIgnoreCase(WEIGHT[0].toString())) {
							
						// kilograms to pounds
						if(toUnit.equalsIgnoreCase(WEIGHT[1].toString())) newValue = value * 2.20462;
							
						// kilograms to grams
						else if(toUnit.equalsIgnoreCase(WEIGHT[2].toString())) newValue = value * 1000;
							
						// kilograms to ounces
						else if(toUnit.equalsIgnoreCase(WEIGHT[3].toString())) newValue = value * 35.274;
					}
						
					//         pounds
					else if(fromUnit.equalsIgnoreCase(WEIGHT[1].toString())) {
							
						// pounds to kilograms
						if(toUnit.equalsIgnoreCase(WEIGHT[0].toString())) newValue = value / 2.20462;
							
						// pounds to grams
						else if(toUnit.equalsIgnoreCase(WEIGHT[2].toString())) newValue = value * 453.592;
							
						// pounds to ounces
						else if(toUnit.equalsIgnoreCase(WEIGHT[3].toString())) newValue = value  * 16;
					}
						
					//         grams
					else if(fromUnit.equalsIgnoreCase(WEIGHT[2].toString())) {
							
						// grams to kilograms
						if(toUnit.equalsIgnoreCase(WEIGHT[0].toString())) newValue = value / 1000;
							
						// grams to pounds
						else if(toUnit.equalsIgnoreCase(WEIGHT[1].toString())) newValue = value / 453.592;
							
						// grams to ounces
						else if(toUnit.equalsIgnoreCase(WEIGHT[3].toString())) newValue = value / 28.35;
					}
						
					//         ounces
					else if(fromUnit.equalsIgnoreCase(WEIGHT[3].toString())) {
							
						// ounces to kilograms
						if(toUnit.equalsIgnoreCase(WEIGHT[0].toString())) newValue = value / 35.274;
							
						// ounces to pounds
						else if(toUnit.equalsIgnoreCase(WEIGHT[1].toString())) newValue = value / 16;
							
						// ounces to grams
						else if(toUnit.equalsIgnoreCase(WEIGHT[2].toString())) newValue = value * 28.35;
					}
						
					//  ========= completely checked for weight units =========
						
					//temperatures:
					//         celsius
					if(fromUnit.equalsIgnoreCase(TEMPERATURE[0].toString()))
					{	
							
						// celsius to fahrenheit
						if(toUnit.equalsIgnoreCase(TEMPERATURE[1].toString())) newValue = (value * (9/5)) + 32;
							
						// celsius to kelvin
						else if(toUnit.equalsIgnoreCase(TEMPERATURE[2].toString())) newValue = value + 273.15;
							
							
					}
						
					//         fahrenheit
					else if(fromUnit.equalsIgnoreCase(TEMPERATURE[1].toString()))
					{	
							
						// fahrenheit to celsius
						if(toUnit.equalsIgnoreCase(TEMPERATURE[0].toString())) newValue = (value * (5/9)) - 32;
							
						// fahrenheit to kelvin
						else if(toUnit.equalsIgnoreCase(TEMPERATURE[2].toString())) newValue = ((value * (5/9)) - 32) + 273.15;
							
					}
						
					//         kelvin
					else if(fromUnit.equalsIgnoreCase(TEMPERATURE[2].toString()))
					{	
							
						// kelvin to celsius
						if(toUnit.equalsIgnoreCase(TEMPERATURE[0].toString())) newValue = value - 273.15;
							
						// kelvin to fahrenheit
						else if(toUnit.equalsIgnoreCase(TEMPERATURE[1].toString())) newValue = ((value - 273.15) * (9/5)) + 32;
							
							
					}
						
					//  ========= completely checked for temperature units =========
						
					//currencies:
					//         usd
					if(fromUnit.equalsIgnoreCase(CURRENCY[0].toString()))
					{	
							
						// usd to eur
						if(toUnit.equalsIgnoreCase(CURRENCY[1].toString())) newValue = value * 0.86;
							
						// usd to bitcoin
						else if(toUnit.equalsIgnoreCase(CURRENCY[2].toString())) newValue = value * 0.000014;
					}
					
					//         eur
					else if(fromUnit.equalsIgnoreCase(CURRENCY[1].toString()))
					{	
							
						// eur to usd
						if(toUnit.equalsIgnoreCase(CURRENCY[0].toString())) newValue = value / 0.86;
							
						// eur to bitcoin
						else if(toUnit.equalsIgnoreCase(CURRENCY[2].toString())) newValue = value * 0.000016;
							
							
					}
						
					//         bitcoin
					else if(fromUnit.equalsIgnoreCase(CURRENCY[2].toString()))
					{	
							
						// bitcoin to usd
						if(toUnit.equalsIgnoreCase(CURRENCY[0].toString())) newValue = value / 0.000014;
							
						// bitcoin to eur
						else if(toUnit.equalsIgnoreCase(CURRENCY[1].toString())) newValue = value / 0.000016;
							
							
					}
						
					//  ========= completely checked for currency units =========
						
					//speeds:
					//         mph
					if(fromUnit.equalsIgnoreCase(SPEED[0].toString()) && 
							toUnit.equalsIgnoreCase(SPEED[1].toString())) newValue = value * 1.60934;
						
					//         kmph
					else if(fromUnit.equalsIgnoreCase(SPEED[1].toString()) && 
							toUnit.equalsIgnoreCase(SPEED[0].toString())) newValue = value / 1.60934;
						
					//  ========= completely checked for currency units =========
					
					//volumes:
					//         liters
					if(fromUnit.equalsIgnoreCase(VOLUME[0].toString()))
					{	
							
						// liters to gallons
						if(toUnit.equalsIgnoreCase(VOLUME[1].toString())) newValue = value / 3.78541;
							
						// liters to ounces
						else if(toUnit.equalsIgnoreCase(VOLUME[2].toString())) newValue = value * 33.814;
							
							
					}
						
					//         gallons
					else if(fromUnit.equalsIgnoreCase(VOLUME[1].toString()))
					{	
							
						// gallons to liters
						if(toUnit.equalsIgnoreCase(VOLUME[0].toString())) newValue = value * 3.78541;
							
						// gallons to ounces
						else if(toUnit.equalsIgnoreCase(VOLUME[2].toString())) newValue = value * 128;
							
							
					}
						
					//         ounces
					else if(fromUnit.equalsIgnoreCase(VOLUME[2].toString()))
					{	
							
						// ounces to liters
						if(toUnit.equalsIgnoreCase(VOLUME[0].toString())) newValue = value / 33.814;
							
						// ounces to gallons
						else if(toUnit.equalsIgnoreCase(VOLUME[1].toString())) newValue = value / 128;
							
							
					}
						
					//  ========= completely checked for temperature units =========
						
						
				}
				else {
						throw new InvalidConversionUnitException("Error: Incompatible unit types.");
				}
			}
			// if the unit to be converted into is not valid, output the error message with the 
			//  converted unit as the one that caused the program to break
			else {
					throw new InvalidConversionUnitException("Error: Invalid Unit Entered: " + toUnit);
			}
		}
		// if the initial unit is not valid, output the error message with the initial unit
		//  as the one that caused the program to break
		else {
			throw new InvalidConversionUnitException("Error: Invalid Unit Entered: " + fromUnit);
		}
				
		// at the very end of the convert method, we return the newValue that is our converted
		//  value
		return newValue;
		
    }

    public static boolean isValidUnit(String unit) {
    	
    	int validity = -1;
    	// start loop by going through each array in UNITARR
    	for(String[] arr : UNITARR) {
    		
    		// on the specific array, go through each unit type for the given array
    		//   if the array has the specified unit, break the inner loop and increment validity
    		for(String data : arr) {
    			if(unit.trim().equalsIgnoreCase(data)) {
        			validity++;
        			break;
        		}
    		}
    		// in any case that validity is anything higher than -1, the unit was found in one of 
    		//  the arrays containing a valid unit; so, the outer loop must be broken in that case
    		if(validity > -1) break;
    	}
    	// once breaking out a second time, do the same comparison to verify the unit's validity
    	//  (see what I did there) and return true if validity was incremented
    	if(validity > -1) return true;
    	
    	//if the loops ran and validity was never incremented, the method will return false
    	else return false;
    }

    public static boolean isValidConversion(String fromUnit, String toUnit) {
    	int found = 0;
    	// this method will follow a similar structure to isValidUnit's structure
    	
    	// first, implement a for each loop using the father array for unit types
    	for(String[] arr : UNITARR) {
    		// Now, we need to search each individual array to see if the array has the two units
    		//  in the same array. If so, these units are compatible for conversion; otherwise, the
    		//  units cannot be used for conversion
    		
    		// for the searching, we will use another for each loop
    		for(String unit : arr) {
    			
    			// to see if the convert-from unit is in the array, use an if-statement that checks 
    			//  the current unit type in the array
    			
    			//    if the unit type is in the array, increment the found variable
    			if(unit.equalsIgnoreCase(fromUnit.trim())) {
    				found++;
    			}
    			// to see if the convert-to unit is in the array, use the same logic as above in 
    			//  the same if-statement, but with the convert-to unit
    			
    			//   if the unit type is in the array, increment the found variable by two so as to
    			//     ensure that if the first variable were found twice, this method will not return
    			//       true
    			//*the above case will never happen with these unit arrays, but I just wanted to be
    			//* extra careful
    			else if(unit.equalsIgnoreCase(toUnit.trim())) {
    				found += 2;
    			}
    		}
    		// if the found variable is 3, then both variables were found; in this case, we break
    		//  the loop and proceed to the next loop to break
    		if(found == 3) {
    			break;
    		}
    		// if the found variable is anything else, return the found variable to zero and search 
    		//  the next array for the units
    		else {
    			found = 0;
    		}
    	}
    	
    	// repeat the same logic to ensure nothing goes wrong with detecting both variables
    	//  if the variable is 3, then both were found in a compatible array, meaning the 
    	//   conversion is valid
    	if(found == 3) return true;
    	
    	// otherwise, the conversion is not valid and the method will return false
    	else return false;
    	
    }
    
    // now, for our runner method: runInterface
    //   all this method does is declare a scanner object, 
    //    print out welcome messages, print out results, catch exceptions, 
    //     and print out closing remarks before closing the scanner object
    public static void runInterface() {
    	
    	// start by declaring a scanner object, input
    	Scanner input = new Scanner(System.in);
    	
    	// next, initialize the result a -1.0 value
    	//  this makes it to where a mistake is obvious and only returns the appropriate value
    	//   if all goes correctly in the program
		double result = -1.0;
		
		// then, print out welcome messages and directions to the user
		System.out.println("===== Welcome to the Unit Converter Program! =====\n");
		System.out.println("===== Directions:                            =====\n");
		System.out.println("===== Start your command line with the word  =====");
		System.out.println("=====  \"convert\" to convert, followed by a   =====");
		System.out.println("===== start unit, then a unit to convert to, =====");
		System.out.println("===== and finally the value to be converted. =====\n");
		System.out.println("=====  to exit, enter the word \"exit\"        =====");
		System.out.println("=====                                        =====\n");
    	
		// now, begin looping through the conversion sequence of inputs and outputs
		while(true) {
			// keeping the try and catch blocks within the while loop keeps the program
			//  going as long as the user does not enter exit
    		try {
    			
    			// prompt the user for input
	    		System.out.print("Please enter a command: ");
	    		// should be 'convert <fromUnit> <toUnit> <value>
	    		
	    		// initialize a String value for the first word (usually convert, but exit if 
	    		//  user enters "exit")
	    		String convComm = input.next();
	    		
	    		// logic for exiting upon exit command
	    		if(convComm.trim().equalsIgnoreCase("exit")) {
	    			break;
	    		}
	    		
	    		// if exit is not the first word or only word entered, the method continues
	    		else {
	    			// begin initializing the units and value as the appropriate data types
		    		String givenUnit = input.next();
		    		String calcUnit = input.next();
		    		double val = input.nextDouble();   
		    		
		    		// clear scanner after
		    		input.nextLine();
		    		
		    		
		    		
		    		
		    		// now convert the units using the convert method and assign that value to result
		    		result = convert(givenUnit, calcUnit, val);
		    		// if anything goes wrong with the input values, this is typically
		    		//  where the program will break and catch the exception thrown
		    		
		    		
		    		// After converting, print out the results in the following format:
		    		// <entered numeric value> + <initial unit> = <calculated result> <final unit>
		    		System.out.println(val + " " + givenUnit + " = " + result + " " + calcUnit);
		    		System.out.println();
		    		
		    		// notify user that a conversion has been completed and continue to the next
		    		System.out.println("=====          Conversion Complete!          =====\n");
	    		}
    		}
    		
    		// catch blocks for any exceptions thrown previously
    		//   all exceptions call for their error message to be printed
    		catch(InvalidConversionUnitException icue){
    			System.err.println(icue);
    		}
    		catch(InputMismatchException ime) {
    			System.err.println(ime + "Error: invalid numeric value.");
    			// this catch clears the scanner because otherwise the messages would continue printing
    			input.nextLine();
    		}
    		catch(IllegalArgumentException iae) {
    			System.err.println(iae);
    		}
    			
    	}
		// in the case that the user enters exit, we print another line,
		System.out.println();
		// then thank the user,
    	System.out.println("***** Thank you for converting using the unit converter! *****");
    	// then close the scanner.
    	input.close();
    	
    	// thank you for reading, sorry if it was a bit excessive in the convert method.
    }

    

}