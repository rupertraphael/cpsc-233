import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

public class NonProjectCategoryTest {
	@Test
	public void test_ConstructorWithGrades_default()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 0.25;
		int gradesToDrop = 1;
		double [] expectedGrades = {0.1, 0.2};

		try
		{
			NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, gradesToDrop, expectedGrades);

			ArrayList<Double> actualGrades = testCategory.getGrades();
			double [] actualArray = new double[actualGrades.size()];
			for (int arrayCounter = 0; arrayCounter < actualGrades.size(); arrayCounter++)
			{
				actualArray[arrayCounter] = actualGrades.get(arrayCounter).doubleValue();
			}

			assertEquals("Testing expected name",  expectedName, testCategory.getName());
			assertEquals("Testing expected weight", expectedWeight, testCategory.getWeight(), 0.00001);
			assertArrayEquals("Testing expected grades", expectedGrades, actualArray, 0.00001);
		}
		catch(CategoryNotValidException cNVE)
		{
			fail("Exception caugh: CategoryNotValidException");
		}
	}
	
	@Test
	public void test_ConstructorWithGrades_invalidGradeTooSmall()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 0.25;
		int gradesToDrop = 1;
		double [] startingGrades = {0.1, 0.2, -3.0};
		double [] expectedGrades = {0.1, 0.2};
		try
		{
			NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, gradesToDrop, startingGrades);

			ArrayList<Double> actualGrades = testCategory.getGrades();
			double [] actualArray = new double[actualGrades.size()];
			for (int arrayCounter = 0; arrayCounter < actualGrades.size(); arrayCounter++)
			{
				actualArray[arrayCounter] = actualGrades.get(arrayCounter).doubleValue();
			}

			assertEquals("Testing expected name", expectedName, testCategory.getName());
			assertEquals("Testing expected weight", expectedWeight, testCategory.getWeight(), 0.00001);
			assertArrayEquals("Testing expected grades", expectedGrades, actualArray, 0.00001);
		}
		catch(CategoryNotValidException cNVE)
		{
			fail("Exception caught: CategoryNotValidException");
		}
	}

	@Test
	public void test_ConstructorWithGrades_invalidGradeTooLarge()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 0.25;
		int gradesToDrop = 1;
		double [] startingGrades = {0.1, 0.2, 30.0};
		double [] expectedGrades = {0.1, 0.2};

		try
		{
			NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, gradesToDrop, startingGrades);

			ArrayList<Double> actualGrades = testCategory.getGrades();
			double [] actualArray = new double[actualGrades.size()];
			for (int arrayCounter = 0; arrayCounter < actualGrades.size(); arrayCounter++)
			{
				actualArray[arrayCounter] = actualGrades.get(arrayCounter).doubleValue();
			}

			assertEquals("Testing expected name", expectedName, testCategory.getName());
			assertEquals("Testing expected weight", expectedWeight, testCategory.getWeight(), 0.00001);
			assertArrayEquals("Testing expected grades", expectedGrades, actualArray, 0.00001);
		}
		catch(CategoryNotValidException cNVE)
		{
			fail("Exception caught: CategoryNotValidException");
		}
	}
	
	@Test (expected = CategoryNotValidException.class)
	public void test_ConstructorWithGrades_categoryNotValid() throws CategoryNotValidException
	{
		String expectedName = "just testing!";
		double expectedWeight = 0.25;
		int gradesToDrop = 1;
		double [] expectedGrades = {0.1, 0.2};

		try
		{
			NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, gradesToDrop, expectedGrades);
		}
		catch(CategoryNotValidException cNVE)
		{
			throw cNVE;
		}
	}
	
	
	@Test
	public void test_calculateGrade_default()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 0.5;
		int numGradesToDrop = 1;
		double [] expectedGrades = {0.1, 0.2};
		double expectedResult = 0.1;

		try
		{
			NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, numGradesToDrop, expectedGrades);
			assertEquals("Testing expected calculated grade", expectedResult, testCategory.calculateGrade(), 0.00001);
		}
		catch(CategoryNotValidException cNVE)
		{
			fail("Exception caught: CategoryNotValidException");
		}
	}
	

	@Test
	public void test_getGrades_encapsulated()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 1.5;
		int numGradesToDrop = 1;
		double [] expectedGrades = {0.1, 0.2};

		try
		{
			NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, numGradesToDrop, expectedGrades);		
			ArrayList<Double> testList = testCategory.getGrades();

			assertNotSame("Testing to ensure a copy of the list is returned.", testList, testCategory.grades);
		}
		catch(CategoryNotValidException cNVE)
		{
			fail("Exception caught: CategoryNotValidException");	
		}
	}
	
	@Test
	public void test_dropGrades_DropOne()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 1.5;
		int numGradesToDrop = 1;
		double [] testArray = {1.0, 2.0, 3.0, 4.0};
		try
		{
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
		catch(CategoryNotValidException cNVE)
		{
			fail("Exception caught: CategoryNotValidException");
		}
	}
	
	@Test
	public void test_dropGrades_DropTwo()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 1.5;
		int numGradesToDrop = 2;
		double [] testArray = {1.0, 2.0, 3.0, 4.0};
		try
		{
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
		catch(CategoryNotValidException cNVE)
		{
			fail("Exception caught: CategoryNotValidException");
		}

	}
	
	@Test
	public void test_dropNGrades_DropTooMany()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 1.5;
		int numGradesToDrop = 3;
		double [] testArray = {1.0, 2.0};
		try
		{
			NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, numGradesToDrop, testArray);

			ArrayList<Double> expectedList = new ArrayList<Double>();
			for (int testCounter = 0; testCounter < testArray.length; testCounter++)
			{
				expectedList.add(new Double(testArray[testCounter]));
			}

			ArrayList<Double> actualList = testCategory.dropGrades();

			assertArrayEquals("Using dropGrades() to drop too many grades",expectedList.toArray(), actualList.toArray());
		}
		catch(CategoryNotValidException cNVE)
		{
			fail("Exception caught: CategoryNotValidException");
		}
	}
	
	@Test
	public void test_dropGrades_encapsulated()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 1.5;
		int numGradesToDrop = 1;
		double [] testArray = {1.0, 2.0};
		try
		{
		NonProjectCategory testCategory = new NonProjectCategory(expectedName, expectedWeight, numGradesToDrop, testArray);
			
		ArrayList<Double> actualList = testCategory.dropGrades();
		ArrayList<Double> testList = testCategory.getGrades();
						
		assertNotSame("Testing to ensure a copy of the list is returned by dropGrades(): different references", testList, actualList);
		
		testCategory.addGrade(4.0);
		assertEquals("Testing to ensure a copy of the list is returned by dropGrades(): adding grade does not change size of list with dropped grade",  1.0, actualList.size(), 0.00001);
		}
		catch(CategoryNotValidException cNVE)
		{
			fail("Exception caught: CategoryNotValidException");
		}
		
		}

}
