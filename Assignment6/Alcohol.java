/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: The Alcohol class represents a type of Beverage that may have an extra cost on weekends
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public class Alcohol extends Beverage
{
	private boolean isWeekend;
	private final double WEEKEND_PRICE = 0.60;
	
	// Constructor initializes the beverage name, size, and weekend status.
	public Alcohol(String bevName, Size size, boolean isWeekend)
	{
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	// Calculates the total price of the alcohol beverage.
	public double calcPrice()
	{
		double price = super.addSizePrice();
		if(isWeekend == true)
		{
			price += WEEKEND_PRICE;
		}
		return price;
	}
	
	// Returns a string representation including base info and price.
	@Override
	public String toString()
	{
		return super.toString() + "$" + calcPrice() + "\n";
	}
	
	// Checks for equality between this Alcohol object and another.
	@Override
	public boolean equals(Object anotherBev)
	{
		if(super.equals(anotherBev) && ((Alcohol) anotherBev).isWeekend() == this.isWeekend())
		{
			return true;
		}
		return false;
	}
	
	// Getter method to check if the beverage is ordered on a weekend.
	public boolean isWeekend()
	{
		return isWeekend;
	}

}
