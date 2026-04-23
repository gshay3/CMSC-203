/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Utility class for working with ragged 2D arrays.
 * This class provides methods to read/write arrays from files
 * and perform calculations such as totals, averages, and finding
 * highest/lowest values in rows, columns, or the entire array.
 * Due: 11/29/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

import java.io.*;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility extends Object
{	
	//Default constructor
	public TwoDimRaggedArrayUtility()
	{
		
	}
	
	/*
	 * Reads data from a file and stores it into a ragged 2D array.
	 * Each line represents a row, and values are separated by spaces.
	 */
	
	public static double[][] readFile(File file) throws FileNotFoundException 
	{
        //Constant values for maximum row/column size
        final int MAX_ROWS = 10;
        final int MAX_COLUMNS = 10;
        
        //Temporary storage as strings before converting to doubles
        String[][] tempArray = new String[MAX_ROWS][];
        
        Scanner scanner = new Scanner(file);

        int rowCount = 0;
        //Read each line and split into tokens
        while (scanner.hasNextLine() && rowCount < MAX_ROWS)
        {
            String[] tokens = scanner.nextLine().split(" ");
            tempArray[rowCount] = new String[tokens.length];
            
            //Copy tokens into temporary array
            for(int col = 0; col < tokens.length && col < MAX_COLUMNS; col++)
            {
            	tempArray[rowCount][col] = tokens[col];
            }
            rowCount++;
        }
        
        //Convert string array to double array
        double[][] data = new double[rowCount][];
        for(int row = 0; row < rowCount; row++)
        {
        	data[row] = new double[tempArray[row].length];
        	for(int col = 0; col < tempArray[row].length; col++)
        	{
        		data[row][col] = Double.parseDouble(tempArray[row][col]);
        	}
        	System.out.println();
        }
        
        scanner.close();
        return data;
    }
	
	//Writes a ragged 2D array to a file, with each row being written on a new line.
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		PrintWriter writeTo = new PrintWriter(outputFile);
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				writeTo.print(data[row][col] + " ");
			}
			writeTo.println();
		}
		writeTo.close();
	}
	
	//Calculates the total of all values in the array.
	public static double getTotal(double[][] data)
	{
		double total = 0;
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				total += data[row][col];
			}
		}
		return total;
	}
	
	//Calculates the average of all values in the array.
	public static double getAverage(double[][] data)
	{
		double total = getTotal(data);
		int count = 0;
		
		for(int row = 0; row < data.length; row++)
		{
				count += data[row].length;
		}
		double average = total/count;
		return average;
	}
	
	//Calculates the total of a specific row.
	public static double getRowTotal(double[][] data, int row)
	{
		double total = 0;
		for(int col = 0; col < data[row].length; col++)
		{
			total += data[row][col];
		}
		return total;
	}
	
	//Calculates the total of a specific column, and only includes rows containing that column.
	public static double getColumnTotal(double[][] data, int col)
	{
		double total = 0;
		for(int row = 0; row < data.length; row++)
		{
			if(col < data[row].length)
			{
				total += data[row][col];
			}
		}
		return total;
	}
	
	//Find the highest value in a specific row.
	public static double getHighestInRow(double[][] data, int row)
	{
		double highest = Double.NEGATIVE_INFINITY;
		for(int col = 0; col < data[row].length; col++)
		{
			if(highest < data[row][col])
			{
				highest = data[row][col];
			}
		}
		return highest;
	}
	
	//Returns the column index of the highest value in a row.
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		double highest = Double.NEGATIVE_INFINITY;
		int highestIndex = 0;
		for(int col = 0; col < data[row].length; col++)
		{
			if(highest < data[row][col])
			{
				highest = data[row][col];
				highestIndex = col;
			}
		}
		return highestIndex;
	}
	
	//Find the lowest value in a specific row.
	public static double getLowestInRow(double[][] data, int row)
	{
		double lowest = Double.POSITIVE_INFINITY;
		for(int col = 0; col < data[row].length; col++)
		{
			if(lowest > data[row][col])
			{
				lowest = data[row][col];
			}
		}
		
		return lowest;
	}
	
	//Return the column index of the lowest value in a row
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		double lowest = Double.POSITIVE_INFINITY;
		int lowestIndex = 0;
		for(int col = 0; col < data[row].length; col++)
		{
			if(lowest > data[row][col])
			{
				lowest = data[row][col];
				lowestIndex = col;
			}
		}
		return lowestIndex;
	}
	
	//Finds the highest value in a column (ragged-safe).
	public static double getHighestInColumn(double[][] data, int col)
	{
		double highest = Double.NEGATIVE_INFINITY;
		for(int row = 0; row < data.length; row++)
		{
			if(col < data[row].length)
			{
				if(highest < data[row][col])
				{
					highest = data[row][col];
				}
			}
		}
		return highest;
	}
	
	//Returns the row index of the highest value in a column.
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		double highest = Double.NEGATIVE_INFINITY;
		int highestIndex = 0;
		for(int row = 0; row < data.length; row++)
		{
			if(col < data[row].length)
			{
				if(highest < data[row][col])
				{
					highest = data[row][col];
					highestIndex = row;
				}
			}
		}
		return highestIndex;
	} 
	
	//Finds the lowest value in a column (ragged-safe).
	public static double getLowestInColumn(double[][] data, int col)
	{
		double lowest = Double.POSITIVE_INFINITY;
		for(int row = 0; row < data.length; row++)
		{
			if(col < data[row].length)
			{
				if(lowest > data[row][col])
				{
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}
	
	
	//Returns the row index of the lowest value in a column.
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		double lowest = Double.POSITIVE_INFINITY;
		int lowestIndex = 0;
		for(int row = 0; row < data.length; row++)
		{
			if(col < data[row].length)
			{
				if(lowest > data[row][col])
				{
					lowest = data[row][col];
					lowestIndex = row;
				}
			}
		}
		return lowestIndex;
	}
	
	//Finds the highest value in the entire array.
	public static double getHighestInArray(double[][] data)
	{
		double highest = Double.NEGATIVE_INFINITY;
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				if(highest < data[row][col])
				{
					highest = data[row][col];
				}
			}
		}
		return highest;
	}
	
	//Finds the lowest value in the entire array.
	public static double getLowestInArray(double[][] data)
	{
		double lowest = Double.POSITIVE_INFINITY;
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				if(lowest > data[row][col])
				{
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}

}
