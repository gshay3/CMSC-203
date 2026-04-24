/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Abstract class representing a general Beverage.
 * Serves as a base class for specific beverage types.
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public abstract class Beverage extends Object
{
	private final double BASE_PRICE = 2.00;
	private final double SIZE_PRICE = 1.00;
	private String bevName;
	private Type type;
	private Size size;
	
	//Constructor initializes beverage name, type, and size.
	public Beverage(String bevName, Type type, Size size)
	{
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	//Returns the base price of the beverage.
	public double getBasePrice()
	{
		return BASE_PRICE;
	}
	
	//Returns the type of the beverage.
	public Type getType()
	{
		return type;
	}
	
	//Returns the name of the beverage.
	public String getBevName()
	{
		return bevName;
	}
	
	//Returns the size of the beverage.
	public Size getSize()
	{
		return size;
	}
	
	//Calculates the price based on size.
	public double addSizePrice()
	{
		if(size == Size.SMALL)
		{
			return BASE_PRICE;
		}
		else if(size == Size.MEDIUM)
		{
			return BASE_PRICE + SIZE_PRICE;
		}
		else
		{
			return BASE_PRICE + (2*SIZE_PRICE);
		}
	}
	
	//Returns a string representation of the beverage.
	@Override
	public String toString()
	{
		return bevName + ", " + size + ", ";
	}
	
	//Compares this Beverage object with another for equality.
	//Two beverages are equal if they have the same name, type, and size.
	@Override
	public boolean equals(Object anotherBev)
	{
		if(this == anotherBev)
		{
			return true;
		}
		if(anotherBev == null || this.getClass() != anotherBev.getClass())
		{
			return false;
		}
		Beverage other = (Beverage)anotherBev;
		return this.bevName.equals(other.bevName) && 
				this.type == other.type && 
				this.size == other.size;
	}
	
	//Abstract method to calculate the total price.
	public abstract double calcPrice();

}
