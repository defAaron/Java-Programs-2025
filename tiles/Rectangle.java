/**
 * Class declaration for rectangle object for the Shape class.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-07
 * Bugs: none known
 */
 
public class Rectangle extends Shape
{
    
    //constructor for rectangle
    public Rectangle(double price, double len, double wid)
    {
        //calling superclass constructor to set unit price and dimensions list
        super(price, new double[] {len, wid});
    }
    
    //getters
    public double[] getDimensionsList()
    {
        return dimensionsList;
    }
    
    public double getArea()
    {
        //calculate area
        return dimensionsList[0] * dimensionsList[1];
    }
    
    //return a string that contains all of the shapes info
    public String toString()
    {
        return "The length of the rectangle is " + dimensionsList[0] + ", the width is " + dimensionsList[1] + ", and the area is " + getArea();
    }
}
