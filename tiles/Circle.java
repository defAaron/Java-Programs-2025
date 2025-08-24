/**
 * Class declaration for circle object for the Shape class.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-07
 * Bugs: none known
 */

public class Circle extends Shape
{
    //constructor for circle
    public Circle(double price, double radius)
    {
        //calling superclass constructor to set unit price and dimensions list
        super(price, new double[] {radius});
    }
    
    //getters
    public double[] getDimensionsList()
    {
        return dimensionsList;
    }
    
    public double getArea()
    {
        //calculate area
        return dimensionsList[0] * dimensionsList[0] * Math.PI;
    }
    
    //return a string that contains all of the shapes info
    public String toString()
    {
        return "The radius of the circle is " + dimensionsList[0] + ", and the area is " + getArea();
    }
}
