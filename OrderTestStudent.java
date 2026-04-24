/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A Junit test that runs multiple different tests cases to confirm 
 * the Order class is functioning properly.
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderTestStudent {

    Order orderWeekday;
    Order orderWeekend;

    Customer customer;

    // Set up test objects before each test
    @Before
    public void setUp() {
        customer = new Customer("TestUser", 25);

        orderWeekday = new Order(10, Day.MONDAY, customer);
        orderWeekend = new Order(12, Day.SATURDAY, customer);
    }

    // Test order number generation and basic getters
    @Test
    public void testConstructorAndGetters() {
        assertEquals(10, orderWeekday.getOrderTime());
        assertEquals(Day.MONDAY, orderWeekday.getOrderDay());
        assertEquals("TestUser", orderWeekday.getCustomer().getName());
        assertEquals(25, orderWeekday.getCustomer().getAge());
    }

    // Test weekend detection
    @Test
    public void testIsWeekend() {
        assertFalse(orderWeekday.isWeekend());
        assertTrue(orderWeekend.isWeekend());
    }

    // Test adding coffee beverage
    @Test
    public void testAddCoffee() {
        orderWeekday.addNewBeverage("Latte", Size.SMALL, true, false);

        assertEquals(1, orderWeekday.getTotalItems());
        assertTrue(orderWeekday.getBeverage(0) instanceof Coffee);
    }

    // Test adding alcohol beverage
    @Test
    public void testAddAlcohol() {
        orderWeekend.addNewBeverage("Beer", Size.MEDIUM);

        assertEquals(1, orderWeekend.getTotalItems());
        assertTrue(orderWeekend.getBeverage(0) instanceof Alcohol);
    }

    // Test adding smoothie beverage
    @Test
    public void testAddSmoothie() {
        orderWeekday.addNewBeverage("Mango", Size.LARGE, 3, true);

        assertEquals(1, orderWeekday.getTotalItems());
        assertTrue(orderWeekday.getBeverage(0) instanceof Smoothie);
    }

    // Test calcOrderTotal
    @Test
    public void testCalcOrderTotal() {
        orderWeekday.addNewBeverage("Latte", Size.SMALL, false, false);
        orderWeekday.addNewBeverage("Mango", Size.MEDIUM, 2, false);

        double total = orderWeekday.calcOrderTotal();

        assertTrue(total > 0);
    }

    // Test findNumOfBevType
    @Test
    public void testFindNumOfBevType() {
        orderWeekday.addNewBeverage("Latte", Size.SMALL, false, false);
        orderWeekday.addNewBeverage("Espresso", Size.SMALL, false, false);
        orderWeekday.addNewBeverage("Beer", Size.SMALL);

        assertEquals(2, orderWeekday.findNumOfBevType(Type.COFFEE));
        assertEquals(1, orderWeekday.findNumOfBevType(Type.ALCOHOL));
    }

    // Test getBeverage valid and invalid index
    @Test
    public void testGetBeverage() {
        orderWeekday.addNewBeverage("Latte", Size.SMALL, false, false);

        assertNotNull(orderWeekday.getBeverage(0));
        assertNull(orderWeekday.getBeverage(5));
    }

    // Test compareTo (order number ordering)
    @Test
    public void testCompareTo() {
        int result = orderWeekday.compareTo(orderWeekend);

        assertTrue(result != 0); // should not be equal
    }

    // Test toString contains key information
    @Test
    public void testToString() {
        orderWeekday.addNewBeverage("Latte", Size.SMALL, false, false);

        String output = orderWeekday.toString();

        assertTrue(output.contains("TestUser"));
        assertTrue(output.contains("MONDAY"));
    }
}