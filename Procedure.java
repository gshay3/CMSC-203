/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A program that creates the Procedure object and creates accessors and mutators for its attributes.
 * Due: 09/26/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public class Procedure 
{
	private String procedure;
	private String date;
	private String practitioner;
	private double charges;
	
	//No arg constructor
	public Procedure()
	{
		
	}
	
	//Parameterized constructor for procedure name and date
	public Procedure(String a, String b)
	{
		procedure = a;
		date = b;
	}
	
	//Parameterized constructor for all attributes
	public Procedure(String a, String b, String c, double d)
	{
		procedure = a;
		date = b;
		practitioner = c;
		charges = d;
	}
	
	//Accessors and mutators for all attributes
	public void setProcedure(String a)
	{
		procedure = a;
	}
	
	public String getProcedure()
	{
		return procedure;
	}
	
	public void setDate(String b)
	{
		date = b;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setPractitioner(String c)
	{
		practitioner = c;
	}
	
	public String getPractitioner()
	{
		return practitioner;
	}
	
	public void setCharges(double d)
	{
		charges = d;
	}
	
	public double getCharges()
	{
		return charges;
	}
	
	//toString method
	public String toString()
	{
		return "\tProcedure: " + procedure + 
				"\n\tProcedure Date: " + date + 
				"\n\tPractitioner: " + practitioner + 
				"\n\tCharge: " + charges + "\n\n";
	}
	
}