/**
 * The program below is a Trivia Game that includes 4 questions on no specific
 * topic along with a special bonus question.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-07-30
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
        
        //print welcome message
        welcomePage();
        
        //loop that controls whether the game should keep going
        while(repeat)
        {
            //print menu message
            quizMenu();
            //defining integer variable play to validate user input
            int play = validMenuOption(scanner);
            
            //if user wants to play
            if(play == 1)
            {
                //ask questions
                int mark = askQuestion(scanner);
                //ask optional bonus question
                int bonus = bonusQuestion(scanner);
                //calculate percent
                double percent = calcPercent(mark, bonus);
                //show final results
                printResults(mark + bonus, percent);
            }
            //if user doesn't want to play
            else if(play == 2)
            {
                //exit message and end loop
                System.out.println("Ok goodbye!");
                repeat = false;
            }
        }
        //close scanner when done
        scanner.close();  
    }
        
    /**
     * Prompts the user until they select a valid menu option
     * @param scanner object for reading user input
     * @return valid menu choice inputted by user
     * pre: scanner is created
     * post: returns 1 or 2
     */
    public static int validMenuOption(Scanner scanner)
    {
        //define integer variable choice and set to 0
        int choice = 0;
        //define boolean variable valid to track valid input
        boolean valid = false;
        
        //while input is not vaid
        while(!valid)
        {
            //prompt user for menu option
            System.out.print("Enter your choice: ");
            String input = scanner.next();
            
            try
            {
                //try to convert input to integer
                choice = Integer.parseInt(input);
                
                //if input is valid
                if(choice == 1 || choice == 2)
                {
                    //input validation
                    valid = true;
                    System.out.println("Valid input.")
                }
                //if option is invalid
                else
                {
                    System.out.println("Invalid option, enter 1 or 2.");
                }
            }
            
            //catch non-numeric input
            catch(NumberFormatException e)
            {
                System.out.println("Invalid input, enter a valid number.");
            }
        }
        //return their valid choice
        return choice;
    }
    
    /**
     * Outputs a welcome message and basic rules for input
     * pre: none
     * post: prints the welcome message
     */
    public static void welcomePage()
    {
        //print out a title
        System.out.println("Welcome to Aaron's Trivia Game!");
        System.out.println("-------------------------------\n");
        
        //print rules and reminders
        System.out.println("Some rules and reminders for inputting answers before we start:");
        System.out.println(" - for numbers, do not type it in letters (ex: the number 3 should be entered as '3', not 'three'.");
        System.out.println(" - don't forget to check your spelling for words!");
        System.out.println(" - try your best and have fun : )\n");
    }
    
    /**
     * Outputs the game menu with the options
     * pre: none
     * post: prints the menu message
     */
    public static void quizMenu()
    {
        //print menu with options
        System.out.println("Choose an option:");
        System.out.println("1) Play Game");
        System.out.println("2) Exit\n");
    }
    
    /**
     * Prompts the user with trivia question and marks correct answers
     * @param scanner object for reading user input
     * @return number of correct answers
     * pre: scanner is created
     * post: returns number of correctly answered question by user
     */
    public static int askQuestion(Scanner scanner)
    {
        //define integer variable mark for counting score
        int mark = 0;
        
        //define string array variable questions for storing questions
        String[] questions = {"How many sides does an octagon have?", 
        "What language is this program written in?", 
        "How do you say the word 'hello' in French?", 
        "What planet do we live on?"};
        
        //define string array variable answers for storing respective answers
        String[] answers = {"8", "java", "bonjour", "earth"};
        
        //loop through each question
        for(int i = 0; i < questions.length; i++)
        {
            //print question and prompt user 
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            String userAnswer = scanner.next();
            
            //compare user input with correct answer
            if(userAnswer.equalsIgnoreCase(answers[i]))
            {
                //increase mark
                System.out.println("Yes, " + answers[i] + " is the correct answer! Amazing job!\n");
                mark++;
            }
            else
            {
                //mark does not change
                System.out.println("Unfortunately, that is incorrect. The correct answer is: " + answers[i] + "\n");
            }
        }
        //return number of correct answer
        return mark;
    }
    
    /**
     * Offers bonus question and checks user answer
     * @param scanner object for reading user input
     * @return bonus mark
     * pre: scanner is created
     * post: returns 1 if user gives correct answer, otherwise 0
     */
    public static int bonusQuestion(Scanner scanner)
    {
        //define integer variable bonus to keep track of bonus mark
        int bonus = 0;
        //define boolean variable bonusValid to track valid input
        boolean bonusValid = false;
        
        //loop until input is valid
        while(!bonusValid)
        {
            //prompt user for if they would like to try bonus quesiton
            System.out.println("Would you like to try out a bonus question? (Y / N)" );
            String bonusAttempt = scanner.next();
            
            try
            {
                //if user input is yes
                if(bonusAttempt.equalsIgnoreCase("y"))
                {
                    //input validation
                    System.out.println("Valid input.");
                    bonusValid = true;
                    //prompt user with bonus question
                    System.out.println("\nBonus Question: What is my first name? ");
                    String bonusAnswer = scanner.next();
                    
                    //check for correct answer
                    if(bonusAnswer.equalsIgnoreCase("aaron"))
                    {
                        //add bonus point and congratulate user
                        System.out.println("\nNice! You just earned a bonus point.\n");
                        bonus++;
                    }
                    
                    else 
                    {
                        //reveal answer
                        System.out.println(bonusAnswer + " is not my first name, Aaron is!\n");
                    }
                    
                }
                
                else if(bonusAttempt.equalsIgnoreCase("n"))
                {
                    //input validation
                    bonusValid = true;
                    System.out.println("Valid input.");
                    System.out.println("Ok, skipping the bonus question.");
                }
                
                else
                {
                    //handle invalid input
                    System.out.println("Invalid input. Please enter y or n.");
                }
            }
            
            catch(Exception e)
            {
                //catch unexpected
                System.out.println("Sorry, I couldn't understand that. Please enter a valid input.");
            }
        }
        
        //print bonus score
        System.out.println("Your bonus score is: " + bonus);
        //return 0 or 1
        return bonus;
    }
    
    /**
     * Calculates percent mark of user's correct answers
     * @param number of correct answers
     * @param bonus mark 
     * @return percent mark as a double
     * pre: mark and bonus are positive integers
     * post: returns percent value out of 100
     */
    public static double calcPercent(int mark, int bonus)
    {
        //calculation for user's percentage score
        return ((double) (mark + bonus )/ 4) * 100;
    }
    
    /**
     * Outputs final mark and percent to user
     * @param number of correct answers
     * @param percent mark
     * @return valid menu choice inputted by user
     * pre: mark and percent are already calculated
     * post: prints user's game results
     */
    public static void printResults(int mark, double percent)
    {
        //print final results
        System.out.println("\n\nCongrats on completing the game!");
        System.out.println("--------------------------------");
        System.out.println("Your mark is " + mark + "/4");
        System.out.println("Your percentage is " + percent + "%");
    }
}
