/**
 * The program below determines whether or not a potential rider should go on a
 * roller coaster based on details that the user will input such as their height
 * and any back or heart trouble they might have.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-07-29
 */


import java.util.Scanner;

public class MyProgram
{
    public static void main(String[] args)
    {
        //creating the scanner object to read input
        Scanner scanner = new Scanner(System.in);
        //defining a boolean variable "repeat" for a loop control variable
        boolean repeat = true;
        
        //printing the title name of the program in the output
        System.out.println("Roller Coaster Ride");
        System.out.println("===================");
            
        while(repeat)
        {
            //defining an integer variable named height and setting it to zero, later used for storing user input for height measurement
            int height = 0;
            //defining a boolean variable validInput and setting it to false to control valid input for height
            boolean validInput = false;
            
            //loop for user inputting height
            while(!validInput)
            {
                //prompt user for height
                System.out.print("Height in cm? (Enter a positive integer) ");
                
                //if the input is an integer
                if(scanner.hasNextInt())
                {
                    height = scanner.nextInt();
                    //only accepts positive integers
                    if(height > 0)
                    {
                        //exit the loop
                        validInput = true;
                    }
                }
                
                //if the input is not an integer
                else
                {
                    System.out.println("Invalid input, please enter a valid positive integer.");
                    scanner.next();
                }
            }
            
            //defining a string variable named back, later used for storing user input for back trouble
            String back = "";
            //setting validInput to false to control valid input for back trouble
            validInput = false;
            
            //loop for user inputting back trouble
            while(!validInput)
            {
                //prompt user for back trouble
                System.out.print("Back Trouble Y/N? ");
                back = scanner.next();
                
                //if user input is valid
                if(back.equalsIgnoreCase("Y") || back.equalsIgnoreCase("N"))
                {
                    //exit the loop
                    validInput = true;
                }
                //if user input is invalid
                else
                {
                    System.out.println("Invalid input, please enter a Y or an N.");
                }
            }
            //defining a string variable named heart, later used for storing user input for heart trouble
            String heart = "";
            //setting validInput to false to control valid input for heart trouble
            validInput = false;
            
            //loop for user inputting heart trouble
            while(!validInput)
            {
                //prompt user for heart trouble
                System.out.print("Heart Trouble Y/N? ");
                heart = scanner.next();
                
                //if user input is valid
                if(heart.equalsIgnoreCase("Y") || heart.equalsIgnoreCase("N"))
                {
                    //exit the loop
                    validInput = true;
                }
                //if user input is invalid
                else
                {
                    System.out.println("Invalid input, please enter a Y or an N.");
                }
            }
            
            //if any one of the inputs that the user gave do not align with the rules of the Roller Coaster Ride
            if(back.equalsIgnoreCase("Y") || heart.equalsIgnoreCase("Y") || height < 122 || height > 188)
            {
                System.out.println("NO, it is not safe for you to ride this roller coaster.\n");
                
                //checking each case that does not align with the rules and explaining why the user cannot go on the ride
                
                if(height<122)
                {
                    System.out.println("Your height is " + height + " cm, which is too short. Come back when you grow taller and in the meanwhile, check out our other rides!\n");
                }
                
                if(height>188)
                {
                    System.out.println("Your height is " + height + " cm, which is too tall. Not sure if there's anyway to get shorter, but you can still check out our other rides!\n");
                }
                
                if(back.equalsIgnoreCase("Y"))
                {
                    System.out.println("Going on a ride while having back trouble is extremely risky and can be injurious to your health. We wish a fast recovery for your back and hopefully next time you can join us on our ride!\n");
                }
                
                if(heart.equalsIgnoreCase("Y"))
                {
                    System.out.println("Going on a ride while having heart trouble is extremely risky and can be injurious to your health. We wish a fast recovery for your heart and hopefully next time you can join us on our ride!\n");
                }
            }
            //print message saying that the user can go on the ride
            else
            {
                System.out.println("YES, it is safe for you to ride this roller coaster.");
            }
        
            //defining a string variable repeatChoice
            String repeatChoice = "";
            //setting validInput to false to control valid input for continuing
            validInput = false;
            
            //loop for user inputting whether or not they want to continue
            while(!validInput)
            {
                //prompt user whether or not they want to continue
                System.out.print("Would you like to enter info for the next rider Y/N? ");
                repeatChoice = scanner.next();
                
                //if user wants to continue
                if(repeatChoice.equalsIgnoreCase("Y"))
                {
                    //exits loop but still continues the outer repeat loop for the next user
                    validInput = true;
                    System.out.println("\n");
                }
                
                //if user does not want to continue
                else if(repeatChoice.equalsIgnoreCase("N"))
                {
                    //exit loop
                    validInput = true;
                    //exits the outer repeat loop and ends the program
                    repeat = false;
                    System.out.println("Goodbye!");
                }
                
                //if user input is invalid
                else
                {
                    System.out.println("Invalid input, please enter a Y or an N.");
                }
            }
        }
    }
}
