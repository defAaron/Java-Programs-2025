/**
 * This program is a class that represents a vehicle which can carry passengers
 * for a profit, it calculates revenue, cost, and profit based on distance, and
 * it also compares two vehicles
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-05
 */

import java.util.Scanner;

public class MyProgram
{
    public static void main(String[] args)
    {
        //define scanner object for user input
        Scanner scanner = new Scanner(System.in);
        //define vehicle array objs to store 3 vehicle objects
        Vehicle[] objs = new Vehicle[3];
        
        //print welcome message
        System.out.println("Welcome to Aaron's Vehicle Trip Analyzer!");
        System.out.println("-----------------------------------------");
        
        //loop for asking gas price
        while(true)
        {
            //try prompting gas price
            try
            {
                System.out.println("What is the current price of gas? ");
                double gasPrice = scanner.nextDouble();
                
                //valid input
                if(gasPrice > 0)
                {
                    Vehicle.setGasPrice(gasPrice);
                    break;
                }
                
                //invalid input handle
                else
                {
                    System.out.println("Invalid input, must be a number greater than 0.");
                }
            }
            
            //invalid input exception handle
            catch(Exception e)
            {
                System.out.println("Invalid input, must be a number greater than 0.");
                scanner.nextLine();
            }
        }
        
        //loop for creating 3 vehicles
        for(int i = 0; i < 3; i++)
        {
            objs[i] = createVehicleObject(i + 1);
            System.out.println("Vehicle " + (i + 1) + ": " + objs[i]);
        }
        
        //loop for printing menu
        while(true)
        {
            //define integer variable choice to store user choice for menu option
            int choice = menuOption();
            
            //if user chooses first choice
            if(choice == 1)
            {
                //prompt user for choice
                int vehicleIndex = chooseVehicleIndex("Which vehicle would you like to analyze? ");
                Vehicle chose = objs[vehicleIndex - 1];
                
                //define double variable distance for storing distance measurement
                double distance;
                
                //loop for prompting user for all methods
                while(true)
                {
                    try
                    {
                        System.out.println("What is the distance of your trip in km? ");
                        distance = scanner.nextDouble();
                        
                        //valid input
                        if(distance > 0)
                        {
                            break;
                        }
                        
                        //invalid input handle
                        else
                        {
                            System.out.println("Invalid input, please enter a positive number.");
                        }
                    }
                    
                    //invalid input exception handle
                    catch(Exception e)
                    {
                        System.out.println("Invalid input, please enter a positive number.");
                        scanner.nextLine();
                    }
                }
                
                
                //define double variable profit for storing profit
                double profit = chose.calculateProfit(distance);
                
                //print profit results
                System.out.println("Your profit is " + profit);
                System.out.println("Result: " + (chose.isProfitable(distance) ? "Profitable" : "Not Profitable"));
            }
            
            
            //if user chooses second choice
            else if(choice == 2)
            {
                //define integer variables inx1 and inx2 for storing vehicle index option
                int inx1 = chooseVehicleIndex("Choose first vehicle: ");
                int inx2;
                
                
                //loop for prompting user for vehicle choice
                while(true)
                {
                    inx2 = chooseVehicleIndex("Choose second vehicle");
                    
                    //valid input
                    if(inx2 != inx1)
                    {
                        break;
                    }
                    
                    //invalid input handle
                    else
                    {
                        System.out.println("Sorry, you need to choose a different vehicle.");
                    }
                }
                
                double distance;
                
                while(true)
                {
                    try
                    {
                        System.out.print("Enter distance of trip you would like to compare in km: ");
                        distance = scanner.nextDouble();
                        
                        if(distance > 0)
                        {
                            break;
                        }
                        
                        else
                        {
                            System.out.println("Invalid input, please enter a positive number.");
                        }
                    }
                    
                    catch(Exception e)
                    {
                        System.out.println("Invalid input, please enter a positive number.");
                        scanner.nextLine();
                    }
                }
                
                Vehicle better = Vehicle.compareTo(objs[inx1 - 1], objs[inx2 - 1], distance);
                System.out.println("The more profitable vehicle is" + better);
            }
            
            else if(choice == 3)
            {
                System.out.println("No problem, exiting program. See you next time!");
                break;
            }
        }
        
        scanner.close();
    }
    
    /**
     * Prints a menu for the user to view options that they can choose from
     * pre: none
     * post: prints the menu
     */
    public static int menuOption()
    {
        //define scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        int option = 0;
        
        System.out.println("Menu Options");
        System.out.println("------------");
        System.out.println("What would you like to do?");
        System.out.println("1)   Check profitability of a trip.");
        System.out.println("2)   Compare two vehicles.");
        System.out.println("3)   Exit program.");
        
        while(true)
        {
            try
            {
                System.out.print("Option: ");
                option = scanner.nextInt();
                
                if(option >= 1 && option <=3)
                {
                    return option;
                }
                
                else
                {
                    System.out.println("Invalid input, please enter an integer from 1 to 3.");
                }
            }
            
            catch(Exception e)
            {
                System.out.println("Invalid input, please enter an integer from 1 to 3.");
                scanner.nextLine();
            }
        }
    }
    
    /**
     * Prompts the user to choose a vehicle
     * @param string variable prompt
     * @return chosen vehicle number
     */
    public static int chooseVehicleIndex(String prompt)
    {
        //define scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        int index = 0;
        
        while(true)
        {
            try
            {
                System.out.print("Choose a vehicle from 1 to 3");
                index = scanner.nextInt();
                
                if(index >=1 && index <= 3)
                {
                    return index;
                }
                
                else
                {
                    System.out.println("Invalid input, please enter an integer from 1 to 3.");
                }
            }
            
            catch(Exception e)
            {
                System.out.println("Invalid input, please enter an integer from 1 to 3.");
                scanner.nextLine();
            }
        }
    }
    
    /**
     * Prompts the user to create a new vehicle
     * @param integer vehicle number being created
     * @return vehicle object that is initialized
     */
    public static Vehicle createVehicleObject(int vehicleNumber)
    {
        //define scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        int passengers = 0;
        double ratePerPassenger = 0;
        double gasEfficiency = 0;
        
        while(true)
        {
            try
            {
                System.out.print("What is the fare per passenger in dollars? ");
                ratePerPassenger = scanner.nextDouble();
                
                if(ratePerPassenger > 0)
                {
                    break;
                }
                
                else
                {
                    System.out.println("Invalid input, must be a positive number.");
                }
            }
            
            catch(Exception e)
            {
                System.out.println("Invalid input, must be a positive number.");
                scanner.nextLine();
            }
        }
        
        while(true)
        {
            try
            {
                System.out.println("How many passengers are there? ");
                passengers = scanner.nextInt();
                
                if(passengers > 0)
                {
                    break;
                }
                
                else
                {
                    System.out.println("Invalid input, must be a positive integer.");
                }
            }
            
            catch(Exception e)
            {
                System.out.println("Invalid input, must be a positive integer.");
                scanner.nextLine();
            }
        }
        
        while(true)
        {
            try
            {
                System.out.print("What is the fuel efficiency in L/Km? ");
                gasEfficiency = scanner.nextDouble();
                
                if(gasEfficiency > 0 && gasEfficiency < 1)
                {
                    break;
                }
                
                else
                {
                    System.out.println("Invalid input, must be between 0 and 1.");
                }
            }
            
            catch(Exception e)
            {
                System.out.println("Invalid input, must be between 0 and 1.");
            }
        }
        
        return new Vehicle(passengers, ratePerPassenger, gasEfficiency);
    }
}
