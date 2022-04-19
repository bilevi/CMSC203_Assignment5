/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: A program that calculates the holiday bonus for each store and the total bonuses for all stores combined
 * Due: 4/18/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: B. Leigh Vining
 */
/**
 * 
 * @author B_Leigh_Vining
 *
 */
public class HolidayBonus {

	
	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param high  the bonus given to the highest sales value
	 * @param low  The bonus given to the lowest sales value
	 * @param other  The bonus given to all the other sale values, minus negative sales
	 * @return  The total bonus for each row/store in the data array
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = new double[data.length]; //create array with number of rows from data
		
		for (int row = 0; row < bonus.length; row++) //for each row
		{
			double total = 0.0; //reset the total amount

			for (int column = 0; column < data[row].length; column++) //for each column
			{
				if (data[row][column] <= 0) //if sales were negative
				{
					total += 0; //no bonus
				}
				else if (data[row][column] == TwoDimRaggedArrayUtility.getHighestInColumn(data, column)) //if sales was highest
				{
					total += high; //add highest bonus
				}

				else if (data[row][column] == TwoDimRaggedArrayUtility.getLowestInColumn(data, column)) //if sales were lowest
				{
					total += low; //add lowest bonus
				}

				else total += other; //otherwise, add regular bonus
			}
			bonus[row] = total; //add total to spot in array that coincides with the row
		}
		return bonus; //return bonus array

	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param high  the bonus given to the highest sales value
	 * @param low  The bonus given to the lowest sales value
	 * @param other  The bonus given to all the other sale values, minus negative sales
	 * @return  The total bonus amount for the entire data array
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = calculateHolidayBonus(data, high, low, other); //to get the bonus amount for each row
		double totalBonus = 0.0; //to hold the total bonus
		
		//for loop to traverse the bonus array
		for (int row = 0; row < bonus.length; row++)
		{
			totalBonus += bonus[row]; //adding each row to total
		}
		return totalBonus; //return total amount
	}
}
