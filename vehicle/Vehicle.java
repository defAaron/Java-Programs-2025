/**
 * Class declaration for vehicle object for the Vehicle Program.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-05
 * Bugs: none known
 */

import java.util.Scanner;

public class Vehicle 
{
    //defining instance variables (attributes)
    private int passengerNum;
    private double passengerFare;
    private double fuelEfficiency;
    
    //defining class variables
    private static double gasPrice;
    private final static int PROFIT = 400;
    
    //constructor for use in creating the public vehicle constants
    public Vehicle(int passengerNum, double passengerFare, double fuelEfficiency)
    {
        this.passengerNum = passengerNum;
        this.passengerFare = passengerFare;
        this.fuelEfficiency = fuelEfficiency;
    }
    
    //getters
    public int getPassengerNum()
    {
        return passengerNum;
    }
    
    public double getPassengerFare()
    {
        return passengerFare;
    }
    
    public double getFuelEfficiency()
    {
        return fuelEfficiency;
    }
    
    
    public static double getGasPrice()
    {
        return gasPrice;
    }
    
    public static int getProfitThreshold()
    {
        return PROFIT;
    }
    
    //setter
    public static void setGasPrice(double price)
    {
        gasPrice = price;
    }
    
    //other methods
    
    //calculate and return the total revenue of the vehicle
    public double revenue()
    {
        return passengerNum * passengerFare;
    }
    
    //calculate and return the total cost of gas using distance, fuelEfficiency, and gas price
    public double totalCost(double distance)
    {
        return fuelEfficiency * distance * gasPrice;
    }
    
    //calculate and return the profit of a vehicle
    public double calculateProfit(double distance)
    {
        return revenue() - totalCost(distance);
    }
    
    //return true or false depending on if the profit is higher than the profit threshold
    public boolean isProfitable(double distance)
    {
        return calculateProfit(distance) > getProfitThreshold();
    }
    
    //use the two vehicle objects and comparing their profits to return the vehicle object with the higher profit
    public static Vehicle compareTo(Vehicle v1, Vehicle v2, double distance)
    {
        return v1.calculateProfit(distance) >= v2.calculateProfit(distance) ? v1 : v2;
        
    }
    
    //return a string that contains all of the vehicle's info
    public String toString()
    {
        return "For this vehicle, the number of passengers is " + passengerNum + ", the fare is $" + passengerFare + ", and the efficiency is " + fuelEfficiency + "L/km";
    }
}
