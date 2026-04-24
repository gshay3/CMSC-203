/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: The OrderInterface defines the required behaviors for the Order class.
 * It specifies how many beverages are added, retrieved, and calculated within an order.
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public interface OrderInterface 
{
	boolean isWeekend();
	
	Beverage getBeverage(int itemNo);
	
	void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup);
	
	void addNewBeverage(String bevName, Size size);
	
	void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein);
	
	double calcOrderTotal();
	
	int findNumOfBevType(Type type);

}
