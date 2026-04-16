/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A program that creates the Patient object and creates accessors and mutators for its attributes.
 * Due: 09/26/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public class Patient 
{
	private String firstName, middleName, lastName;
	private String address, city, state, zip;
	private String eName, eNumber;
	private String name, fullAddress, emergencyContact;
	
	//No arg constructor
	public Patient()
	{
		
	}
	
	//Parameterized constructor for first, middle, and last name
	public Patient(String a, String b, String c)
	{
		firstName = a;
		middleName = b;
		lastName = c;
	}
	
	//Parameterized constructor for address
	public Patient(String a, String b, String c, String d)
	{
		address = a;
		city = b;
		state = c;
		zip = d;
	}
	
	//Accessors and mutators for all attributes
	public void setFirstName(String a)
	{
		firstName = a;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setMiddleName(String b)
	{
		middleName = b;
	}
	
	public String getMiddleName()
	{
		return middleName;
	}
	
	public void setLastName(String c)
	{
		lastName = c;
	}
	public String getLastName()
	{
		return lastName;
	}
	
	public void setAddress(String d)
	{
		address = d;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setCity(String e)
	{
		city = e;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setState(String f)
	{
		state = f;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setZip(String g)
	{
		zip = g;
	}
	
	public String getZip()
	{
		return zip;
	}
	
	public void setEmergencyName(String h)
	{
		eName = h;
	}
	
	public String getEmergencyName()
	{
		return eName;
	}
	
	public void setEmergencyNumber(String i)
	{
		eNumber = i;
	}
	
	public String getEmergencyNumber()
	{
		return eNumber;
	}
	
	//Method to build full name
	public String buildFullName()
	{
		name = firstName + " " + middleName + " " + lastName;
		return name;
	}
	
	//Method to build full address
	public String buildAddress()
	{
		fullAddress = address + " " + city + " " + state + " " + zip;
		return fullAddress;
	}
	
	//Method to build full emergency contact
	public String buildEmergencyContact()
	{
		emergencyContact = eName + " " + eNumber;
		return emergencyContact;
	}
	
	//toString method
	public String toString()
	{
		return "Patient info: \n" +
				"  Name: " + name + 
				"\n  Address: " + fullAddress + 
				"\n  Emergency Contact: " + emergencyContact + 
				"\n\n";
	}
}
