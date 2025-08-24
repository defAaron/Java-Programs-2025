/**
 * The program below implements an application that prompts a user for an 
 * amount of money in dollars and cents that he or she would like to 
 * exchange for coins and displays minimum values of the coins that they 
 * can receive
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-07-28
 */

import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //loop to continue the program
        boolean exit = false;
        while (!exit) {
            System.out.println("Change Exchange");
            System.out.print("Enter the amount in dollars and cents (e.g., xxxx.xx): ");
            double amount = scanner.nextDouble();

            //calculate the money in cents
            int totalCents = (int) (amount * 100);
            
            //calculate the numbers of different coins
            int toonies = totalCents / 200;
            totalCents %= 200;
            int loonies = totalCents / 100;
            totalCents %= 100;
            int quarters = totalCents / 25;
            totalCents %= 25;
            int dimes = totalCents / 10;
            totalCents %= 10;
            int nickels = totalCents / 5;
            int pennies = totalCents % 5;

            //print each type of coin and number of each respective coin beside it
            System.out.println("Amount: $" + amount);
            System.out.println("Toonies: " + toonies);
            System.out.println("Loonies: " + loonies);
            System.out.println("Quarters: " + quarters);
            System.out.println("Dimes: " + dimes);
            System.out.println("Nickels: " + nickels);
            System.out.println("Pennies: " + pennies);

            //ask user if they would like to calculate again
            System.out.println("Do you want to calculate again? (yes/no)");
            //conditional that decides whether the program should loop or exit
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("no")) {
                exit = true;
            }
        }

        scanner.close();
    }
}
