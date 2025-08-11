/**
 * Class declaration for Employee object for Employee Program.
 * 
 * @author     Aaron Dutta
 * @version    1.0
 * @date       2025-08-06
 * Bugs: none known
 */

public class Employee 
{
    //defining instance variables
    private int employeeIdNumber;
    private String firstName;
    private String lastName;
    private double annualSalary;
    private String startDate;
    
    //constructor for use in creating public employee constants
    public Employee(int employeeIdNumber, String firstName, String lastName, double annualSalary, String startDate)
    {
        this.employeeIdNumber = employeeIdNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
        this.startDate = startDate;
    }
    
    //getters
    public int getEmployeeIdNumber()
    {
        return employeeIdNumber;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public double getAnnualSalary()
    {
        return annualSalary;
    }
    
    public String getStartDate()
    {
        return startDate;
    }
    
    //return a string that contains all of the employees info
    public String toString()
    {
        return "\n\nID Number: " + employeeIdNumber + ", First name: " + firstName + ", Last Name: " + lastName + ", Annual Salary: $" + annualSalary + ", Start Date: " + startDate;
    }
}
