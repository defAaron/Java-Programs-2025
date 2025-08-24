/**
 * Class declaration for item class.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-08
 * Bugs: none known
 */

public class Item 
{
    //define instance variables
    private String sku;
    private String name;
    private String category;
    private int quantity;
    private int minimumQuantity;
    private double vendorPrice;
    private double markupPercentage;
    private double currentDiscount;
    
    //constructor to initialize all instance variables
    public Item(String sku, String name, String category, int quantity, int minimumQuantity, double vendorPrice, double markupPercentage, double currentDiscount)
    {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.minimumQuantity = minimumQuantity;
        this.vendorPrice = vendorPrice;
        this.markupPercentage = markupPercentage;
        this.currentDiscount = currentDiscount;
    }
    
    //getters
    public String getSku()
    {
        return sku;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getCategory()
    {
        return category;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public int getMinimumQuantity()
    {
        return minimumQuantity;
    }
    
    public double getVendorPrice()
    {
        return vendorPrice;
    }
    
    public double getMarkupPercentage()
    {
        return markupPercentage;
    }
    
    public double getCurrentDiscount()
    {
        return currentDiscount;
    }


    //setters
    public void setSku(String sku)
    {
        this.sku = sku;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setCategory(String category)
    {
        this.category = category;
    }
    
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public void setMinimumQuantity(int minimumQuantity)
    {
        this.minimumQuantity = minimumQuantity;
    }
    
    public void setVendorPrice(double vendorPrice)
    {
        this.vendorPrice = vendorPrice;
    }
    
    public void setMarkupPercentage(double markupPercentage)
    {
        this.markupPercentage = markupPercentage;
    }
    
    public void setCurrentDiscount(double currentDiscount)
    {
        this.currentDiscount = currentDiscount;
    }

    //getters for calculated values
    public double getRegularPrice()
    {
        return vendorPrice * (1 + markupPercentage / 100);
    }
    
    public double getCurrentPrice()
    {
        return getRegularPrice() * (1 + currentDiscount / 100);
    }

    //return a string that contains all of the item's info
    public String toString()
    {
        return String.format("%s, %s, %s, %d, %d, %.2f, %.0f, %.2f, %.0f, %.2f", sku, name, category, quantity, minimumQuantity, vendorPrice, markupPercentage, getRegularPrice(), currentDiscount, getCurrentPrice());
    }
}
