/**
 * The program below is a program that has the ability to store and display
 * integer values in an array, and allows the user to use multiple functions that 
 * deal with the array.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-07-31
 */


//importing Scanner class for user input and InputMismatchException to handle input errors
import java.util.Scanner;
import java.util.InputMismatchException;

public class MyProgram
{
    public static void main(String[] args)
    {
        //create scanner object
        Scanner scanner = new Scanner(System.in);
        
        //define integer array variable numbers to hold up to 20 positive integers
        int[] numbers = new int[20];
        //define integer variable count for tracking how many numbers are in the array
        int count = 0;
        
        //define boolean variable repeat to control the menu loop
        boolean repeat = true;
        
        //print welcome message
        System.out.println("WELCOME TO AARON'S INTEGER ARRAY PROGRAM");
        System.out.println("----------------------------------------");
        
        //main loop that runs until user chooses to exit
        while(repeat)
        {
            //define integer variable choice to store user option choice
            int choice = 0;
            
            //loop for valid option choice
            while(true)
            {
                //print menu options
                printMenu();
            
                try
                {
                    //store user input
                    choice = scanner.nextInt();
                    
                    //input validation
                    if(choice <=6 && choice >=1)
                    {
                        //exit loop
                        System.out.println("Thanks for the valid input");
                        break;
                    }
                    
                    //if invalid choice then reprompt user
                    else
                    {
                        System.out.println("Please enter a valid integer from 1 to 6");
                    }
                }
                //handle non-integer input exception
                catch(InputMismatchException e)
                {
                    System.out.println("Invalid input, please enter an integer from 1 to 6.");
                    scanner.next();
                }
            }
            
            //for each menu option
            switch(choice)
            {
                //add numbers option
                case 1:
                    //if array is full
                    if(count >=20)
                    {
                        System.out.println("You cannot add more than 20 numbers. The array is full!");
                        break;
                    }
                    
                    //define integer variable howManyNums to store number of integers user wishes to add
                    int howManyNums = 0;
                    
                    //loop for prompting user for number of integers to be added
                    while(true)
                    {
                        System.out.print("\n\nEnter the number of integers you would like to add: ");
                        
                        try
                        {
                            //store user input
                            howManyNums = scanner.nextInt();
                            
                            //checking for invalid input
                            if(howManyNums <= 0)
                            {
                                System.out.println("Please enter a number greater than 0, you cannot add a negative number of integers.");
                                break;
                            }
                            else if(count + howManyNums > 20)
                            {
                                System.out.println("Sorry, the maximum number of integers you can add is " + (20 - count) + ".");
                                continue;
                            }
                            
                            //valid input
                            else
                            {
                                break;
                            }
                        }
                        //handle non-integer input exception
                        catch(InputMismatchException e)
                        {
                            System.out.println("Invalid input, please enter a valid positive integer.");
                            //clear invalid input
                            scanner.next();
                        }
                    }
                    
                    //loop for prompting each integer from user
                    for (int i = 0; i < howManyNums; i++)
                    {
                        System.out.print("\nEnter positive integer " + (i + 1) + ": ");
                            
                        try
                        {
                            //define integer variable addedNum to store user input
                            int addedNum = scanner.nextInt();
                            
                            //valid input    
                            if(addedNum > 0)
                            {
                                numbers[count++] = addedNum;
                                System.out.println(addedNum + " was added to the array succesfully.");
                                }
                            //invalid input
                            else
                            {
                                System.out.println("Invalid input, please enter a valid positive integer.");
                                scanner.next();
                                i--;
                            }
                        }
                        
                        //handle non-integer input exception
                        catch(InputMismatchException e)
                        {
                            System.out.println("Invalid input, please enter a valid positive integer.");
                            scanner.next();
                            i--;
                        }
                    }
                    
                    //option 1 end
                    break;
                
                //remove integer option
                case 2:
                    System.out.println("\n\nEnter an integer you would like to remove the first occurence of: ");
                    
                    try
                    {
                        //define integer variable removedNum to store user input
                        int removedNum = scanner.nextInt();
                        //define boolean variable isInArray to track if number is in array
                        boolean isInArray = false;
                        
                        //loop for search for number in array
                        for(int i = 0; i < count; i++)
                        {
                            if(numbers[i] == removedNum)
                            {
                                //move all elements to the left
                                for(int j = i; j < count - 1; j++)
                                {
                                    numbers[i] = numbers[j + 1];
                                }
                                
                                //clear last element
                                numbers[count - 1] = 0;
                                
                                //decrease count
                                count--;
                                
                                //validate as found and exit loop
                                isInArray = true;
                                System.out.println("Got that, the first occurence of " + removedNum + " was successfully removed from the array.");
                                break;
                            }
                        }
                        
                        //if not in array
                        if(!isInArray)
                        {
                            System.out.println("Sorry, that number isn't in the array");
                        }
                    }
                    
                    //handle non-integer input exception
                    catch(InputMismatchException e)
                    {
                        System.out.println("Invalid input, please enter a valid integer.");
                        scanner.next();
                    }
                    
                    break;
                    
                
                //list all elements and calculate their sum
                case 3:
                    //define integer variable sum for the sum of all numbers in array
                    int sum = 0;
                    
                    System.out.println("\n\nThe following integers are in the array: ");
                    
                    //loop for printing all elements in array
                    for(int i = 0; i < count; i++)
                    {
                        System.out.print(numbers[i] + " ");
                        //calculate sum
                        sum += numbers[i];
                    }
                    
                    //display sum and exit loop
                    System.out.println("\nSum of all elements: " + sum);
                    break;
                    
                    
                //list even elements and calculate their sum
                case 4:
                    //define integer variable evenSum for the sum of even numbers in array
                    int evenSum = 0;
                    
                    System.out.println("\n\nThe following even integers are in the array: ");
                    
                    //loop for printing even elements in array
                    for(int i = 0; i < count; i++)
                    {
                        //check if remainder when divided by 2 is zero (number is even)
                        if(numbers[i] % 2 == 0)
                        {
                            System.out.print(numbers[i] + ", ");
                            //calculate even sum
                            evenSum += numbers[i];
                        }
                    }
                    
                    //display even sum and exit loop
                    System.out.println("\nSum of all even elements: " + evenSum);
                    break;
                    
                    
                    
                case 5:
                    //define integer variable oddSum for the sum of odd numbers in array
                    int oddSum = 0;
                    
                    System.out.println("\n\nThe following odd integers are in the array: ");
                    
                    //loop for printing odd elements in array
                    for(int i = 0; i < count; i++)
                    {
                        //check if remainder when divided by 2 is not zero (number is odd)
                        if(numbers[i] % 2 != 0)
                        {
                            System.out.print(numbers[i] + ", ");
                            //calculate odd sum
                            oddSum += numbers[i];
                        }
                    }
                    
                    //display odd sum and exit loop
                    System.out.println("\nSum of all odd elements: " + oddSum);
                    break;
                    
                //user wants to exit the program
                case 6:
                    //print goodbye message, close scanner and exit program
                    System.out.println("Alright, goodbye!");
                    scanner.close();
                    return;
                    
                //backup input validation
                default:
                    System.out.println("Invalid option, enter a valid integer from 1 to 6.");
            }
        }
    }
    
    /**
     * Prints a menu for the user to view options that they can choose from
     * pre: none
     * post: prints the menu
     */
    public static void printMenu()
    {
        //print options for use
        System.out.println("\n\nWhat would you like to do?\n");
        System.out.println("1)   Add a positive integer.");
        System.out.println("2)   Remove the first occurence of a positive integer.");
        System.out.println("3)   List all integers and compute their sum.");
        System.out.println("4)   List all even integers and compute their sum.");
        System.out.println("5)   List all odd integers and compute their sum.");
        System.out.println("6)   Exit program.");
        System.out.print("\nOption choice: ");
    }
}
