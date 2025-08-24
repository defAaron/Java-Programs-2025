/**
 * This program is an interactive integer sorting program that allows the user
 * to sort a group of numbers using selection, bubble, insertion, or quick sort,
 * and can display the numbers in ascending or descending order.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-13
 */

import java.util.*;

public class MyProgram
{
    public static void main(String[] args)
    {
        //create scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        //create random object for generating random numbers
        Random random = new Random();
        
        //define boolean variable repeat to control main loop
        boolean repeat = true;
        
        //main loop
        while(repeat)
        {
            //define integer variable size to store number of integers to be sorted
            int size = 0;
            
            //print welcome message
            System.out.println("Welcome to Aaron's Special Sorting Program!");
            System.out.println("-------------------------------------------");
            
            //loop for prompting number of integers to be sorted
            while(true)
            {
                try
                {
                    System.out.print("\nHow many integers would you like to sort? ");
                    
                    size = Integer.parseInt(scanner.nextLine());
                    
                    //valid input
                    if(size > 0)
                    {
                        break;
                    }
                    
                    //invalid input
                    System.out.println("\nInvalid input, please enter a positive integer.\n");
                }
                
                //handle invalid input
                catch(NumberFormatException e)
                {
                    System.out.println("\nInvalid input, please enter a positive integer.\n");
                }
            }
            
            //define integer array numbers to store an array of integers with size equal to variable size
            int[] numbers = new int[size];
            
            //loop to fill array
            for(int i = 0; i < size; i++)
            {
                //generate random integer between -1000 and 1000
                numbers[i] = random.nextInt(2001) - 1000;
            }
            
            //display inital list
            System.out.println("\nList before sorting: " + Arrays.toString(numbers));
            
            //define integer variable choice to store user menu option
            int choice = menuOption(scanner);
            
            //define boolean variable ascending to store user sort order option
            boolean ascending = sortOrder(scanner);
            
            switch(choice)
            {
                //user wants to use selection sort
                case 1:
                    
                    selectionSort(numbers, ascending);
                    break;
                    
                //user wants to use bubble sort
                case 2:
                    
                    bubbleSort(numbers, ascending);
                    break;
                
                //user wants to use insertion sort    
                case 3:
                    
                    insertionSort(numbers, ascending);
                    break;
                
                //user wants to use quick sort    
                case 4:
                    
                    quickSort(numbers, 0, numbers.length - 1, ascending);
                    break;
            }
            
            //display final list
            System.out.println("\nList after sorting: " + Arrays.toString(numbers));
            
            //loop for asking if user wants to repeat
            while(true)
            {
                System.out.print("\nWould you like to do this again? (Y/N)");
                
                String again = scanner.nextLine().trim().toUpperCase();
                
                //if user wants to repeat
                if(again.equals("Y"))
                {
                    repeat = true;
                    break;
                }
                
                //if user wants to exit program
                else if(again.equals("N"))
                {
                    repeat = false;
                    System.out.println("\nGot that, see you next time!");
                    break;
                }
                
                //invalid input
                else
                {
                    System.out.println("\nSorry, I couldn't understand that. Please enter a Y or N.\n");
                }
            }
        }
        
        //close the scanner
        scanner.close();
    }
    
