/**
 * This program is an employee records program that can add, remove, and list
 * any employees to a database, and prompts the user for information about the
 * employee such as their id, first and last name, salary, and start date.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-06
 */


//import all utility classes for program use
import java.util.*;
//import all text formatting classes for using SimpleDateFormat
import java.text.*;

public class MyProgram
{
    //define scanner object for user input
    private static Scanner scanner = new Scanner(System.in);
    
    //define new arraylist to store employee objects
    private static ArrayList<Employee> employees = new ArrayList<>();
    
    public static void main(String[] args)
    {
        //define boolean variable repeat to control main loop
        boolean repeat = true;
        
        //print welcome message
        System.out.println("Welcome to Aaron's Employee Records Program");
        System.out.println("-------------------------------------------\n");
            
        //loop for running program
        while(repeat)
        {
            //display menu options
            System.out.println("1)   Add an employee.");
            System.out.println("2)   Remove an employee.");
            System.out.println("3)   List all employees.");
            System.out.println("4)   Exit program.");
            System.out.print("Option: ");
            
            //try converting user input to integer
            try
            {
                //define integer variable choice to store menu option choice from user
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                switch(choice)
                {
                    //add employee
                    case 1:
                        addEmployee();
                        break;   
                        
                    //remove employee
                    case 2:
                        removeEmployee();
                        break;
                        
                    //list all employees
                    case 3:
                        listEmployee();
                        break;
                        
                    //exit program
                    case 4:
                        //print goodbye message and end loop
                        System.out.println("\n\nSee you next time, goodbye!");
                        repeat = false;
                        break;
                        
                    //handle invalid number from user
                    default:
                    
                        System.out.println("\nInvalid input, please enter a number from 1 to 4.\n");
                    
                }
            }
            
            //invalid input handle
            catch(NumberFormatException e)
            {
                System.out.println("\nInvalid input, please enter a number from 1 to 4.\n");
            }
        }
    }
    
    /**
     * Prompts user for adding an employee
     * pre: none
     * post: adds new employee
     */
    private static void addEmployee()
    {
        //define integer variable id to store id
        int id = 0;
        
        //define string variable firstName to store first name
        String firstName = "";
        
        //define string variable lastName to store last name
        String lastName = "";
        
        //define double variable salary to store salar
        double salary = 0.0;
        
        //define string variable date to store date
        String date = "";
        
        System.out.println("\nEmployee ID: ");
        
        //loop for vaildating employee id input
        while(true)
        {
            try
            {
                //set id to input that is trying to be converting to integer
                id = Integer.parseInt(scanner.nextLine().trim());
                
                //define boolean variable exists to check if id already exists
                boolean exists = false;
                
                //loop through employees arraylist
                for(Employee x : employees)
                {
                    //if id matches
                    if(x.getEmployeeIdNumber() == id)
                    {
                        //notify user and try again
                        System.out.println("\nSorry, that employee ID already exists.\n\n");
                        exists = true;
                        break;
                    }
                }
                
                //if id doesn't match
                if(!exists)
                {
                    //exit loop
                    break;
                }
            }
        
            //handle invalid input
            catch(NumberFormatException e)
            {
                System.out.println("\nInvalid input, please enter a valid number.\n");
            }
        }
        
        //first name input
        while(true)
        {
            System.out.print("First name: ");
            firstName = scanner.nextLine();
            break;
        }
        
        //last name input
        while(true)
        {
            System.out.print("Last name: ");
            lastName = scanner.nextLine();
            break;
        }
           
        //loop for validating salary input 
        while(true)
        {
            System.out.print("Annual Salary: ");
            
            try
            {
                //set salary to input that is trying to be converted to double
                salary = Double.parseDouble(scanner.nextLine());
                break;
            }
            
            //handle invalid input
            catch(NumberFormatException e)
            {
                System.out.println("\nInvalid input, please enter a valid number.\n");
            }
        }
            
        //loop for validating date input
        while(true)
        {
            System.out.print("Start date in mm/dd/yyyy format: ");
            date = scanner.nextLine();
                
            //call method for validating date
            if(validateDateInput(date))
            {
                break;
            }
            
            //if date does not match expected format
            else
            {
                System.out.println("\nInvalid input, please enter the date in the correct format.\n");
            }
        }
        
        //add new employee to list and notify user
        employees.add(new Employee(id, firstName, lastName, salary, date));
        System.out.println("\nGot that, employee was successfully added!");
    }
    
    /**
     * Prompts user for removing an employee
     * pre: none
     * post: removes an employee
     */
    private static void removeEmployee()
    {
        System.out.println("\nEnter the ID of the employee you would like to remove: ");
        
        //define string variable removeId to store id of employee to be removed
        String removeId = scanner.nextLine();
        
        try
        {
            //define integer variable id and set to input that is trying to be converted to integer
            int id = Integer.parseInt(removeId);
            
            //define boolean variable removeSuccess to check if employee can be removed
            boolean removeSuccess = false;
            
            //loop for finding employee
            for(int i = 0; i < employees.size(); i++)
            {
                //if id matches
                if(employees.get(i).getEmployeeIdNumber() == id)
                {
                    //remove employee and exit loop
                    employees.remove(i);
                    removeSuccess = true;
                    System.out.println("\nGot that, employee was successfully removed.");
                    break;
                }
            }
            
            //if id doesn't match
            if(!removeSuccess)
            {
                System.out.println("\nSorry, we couldn't find that employee.\n");
            }
        }
        
        //handle invalid input
        catch(NumberFormatException e)
        {
            System.out.println("\nInvalid input, ID needs to be an integer.\n");
        }
    }
    
    /**
     * Lists all employees in output
     * pre: none
     * post: prints list of employees
     */
    private static void listEmployee()
    {
        //if there are no employees
        if(employees.isEmpty())
        {
            System.out.println("\nSorry, there aren't any employees that I can show you currently. Try adding more employees.\n");
        }
        
        //if there are employees
        else
        {
            //loop through all employees and print each
            for(Employee e : employees)
            {
                System.out.println(e);
            }
        }
    }
    
    /**
     * Prompts the user to choose a vehicle
     * @param string variable date
     * @return true or false
     * pre: date is created
     * post: return true if parsing is successful, otherwise false
     */
    private static boolean validateDateInput(String date)
    {
        //define datefmt object for checking user input format
        SimpleDateFormat datefmt = new SimpleDateFormat("MM/dd/yyyy");
        
        //make sure that user inputs exactly according to the date format
        datefmt.setLenient(false);
        
        //try parsing date string
        try
        {
            datefmt.parse(date);
            return true;
        }
        
        //handle invalid format
        catch(ParseException e)
        {
            return false;
        }
    }
}
