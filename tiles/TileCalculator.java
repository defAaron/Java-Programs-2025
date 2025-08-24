/**
 * This program is an interactive tile calculator that allows the user to add, 
 * remove, and list 8 different types of tiles, enter a unit price, and 
 * calculate total cost and area of the floor they create.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-07
 */


//import the required classes
import java.util.Scanner;
import java.util.ArrayList;

public class TileCalculator 
{
    //create new arraylist shapes
    private static ArrayList<Shape> shapes = new ArrayList<>();
    
    
    public static void main(String[] args) 
    {
        //create scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        //define boolean variable repeat to control main loop
        boolean repeat = true;
        
        //print welcome message
        System.out.println("Welcome to Aaron's Tile Calculator Program!");
        System.out.println("------------------------------------------\n");
            
        //loop for main program
        while(repeat)
        {
            //print menu options
            menuOption();
            
            try
            {
                //define integer variable choice to store menu option choice from user
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                switch(choice)
                {
                    //user chooses to add shape
                    case 1:
                        
                        addShape(scanner);
                        break;   
                        
                    //user chooses to remove shape
                    case 2:
                        
                        removeShape(scanner);
                        break;
                        
                    //user chooses to list shapes
                    case 3:
                        
                        displayShapes();
                        break;
                        
                    //user chooses to set unit price
                    case 4:
                        
                        setUnitPrice(scanner);
                        break;
                        
                    //user chooses to calculate total cost
                    case 5:
                        
                        calcTotalCost();
                        break;
                        
                    //user chooses to calculate total area
                    case 6:
                        
                        calcTotalArea();
                        break;
                        
                    //user chooses to clear all shapes
                    case 7:
                        
                        clearShapes();
                        break;
                    
                    //user chooses to exit program    
                    case 8:
                        
                        //end loop and say goodbye message
                        repeat = false;
                        System.out.println("Got that, see you next time!");
                        break;
                        
                    //handle invalid number from user
                    default:
                    
                        System.out.println("\nInvalid input, please enter a number from 1 to 8.\n");
                        continue;
                }
            }
            
            //invalid input handle
            catch(NumberFormatException e)
            {
                System.out.println("\nInvalid input, please enter a number from 1 to 8.\n");
                continue;
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
        //print out menu options
        System.out.println("1)    Create new shape.");
        System.out.println("2)    Delete existing shape.");
        System.out.println("3)    Display list of existing shapes with details of each shape.");
        System.out.println("4)    Enter unit price.");
        System.out.println("5)    Calculate total cost of floor.");
        System.out.println("6)    Calculate total area of floor.");
        System.out.println("7)    Clear list of all shapes.");
        System.out.println("8)    Exit program.\n");
        System.out.print("Option: ");
    }
    
    
    /**
     * validates user input
     * @param scanner object and string variable prompt
     * @return value or invalid input message
     * pre: scanner and prompt are created
     * post: return value if valid, else invalid input message
     */
    private static double validateDouble(Scanner scanner, String prompt)
    {
        //loop for getting valid input
        while(true)
        {
            System.out.print(prompt);
            
            try
            {
                //define double variable value to convert string input into double
                double value = Double.parseDouble(scanner.nextLine());
                
                //if value is negative
                if(value <= 0)
                {
                    System.out.print("\nInvalid input, please enter a positive number.\n");
                }
                
                //valid input
                else
                {
                    return value;
                }
            }
            
            //invalid input handle
            catch(NumberFormatException e)
            {
                System.out.print("\nInvalid input, please enter a positive number.\n");
            }
        }
    }
    
    
    /**
     * adds shape to arraylist
     * @param scanner object
     * pre: scanner is created
     * post: none
     */
    public static void addShape(Scanner scanner)
    {
        //print options for shapes
        System.out.println("\nWhich shape would you like to add?");
        System.out.println("1)    Rectangle");
        System.out.println("2)    Parallelogram");
        System.out.println("3)    Triangle");
        System.out.println("4)    Circle");
        System.out.println("5)    Donut");
        System.out.println("6)    Trapezoid");
        System.out.println("7)    Hexagon\n");
        System.out.print("Shape: ");
        
        //define Shape variable shape as empty
        Shape shape = null;
        
        //loop for adding a shape
        while(true)
        {
        
            try
            {
                //define integer variable choice to store menu option choice from user
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                //define double variable unit price for storing unit price from user
                double unitPrice = 0.0;
                
                switch(choice)
                {
                    //user chooses rectangle
                    case 1:
                        
                        double lenRect = validateDouble(scanner, "Length: ");
                        double wid = validateDouble(scanner, "Width: ");
                        shape = new Rectangle(unitPrice, lenRect, wid);
                        
                        break;   
                        
                    //user chooses parallelogram
                    case 2:
                        
                        double basePara = validateDouble(scanner, "Base: ");
                        double heightPara = validateDouble(scanner, "Height: ");
                        shape = new Parallelogram(unitPrice, basePara, heightPara);
                        
                        break;   
                        
                    //user chooses triangle
                    case 3:
                        
                        double baseTri = validateDouble(scanner, "Base: ");
                        double heightTri = validateDouble(scanner, "Height: ");
                        shape = new Triangle(unitPrice, baseTri, heightTri);
                        
                        break;
                        
                    //user chooses circle
                    case 4:
                        
                        double radius = validateDouble(scanner, "Radius: ");
                        shape = new Circle(unitPrice, radius);
                        
                        break;   
                    
                    //user chooses donut
                    case 5:
                        
                        double larger = validateDouble(scanner, "Larger Radius: ");
                        double smaller = validateDouble(scanner, "Smaller Radius: ");
                        
                        if(larger <= smaller)
                        {
                            System.out.println("\nLarger radius cannot be smaller/equal to smaller radius.\n");
                            return;
                        }
                        
                        shape = new Donut(unitPrice, larger, smaller);
                        
                        break;   
                    
                    //user chooses trapezoid
                    case 6:
                        
                        double baseTrap1 = validateDouble(scanner, "Base 1: ");
                        double baseTrap2 = validateDouble(scanner, "Base 2: ");
                        double heightTrap = validateDouble(scanner, "Height: ");
                        shape = new Trapezoid(unitPrice, baseTrap1, baseTrap2, heightTrap);
                        
                        break;
                     
                    //user chooses hexagon  
                    case 7:
                        
                        double lenHex = validateDouble(scanner, "Length: ");
                        shape = new Hexagon(unitPrice, lenHex);
                        break;
                        
                    //handle invalid number from user
                    default:
                        System.out.println("\nInvalid input, please enter a number from 1 to 8.\n");
                        continue;
                    
                }
                
                //add new shape and end loop
                shapes.add(shape);
                System.out.println("Got that, " + shape);
                break;
            }
            
            //invalid input handle
            catch(NumberFormatException e)
            {
                System.out.println("\nInvalid input, please enter a number from 1 to 7.\n");
            }
        }
        
    }
    
    
    /**
     * removes shape from arraylist
     * @param scanner object
     * pre: scanner is created
     * post: none
     */
    private static void removeShape(Scanner scanner)
    {
        //if no shapes
        if(shapes.isEmpty())
        {
            System.out.println("\nSorry, there aren't any shapes to delete.\n");
            return;
        }
        
        //list all shapes with index
        displayShapes();
        
        //prompt user for shape they wish to delete
        System.out.print("\nEnter the index of the shape you wish to delete.\n");
        
        try
        {
            //define integer variable index to store string input converted to integer
            int index = Integer.parseInt(scanner.nextLine());
            
            //if valid index
            if(index >= 0 && index < shapes.size())
            {
                System.out.println("\nGot that, " + shapes.remove(index) + " was just deleted.\n");
            }
            
            //if index not found
            else
            {
                System.out.println("\nSorry, there is no shape at that index.\n");
            }
        }
        
        //invalid input handle
        catch(NumberFormatException e)
        {
            System.out.println("\nInvalid input, please enter a valid index.\n");
        }
    }
    
    
    /**
     * Displays shapes in arraylist
     * pre: none
     * post: prints list of shapes
     */
    private static void displayShapes()
    {
        //if no shapes
        if(shapes.isEmpty())
        {
            System.out.println("\nSorry, there aren't any shapes to display.\n");
            return;
        }
        
        //loop for listing all shapes
        for(int i = 0; i < shapes.size(); i++)
        {
            System.out.println(i + ": " + shapes.get(i));
        }
    }
    
    
    /**
     * Sets a unit price
     * @param scanner object
     * pre: scanner is created
     * post: none
     */
    private static void setUnitPrice(Scanner scanner)
    {
        //prompt user for unit price
        System.out.println("\nUnit price: ");
        
        try
        {
            //define double variable price to store string input converted to double
            double price = Double.parseDouble(scanner.nextLine());
            
            //if invalid price
            if(price <= 0)
            {
                System.out.println("\nInvalid input, please enter a positive number.\n");
                return;
            }
            
            //assign price to all shapes
            for(Shape x: shapes)
            {
                x.setUnitPrice(price);
            }
            
            //print success message
            System.out.println("\nGot that, the unit price was set to $" + price);
        }
        
        //invalid input handle
        catch(NumberFormatException e)
        {
            System.out.println("\nInvalid input, please enter a valid number.\n");
        }
    }
    
    
    /**
     * Calculates total cost
     * pre: none
     * post: print total cost if valid prerequisites, else invalid input message
     */
    private static void calcTotalCost()
    {
        //if no shapes
        if(shapes.isEmpty())
        {
            System.out.println("\nSorry, we couldn't find any shapes to calculate the cost of.\n");
            return;
        }
        
        //if no unit price set
        if(shapes.get(0).getUnitPrice() <= 0)
        {
            System.out.println("\nPlease set a unit price first by selecting option 4.\n");
            return;
        }
        
        //define double variable totalCost to store total cost
        double totalCost = 0;
        
        //loop through all costs for each shape
        for(Shape x: shapes)
        {
            //calculate total cost
            totalCost += x.getCost();
        }
        
        //print total cost in output
        System.out.println("\nTotal cost is $" + totalCost);
    }
    
    
    /**
     * Calculates total area
     * pre: none
     * post: print total area if valid prerequisites, else invalid input message
     */
    private static void calcTotalArea()
    {
        //if no shapes
        if(shapes.isEmpty())
        {
            System.out.println("\nSorry, we couldn't find any shapes to calculate the area of.\n");
            return;
        }
        
        //define double variable totalArea to store total area
        double totalArea = 0;
        
        //loop through all areas for each shape
        for(Shape x: shapes)
        {
            //calculate total area
            totalArea += x.getArea();
        }
        
        //print total area in output
        System.out.println("\nTotal area is " + totalArea);
    }
    
    /**
     * Clears all shapes in arraylist
     * pre: none
     * post: clears all the shapes
     */
    private static void clearShapes()
    {
        //clear ArrayList
        shapes.clear();
        System.out.println("\nGot that, all shapes are now cleared.\n");
    }
}
