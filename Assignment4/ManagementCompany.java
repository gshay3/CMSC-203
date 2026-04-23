/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A class that builds the ManagementCompany object and calculates information based off it's properties and plots.
 * Due: 11/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public class ManagementCompany
{
    private static final int MAX_PROPERTY = 5;
    private static final int MGMT_WIDTH = 10;
    private static final int MGMT_DEPTH = 10;

    private String name;
    private String taxID;
    private double mgmFee;
    private Plot plot;
    private Property[] properties;
    private int propertyCount;

    // Constructors
    public ManagementCompany()
    {
        this("", "", 0.0);
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(String name, String taxID, double mgmFee)
    {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
    {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(ManagementCompany otherCompany)
    {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFee = otherCompany.mgmFee;
        this.plot = new Plot(otherCompany.plot);
        this.properties = new Property[MAX_PROPERTY];
    }

    // Methods
    public int addProperty(String name, String city, double rent, String owner)
    {
        return addProperty(name, city, rent, owner, 0, 0, 1, 1);
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
    {
        Property p1 = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(p1);
    }

    public int addProperty(Property property)
    {
        if (propertyCount >= MAX_PROPERTY)
        {
            return -1;
        }

        else if (property == null)
        {
        	return -2;
        }
        
        else if (!plot.encompasses(property.getPlot()))
        {
            return -3;
        }

        for (int i = 0; i < propertyCount; i++)
        {
            if (properties[i].getPlot().overlaps(property.getPlot()))
            {
                return -4;
            }
        }

        properties[propertyCount] = property;
        propertyCount++;
        return propertyCount - 1;
    }

    public void removeLastProperty()
    {
        if (propertyCount > 0)
        {
            properties[propertyCount - 1] = null;
            propertyCount--;
        }
    }

    public boolean isPropertiesFull()
    {
    	if(propertyCount == MAX_PROPERTY)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    public int getPropertiesCount()
    {
        return propertyCount;
    }

    public double getTotalRent()
    {
        double totalRent = 0.0;
        for (int i = 0; i < propertyCount; i++)
        {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    public Property getHighestRentPropperty()
    {
        Property highestRentProperty = properties[0];
        for (int i = 1; i < propertyCount; i++)
        {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount())
            {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    public boolean isMangementFeeValid()
    {
    	if(mgmFee >= 0.0 && mgmFee <= 100.0)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    public String getName()
    {
        return name;
    }

    public String getTaxID()
    {
        return taxID;
    }

    public Property[] getProperties()
    {
    	Property[] propertiesCopy;
    	propertiesCopy = new Property[propertyCount];
    	for (int i = 0; i < propertyCount; i++) {
            propertiesCopy[i] = properties[i];
        }
    	return propertiesCopy;
    }

    public double getMgmFeePer()
    {
        return mgmFee;
    }

    public Plot getPlot()
    {
        return new Plot(plot);
    }

    public String toString()
    {
    	StringBuilder result = new StringBuilder("List of the properties for " + name + ", taxID: " + taxID + "\n");
    	result.append("______________________________________________________\n");

    	for (int i = 0; i < propertyCount; i++)
    	{
    	    result.append(properties[i].toString()).append("\n");
    	}
    	result.append("______________________________________________________\n");

    	double totalMgmFee = (mgmFee / 100) * getTotalRent();
    	result.append("\n total management Fee: ").append(String.format("%.2f", totalMgmFee));
    	return result.toString();
    }
}
