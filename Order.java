/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: The Order class represents a customer's order containing multiple beverages.
 * It implements OrderInterface and Comparable to allow ordering comparisons.
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

import java.util.ArrayList;

public class Order extends Object implements OrderInterface, Comparable<Order>
{
	private static int counter = 10000;
	private int orderNo;
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> beverages;
	
	//Constructor initializes order details and generates a unique order number.
	public Order(int orderTime, Day orderDay, Customer cust)
	{
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		orderNo = generateOrder();
		beverages = new ArrayList<Beverage>();
	}
	
	//Generates a unique order number using a static counter.
	public int generateOrder()
	{
		return orderNo = counter++;
	}
	
	//Returns the order number.
	public int getOrderNo()
	{
		return orderNo;
	}
	
	//Returns the time the order was placed.
	public int getOrderTime()
	{
		return orderTime;
	}
	
	//Returns the day the order was placed.
	public Day getOrderDay()
	{
		return orderDay;
	}
	
	//Returns a copy of the customer to preserve encapsulation.
	public Customer getCustomer()
	{
		return new Customer(cust);
	}
	
	//Checks if the order was placed on the weekend.
	public boolean isWeekend()
	{
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY)
		{
			return true;
		}
		return false;
	}
	
	//Returns a beverage at a specified index if valid.
	public Beverage getBeverage(int itemNo)
	{
		if(itemNo >= 0 && itemNo < beverages.size())
		{
			return beverages.get(itemNo);
		}
		return null;
	}
	
	//Returns the total number of beverages in the order.
	public int getTotalItems()
	{
		return beverages.size();
	}
	
	//Adds a coffee beverage to the order.
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(coffee);
	}
	
	//Adds a alcohol beverage to the order.
	public void addNewBeverage(String bevName, Size size)
	{
		Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
		beverages.add(alcohol);
	}
	
	//Adds a smoothie beverage to the order.
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
		beverages.add(smoothie);
	}
	
	//Calculates the total price of all beverages in the order.
	public double calcOrderTotal()
	{
		double total = 0;
		for(int i = 0; i < beverages.size(); i++)
		{
			total += beverages.get(i).calcPrice();
		}
		return total;
	}
	
	//Counts how many beverages of a specific type are in the order.
	public int findNumOfBevType(Type type)
	{
		int count = 0;
		for(int i = 0; i < beverages.size(); i++)
		{
			if(beverages.get(i).getType() == type)
			{
				count++;
			}
		}
		return count;
	}
	
	//Returns a string representation of the order, including all beverages.
	@Override
	public String toString()
	{
		String bevs = "";
		for(int i = 0; i < beverages.size(); i++)
		{
			bevs += beverages.get(i);
		}
		return "Order # " + orderNo + "\nOrder Time: " + orderTime + "\nOrder Day: " + orderDay +
				"\nCustomer Name: " + cust.getName() + "\nCustomer Age: " + cust.getAge() + "\nBeverages:\n" + bevs;
	}
	
	//Compares two orders based on order number.
	public int compareTo(Order anotherOrder)
	{
		return Integer.compare(this.orderNo, anotherOrder.orderNo);
	}

}
