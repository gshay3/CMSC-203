/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A Junit test that runs multiple different tests cases to confirm 
 * the BevShop class is functioning properly.
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {

    BevShop shop;

    //Runs before each test
    @Before
    public void setUp() throws Exception {
        shop = new BevShop();
    }

    //Runs after each test
    @After
    public void tearDown() throws Exception {
        shop = null;
    }

    //Test valid and invalid times
    @Test
    public void testIsValidTime() {
        assertTrue(shop.isValidTime(10));   //within range
        assertTrue(shop.isValidTime(12));   //boundary value
        
        assertFalse(shop.isValidTime(7));   //below min
        assertFalse(shop.isValidTime(30));  //above max
    }

    //Test age validation
    @Test
    public void testIsValidAge() {
        assertTrue(shop.isValidAge(25));
        assertFalse(shop.isValidAge(18));
    }

    //Test starting a new order
    @Test
    public void testStartNewOrder() {
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertEquals(1, shop.totalNumOfMonthlyOrders());
    }

    //Test processing different beverage types
    @Test
    public void testProcessOrders() {
        shop.startNewOrder(10, Day.MONDAY, "John", 25);

        shop.processCoffeeOrder("Latte", Size.SMALL, true, false);
        shop.processSmoothieOrder("Berry", Size.MEDIUM, 2, true);
        shop.processAlcoholOrder("Beer", Size.LARGE);

        //Check alcohol count updated
        assertEquals(1, shop.getNumOfAlcoholDrink());

        //Ensure order exists
        assertNotNull(shop.getCurrentOrder());
    }

    //Test finding an order
    @Test
    public void testFindOrder() {
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        int orderNo = shop.getCurrentOrder().getOrderNo();

        assertEquals(0, shop.findOrder(orderNo));
        assertEquals(-1, shop.findOrder(9999)); //non-existent
    }

    //Test total order price calculation
    @Test
    public void testTotalOrderPrice() {
        shop.startNewOrder(10, Day.MONDAY, "John", 25);

        shop.processCoffeeOrder("Latte", Size.SMALL, false, false);
        int orderNo = shop.getCurrentOrder().getOrderNo();

        double total = shop.totalOrderPrice(orderNo);
        assertTrue(total > 0); //basic validation
    }

    //Test total monthly sales
    @Test
    public void testTotalMonthlySale() {
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        shop.processCoffeeOrder("Latte", Size.SMALL, false, false);

        shop.startNewOrder(12, Day.TUESDAY, "Jane", 30);
        shop.processSmoothieOrder("Mango", Size.MEDIUM, 2, false);

        double total = shop.totalMonthlySale();
        assertTrue(total > 0);
    }

    //Test getting order by index
    @Test
    public void testGetOrderAtIndex() {
        shop.startNewOrder(10, Day.MONDAY, "John", 25);

        assertNotNull(shop.getOrderAtIndex(0));
        assertNull(shop.getOrderAtIndex(5)); //invalid index
    }

    //Test sorting orders
    @Test
    public void testSortOrders() {
        shop.startNewOrder(12, Day.WEDNESDAY, "A", 25);
        shop.startNewOrder(10, Day.MONDAY, "B", 25);

        shop.sortOrders();

        Order first = shop.getOrderAtIndex(0);
        Order second = shop.getOrderAtIndex(1);

        //Verify sorting consistency
        assertTrue(first.compareTo(second) <= 0);
    }

    //Test toString method
    @Test
    public void testToString() {
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        shop.processCoffeeOrder("Latte", Size.SMALL, false, false);

        String result = shop.toString();

        assertTrue(result.contains("Total monthly sales"));
        assertTrue(result.contains("Order"));
    }
}
