/**
 * Class declaration for parallelogram object for the Shape class.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-07
 * Bugs: none known
 */

public class Parallelogram extends Shape
{
    //constructor for parallelogram
    public Parallelogram(double price, double base, double height)
    {
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
        return dimensionsList[0] * dimensionsList[1];
    }
    
    //return a string that contains all of the shapes info
    public String toString()
    {
        return "The base of the parallelogram is " + dimensionsList[0] + ", the height is " + dimensionsList[1] + ", and the area is " + getArea();
    }
}
