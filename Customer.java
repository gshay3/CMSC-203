/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: The Customer class represents a customer with a name and age.
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public class Customer extends Object 
{
	private String name;
	private int age;
	
	//Constructor that initializes a new Customer with a name and age.
	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	//Copy constructor that creates a new Customer object from an existing one.
	public Customer(Customer c)
	{
		this.name = c.name;
		this.age = c.age;
	}
	
	//Returns the customer's age.
	public int getAge()
	{
		return age;
	}
	
	//Updates the customer's age.
	public void setAge(int ageSet)
	{
		age = ageSet;
	}
	
	//Returns the customer's name.
	public String getName()
	{
		return name;
	}
	
	//Updates the customer's name.
	public void setName(String nameSet)
	{
		name = nameSet;
	}
	
	//Returns a string representation of the customer's name and age.
	@Override
	public String toString()
	{
		return name + "," + age;
	}

}
