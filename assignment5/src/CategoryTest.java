import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
public class CategoryTest {
	@Test
	public void test_constructorNoArgs_default()
	{
		Category testCategory = new Category();
		assertEquals("Testing default name", testCategory.getName(), "");
		assertEquals("Testing default weight", testCategory.getWeight(), 0.0, 0.00001);
		assertNotNull("Testing default grades", testCategory.getGrades());
	}
	
	@Test
	public void test_ConstructorWithGrades_default()
	{
		String expectedName = "Testing only";
		double expectedWeight = 0.25;
		double [] expectedGrades = {0.1, 0.2};
		Category testCategory = new Category(expectedName, expectedWeight, expectedGrades);
		
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
	public void test_ConstructorWithGrades_invalidGradeTooSmall()
	{
		String expectedName = "Testing only";
		double expectedWeight = 0.25;
		double [] startingGrades = {0.1, 0.2, -5.0};
		double [] expectedGrades = {0.1, 0.2};
		Category testCategory = new Category(expectedName, expectedWeight, startingGrades);
		
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
	public void test_ConstructorWithGrades_invalidGradeTooLarge()
	{
		String expectedName = "Testing only";
		double expectedWeight = 0.25;
		double [] startingGrades = {0.1, 0.2, -5.0};
		double [] expectedGrades = {0.1, 0.2};
		Category testCategory = new Category(expectedName, expectedWeight, startingGrades);
		
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
		double [] expectedGrades = {0.1, 0.2};
		double expectedResult = 0.05;
		
		Category testCategory = new Category(expectedName, expectedWeight, expectedGrades);
		assertEquals("Testing expected calculated grade", testCategory.calculateGrade(), expectedResult, 0.00001);
	}
	
	@Test
	public void test_calculateGrade_tooSmallWeight()
	{
		String expectedName = "Testing only";
		double expectedWeight = -1;
		double [] expectedGrades = {0.1, 0.2};
		double expectedResult = 0.0;
		
		Category testCategory = new Category(expectedName, expectedWeight, expectedGrades);
		assertEquals("Testing expected calculated grade", testCategory.calculateGrade(), expectedResult, 0.00001);
	
	}
	
	@Test
	public void test_calculateGrade_tooBigWeight()
	{
		String expectedName = "Testing only";
		double expectedWeight = 1.5;
		double [] expectedGrades = {0.1, 0.2};
		double expectedResult = 0.0;
		
		Category testCategory = new Category(expectedName, expectedWeight, expectedGrades);
		assertEquals("Testing expected calculated grade", testCategory.calculateGrade(), expectedResult, 0.00001);
	
	}
	
	@Test
	public void test_getGrades_encapsulated()
	{
		String expectedName = "Testing only";
		double expectedWeight = 1.5;
		double [] expectedGrades = {0.1, 0.2};
		Category testCategory = new Category(expectedName, expectedWeight, expectedGrades);		
		ArrayList<Double> testList = testCategory.getGrades();
						
		assertNotSame("Testing to ensure a copy of the list is returned.", testCategory.grades, testList);
	}
	

}
