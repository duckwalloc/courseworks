// create a custom exception for when a unit is not supported or the conversion is not valid
public class InvalidConversionUnitException extends Exception {
	public InvalidConversionUnitException(String message) {
		super(message);
	}
}
