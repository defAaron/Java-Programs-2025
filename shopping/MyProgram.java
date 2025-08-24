/**
 * This program is an interactive grocery store inventory that allows the user
 * to query and add items, and asks for specific information such as the name,
 * category, quantity and minimum quantity, vendor price, and markup percentage,
 * and it will also display these descriptions when queried as well as regular
 * and current price. The user can also save the file, and the program has a 
 * pre-set inventory that the user can query.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-08
 */


//import required classes
import java.io.*;
import java.util.*;

public class MyProgram
{
    
    //define new arraylist inventory in the item class
    private static ArrayList<Item> inventory = new ArrayList<>();
    
    //define scanner object for user input
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        //print welcome message
        System.out.println("Welcome to Aaron's Grocery Store Inventory Program!");
        System.out.println("---------------------------------------------------");
        
        //load inventory from text file at start
        loadInv();
        
        while(true)
        {
            //print menu options
            System.out.println("\nWhat would you like to do?");
            System.out.println("1)   Query Inventory.");
            System.out.println("2)   Add New Item.");
            System.out.println("3)   Save File.");
            System.out.println("4)   Exit Program");
            System.out.print("\nOption: ");
            
            try
            {
                //define integer variable choice to store menu option choice from user
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                switch(choice)
                {
                    //user chooses to query inventory
                    case 1:
                        
                        queryInv();
                        break;   
                        
                    //user chooses to add new item
                    case 2:
                        
                        addItem();
                        break;
                        
                    //user chooses to save file
                    case 3:
                        
                        saveFile();
                        break;
                        
                    //user chooses to exit program
                    case 4:
                        
                        return;
                        
                    //handle invalid number from user
                    default:
                    
                        System.out.println("\nInvalid input, please enter a number from 1 to 4.\n");
                        continue;
                }
            }
            
            //invalid input handle
            catch(NumberFormatException e)
            {
                System.out.println("\nInvalid input, please enter a number from 1 to 4.\n");
                continue;
            }
        }
    }
    
    /**
     * loads inventory from inventory.txt file into arraylist
     * pre: none
     * post: adds inventory.txt into arraylist
     */
    private static void loadInv()
    {
        try
        {
            //create reader object for reading file
            BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"));
            
            //define string variable line to read file lines
            String line;
            
            //loop for reading file lines
            while((line = reader.readLine()) != null)
            {
                //split each line by commas
                String[] itemParts = line.split(",");
                
                //create new item object
                Item item = new Item(itemParts[0].trim(), itemParts[1].trim(), itemParts[2].trim(), Integer.parseInt(itemParts[3].trim()), 
                Integer.parseInt(itemParts[4].trim()), Double.parseDouble(itemParts[5].trim()), Double.parseDouble(itemParts[6].trim()), 
                Double.parseDouble(itemParts[7].trim()));
                
                //add to inventory list
                inventory.add(item);
            }
        }
        
        //handle file errors
        catch(IOException ioe)
        {
            System.out.println("Sorry, there was a file IO error.");
        }
    }
    
    /**
     * search for item by SKU or name
     * pre: none
     * post: searches for item
     */
    public static void queryInv()
    {
        //prompt user for sku or name
        System.out.print("SKU or Name: ");
        String input = scanner.nextLine().toLowerCase();
        
        //define boolean variable exists for tracking if item exists
        boolean exists = false;
        
        //loop for searching through inventory
        for(Item item : inventory)
        {
            //if match is found
            if(item.getSku().toLowerCase().equals(input) || item.getName().toLowerCase().contains(input))
            {
                //print item details
                System.out.println(item);
                //set exists to true
                exists = true;
            }
        }
        
        //if match is not found
        if(!exists)
        {
            System.out.println("Sorry, we couldn't find that item!");
        }
    }
    
    
    /**
     * adds item to inventory
     * pre: none
     * post: new item is added to inventory
     */
    public static void addItem()
    {
        //define string variable category to store user category input
        String category = "";
        
        //loop for controlling valid category input
        while(true)
        {
            //prompt user for category
            System.out.print("Category: ");
            category = scanner.nextLine().toLowerCase().trim();
            
            //if valid category
            if(category.equals("fruit") || category.equals("vegetable") || category.equals("meat"))
            {
                break;
            }
            
            //invalid category
            System.out.println("Invalid input, please enter a valid category: either fruit, vegetable, or meat.");
        }
        
        //define string variable prefix based on category
        String prefix = category.equals("fruit") ? "FRU" : category.equals("vegetable") ? "VEG" : "MEA";
        
        //define integer variable max for storing largest SKU number
        int max = 0;
        
        //loop for finding largest SKU number
        for(Item item : inventory)
        {
            if(item.getSku().startsWith(prefix))
            {
                //get the number after the dash
                int num = Integer.parseInt(item.getSku().split("-")[1]);
                
                //update the max number if larger exists
                if(num > max)
                {
                    max = num;
                }
            }
        }
        
        //define string variable sku to store new SKU
        String sku = prefix + "-" + String.format("%04d", max + 1);
        
        //prompt user for name and store in string variable name
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        //prompt user for quantity and store in integer variable quantity
        System.out.print("Quantity: ");
        int quantity = validInt();
        
        //prompt user for minimum quantity and store in integer variable minimum quantity
        System.out.print("Minimum Quantity: ");
        int minQuantity = validInt();
        
        //prompt user for vendor price and store in double variable vendorPrice
        System.out.print("Vendor Price: ");
        double vendorPrice = validDbl();
        
        //prompt user for markup and store in double variable markup
        System.out.print("Markup: ");
        double markup = validDbl();
        
        //prompt user for discount and store in double variable discount
        System.out.print("Discount: ");
        double discount = validDbl();
        
        //create new item object
        Item newItem = new Item(sku, name, category, quantity, minQuantity, vendorPrice, markup, discount);
        
        //define integer variable placeIndex for placing new object
        int placeIndex = 0;
        
        //loop for placing object in inventory
        for(placeIndex = 0; placeIndex < inventory.size(); placeIndex++)
        {
            Item currentItem = inventory.get(placeIndex);
            
            //if object is fruit then insert before first non-fruit object
            if(category.equals("fruit") && !currentItem.getSku().startsWith("FRU"))
            {
                break;
            }
            
            //if object is veggie then insert before first meat
            if(category.equals("vegetable") && currentItem.getSku().startsWith("MEA"))
            {
                break;
            }
            
            //if same category
            if(currentItem.getSku().startsWith(prefix))
            {
                //insert in number order
                int currentNum = Integer.parseInt(currentItem.getSku().split("-")[1]);
                
                if((max + 1) < currentNum)
                {
                    break;
                }
            }
        }
        
        //place new item
        inventory.add(placeIndex, newItem);
        System.out.println("Got that, " + newItem + " was just added!");
    }
    
    
    /**
     * saves inventory back to file
     * pre: none
     * post: inventory is saved
     */
    public static void saveFile()
    {
        try
        {
            //define out object for reading file
            BufferedWriter out = new BufferedWriter(new FileWriter("inventory.txt"));
            
            //write each item in inventory to file
            for(Item item : inventory)
            {
                out.write(item.toString());
                out.newLine();
            }
            
            //close the writer
            out.close();
        }
        
        //handle file error
        catch(IOException ioe)
        {
            System.out.println("Sorry, we encountered an error while trying to save the file.");
        }
    }
    
    
    /**
     * validate user input when integer
     * pre: none
     * post: returns integer if valid, else invalid message
     */
    private static int validInt()
    {
        //loop for validating input
        while(true)
        {
            try
            {
                String input = scanner.nextLine();
                
                //convert string to integer
                int value = Integer.parseInt(input);
                return value;
            }
            
            //handle invalid input
            catch(NumberFormatException e)
            {
                System.out.println("Invalid input, please enter a valid integer.");
            }
        }
    }
    
    
    /**
     * validate user input when double
     * pre: none
     * post: returns double if valid, else invalid message
     */
    private static double validDbl()
    {
        //loop for validating input
        while(true)
        {
            try
            {
                String input = scanner.nextLine();
                
                //convert string to integer
                double value = Double.parseDouble(input);
                return value;
            }
            
            //handle invalid input
            catch(NumberFormatException e)
            {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
    }
}
