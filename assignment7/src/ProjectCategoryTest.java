import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.junit.Test;

public class ProjectCategoryTest {
	@Test
	public void test_ConstructorWithGrades_default()
	{
		String expectedName = "Project";
		double expectedWeight = 0.25;
		double adjustmentFactor = 1.0;
		double expectedGrade = 1.0;
		double [] expectedArray = {1.0};
		ProjectCategory testCategory = new ProjectCategory(expectedWeight, expectedGrade, adjustmentFactor);	
		
		ArrayList<Double> actualGrades = testCategory.getGrades();
		double [] actualArray = new double[actualGrades.size()];
		for (int arrayCounter = 0; arrayCounter < actualGrades.size(); arrayCounter++)
		{
			actualArray[arrayCounter] = actualGrades.get(arrayCounter).doubleValue();
		}
		
		assertEquals("Testing expected name", testCategory.getName(), expectedName);
		assertEquals("Testing expected weight", testCategory.getWeight(), expectedWeight, 0.00001);
		assertArrayEquals("Testing expected grades", actualArray, expectedArray, 0.00001);
	}
	
	@Test
	public void test_ConstructorWithGrades_invalidGradeTooSmall()
	{
		String expectedName = "Project";
		double expectedWeight = 0.25;
		double startingGrade = -3.0;
		double adjustmentFactor = 1.0;
		double [] expectedGrades = {};
		ProjectCategory testCategory = new ProjectCategory(expectedWeight, startingGrade, adjustmentFactor);
		
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
		String expectedName = "Project";
		double expectedWeight = 0.25;
		double adjustmentFactor = 1.0;
		double startingGrade = 4.4;
		double [] expectedGrades = {};
		ProjectCategory testCategory = new ProjectCategory(expectedWeight, startingGrade, adjustmentFactor);
		
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
		String expectedName = "Project";
		double expectedWeight = 0.5;
		double adjustmentFactor = 1.0;
		double startingGrade = 1.0;
		double expectedResult = 0.5;
		
		ProjectCategory testCategory = new ProjectCategory(expectedWeight, startingGrade, adjustmentFactor);
		assertEquals("Testing expected calculated grade", testCategory.calculateGrade(), expectedResult, 0.00001);
	}
	
	@Test
	public void test_getAdjustedGrade_default()
	{
		double expectedWeight = 0.5;
		double adjustmentFactor = 1.0;
		double startingGrade = 1.0;
		double expectedResult = 1.0;
		
		ProjectCategory testCategory = new ProjectCategory(expectedWeight, startingGrade, adjustmentFactor);
		assertEquals("Testing expected adjusted grade", testCategory.getAdjustedGrade(), expectedResult, 0.00001);
	}
	
	@Test
	public void test_getAdjustedGrade_tooManyGrades()
	{
		double expectedWeight = 0.5;
		double adjustmentFactor = 1.0;
		double startingGrade = 1.0;
		double expectedResult = 0.0;
		
		ProjectCategory testCategory = new ProjectCategory(expectedWeight, startingGrade, adjustmentFactor);
		testCategory.addGrade(startingGrade);
		assertEquals("Testing expected adjusted grade", testCategory.getAdjustedGrade(), expectedResult, 0.00001);
	}
	
	@Test
	public void test_getAdjustedGrade_factorTooSmall()
	{
		double expectedWeight = 0.5;
		double adjustmentFactor = -1.0;
		double startingGrade = 1.0;
		double expectedResult = 1.0;
		
		ProjectCategory testCategory = new ProjectCategory(expectedWeight, startingGrade, adjustmentFactor);
		assertEquals("Testing expected adjusted grade", testCategory.getAdjustedGrade(), expectedResult, 0.00001);
	}
	
	@Test
	public void test_getAdjustedGrade_adjustedOverLimit()
	{
		String expectedName = "Project";
		double expectedWeight = 0.5;
		double adjustmentFactor = 2.0;
		double startingGrade = 4.0;
		double expectedResult = 4.3;
		
		ProjectCategory testCategory = new ProjectCategory(expectedWeight, startingGrade, adjustmentFactor);
		assertEquals("Testing expected adjusted grade", testCategory.getAdjustedGrade(), expectedResult, 0.00001);
	}
	
	@Test
	public void test_setAdjustmentFactor()
	{
		String expectedName = "Project";
		double expectedWeight = 0.5;
		double adjustmentFactor = 1.5;
		double expectedResult = 1.5;
		
		ProjectCategory testCategory = new ProjectCategory(expectedWeight, 1.0);
		testCategory.setAdjustmentFactor(adjustmentFactor);
		
		assertEquals("Testing setter for adjustmentFactor", testCategory.getAdjustedGrade(), expectedResult, 0.00001);
	}
	
	@Test
	public void test_setAdjustmentFactorTooSmall()
	{
		String expectedName = "Project";
		double expectedWeight = 0.5;
		double adjustmentFactor = -1.5;
		double expectedResult = 1.0;
		
		ProjectCategory testCategory = new ProjectCategory(expectedWeight, 1.0);
		testCategory.setAdjustmentFactor(adjustmentFactor);
		
		assertEquals("Testing setter for adjustmentFactor", testCategory.getAdjustedGrade(), expectedResult, 0.00001);
	}


}
