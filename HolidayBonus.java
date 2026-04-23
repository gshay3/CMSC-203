/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class is used to calculate holiday bonuses for each store
 * based on their performance in each category (column).
 * The highest value in a column gets the highest bonus,
 * the lowest value (if not equal to highest) gets the lowest bonus,
 * and all other positive values receive an average bonus.
 * Due: 11/29/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public class HolidayBonus extends Object
{
	// Constant bonus values
	private static final double HIGH_BONUS = 5000.00;
	private static final double LOW_BONUS = 1000.00;
	private static final double AVG_BONUS = 2000.00;
	
	//Default constructor
	public HolidayBonus()
	{
		
	}
	
	//Calculates the holiday bonus for each store(row) in the data array.
	public static double[] calculateHolidayBonus(double[][] data)
	{
		double[] bonus = new double[data.length];
		
		//Loop through each row
		for(int row = 0; row < data.length; row++)
		{
			//Loop through each column in the current row
			for(int col = 0; col < data[row].length; col++)
			{
				//Get highest and lowest values for this column
				double highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
				double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
				//If this value is the highest in the column, add HIGH_BONUS
				if(data[row][col] == highest)
				{
					bonus[row] += HIGH_BONUS;
				}
				//If this value is the lowest in the column (and not equal to the highest), add LOW_BONUS
				else if(data[row][col] == lowest && highest != lowest)
				{
					bonus[row] += LOW_BONUS;
				}
				//If this value is positive and not highest/lowest, add AVG_BONUS
				else if(data[row][col] > 0)
				{
					bonus[row] += AVG_BONUS;
				}
			}
		}
		
		return bonus;
	}
	
	//Calculates the total of all holiday bonuses
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		//Get individual bonuses first
		double[] bonus = calculateHolidayBonus(data);
		double totalBonus = 0;
		
		//sum up all bonuses
		for(int i = 0; i < bonus.length; i++)
		{
			totalBonus += bonus[i];
		}
		
		return totalBonus;
	}

}
