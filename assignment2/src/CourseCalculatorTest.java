import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CourseCalculatorTest {
	String filename = "CourseCalculator.java";

	private boolean containsImportStatement() {
		boolean containsImport = false;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line != null && !containsImport) {
				if (line.matches("import+\\s.*")) {
					containsImport = true;
				} 
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return containsImport;
	}
	
	/**
	Checks if the specified library is used anywhere in the code tested.  It checks
	for the word exactly.  If there is a variable name that contains the library name,
	this will result in a false positive.
	*/
	private boolean usesLibrary(String libraryName) {
		boolean usesLibrary = false;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line != null && !usesLibrary) {
				if (line.contains(libraryName)) {
					usesLibrary = true;
				} 
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return usesLibrary;	
	}
	
	/**
		Checks if the coding construct is used in the class we're testing.  It expects the 
		construct to be preceded and followed by white space or parenthesis.
	*/
	private boolean usesConstruct(String constructName) {
		boolean usesConstruct = false;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line != null && !usesConstruct) {
				if (line.matches(".*\\s+if+[\\s+,(].*")) {
					usesConstruct = true;
				} 
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return usesConstruct;	
	}

	@Test
	public void test_array_iQuiz()
	{
		int expected = 11;
		int actual = CourseCalculator.iQuizGrades.length;
		assertEquals("Checking the size of the iQuizGrades array", expected, actual);
	}
	
	@Test
	public void test_array_iAssignmentGrades()
	{
		int expected = 10;
		int actual = CourseCalculator.iAssignmentGrades.length;
		assertEquals("Checking the size of the iAssignmentGrades array", expected, actual);
	}
	
	@Test
	public void test_array_iCodingChallenge()
	{
		int expected = 6;
		int actual = CourseCalculator.iCodingChallengeGrades.length;
		assertEquals("Checking the size of the iCodingChallengeGrades array", expected, actual);
	}
	
	@Test
	public void test_findAverageGrade_Default()
	{
		double expected = 2.5;
		double [] testArray = {1.0, 2.0, 3.0, 4.0};
		
		double testActual = CourseCalculator.findAverageGrade(testArray);
		assertEquals("Checking whether the findAverageGrade method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_findAverageGrade_Too_Small()
	{
		double expected = 0.0;
		double [] testArray = {0.0, 0.0, 0.0, -0.1};
		
		double testActual = CourseCalculator.findAverageGrade(testArray);
		assertEquals("Checking whether the findAverageGrade method checks for results that are too small", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_findAverageGrade_Too_Large()
	{
		double expected = 0.0;
		double [] testArray = {4.3, 4.3, 4.3, 4.4};
		
		double testActual = CourseCalculator.findAverageGrade(testArray);
		assertEquals("Checking whether the findAverageGrade method checks for results that are too small", expected, testActual, 0.00001);
	}
	/*@Test
	public void test_isLower_a() {
		assertFalse("Don't use the Character class in your code.",usesLibrary("Character"));
		
		boolean expected = true;
		boolean actual = Expressions2.isLower('a');
		
		assertEquals("Checking if a is lower case letter", expected, actual);
	} */

}
