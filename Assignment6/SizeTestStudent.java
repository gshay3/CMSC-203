/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description:  JUnit test class for the Size enum
 * It is used to specify the day an order is placed in the BevShop system
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class SizeTestStudent {

    // Test that all enum values exist and are in correct order
    @Test
    public void testEnumValues() {
        Size[] sizes = Size.values();

        assertEquals(3, sizes.length);
        assertEquals(Size.SMALL, sizes[0]);
        assertEquals(Size.MEDIUM, sizes[1]);
        assertEquals(Size.LARGE, sizes[2]);
    }

    // Test valueOf method for valid enum names
    @Test
    public void testValueOf() {
        assertEquals(Size.SMALL, Size.valueOf("SMALL"));
        assertEquals(Size.MEDIUM, Size.valueOf("MEDIUM"));
        assertEquals(Size.LARGE, Size.valueOf("LARGE"));
    }

    // Test toString method (default enum behavior)
    @Test
    public void testToString() {
        assertEquals("SMALL", Size.SMALL.toString());
        assertEquals("MEDIUM", Size.MEDIUM.toString());
        assertEquals("LARGE", Size.LARGE.toString());
    }

    // Test ordinal values (position in enum)
    @Test
    public void testOrdinal() {
        assertEquals(0, Size.SMALL.ordinal());
        assertEquals(1, Size.MEDIUM.ordinal());
        assertEquals(2, Size.LARGE.ordinal());
    }
}
