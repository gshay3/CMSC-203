/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A program that allows you to enter patient and procedure data and then displays it along with their calculated total charges.
 * Due: 09/26/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public class PatientDriverApp 
{
	public static void main(String[] args)
	{
		//Creating a new Patient object and setting/returning values for its fields
		Patient a = new Patient();
		a.setFirstName("Mark");
		a.setMiddleName("S");
		a.setLastName("Manson");
		a.buildFullName();
		a.setAddress("8651 Magnolia Way");
		a.setCity("Rockville");
		a.setState("MD");
		a.setZip("20850");
		a.buildAddress();
		a.setEmergencyName("John Manson");
		a.setEmergencyNumber("310-248-9532");
		a.buildEmergencyContact();
		
		//Creating a new Procedure object and setting/returning values for its fields
		Procedure x = new Procedure();
		x.setProcedure("Heart Surgery");
		x.setDate("09/25/23");
		x.setPractitioner("Dr. Smith");
		x.setCharges(3000.75);
		
		//Creating a second Procedure object and setting/returning values for its fields
		Procedure y = new Procedure();
		y.setProcedure("Physical Exam");
		y.setDate("09/26/23");
		y.setPractitioner("Dr. Smith");
		y.setCharges(250.00);
		
		//Creating a third Procedure object and setting/returning values for its fields
		Procedure z = new Procedure();
		z.setProcedure("Endoscopy");
		z.setDate("09/27/23");
		z.setPractitioner("Dr. Smith");
		z.setCharges(1350.50);
		
		//Displaying the personal information of the patient and their procedures
		System.out.print(a);
		System.out.print(x);
		System.out.print(y);
		System.out.print(z);
		//Displaying the total charges from the patient's procedures
		System.out.print(calculateTotalCharges(x, y, z));
		
		System.out.print("The program was developed by a Student: Griffin Shay 09/26/23");
	}
	
	//A method to calculate and display total charges
	public static String calculateTotalCharges(Procedure one, Procedure two, Procedure three)
	{
		double totalCharges = one.getCharges() + two.getCharges() + three.getCharges();
		return "Total Charges: $" + totalCharges + "\n\n";
	}
}
