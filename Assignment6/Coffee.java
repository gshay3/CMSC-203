/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: The Coffee class represents a coffee beverage with optional extras.
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public class Coffee extends Beverage
{
	private boolean extraShot;
	private boolean extraSyrup;
	private final double SHOT = 0.50;
	private final double SYRUP = 0.50;
	
	//Constructor initializes coffee name, size, and optional add-ons.
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	//Returns whether the coffee has an extra shot.
	public boolean getExtraShot()
	{
		return extraShot;
	}
	
	//Returns whether the coffee has extra syrup.
	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}
	
	//Calculates the total price of the coffee depending on its base price, size, and potential add-ons.
	public double calcPrice()
	{
		double price = super.addSizePrice();
		if(getExtraShot() == true)
		{
			price += SHOT;
		}
		if(getExtraSyrup() == true)
		{
			price += SYRUP;
		}
		return price;
	}
	
	//Returns a string representation including extras and total price.
	@Override
	public String toString()
	{
		return super.toString() + ", Extra Shot: " + extraShot + 
				", Extra Syrup: " + extraSyrup + ", $" + calcPrice() + "\n";
	}
	
	//Compares this coffee object with another for equality
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
		Coffee other = (Coffee)anotherBev;
		return super.equals(other) && 
				this.extraShot == other.extraShot && 
				this.extraSyrup == other.extraSyrup;
	}

}
