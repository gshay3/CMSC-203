/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A Junit test that performs multiple different types of tests to check whether
 * all of the methods in TwoDimRaggedUtility are functioning correctly.
 * Due: 11/29/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

import static org.junit.Assert.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] testData;
    private File testFile;

    @Before
    public void setUp() {
        // Set up test data
        testData = new double[][] { { 1.0, 2.0, 3.0 }, { 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };

        // Create a temporary test file
        testFile = new File("testFile.txt");
        try {
            TwoDimRaggedArrayUtility.writeToFile(testData, testFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadFile()
    {

        try
        {
            double[][] result = TwoDimRaggedArrayUtility.readFile(testFile);

            // Verify the dimensions of the result matrix
            assertEquals(3, result.length); // Assuming you have 3 rows in your test data
            assertEquals(3, result[0].length); // Assuming you have 3 columns in your test data

            // Verify the content of the result matrix
            assertEquals(1.0, result[0][0], 0.001); // Delta is used for double comparison
            assertEquals(2.0, result[0][1], 0.001);
            assertEquals(3.0, result[0][2], 0.001);

            assertEquals(4.0, result[1][0], 0.001);
            assertEquals(5.0, result[1][1], 0.001);
            
            assertEquals(6.0, result[2][0], 0.001);
            assertEquals(7.0, result[2][1], 0.001);
            assertEquals(8.0, result[2][2], 0.001);
            assertEquals(9.0, result[2][3], 0.001);

        } 
        
        catch (FileNotFoundException e)
        {
            fail("FileNotFoundException should not be thrown");
        }
    }
    
    @Test
    public void testWriteToFile() throws FileNotFoundException {
        double[][] testData = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };

        File outputFile = new File("test_output.txt");
        TwoDimRaggedArrayUtility.writeToFile(testData, outputFile);

        // Read the content of the written file and compare with the expected data
        double[][] readData = TwoDimRaggedArrayUtility.readFile(outputFile);
        assertEquals(testData.length, readData.length);
        
        for (int i = 0; i < testData.length; i++) {
            assertEquals(testData[i].length, readData[i].length);
            for (int j = 0; j < testData[i].length; j++) {
                assertEquals(testData[i][j], readData[i][j], 0.001); // Adjust delta as needed
            }
        }

        // Clean up: Delete the temporary test file
        outputFile.delete();
    }

    @Test
    public void testGetTotal() {
        double total = TwoDimRaggedArrayUtility.getTotal(testData);
        assertEquals(45.0, total, 0.001);
    }

    @Test
    public void testGetAverage() {
        double average = TwoDimRaggedArrayUtility.getAverage(testData);
        assertEquals(5.000, average, 0.001);
    }

    @Test
    public void testGetRowTotal() {
        double rowTotal = TwoDimRaggedArrayUtility.getRowTotal(testData, 1);
        assertEquals(9.0, rowTotal, 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        double colTotal = TwoDimRaggedArrayUtility.getColumnTotal(testData, 1);
        assertEquals(14.0, colTotal, 0.001);
    }

    @Test
    public void testGetHighestInRow() {
        double highestInRow = TwoDimRaggedArrayUtility.getHighestInRow(testData, 0);
        assertEquals(3.0, highestInRow, 0.001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        int highestInRowIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(testData, 0);
        assertEquals(2, highestInRowIndex);
    }

    @Test
    public void testGetLowestInRow() {
        double lowestInRow = TwoDimRaggedArrayUtility.getLowestInRow(testData, 1);
        assertEquals(4.0, lowestInRow, 0.001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        int lowestInRowIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(testData, 1);
        assertEquals(0, lowestInRowIndex);
    }

    @Test
    public void testGetHighestInColumn() {
        double highestInColumn = TwoDimRaggedArrayUtility.getHighestInColumn(testData, 0);
        assertEquals(6.0, highestInColumn, 0.001);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        int highestInColumnIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(testData, 0);
        assertEquals(2, highestInColumnIndex);
    }

    @Test
    public void testGetLowestInColumn() {
        double lowestInColumn = TwoDimRaggedArrayUtility.getLowestInColumn(testData, 1);
        assertEquals(2.0, lowestInColumn, 0.001);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        int lowestInColumnIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(testData, 1);
        assertEquals(0, lowestInColumnIndex);
    }

    @Test
    public void testGetHighestInArray() {
        double highestInArray = TwoDimRaggedArrayUtility.getHighestInArray(testData);
        assertEquals(9.0, highestInArray, 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        double lowestInArray = TwoDimRaggedArrayUtility.getLowestInArray(testData);
        assertEquals(1.0, lowestInArray, 0.001);
    }

}
