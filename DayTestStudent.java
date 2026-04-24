/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description:  JUnit test class for the Day enum
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

public class DayTestStudent {

    // Test that all expected enum values exist in correct order
    @Test
    public void testEnumValues() {
        Day[] days = Day.values();

        assertEquals(7, days.length);

        assertEquals(Day.MONDAY, days[0]);
        assertEquals(Day.TUESDAY, days[1]);
        assertEquals(Day.WEDNESDAY, days[2]);
        assertEquals(Day.THURSDAY, days[3]);
        assertEquals(Day.FRIDAY, days[4]);
        assertEquals(Day.SATURDAY, days[5]);
        assertEquals(Day.SUNDAY, days[6]);
    }

    // Test valueOf() method for valid enum name
    @Test
    public void testValueOf() {
        assertEquals(Day.MONDAY, Day.valueOf("MONDAY"));
        assertEquals(Day.SUNDAY, Day.valueOf("SUNDAY"));
    }

    // Test that enum names match expected strings
    @Test
    public void testToString() {
        assertEquals("MONDAY", Day.MONDAY.toString());
        assertEquals("FRIDAY", Day.FRIDAY.toString());
    }
}