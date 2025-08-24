/**
 * This program is an interactive modified fibonacci number calculator that
 * shows the nth term of a sequence that is defined by the sum of the previous
 * two terms.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-12
 */

import java.util.*;

public class MyProgram
{
    public static void main(String[] args)
    {
        //import scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        //print welcome message
        System.out.println("Welcome to Aaron's Modified Fibonacci Number Calculator!");
        System.out.println("--------------------------------------------------------");
        
        //let user know about input guidelines
        System.out.println("Enter a non-negative integer for term number, and if you wish to exit just type in -1!\n");
        
        //loop for prompting for term number
        while(true)
        {
            //define integer variable term to store user input
            int term;
            
            while(true)
            {
                //input validation
                try
                {
                    System.out.print("Term number: ");
                    term = scanner.nextInt();
                    break;
                }
                
                //handle invalid input
                catch(InputMismatchException e)
                {
                    System.out.println("Invalid input, please enter a valid integer.");
                }
            }
            
            //if user wants to exit program
            if(term == -1)
            {
                System.out.println("Got that, exiting the program. See you next time!");
                break;
            }
            
            //if user enters a negative term
            if(term < 0)
            {
                System.out.println("Invalid input, you must enter a non-negative integer to continue or -1 to quit.");
                continue;
            }
            
            //define integer variable answer to be the modified fibonacci solution of term
            int answer = modifiedFibonacci(term);
            System.out.println("Term " + term + " is " + answer + "\n"); 
        }
        
        
        //close the scanner
        scanner.close();
    }
    
    /**
     * calculates modified fibonacci solution for term n
     * @param integer variable n
     * @return fibonacci answer as an integer value corresponding to the term n
     * pre: integer variable n is created
     * post: return value
     */
    public static int modifiedFibonacci(int n)
    {
        //base case 1
        if(n == 0)
        {
            return 3;
        }
        
        //base case 2
        else if(n == 1)
        {
            return 5;
        }
        
        //base case 3
        else if(n == 2)
        {
            return 8;
        }
        
        //any number that is not the base case
        else
        {
            //use formula to calculate answer
            return modifiedFibonacci(n - 1) + modifiedFibonacci(n - 2) + modifiedFibonacci(n - 3);
        }
        
    }
}