    /**
     * displays sorting menu and prompts menu option choice
     * @param scanner object
     * @return choice of user as an integer
     * pre: scanner is created
     * post: return integer between 1 and 4
     */
    public static int menuOption(Scanner scanner)
    {
        //define integer variable choice to store user input
        int choice = 0;
        
        //loop for prompting menu option
        while(true)
        {
            //print menu options
            System.out.println("\nChoose the sorting algorithm you wish to use:");
            System.out.println("1)    Selection Sort.");
            System.out.println("2)    Bubble Sort.");
            System.out.println("3)    Insertion Sort.");
            System.out.println("4)    Quick Sort.");
            
            try
            {
                System.out.print("\nOption: ");
                choice = Integer.parseInt(scanner.nextLine());
                
                //valid input
                if(choice >= 1 && choice <= 4)
                {
                    break;
                }
                
                //invalid input
                System.out.println("\nInvalid input, please enter a number from 1 to 4.\n");
            }
            
            //handle invalid input
            catch(NumberFormatException e)
            {
                System.out.println("\nInvalid input, please enter a number from 1 to 4.\n");
            }
        }
        return choice;
    }
    
    
    /**
     * prompts whether user wants ascending or descending order
     * @param scanner object
     * @return choice of user as a boolean
     * pre: scanner is created
     * post: return true if ascending, false if descending
     */
    public static boolean sortOrder(Scanner scanner)
    {
        //loop for prompting sort order
        while(true)
        {
            System.out.println("\nSort order (A = ascending, D = descending) : ");
            
            String order = scanner.nextLine().trim().toUpperCase();
            
            //if ascending
            if(order.equals("A"))
            {
                return true;
            }
            
            //if descending
             if(order.equals("D"))
            {
                return false;
            }
            
            //invalid input
            System.out.println("\nInvalid input, please enter an a or d\n");
        }
    }
    
    
    /**
     * sorts array using selection sort
     * @param integer array arr 
     * @param boolean variable ascending
     * @return none
     * pre: arr and ascending are not null
     * post: arr is sorted
     */
    public static void selectionSort(int [] arr, boolean ascending)
    {
        //outer loop
        for(int i = 0; i < arr.length - 1; i++)
        {
            //define integer variable taget to store index of smallest or largest value
            int target = i;
            
            //inner loop
            for(int j = i + 1; j < arr.length; j++)
            {
                if((ascending && arr[j] < arr[target]) || (!ascending && arr[j] > arr[target]))
                {
                    //update target
                    target = j;
                }
            }
            
            //swap values
            int temp = arr[target];
            arr[target] = arr[i];
            arr[i] = temp;
        }
    }
    
    
    /**
     * sorts array using bubble sort
     * @param integer array arr 
     * @param boolean variable ascending
     * @return none
     * pre: arr and ascending are not null
     * post: arr is sorted
     */
    public static void bubbleSort(int [] arr, boolean ascending)
    {
        //define boolean variable sorted to control loop
        boolean sorted;
        
        //outer loop
        for(int i = 0; i < arr.length - 1; i++)
        {
            //not sorted
            sorted = false;
            
            //inner loop
            for(int j = 0; j < arr.length - i - 1; j++)
            {
                if((ascending && arr[j] > arr[j + 1]) || (!ascending && arr[j] < arr[j + 1]))
                {
                    //swap values
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = true;
                }
            }
            
            //if not sorted
            if(!sorted)
            {
                break; 
            }
        }
    }
    
    
    /**
     * sorts array using insertion sort
     * @param integer array arr 
     * @param boolean variable ascending
     * @return none
     * pre: arr and ascending are not null
     * post: arr is sorted
     */
    public static void insertionSort(int [] arr, boolean ascending)
    {
        //start from second element
        for(int i = 1; i < arr.length; i++)
        {
            //define integer variable j to store previous index
            int j = i - 1;
            
            //define integer variable key to store value to insert
            int key = arr[i];
            
            while(j >= 0 && ((ascending && arr[j] > key) || (!ascending && arr[j] < key)))
            {
                //shift element
                arr[j + 1] = arr[j];
                j--;
            }
            
            //insert key
            arr[j + 1] = key;
            
        }
    }
    
    
    /**
     * sorts array using quick sort
     * @param integer array arr 
     * @param boolean variable ascending
     * @return none
     * pre: arr is not null
     * post: arr is sorted
     */
    public static void quickSort(int [] arr, int low, int high, boolean ascending)
    {
        if(low < high)
        {
            //define integer variable p as the pivot index
            int p = partition(arr, low, high, ascending);
            
            //sort left side
            quickSort(arr, low, p - 1, ascending);
            
            //sort right side
            quickSort(arr, p + 1, high, ascending);
        }
    }
    
    
    /**
     * partitions array for quick sort
     * @param integer array arr 
     * @param integer variable low
     * @param integer variable high
     * @param boolean variable ascending
     * @return index of pivot element after partition
     * pre: arr is not null, low >= 0, high < arr.length
     * post: pivot is placed in right spot
     */
    public static int partition(int[] arr, int low, int high, boolean ascending)
    {
        //choose last element as pivot
        int pivot = arr[high];
        
        //define integer variable i as the smaller element index
        int i = low - 1;
        
        for(int j = low; j < high; j++)
        {
            if((ascending && arr[j] <= pivot) || (!ascending && arr[j] >= pivot))
            {
                //swap values
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        //swap pivot into right spot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
