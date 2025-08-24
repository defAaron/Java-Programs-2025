/**
 * Abstract class declaration for the class shape that represents a geometric
 * shape, and defines methods that all shapes need to have
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-07
 * Bugs: none known
 */

public abstract class Shape 
{
    //defining instance variables
    protected double unitPrice;
    protected double[] dimensionsList;
    
    //constructor to initialize unit price and dimensions list
    public Shape(double unitPrice, double[] dimensionsList)
    {
        this.unitPrice = unitPrice;
        this.dimensionsList = dimensionsList;
    }
    
    //getters 
    public double getUnitPrice()
    {
        return unitPrice;
    }
    
    public double getCost()
    {
        return unitPrice * getArea();
    }
    
    public double[] getDimensionsList()
    {
        return dimensionsList;
    }
    
    //setter
    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
    }
    
    //abstract method to calculate area of shape
    public abstract double getArea();
    
    ////abstract method to provide string message about shape
    public abstract String toString();
}
