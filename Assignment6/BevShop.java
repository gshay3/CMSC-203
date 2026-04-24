/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: The BevShop class manages orders and enforces rules for beverage purchases.
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

import java.util.ArrayList;

public class BevShop extends Object implements BevShopInterface
{
	private int numOfAlcoholDrinks = 0;
	public ArrayList<Order> orders;
	
	//Constructor initializes the order list.
	public BevShop()
	{
		orders = new ArrayList<Order>();
	}
	
	//Checks if a given time is within the valid operating hours.
	public boolean isValidTime(int time)
	{
		return (time >= MIN_TIME && time <= MAX_TIME);
	}
	
	//Returns the maximum number of fruit allowed in a smoothie.
	public int getMaxNumOfFruits()
	{
		return MAX_FRUIT;
	}
	
	//Returns the minimum age required to purchase alcohol.
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	//Checks if the number of fruits exceeds the allowed maximum.
	public boolean isMaxFruit(int numOfFruits)
	{
		return numOfFruits >= MAX_FRUIT;
	}
	
	//Returns the maximum number of alcohol drinks allowed per order.
	public int getMaxOrderForAlcohol()
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	//Checks if the customer has reached the maximum allowed alcohol drinks.
	public boolean isEligibleForMore()
	{
		return getNumOfAlcoholDrink() > MAX_ORDER_FOR_ALCOHOL;
	}
	
	//Returns the current number of alcohol drinks.
	public int getNumOfAlcoholDrink()
	{
		return numOfAlcoholDrinks;
	}
	
	//Checks if the customer meets the minimum age requirement for alcohol.
	public boolean isValidAge(int age)
	{
		return age >= MIN_AGE_FOR_ALCOHOL;
	}
	
	//Starts a new order and adds it to the list of orders.
	public void startNewOrder(int time, Day day, String customerName, int customerAge)
	{
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
	}
	
	//Adds a coffee beverage to the current order.
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	//Adds a alcohol beverage to the current order and updates the count.
	public void processAlcoholOrder(String bevName, Size size)
	{
		getCurrentOrder().addNewBeverage(bevName, size);
		numOfAlcoholDrinks++;
	}
	
	//Adds a smoothie to the current order.
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
	//Searches for an order by order number and returns its index or -1 if the order wasn't found.
	public int findOrder(int orderNo)
	{
		int index = -1;
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i).getOrderNo() == orderNo)
			{
				index = i;
			}
		}
		return index;
	}
	
	//Calculates the total price for a specific order.
	public double totalOrderPrice(int orderNo)
	{
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}
	
	//Calculates the total sales from all orders.
	public double totalMonthlySale()
	{
		double total = 0;
		for(int i = 0; i < orders.size(); i++)
		{
			total += orders.get(i).calcOrderTotal();
		}
		return total;
	}
	
	//Returns the total number of orders placed.
	public int totalNumOfMonthlyOrders()
	{
		return orders.size();
	}
	
	//Returns the most recently added order.
	public Order getCurrentOrder()
	{
		int index = orders.size() - 1;
		return orders.get(index);
	}
	
	//Returns the order at a specific index if valid, otherwise null.
	public Order getOrderAtIndex(int index)
	{
		if(index >= 0 && index < orders.size())
		{
			return orders.get(index);
		}
		return null;
	}
	
	//Sorts the orders list using a simple selection sort based on compareTo
	public void sortOrders()
	{
		for(int i = 0; i < orders.size()-1; i++) 
		{
			int index = i;	
			for(int x = i+1; x < orders.size(); x++) 
			{	
				if(orders.get(x).compareTo(orders.get(index)) == -1)
				{
					index = x;
				}
			}
			
			Order temp = orders.get(index);
			orders.set(index, orders.get(i));
			orders.set(i, temp);
		}
	}
	
	//Returns a formatted string showing total sales and all orders.
	@Override
	public String toString()
	{
		String str = "Total monthly sales: " + totalMonthlySale() + "\n";
		for(int i = 0; i < orders.size(); i++) 
		{	
			str += "Order " + i + ": " + orders.get(i).toString() + "\n";	
		}
		
		return str;
	}

}
