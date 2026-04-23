/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A class that creates the Property object with the fields for a name, city, rent, and owner.
 * Due: 11/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public class Property
{
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // Constructors
    public Property() 
    {
        this("", "", 0.0, "");
        plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner)
    {
        this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
    }

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty)
    {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.getPlot());
    }

    // Methods
    public Plot getPlot()
    {
        return new Plot(plot);
    }

    public String getPropertyName()
    {
        return propertyName;
    }

    public String getCity()
    {
        return city;
    }

    public double getRentAmount()
    {
        return rentAmount;
    }

    public String getOwner()
    {
        return owner;
    }

    public String toString()
    {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}