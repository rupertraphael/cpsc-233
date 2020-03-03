import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.junit.Test;

public class NonProjectCategoryTest {
	@Test
	public void test_ConstructorWithGrades_default()
	{
		String expectedName = "Testing only";
		double expectedWeight = 0.25;
		int gradesToDrop = 1;
		double [] expectedGrades = {0.1, 0.2};
		NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, gradesToDrop, expectedGrades);
		
		ArrayList<Double> actualGrades = testCategory.getGrades();
		double [] actualArray = new double[actualGrades.size()];
		for (int arrayCounter = 0; arrayCounter < actualGrades.size(); arrayCounter++)
		{
			actualArray[arrayCounter] = actualGrades.get(arrayCounter).doubleValue();
		}
		
		assertEquals("Testing expected name", testCategory.getName(), expectedName);
		assertEquals("Testing expected weight", testCategory.getWeight(), expectedWeight, 0.00001);
		assertArrayEquals("Testing expected grades", actualArray, expectedGrades, 0.00001);
	}
	
	public void test_ConstructorWithGrades_invalidGradeTooSmall()
	{
		String expectedName = "Testing only";
		double expectedWeight = 0.25;
		int gradesToDrop = 1;
		double [] startingGrades = {0.1, 0.2, -3.0};
		double [] expectedGrades = {0.1, 0.2};
		NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, gradesToDrop, startingGrades);
		
		ArrayList<Double> actualGrades = testCategory.getGrades();
		double [] actualArray = new double[actualGrades.size()];
		for (int arrayCounter = 0; arrayCounter < actualGrades.size(); arrayCounter++)
		{
			actualArray[arrayCounter] = actualGrades.get(arrayCounter).doubleValue();
		}
		
		assertEquals("Testing expected name", testCategory.getName(), expectedName);
		assertEquals("Testing expected weight", testCategory.getWeight(), expectedWeight, 0.00001);
		assertArrayEquals("Testing expected grades", actualArray, expectedGrades, 0.00001);
	}
	
	public void test_ConstructorWithGrades_invalidGradeTooLarge()
	{
		String expectedName = "Testing only";
		double expectedWeight = 0.25;
		int gradesToDrop = 1;
		double [] startingGrades = {0.1, 0.2, 30.0};
		double [] expectedGrades = {0.1, 0.2};
		NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, gradesToDrop, startingGrades);
		
		ArrayList<Double> actualGrades = testCategory.getGrades();
		double [] actualArray = new double[actualGrades.size()];
		for (int arrayCounter = 0; arrayCounter < actualGrades.size(); arrayCounter++)
		{
			actualArray[arrayCounter] = actualGrades.get(arrayCounter).doubleValue();
		}
		
		assertEquals("Testing expected name", testCategory.getName(), expectedName);
		assertEquals("Testing expected weight", testCategory.getWeight(), expectedWeight, 0.00001);
		assertArrayEquals("Testing expected grades", actualArray, expectedGrades, 0.00001);
	}
	
	@Test
	public void test_calculateGrade_default()
	{
		String expectedName = "Testing only";
		double expectedWeight = 0.5;
		int numGradesToDrop = 1;
		double [] expectedGrades = {0.1, 0.2};
		double expectedResult = 0.1;
		
		NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, numGradesToDrop, expectedGrades);
		assertEquals("Testing expected calculated grade", testCategory.calculateGrade(), expectedResult, 0.00001);
	}
	

	@Test
	public void test_getGrades_encapsulated()
	{
		String expectedName = "Testing only";
		double expectedWeight = 1.5;
		int numGradesToDrop = 1;
		double [] expectedGrades = {0.1, 0.2};
		NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, numGradesToDrop, expectedGrades);		
		ArrayList<Double> testList = testCategory.getGrades();
						
		assertNotSame("Testing to ensure a copy of the list is returned.", testCategory.grades, testList);
	}
	
	@Test
	public void test_dropGrades_DropOne()
	{
		String expectedName = "Testing only";
		double expectedWeight = 1.5;
		int numGradesToDrop = 1;
		double [] testArray = {1.0, 2.0, 3.0, 4.0};
		NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, numGradesToDrop, testArray);
		
		
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			expectedList.add(new Double(testArray[testCounter]));
		}

		ArrayList<Double> actualList = testCategory.dropGrades();
		expectedList.remove(0);
				
		assertArrayEquals("Using dropGrades() to drop one grade", expectedList.toArray(), actualList.toArray());
	}
	
	@Test
	public void test_dropGrades_DropTwo()
	{
		String expectedName = "Testing only";
		double expectedWeight = 1.5;
		int numGradesToDrop = 2;
		double [] testArray = {1.0, 2.0, 3.0, 4.0};
		NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, numGradesToDrop, testArray);
		
		
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			expectedList.add(new Double(testArray[testCounter]));
		}

		ArrayList<Double> actualList = testCategory.dropGrades();
		expectedList.remove(1);
		expectedList.remove(0);
				
		assertArrayEquals("Using dropGrades() to drop two grades",expectedList.toArray(), actualList.toArray());
	}
	
	@Test
	public void test_dropNGrades_DropTooMany()
	{
		String expectedName = "Testing only";
		double expectedWeight = 1.5;
		int numGradesToDrop = 3;
		double [] testArray = {1.0, 2.0};
		NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, numGradesToDrop, testArray);
			
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			expectedList.add(new Double(testArray[testCounter]));
		}

		ArrayList<Double> actualList = testCategory.dropGrades();
						
		assertArrayEquals("Using dropGrades() to drop too many grades",expectedList.toArray(), actualList.toArray());
	}
	
	@Test
	public void test_dropGrades_encapsulated()
	{
		String expectedName = "Testing only";
		double expectedWeight = 1.5;
		int numGradesToDrop = 1;
		double [] testArray = {1.0, 2.0};
		NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, numGradesToDrop, testArray);
			
		ArrayList<Double> actualList = testCategory.dropGrades();
		ArrayList<Double> testList = testCategory.getGrades();
						
		assertNotSame("Testing to ensure a copy of the list is returned by dropGrades(): different references", testList, actualList);
		
		testCategory.addGrade(4.0);
		assertEquals("Testing to ensure a copy of the list is returned by dropGrades(): adding grade does not change size of list with dropped grade", actualList.size(), 1.0, 0.00001);
	}
