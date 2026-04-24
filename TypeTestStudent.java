/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description:  Junit test class for the Type enum.
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

public class TypeTestStudent {

    // Test that all enum values exist and are in correct order
    @Test
    public void testEnumValues() {
        Type[] types = Type.values();

        assertEquals(3, types.length);
        assertEquals(Type.SMOOTHIE, types[0]);
        assertEquals(Type.COFFEE, types[1]);
        assertEquals(Type.ALCOHOL, types[2]);
    }

    // Test valueOf method for valid enum names
    @Test
    public void testValueOf() {
        assertEquals(Type.SMOOTHIE, Type.valueOf("SMOOTHIE"));
        assertEquals(Type.COFFEE, Type.valueOf("COFFEE"));
        assertEquals(Type.ALCOHOL, Type.valueOf("ALCOHOL"));
    }

    // Test toString method (default enum behavior)
    @Test
    public void testToString() {
        assertEquals("SMOOTHIE", Type.SMOOTHIE.toString());
        assertEquals("COFFEE", Type.COFFEE.toString());
        assertEquals("ALCOHOL", Type.ALCOHOL.toString());
    }

    // Test ordinal positions of enum constants
    @Test
    public void testOrdinal() {
        assertEquals(0, Type.SMOOTHIE.ordinal());
        assertEquals(1, Type.COFFEE.ordinal());
        assertEquals(2, Type.ALCOHOL.ordinal());
    }
}