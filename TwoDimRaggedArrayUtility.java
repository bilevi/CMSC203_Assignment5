import java.util.*;
import java.io.*;

/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: A program that reads a file and gets averages/totals for the rows/columns of a ragged array.
 * It can also write the array into a text file.
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

public class TwoDimRaggedArrayUtility {

/**
 * 
 * @param file  The file containing numbers that is to be read into the program
 * @return A double jagged array that contains the sales from different stores/brands
 * @throws java.io.FileNotFoundException  if no file is found
 */
	public static double[][] readFile(File file) throws java.io.FileNotFoundException {
		Scanner inputFile = new Scanner(file); //to traverse the file
		String[][] input = new String[10][10]; //to hold values from file
		double[][] data;
		String[] rowIndex;
		int row = 0;

		
		/*
		 * Go through the file to create a jagged array with appropriate sized rows and columns
		 */
		while (inputFile.hasNext()) //while there is something to take in
		{
			rowIndex = inputFile.nextLine().split(" "); //figure out how many tokens per row
			input[row] = new String[rowIndex.length]; 
			for (int column = 0; column < rowIndex.length; column++)
			{
				input[row][column] = rowIndex[column];
			}
			row++; //go to next row
		}
		inputFile.close(); //close the file

		data = new double[row][]; 

		for (int i = 0; i < row; i++) 
		{
			data[i] = new double[input[i].length]; 
			for (int j = 0; j < input[i].length; j++)
			{
				data[i][j] = Double.parseDouble(input[i][j]); //transform the strings into doubles
			}
		}
		return data; //return the created jagged array
	}

	/**
	 * 
	 * @param data  The double jagged that was used in the program that the sales from different stores/brands
	 * @param outputFile  The file created with data
	 * @throws java.io.FileNotFoundException  If there is no file found
	 */
	public static void writeToFile(double[][] data, File outputFile) throws java.io.FileNotFoundException{
		PrintWriter file = new PrintWriter(outputFile); //create a file to write to

		for (int row = 0; row < data.length; row++)
		{
			for (int column = 0; column < data[row].length; column++)
			{
				file.print(data[row][column] + " "); //add the spot to the file
			}
			file.println(); //go to next line
		}
		file.close(); //close file
	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @return The overall total from the jagged array
	 */
	public static double getTotal(double[][] data) {
		double total = 0.0;

		for (int row = 0; row < data.length; row++)
		{
			for (int column = 0; column < data[row].length; column++)
			{
				total += data[row][column]; //add spot value to total
			}
		}
		return total; //return total
	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from different stores/brands
	 * @return The average from the overall array
	 */
	public static double getAverage(double[][] data) {
		double total = 0.0;
		int count = 0; //to get number of spots in array

		for (int row = 0; row < data.length; row++)
		{
			for (int column = 0; column < data[row].length; column++)
			{
				total += data[row][column]; //add spot to total
				count++; //add to count
			}
		}
		return total/count; //return average
	}

	
	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param row  The specified row within the array
	 * @return The total from a specific row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0.0;

		for (int column = 0; column < data[row].length; column++) //going through the column spots for the specified row
		{
			total += data[row][column]; //add value to total
		}
		return total;
	}

	
	/**
	 * 
	 * @param data The jagged array that contains the sales from the different stores/brands
	 * @param col  The specified column within the array
	 * @return  The total from a specific column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0.0;

		for (int row = 0; row < data.length; row++) //going through each row
		{
			if (col < data[row].length) //if the specified column spot is in that row
			{
			total += data[row][col]; //add spot to total
			}
		}
		return total;
	}

	
	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param row  The specified row within the array
	 * @return  The highest value in the specified row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = 0.0;

		for (int column = 0; column < data[row].length; column++)
		{
			if (data[row][column] >= highest) //if the value is greater than highest
			{
				highest = data[row][column]; //assign new value to highest
			}
		}
		return highest;
	}

	
	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param row  The specified row within the array
	 * @return  The column index containing the highest value in the specified row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = 0.0;
		int index = 0;

		for (int column = 0; column < data[row].length; column++)
		{
			if (data[row][column] >= highest)
			{
				highest = data[row][column];
				index = column; //assign column number to index
			}
		}
		return index; //return column number for specified row
	}

	
	/**
	 * 
	 * @param data  he jagged array that contains the sales from the different stores/brands
	 * @param row  The specified row within the array
	 * @return  The lowest value in the specified row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = 999999;

		for (int column = 0; column < data[row].length; column++)
		{
			if (data[row][column] <= lowest) //if value is less than lowest
			{
				lowest = data[row][column]; //assign new value to lowest
			}
		}
		return lowest;
	}

	
	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param row  The specified row within the array
	 * @return  The column index containing the lowest value in the specified row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = 999999;
		int index = 0;

		for (int column = 0; column < data[row].length; column++)
		{
			if (data[row][column] <= lowest)
			{
				lowest = data[row][column];
				index = column; //assign column number to index
			}
		}
		return index; //return column number
	}

	
	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param col  The specified column within the array
	 * @return  the highest value in the specified column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = 0.0;

		for (int row = 0; row < data.length; row++) //going through each row
		{
			if (col < data[row].length) //if specified column is in that row
			{
				if (data[row][col] >= highest) //and if value is greater than highest
				{
					highest = data[row][col]; //assign new value to highest
				}
			}
		}
		return highest;
	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param col  The specified column within the array
	 * @return  The row index containing the highest value in the specified column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = 0.0;
		int index = 0;

		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length)
			{
				if (data[row][col] >= highest)
				{
					highest = data[row][col];
					index = row; //assign the row to index
				}
			}
		}
		return index; //return the row number
	}

	
	/**
	 * 
	 *@param data  The jagged array that contains the sales from the different stores/brands
	 * @param col  The specified column within the array
	 * @return  The lowest value for the specified column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = 999999;

		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length) //if column is in the row
			{
				if (data[row][col] <= lowest) //and the value is lower than lowest
				{
					lowest = data[row][col]; //assign value to lowest
				}
			}
		}
		return lowest;
	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param col  The specified column within the array
	 * @return  the row index containing the lowest value for the specified column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = 999999;
		int index = 0;

		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length) //if column is in the row
			{
				if (data[row][col] <= lowest) //and if its the lowest number
				{
					lowest = data[row][col]; //assign value to lowest
					index = row; //and get the index number
				}
			}
		}
		return index; //return the index
	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @return  the highes value in the entire array
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = 0.0;

		//going through the entire array
		for (int row = 0; row < data.length; row++)
		{
			for (int column = 0; column < data[row].length; column++)
			{
				if (data[row][column] > highest) //if the value is bigger than highest
				{
					highest = data[row][column]; //assign value to highest
				}
			}
		}
		return highest;
	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @return  The lowest value in the entire array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = 999999;

		//going through the entire array
		for (int row = 0; row < data.length; row++)
		{
			for (int column = 0; column < data[row].length; column++)
			{
				if (data[row][column] < lowest) //if the value is smaller than lowest
				{
					lowest = data[row][column]; //assign value to lowest
				}
			}
		}
		return lowest; //return lowest
	}
}