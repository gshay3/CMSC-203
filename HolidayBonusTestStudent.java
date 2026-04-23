/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A Junit test that performs multiple tests to check whether all methods
 * in HolidayBonus are functioning correctly.
 * Due: 11/29/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HolidayBonusTestStudent {

    @Test
    public void testCalculateHolidayBonus_basicCase() {
        double[][] data = {
            {10, 20, 30},
            {20, 10, 40},
            {30, 40, 10}
        };

        double[] result = HolidayBonus.calculateHolidayBonus(data);

        // Manually computed expected bonuses
        // Column 0: highest=30, lowest=10
        // Column 1: highest=40, lowest=10
        // Column 2: highest=40, lowest=10

        assertEquals(1000 + 2000 + 2000, result[0], 0.001); // row 0
        assertEquals(2000 + 1000 + 5000, result[1], 0.001); // row 1
        assertEquals(5000 + 5000 + 1000, result[2], 0.001); // row 2
    }

    @Test
    public void testCalculateHolidayBonus_allSameValues() {
        double[][] data = {
            {10, 10},
            {10, 10}
        };

        double[] result = HolidayBonus.calculateHolidayBonus(data);

        // highest == lowest → only HIGH bonus applies
        assertEquals(5000 + 5000, result[0], 0.001);
        assertEquals(5000 + 5000, result[1], 0.001);
    }

    @Test
    public void testCalculateHolidayBonus_withNegatives() {
        double[][] data = {
            {-10, 20},
            {30, -5}
        };

        double[] result = HolidayBonus.calculateHolidayBonus(data);

        // Negative values should not receive AVG_BONUS
        assertTrue(result[0] >= 0);
        assertTrue(result[1] >= 0);
    }

    @Test
    public void testCalculateHolidayBonus_raggedArray() {
        double[][] data = {
            {10, 20},
            {30},
            {5, 15, 25}
        };

        double[] result = HolidayBonus.calculateHolidayBonus(data);

        assertEquals(3, result.length);
        // Just verify no crashes and values computed
        assertTrue(result[0] > 0);
        assertTrue(result[1] > 0);
        assertTrue(result[2] > 0);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double[][] data = {
            {10, 20},
            {30, 5}
        };

        double[] bonuses = HolidayBonus.calculateHolidayBonus(data);
        double total = HolidayBonus.calculateTotalHolidayBonus(data);

        double expectedTotal = bonuses[0] + bonuses[1];
        assertEquals(expectedTotal, total, 0.001);
    }

    @Test
    public void testCalculateHolidayBonus_zeroValues() {
        double[][] data = {
            {0, 0},
            {0, 0}
        };

        double[] result = HolidayBonus.calculateHolidayBonus(data);

        // Zero is not > 0, so only HIGH bonus applies (since all equal)
        assertEquals(5000 + 5000, result[0], 0.001);
        assertEquals(5000 + 5000, result[1], 0.001);
    }
}