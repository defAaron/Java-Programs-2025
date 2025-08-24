/**
 * Class declaration for triangle object for the Shape class.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-07
 * Bugs: none known
 */

public class Triangle extends Shape
{
    //constructor for triangle
    public Triangle(double price, double base, double height)
    {
        //calling superclass constructor to set unit price and dimensions list
        super(price, new double[] {base, height});
    }
    
    //getters
    public double[] getDimensionsList()
    {
        return dimensionsList;
    }
    
    public double getArea()
    {
        //calculate area
        return dimensionsList[0] * dimensionsList[1] * 0.5;
    }
    
    //return a string that contains all of the shapes info
    public String toString()
    {
        return "The base of the triangle is " + dimensionsList[0] + ", the height is " + dimensionsList[1] + ", and the area is " + getArea();
    }
}
