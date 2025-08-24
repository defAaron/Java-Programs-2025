/**
 * Class declaration for hexagon object for the Shape class.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-07
 * Bugs: none known
 */

public class Hexagon extends Shape
{
    //constructor for hexagon
    public Hexagon(double price, double len)
    {
        //calling superclass constructor to set unit price and dimensions list
        super(price, new double[] {len});
    }

    //getters
    public double[] getDimensionsList()
    {
        return dimensionsList;
    }
    
    public double getArea()
    {
        //calculate area
        return dimensionsList[0] * dimensionsList[0] * 3 * Math.sqrt(3) * 0.5;
    }
  
    //return a string that contains all of the shapes info
    public String toString()
    {
        return "The side length of the trapezoid is " + dimensionsList[0] + ", and the area is " + getArea();
    }
}
