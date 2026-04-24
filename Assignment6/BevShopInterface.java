/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: The BevShopInterface is an interface that defines the required behavior for a beverage shop.
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/


public interface BevShopInterface 
{
	//Minimum and maximum values for various fields.
	static final int MIN_AGE_FOR_ALCOHOL = 21;
	static final int MAX_ORDER_FOR_ALCOHOL = 3;
	static final int MIN_TIME = 8;
	static final int MAX_TIME = 23;
	static final int MAX_FRUIT = 5;
	
	
	//Methods to be implemented by the class that implements this interface.
	boolean isValidTime(int time);
	
	int getMaxNumOfFruits();
	
	int getMinAgeForAlcohol();
	
	boolean isMaxFruit(int numOfFruits);
	
	int getMaxOrderForAlcohol();
	
	boolean isEligibleForMore();
	
	int getNumOfAlcoholDrink();
	
	boolean isValidAge(int age);
	
	void startNewOrder(int time, Day day, String customerName, int customerAge);
	
	void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup);
	
	void processAlcoholOrder(String bevName, Size size);
	
	void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein);
	
	int findOrder(int orderNo);
	
	double totalOrderPrice(int orderNo);
	
	double totalMonthlySale();
	
	int totalNumOfMonthlyOrders();
	
	Order getCurrentOrder();
	
	Order getOrderAtIndex(int index);
	
	void sortOrders();

}
