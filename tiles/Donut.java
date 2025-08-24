/**
 * Class declaration for donut object for the Shape class.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-07
 * Bugs: none known
 */

public class Donut extends Shape
{
    //constructor for donut
    public Donut(double price, double largeRadius, double smallRadius)
    {
    //calling superclass constructor to set unit price and dimensions list
       super(price, new double[] {largeRadius, smallRadius});
    }

    //getters
    public double[] getDimensionsList()
    {
        return dimensionsList;
    }
    
    public double getArea()
    {
        //calculate area
        return (dimensionsList[0] * dimensionsList[0] - dimensionsList[1] * dimensionsList[1]) * Math.PI;
    }
    
    //return a string that contains all of the shapes info
    public String toString()
    {
        return "The large radius of the donut is " + dimensionsList[0] + ", the small radius is " + dimensionsList[1] + ", and the area is " + getArea();
    }
}
