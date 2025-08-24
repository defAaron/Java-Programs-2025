/**
 * Class declaration for trapezoid object for the Shape class.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-07
 * Bugs: none known
 */

public class Trapezoid extends Shape
{
    //constructor for trapezoid
    public Trapezoid(double price, double base1, double base2, double height)
    {
        //calling superclass constructor to set unit price and dimensions list
        super(price, new double[] {base1 , base2, height});
    }
    
    //getters
    public double[] getDimensionsList()
    {
        return dimensionsList;
    }
    
    public double getArea()
    {
        //calculate area
        return (dimensionsList[0] + dimensionsList[1]) * dimensionsList[2] * 0.5;
    }
    
    //return a string that contains all of the shapes info
    public String toString()
    {
        return "The bases of the trapezoid are " + dimensionsList[0] + " and " + dimensionsList[1] + ", the height is " + dimensionsList[2] + ", and the area is " + getArea();
    }
}
