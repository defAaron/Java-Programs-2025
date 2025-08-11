/**
 * The program below is a Student Grades Application that simulates a grade 
 * book for a class with 30 students who each have four test scores.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-01
 */

//importing Scanner class for user input
import java.util.Scanner;

public class MyProgram
{
    public static void main(String[] args)
    {
        //create scanner object
        Scanner scanner = new Scanner(System.in);
        
        //define string array students to hold up to 30 rows and 6 columns
        String [][] students = new String[30][6];
        
        //define string array grades to hold up to 4 strings
        String[] grades = new String[4];
        
        //define integer variable count for tracking number of students
        int count = 0;
        
        //define integer variable validGrades for verifying wh
        boolean validGrades = true;
        
        //define boolean variable repeat to control menu loop
        boolean repeat = true;

        //print welcome message
        System.out.println("Welcome to Aaron's Student Grades Application");
        System.out.println("---------------------------------------------\n");
        
        //main loop that runs until user choose to exit
        while(repeat)
        {
            //print menu options
            menuOption();
            
            //define integer variable choice to store user option choice as an integer
            int choice;
            
            //define string variable input to read user option choice as a string
            String input = scanner.nextLine();
            
            //try converting user input to integer
            try
            {
                choice = Integer.parseInt(input);
            }
            
            //handle invalid input exceptions
            catch(NumberFormatException e)
            {
                System.out.println("Invalid input, please enter a number from 1 to 5.\n\n");
                continue;
            }
            
            //for each menu option
            switch(choice)
            {
                //list option
                case 1:

                    //if no students are in array
                    if(count == 0)
                    {
                        //notify user
                        System.out.println("Sorry, there aren't any students added yet. Try adding a few students.\n\n");
                        break;
                    }
                   
                    //if there are students in array
                    else
                    {
                        //print out header for list
                        System.out.println("\nStudent-Grade List");
                        System.out.println("------------------");
                       
                        //loop for retrieving student names and grades
                        for(int i = 0; i < count; i++)
                        {
                            //defining a string array variable to extract one row from the array at a time and printing it in the output
                            String[] x = students[i];
                            System.out.println(x[0] + ", " + x[1] + ", " + x[2] + ", " + x[3] + ", " + x[4] + ", " + x[5]);
                        }
                    }
                    //exit case
                    break;
                    
                //add option
                case 2:
                    
                    //if maximum students already reached
                    if(count >= 30)
                    {
                        //notify user that the class is full
                        System.out.println("Sorry, the class list is full, you cannot add anymore students.\n\n");
                        
                        //exit case
                        break;
                    }
                    
                    //prompt user for first name and store within string variable fireName
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine().trim();
                    
                    //prompt user for last name and store within string variable lastName
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine().trim();
                    
                    //if user enters blank space
                    if(firstName.isEmpty() || lastName.isEmpty())
                    {
                        System.out.println("You left a required piece of information empty.\n\n");
                        break;
                    }
                    
                    //defining boolean variable isInArray to check if student already exists
                    boolean isInArray = false;
                    
                    //check if student already exists using a loop that goes through the whole array
                    for(int i = 0; i < count; i++)
                    {
                        if(students[i][0].equalsIgnoreCase(firstName) && students[i][1].equalsIgnoreCase(lastName))
                        {
                            //if student already exists then end loop
                            isInArray = true;
                            break;
                        }
                    }
                    
                    //if student already exists then notify user and exit case
                    if(isInArray)
                    {
                        System.out.println("Student already exists.\n\n");
                        break;
                    }
                    
                    //loop for user to enter grades
                    for(int i = 0; i < 4; i ++)
                    {
                        //prompt user to enter grades and store in string variable gradeInput
                        System.out.print("Grade " + (i + 1) + ": ");
                        String gradeInput = scanner.nextLine().trim();
                        
                        //if user input is invalid
                        if(gradeInput.isEmpty() || !validInput(gradeInput))
                        {
                            //notify user
                            System.out.println("Invalid input, you must enter a valid number for grades.\n\n");
                            
                            //set validGrades to false
                            validGrades = false;
                            
                            //exit loop
                            break;
                        }
                        
                        //store gradeInput inside array
                        grades[i] = gradeInput.trim();
                    }
                    
                    //if valid input
                    if(validGrades)
                    {
                        //store firstName and lastName in array
                        students[count][0] = firstName;
                        students[count][1] = lastName;
                        
                        //copy the 4 grades from the grades array into the students array
                        System.arraycopy(grades, 0, students[count], 2, 4);
                        
                        //increase count by 1
                        count++;
                        
                        //user input validation
                        System.out.println("Got that, " + firstName + " " + lastName + " was successfully added to the list.\n\n");
                    }
                    
                    //exit case
                    break;
                    
                //student average option
                case 3:
                
                    //prompt user for first name and store in string variable findFirstName
                    System.out.print("First name: ");
                    String findFirstName = scanner.nextLine().trim();
                    
                    //prompt user for last name and store in string variable findLastName
                    System.out.print("Last name: ");
                    String findLastName = scanner.nextLine().trim();
                    
                    //define boolean variable isFound for checking if student exists in array
                    boolean isFound = false;
                
                    //loop for verifying if student exists
                    for(int i = 0; i < count; i++)
                    {
                        //if student exists
                        if(students[i][0].equalsIgnoreCase(findFirstName) && students[i][1].equalsIgnoreCase(findLastName))
                        {
                            //define double variable total and assign it a value of 0
                            double total = 0;
                            
                            //loop for calculating total
                            for(int j = 2; j < 6; j++)
                            {
                                //add all grades of student and assign total to that value
                                total += Double.parseDouble(students[i][j]);
                            }
                            
                            //define double variable average equal to total over 4
                            double average = total / 4.0;
                            
                            //output statement with student's average
                            System.out.println(findFirstName + " " + findLastName + "'s average is " + average + "%\n\n");
                            
                            //set isFound to true and end loop
                            isFound = true;
                            break;
                        }
                    }
                    
                    //if student does not exist
                    if(!isFound)
                    {
                        //notify user that student does not exist
                        System.out.println("Sorry, we couldn't find that student.\n\n");
                    }
                
                    //exit case
                    break;
                
                //course average option
                case 4:
                    
                    //if no students are in array
                    if(count == 0)
                    {
                        //notify user
                        System.out.println("Sorry, there aren't any students added yet. Try adding a few students.\n\n");
                        break;
                    }
                    
                    //define double variable sum and assign it a value of 0
                    double sum = 0;
                    
                    //loop for calculating student total
                    for(int i = 0; i < count; i++)
                    {
                        //define double variable sTotal for storing student total
                        double sTotal = 0;
                        
                        //loop for calculating sum of all grades
                        for(int j = 2; j < 6; j++)
                        {
                            //add all grades of students
                            sTotal += Double.parseDouble(students[i][j]);
                        }
                        
                        //calculate total sum per course
                        sum += sTotal / 4.0;
                    }
                    
                    //define double variable courseAverage equal to total sum over number of students
                    double courseAverage = sum / count;
                    
                    //print course average in output
                    System.out.println("Course average is " + courseAverage +"\n\n");
                    
                    //exit case
                    break;
                
                case 5:
                    //set repeat to false to end loop
                    repeat = false;
                    
                    //print goodbye message
                    System.out.println("Thank you for using Aaron's Student Grades Application! See you next time!");
                    
                    //exit loop
                    break;
                
                default:
                    //default invalid input handler
                    System.out.println("Invalid input, please enter a number from 1 to 5.\n\n");
            }
        }
    }
    
    /**
     * Prints a menu for the user to view options that they can choose from
     * pre: none
     * post: prints the menu
     */
    public static void menuOption()
    {
        //print options
        System.out.println("\nWhat would you like to do?");
        System.out.println("   1) List all students and their grades.");
        System.out.println("   2) Add student and their grades.");
        System.out.println("   3) Show a student's average.");
        System.out.println("   4) Show course average.");
        System.out.println("   5) Exit Program.");
        System.out.print("\nOption: ");
    }

    /**
     * Checks whether or not user input is valid
     * @param string variable str
     * @return true or false
     * pre: str is created
     * post: returns false if exception otherwise returns true
     */
    public static boolean validInput(String str)
    {
        //try converting to double and return true
        try
        {
            Double.parseDouble(str);
            return true;
        }
        
        //handle exception and return false
        catch(NumberFormatException e)
        {
            return false;
        }
    }
}