//	
//	@Test
//	public void test_findAverageGrade_Default()
//	{
//		double expected = 2.5;
//		CourseCalculator testCalculator = new CourseCalculator();
//		ArrayList<Double> testList = new ArrayList<Double>();
//		double [] testArray = {1.0, 2.0, 3.0, 4.0};
//		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
//		{
//			testList.add(new Double(testArray[testCounter]));
//		}
//		double testActual = testCalculator.findAverageGrade(testList);
//		assertEquals("Checking whether the findAverageGrade method returns the correct value", expected, testActual, 0.00001);
//	}
//	
//	@Test
//	public void test_findAverageGrade_Too_Small()
//	{
//		double expected = 0.0;
//		double [] testArray = {-1.0, 2.0, -13.0, -1.0};
//		ArrayList<Double> testList = new ArrayList<Double>();
//		CourseCalculator testCalculator = new CourseCalculator();
//		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
//		{
//			testList.add(new Double(testArray[testCounter]));
//		}		
//		double testActual = testCalculator.findAverageGrade(testList);
//		assertEquals("Checking whether the findAverageGrade method checks for results that are too small", expected, testActual, 0.00001);
//	}
//	
//	@Test
//	public void test_findAverageGrade_Too_Large()
//	{
//		double expected = 0.0;
//		double [] testArray = {1.0, 2.0, 13.0, 1.0};
//		ArrayList<Double> testList = new ArrayList<Double>();
//		CourseCalculator testCalculator = new CourseCalculator();
//		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
//		{
//			testList.add(new Double(testArray[testCounter]));
//		}	
//		double testActual = testCalculator.findAverageGrade(testList);
//		assertEquals("Checking whether the findAverageGrade method checks for results that are too small", expected, testActual, 0.00001);
//	}

}
