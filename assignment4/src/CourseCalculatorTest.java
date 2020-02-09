import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class CourseCalculatorTest {
	@Test 
	public void test_loadIAssignmentGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0, 0.0, 0.0};
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			expectedList.add(new Double(testArray[testCounter]));
		}
		
		testCalculator.loadIAssignmentGrades(testArray);
		ArrayList<Double> actualList = testCalculator.getIAssignmentGrades();
		
		assertArrayEquals("Testing the loading of iAssignmentGrades", expectedList.toArray(), actualList.toArray());
	}
	
	@Test 
	public void test_loadIQuizGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0, 0.0, 0.0};
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			expectedList.add(new Double(testArray[testCounter]));
		}
		
		testCalculator.loadIQuizGrades(testArray);
		ArrayList<Double> actualList = testCalculator.getIQuizGrades();
		
		assertArrayEquals("Testing the loading of iQuizGrades",expectedList.toArray(), actualList.toArray());
	}
	
	@Test 
	public void test_loadICodingChallengeGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0, 0.0, 0.0};
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			expectedList.add(new Double(testArray[testCounter]));
		}
		
		testCalculator.loadICodingChallengeGrades(testArray);
		ArrayList<Double> actualList = testCalculator.getICodingChallengeGrades();
		
		assertArrayEquals("Testing the loading of iCodingChallengeGrades", expectedList.toArray(), actualList.toArray());
	}
	
	@Test 
	public void test_loadTQuizGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0, 0.0, 0.0};
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			expectedList.add(new Double(testArray[testCounter]));
		}
		
		testCalculator.loadTQuizGrades(testArray);
		ArrayList<Double> actualList = testCalculator.getTQuizGrades();
		
		assertArrayEquals("Testing the loading of tQuizGrades", expectedList.toArray(), actualList.toArray());
	}
	
	@Test 
	public void test_calculateIAssignmentGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0, 0.0, 0.0};
		testCalculator.loadIAssignmentGrades(testArray);
		double testActual = testCalculator.calculateIAssignmentGrade();
		double expected = 0.1;
		assertEquals("Checking whether the calculatingIAssignment method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test 
	public void test_calculateIQuizGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0, 0.0, 0.0};
		testCalculator.loadIQuizGrades(testArray);
		double testActual = testCalculator.calculateIQuizGrade();
		double expected = 0.2;
		assertEquals("Checking whether the calculateIQuizGrade method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test 
	public void test_calculateICodingChallengeGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0, 0.0};
		testCalculator.loadICodingChallengeGrades(testArray);
		double testActual = testCalculator.calculateICodingChallengeGrade();
		double expected = 0.3;
		assertEquals("Checking whether the calculateICodingchallenge method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test 
	public void test_calculateTQuizGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0, 0.0, 0.0};
		testCalculator.loadTQuizGrades(testArray);
		double testActual = testCalculator.calculateTQuizGrade();
		double expected = 0.1;
		assertEquals("Checking whether the calculateTQuizGrade method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_calculateTProjectGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double testActual = testCalculator.calculateTProjectGrade();
		double expected = 0.3;
		assertEquals("Checking whether the calculateTProjectGrade method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_dropNGrades_DropOne()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 3.0, 4.0};
		ArrayList<Double> testList = new ArrayList<Double>();
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(new Double(testArray[testCounter]));
			expectedList.add(new Double(testArray[testCounter]));
		}

		ArrayList<Double> actualList = (testCalculator.dropNGrades(testList, 1));
		expectedList.remove(0);
				
		assertArrayEquals("Using dropNGrades() to drop one grade", expectedList.toArray(), actualList.toArray());
	}
	
	@Test
	public void test_dropNGrades_DropTwo()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 3.0, 4.0};
		ArrayList<Double> testList = new ArrayList<Double>();
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(new Double(testArray[testCounter]));
			expectedList.add(new Double(testArray[testCounter]));
		}

		ArrayList<Double> actualList = (testCalculator.dropNGrades(testList, 2));
		expectedList.remove(1);
		expectedList.remove(0);
				
		assertArrayEquals("Using dropNGrades() to drop two grades",expectedList.toArray(), actualList.toArray());
	}
	
	@Test
	public void test_dropNGrades_DropTooMany()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0};
		ArrayList<Double> testList = new ArrayList<Double>();
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(new Double(testArray[testCounter]));
			expectedList.add(new Double(testArray[testCounter]));
		}

		ArrayList<Double> actualList = (testCalculator.dropNGrades(testList, 3));
						
		assertArrayEquals("Using dropNGrades() to drop too many grades",expectedList.toArray(), actualList.toArray());
	}
	
	@Test
	public void test_dropNGrades_encapsulated()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0};
		ArrayList<Double> testList = new ArrayList<Double>();
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(new Double(testArray[testCounter]));
			expectedList.add(new Double(testArray[testCounter]));
		}

		ArrayList<Double> actualList = (testCalculator.dropNGrades(testList, 3));
						
		assertNotSame("Testing to ensure a copy of the list is returned.", testList, actualList);
	}
	
	@Test
	public void test_findAverageGrade_Default()
	{
		double expected = 2.5;
		CourseCalculator testCalculator = new CourseCalculator();
		ArrayList<Double> testList = new ArrayList<Double>();
		double [] testArray = {1.0, 2.0, 3.0, 4.0};
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(new Double(testArray[testCounter]));
		}
		double testActual = testCalculator.findAverageGrade(testList);
		assertEquals("Checking whether the findAverageGrade method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_findAverageGrade_Too_Small()
	{
		double expected = 0.0;
		double [] testArray = {-1.0, 2.0, -13.0, -1.0};
		ArrayList<Double> testList = new ArrayList<Double>();
		CourseCalculator testCalculator = new CourseCalculator();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(new Double(testArray[testCounter]));
		}		
		double testActual = testCalculator.findAverageGrade(testList);
		assertEquals("Checking whether the findAverageGrade method checks for results that are too small", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_findAverageGrade_Too_Large()
	{
		double expected = 0.0;
		double [] testArray = {1.0, 2.0, 13.0, 1.0};
		ArrayList<Double> testList = new ArrayList<Double>();
		CourseCalculator testCalculator = new CourseCalculator();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(new Double(testArray[testCounter]));
		}	
		double testActual = testCalculator.findAverageGrade(testList);
		assertEquals("Checking whether the findAverageGrade method checks for results that are too small", expected, testActual, 0.00001);
	}
	
}
