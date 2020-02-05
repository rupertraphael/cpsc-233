import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CourseCalculatorTest {
	
	@Test 
	public void test_calculateIAssignmentGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0};
		double testActual = testCalculator.calculateIAssignmentGrade(testArray);
		double expected = 0.1;
		assertEquals("Checking whether the calculatingIAssignment method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test 
	public void test_calculateIQuizGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0};
		double testActual = testCalculator.calculateIQuizGrade(testArray);
		double expected = 0.2;
		assertEquals("Checking whether the calculateIQuizGrade method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test 
	public void test_calculateICodingChallengeGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0};
		double testActual = testCalculator.calculateICodingChallengeGrade(testArray);
		double expected = 0.3;
		assertEquals("Checking whether the calculateICodingchallenge method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test 
	public void test_calculateTQuizGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0};
		double testActual = testCalculator.calculateTQuizGrade(testArray);
		double expected = 0.1;
		assertEquals("Checking whether the calculateTQuizGrade method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_calculateTProjectGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double rawGrade = 1.0;
		double testActual = testCalculator.calculateTProjectGrade(rawGrade);
		double expected = 0.3;
		assertEquals("Checking whether the calculateTProjectGrade method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_findAverageGrade_Default()
	{
		double expected = 2.5;
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 3.0, 4.0};
		
		double testActual = testCalculator.findAverageGrade(testArray);
		assertEquals("Checking whether the findAverageGrade method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_findAverageGrade_Too_Small()
	{
		double expected = 0.0;
		double [] testArray = {-1.0, 2.0, -13.0, -1.0};
		CourseCalculator testCalculator = new CourseCalculator();
		
		double testActual = testCalculator.findAverageGrade(testArray);
		assertEquals("Checking whether the findAverageGrade method checks for results that are too small", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_findAverageGrade_Too_Large()
	{
		double expected = 0.0;
		double [] testArray = {1.0, 5.0, 13.0, 1.0};
		CourseCalculator testCalculator = new CourseCalculator();
		
		double testActual = testCalculator.findAverageGrade(testArray);
		assertEquals("Checking whether the findAverageGrade method checks for results that are too small", expected, testActual, 0.00001);
	}
	
}
