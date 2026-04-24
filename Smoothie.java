/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: The Smoothie class represents a type of Beverage that may have fruit and extra protein.
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public class Smoothie extends Beverage
{
	private int numOfFruits;
	private boolean addProtein;
	private final double FRUITS = 0.50;
	private final double PROTEIN = 1.50;
	
	
	// Constructor initializes smoothie name, fruit count, and protein option.
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	// Returns the number of fruits in the smoothie.
	public int getNumOfFruits()
	{
		return numOfFruits;
	}
	
	// Returns whether protein was added.
	public boolean getAddProtein()
	{
		return addProtein;
	}
	
	// Returns a string representation of the smoothie, including price, fruit count, and if protein was added.
	@Override
	public String toString()
	{
		return super.toString() + ", Protiend Added: " + addProtein + 
				", Number of Fruits: " + numOfFruits + ", $" + calcPrice() + "\n";
	}
	
	// Calculates the total price of the smoothie.
	public double calcPrice()
	{
		double price = super.addSizePrice();
		
		price += getNumOfFruits() * FRUITS;
		if(addProtein == true)
		{
			price += PROTEIN;
		}
		return price;
	}
	
	// Compares two smoothie objects for equality.
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
		
		Smoothie other = (Smoothie)anotherBev;
		
		return super.equals(other) &&
				this.numOfFruits == other.numOfFruits &&
				this.addProtein == other.addProtein;
	}

}
