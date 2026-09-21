# define a function to ask for the input file
def ask():
    # take a file from input for what needs to be done
    infile = input("Enter a file with your tasks for the day \n(please make sure the task is separated with a 'return' character)\n")

    # returns the inputted file name
    return infile

# define a function to create the list
def create_list(file):
    # create a list from the given file
    tasks = []

    # open and read the given file
    infile = open(file, "r")
    
    # dummy value to skip a blank line in output
    rei = 0

    # create value "line" to represent any lines in the text file to be read/considered
    line = infile.readline()

    # create a while loop that adds each line until there are no more lines in the file
    while line != "":
        # prevent blank lines from being counted using dummy value
        if line == "\n":
            # increments dummy value as blank statement, effectively skipping the line
            rei += 1

        # append any other lines
        else:
            tasks.append(line)

        # continue to the next line
        line = infile.readline()

    # close the input file once the file is completely read
    infile.close()

    # return the list of tasks
    return tasks

    
# define a void function to print the tasks in the form of a visual list for users
def create_checklist(list_samp):
    # iterates through each list item using the parameter list and prints the task in the correct format
    for item in list_samp:
        print(f'* {item}')

# define a function to update the checklist of tasks when the tasks are completed
def update_checklist(list_new):
    # takes the task list as a parameter

    # initialize the task number as one to start with "Task 1"
    i = 1

    # initialize an empty list to store all the indices of tasks that were completed
    beRemoved = []

    # use a for loop to ask if each task has been completed
    for item in list_new:

        # take an input
        check = input(f'\nHas task {i} been completed? ')

        # if the input starts with y, add the index of the iterated task to the list of tasks to be removed and increment i
        if check[0] == 'y':

            # print that the task was completed
            print(f'\nTask "{item}" is done.')
            beRemoved.append(i-1)
            
            i += 1

        # if the input starts with anything else, the task is assumed to be incomplete and only increment i     
        else:

            # print that the task still needs to be completed
            print(f'\nTask "{item}" needs to be done.\n')
            i += 1

    # iterate throught the removal list backwards
    # this will prevent the list index from being out of range after deleting a prior task
    # to do this, the range will have to start at the final item, end an item before the start of the list, and decrement by 1
    for i in range(len(beRemoved)-1, -1, -1):

        # remove the item in the list at the given index in the removal list
        list_new.pop(beRemoved[i])

    # clear the removal list for the next update
    beRemoved = []

    # print a line to signify that the tasks have been checked for completion
    print('--------------------------------------------------------------------------------')

    # if/else statement checks if there are still tasks to be completed
    if len(list_new) == 0:

        # if there are no remaining tasks, add the ending string to the list
        list_new.append('xxxxxxx')

    # otherwise, create a new checklist with the remaining tasks
    else:

        print(f'Remaining Tasks: \n')

        create_checklist(list_new)

# this function combines all the previous functions defined
def checklist():

    # get the input file
    new = ask()

    # create the list of tasks with the input file
    user_tasks = create_list(new)

    # print the checklist
    create_checklist(user_tasks)

    # and continue updating the checklist until the ending string is added
    while user_tasks[0] != 'xxxxxxx':

        update_checklist(user_tasks)

        print()
    # once all the tasks are completed and the while loop is broken, congratulate the user on completion
    print('All tasks completed! \nGood Job!')
    
        
    

# create the main function to call the previous function
def main():

    checklist()

# call the main function
if __name__ == "__main__":
    main()
