import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;
public class CategoryTest extends FormatTester{
	
	public class TrialCategory extends Category
	{
		public TrialCategory()
		{
			super();
		}
		
		public TrialCategory(String newName, double newWeight, double[] rawGrades) throws CategoryNotValidException
		{
			super(newName, newWeight, rawGrades);
		}
		
		public double calculateGrade()
		{
			boolean validWeight = ((this.weight > 0) && (this.weight <= 1.0));
			if(!grades.isEmpty() && validWeight)
			{
				return grades.get(0).doubleValue() * weight;
			}
			else
				return 0.0;
		}
	}
	public static final String CLASSNAME = "Category";
	
	public CategoryTest()
	{
		super(CLASSNAME, true);
	}
	
	private void testClassDefinition()
	{
		String[] abstractMethods = {"double calculateGrade()"};
		assertTrue("Class should have abstract methods calculateGrade that returns a double (minimize whitespace in signature).", hasRequiredAbstractMethods(abstractMethods));
		
	}
	
	@Test 
	public void test_constructorNoArgs_default()
	{
		TrialCategory testCategory = new TrialCategory();
		testClassDefinition();
		assertEquals("Testing default name", "", testCategory.getName());
		assertEquals("Testing default weight", 0.0, testCategory.getWeight(), 0.00001);
		assertNotNull("Testing default grades", testCategory.getGrades());
	}
	
	@Test 
	public void test_ConstructorWithGrades_default()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 0.25;
		double [] expectedGrades = {0.1, 0.2};
		try
		{
			TrialCategory testCategory = new TrialCategory(expectedName, expectedWeight, expectedGrades);
			testClassDefinition();

			ArrayList<Double> actualGrades = testCategory.getGrades();
			double [] actualArray = new double[actualGrades.size()];
			for (int arrayCounter = 0; arrayCounter < actualGrades.size(); arrayCounter++)
			{
				actualArray[arrayCounter] = actualGrades.get(arrayCounter).doubleValue();
			}

			assertEquals("Testing expected name", expectedName, testCategory.getName());
			assertEquals("Testing expected weight",  expectedWeight, testCategory.getWeight(), 0.00001);
			assertArrayEquals("Testing expected grades", expectedGrades, actualArray,  0.00001);
		}
		catch(CategoryNotValidException cNVE)
		{
			fail("CategoryNotValidException caught!");
		}
	}
	
	@Test
	public void test_ConstructorWithGrades_invalidGradeTooSmall()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 0.25;
		double [] startingGrades = {0.1, 0.2, -5.0};
		double [] expectedGrades = {0.1, 0.2};
		try
		{
			TrialCategory testCategory = new TrialCategory(expectedName, expectedWeight, startingGrades);
			testClassDefinition();

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
			fail("CategoryNotValidException caught!");
		}
	}
	
	@Test
	public void test_ConstructorWithGrades_invalidGradeTooLarge()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 0.25;
		double [] startingGrades = {0.1, 0.2, -5.0};
		double [] expectedGrades = {0.1, 0.2};
		try
		{
			TrialCategory testCategory = new TrialCategory(expectedName, expectedWeight, startingGrades);
			testClassDefinition();

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
			fail("CategoryNotValidException caught!");
		}
	}
	
	@Test (expected = CategoryNotValidException.class)
	public void test_constructor_non_valid_category() throws CategoryNotValidException
	{
		String expectedName = "just testing";
		double expectedWeight = 0.5;
		double [] expectedGrades = {0.1, 0.2};
		
		try
		{
		TrialCategory testCategory = new TrialCategory(expectedName, expectedWeight, expectedGrades);
		testClassDefinition();
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
		double [] expectedGrades = {0.1, 0.2};
		double expectedResult = 0.05;
		try
		{
		TrialCategory testCategory = new TrialCategory(expectedName, expectedWeight, expectedGrades);
		testClassDefinition();
		assertEquals("Testing expected calculated grade", expectedResult, testCategory.calculateGrade(), 0.00001);
		}
		catch(CategoryNotValidException cNVE)
		{
			fail("CategoryNotValidException caught!");
		}
	}
	
	@Test
	public void test_calculateGrade_tooSmallWeight()
	{
		String expectedName = "iQuiz";
		double expectedWeight = -1;
		double [] expectedGrades = {0.1, 0.2};
		double expectedResult = 0.0;
		try
		{
			TrialCategory testCategory = new TrialCategory(expectedName, expectedWeight, expectedGrades);
			testClassDefinition();
			assertEquals("Testing expected calculated grade", expectedResult, testCategory.calculateGrade(), 0.00001);
		}
		catch(CategoryNotValidException cNVE)
		{
			fail("CategoryNotValidException caught!");
		}
	}
	
	@Test
	public void test_calculateGrade_tooBigWeight()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 1.5;
		double [] expectedGrades = {0.1, 0.2};
		double expectedResult = 0.0;
		
		try
		{
		TrialCategory testCategory = new TrialCategory(expectedName, expectedWeight, expectedGrades);
		testClassDefinition();
		assertEquals("Testing expected calculated grade",  expectedResult, testCategory.calculateGrade(), 0.00001);
		}
		catch(CategoryNotValidException cNVE)
		{
			fail("CategoryNotValidException caught!");
		}
	}
	
	@Test
	public void test_getGrades_encapsulated()
	{
		String expectedName = "iQuiz";
		double expectedWeight = 1.5;
		double [] expectedGrades = {0.1, 0.2};
		try {
		TrialCategory testCategory = new TrialCategory(expectedName, expectedWeight, expectedGrades);
		testClassDefinition();
		ArrayList<Double> testList = testCategory.getGrades();
						
		assertNotSame("Testing to ensure a copy of the list is returned.", testCategory.grades, testList);
		}
		catch(CategoryNotValidException cNVE)
		{
			fail("CategoryNotValidException caught!");
		}
	}
	

}
