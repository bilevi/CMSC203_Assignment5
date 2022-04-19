

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] set1 = {{348.93, 0.46, 2353.32, 504.22, 20.19, 1123.45},
			{12.23, 9.43, 5434.76, 56.93, 953.61, 78.65},
			{1.00, 7.58, 21.13, 34234.45, 84028.30, 2042.43},
			{5464.54, 346633.34, 65.23, 0.97, 0.01, 294.29},
			{1212.12, 46.39, 0.21, 3.15, 930.29, 593.69},
			{453.94, 12.45, 95038.93, 503.96, 7.93, 94.04}};

	private double[][] set2 = {{34.23, -3.54, 9285.39, -394.29, -83.95, 232.54},
			{43.26, 97.57, -593.94, 3968.59, -394.28, 3.96},
			{-29.39, 9369.75, 93.59, 9285.20, 304.21, -2946.93},
			{928.12, -342.95, 39294.94, -294.13, 91.90, -74.25},
			{-13.75, 9.82, -21.51, 71.11, 12.39, -49.22},
			{7.31, 9.23, 1.11, 0.89, 932.91, 863.12}};

	private double[][] set3 = {{1234.45, -93.43, 55.43},
			{-32.31, 23543.21, 2354.45, -39.91, 72.49, 3.24},
			{62.88, 21.65, -32.95},
			{32.12, 0.00, -21.91},
			{-12.65, 22.44, 922.55, 344.49, -3.42},
			{56.33, 44.72, 2.04, 0.45, 92.19, 19309.88}};

	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		set1 = set2 = set3 = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(582586.55,TwoDimRaggedArrayUtility.getTotal(set1),.001);
		assertEquals(69699.01,TwoDimRaggedArrayUtility.getTotal(set2),.001);
		assertEquals(47938.43,TwoDimRaggedArrayUtility.getTotal(set3),.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(16182.96,TwoDimRaggedArrayUtility.getAverage(set1),.01);
		assertEquals(1936.08,TwoDimRaggedArrayUtility.getAverage(set2),.01);
		assertEquals(1843.79,TwoDimRaggedArrayUtility.getAverage(set3),.01);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(4350.57,TwoDimRaggedArrayUtility.getRowTotal(set1,0),.001);
		assertEquals(352458.38,TwoDimRaggedArrayUtility.getRowTotal(set1,3),.001);
		assertEquals(3125.16,TwoDimRaggedArrayUtility.getRowTotal(set2,1),.001);
		assertEquals(8.84,TwoDimRaggedArrayUtility.getRowTotal(set2,4),.001);
		assertEquals(51.58,TwoDimRaggedArrayUtility.getRowTotal(set3,2),.001);
		assertEquals(19505.61,TwoDimRaggedArrayUtility.getRowTotal(set3,5),.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(4350.57,TwoDimRaggedArrayUtility.getRowTotal(set1,0),.001);
		assertEquals(352458.38,TwoDimRaggedArrayUtility.getRowTotal(set1,3),.001);
		assertEquals(3125.16,TwoDimRaggedArrayUtility.getRowTotal(set2,1),.001);
		assertEquals(8.84,TwoDimRaggedArrayUtility.getRowTotal(set2,4),.001);
		assertEquals(51.58,TwoDimRaggedArrayUtility.getRowTotal(set3,2),.001);
		assertEquals(19505.61,TwoDimRaggedArrayUtility.getRowTotal(set3,5),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(346633.34,TwoDimRaggedArrayUtility.getHighestInArray(set1),.001);
		assertEquals(39294.94,TwoDimRaggedArrayUtility.getHighestInArray(set2),.001);
		assertEquals(23543.21,TwoDimRaggedArrayUtility.getHighestInArray(set3),.001);	
	}


	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] data=null;

		try {
			TwoDimRaggedArrayUtility.writeToFile(set3, outputFile);
		} catch (Exception e) {
			fail("This caused an exception, which should not happen");
		}
		
		data = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(1234.45, data[0][0],.001);
		assertEquals(-93.43, data[0][1],.001);
		assertEquals(55.43, data[0][2],.001);

		assertEquals(-32.31, data[1][0],.001);
		assertEquals(23543.21, data[1][1],.001);
		assertEquals(2354.45, data[1][2],.001);
		assertEquals(-39.91, data[1][3],.001);
		assertEquals(72.49, data[1][4],.001);
		assertEquals(3.24, data[1][5],.001);

		assertEquals(62.88, data[2][0],.001);
		assertEquals(21.65, data[2][1],.001);
		assertEquals(-32.95, data[2][2],.001);

		assertEquals(32.12, data[3][0],.001);
		assertEquals(0.00, data[3][1],.001);
		assertEquals(-21.91, data[3][2],.001);	

		assertEquals(-12.65, data[4][0],.001);
		assertEquals(22.44, data[4][1],.001);
		assertEquals(922.55, data[4][2],.001);
		assertEquals(344.49, data[4][3],.001);
		assertEquals(-3.42, data[4][4],.001);

		assertEquals(56.33, data[5][0],.001);
		assertEquals(44.72, data[5][1],.001);
		assertEquals(2.04, data[5][2],.001);
		assertEquals(0.45, data[5][3],.001);
		assertEquals(92.19, data[5][4],.001);
		assertEquals(19309.88, data[5][5],.001);
	}
}