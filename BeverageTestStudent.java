/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A Junit test that runs multiple different tests cases to confirm 
 * the Beverage class is functioning properly.
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

//Concrete test subclass so we can instantiate Beverage
class TestBeverage extends Beverage 
{
    public TestBeverage(String name, Type type, Size size) {
        super(name, type, size);
    }

    //Simple implementation just returns size-based price
    public double calcPrice() {
        return addSizePrice();
    }
}

public class BeverageTestStudent {

    TestBeverage bev1, bev2, bev3;

    @Before
    public void setUp() {
        bev1 = new TestBeverage("Coffee", Type.COFFEE, Size.SMALL);
        bev2 = new TestBeverage("Coffee", Type.COFFEE, Size.MEDIUM);
        bev3 = new TestBeverage("Coffee", Type.COFFEE, Size.LARGE);
    }

    //Test base price
    @Test
    public void testGetBasePrice() {
        assertEquals(2.0, bev1.getBasePrice(), 0.01);
    }

    //Test getters
    @Test
    public void testGetters() {
        assertEquals("Coffee", bev1.getBevName());
        assertEquals(Type.COFFEE, bev1.getType());
        assertEquals(Size.SMALL, bev1.getSize());
    }

    //Test size-based pricing
    @Test
    public void testAddSizePrice() {
        assertEquals(2.0, bev1.addSizePrice(), 0.01); // small
        assertEquals(3.0, bev2.addSizePrice(), 0.01); // medium
        assertEquals(4.0, bev3.addSizePrice(), 0.01); // large
    }

    //Test toString
    @Test
    public void testToString() {
        String result = bev1.toString();
        assertTrue(result.contains("Coffee"));
        assertTrue(result.contains("SMALL"));
    }

    //Test equals method
    @Test
    public void testEquals() {
        TestBeverage same = new TestBeverage("Coffee", Type.COFFEE, Size.SMALL);
        TestBeverage different = new TestBeverage("Tea", Type.COFFEE, Size.SMALL);

        assertTrue(bev1.equals(same));
        assertFalse(bev1.equals(different));
        assertFalse(bev1.equals(null));
    }

    //Test calcPrice implementation
    @Test
    public void testCalcPrice() {
        assertEquals(2.0, bev1.calcPrice(), 0.01);
        assertEquals(3.0, bev2.calcPrice(), 0.01);
        assertEquals(4.0, bev3.calcPrice(), 0.01);
    }
}