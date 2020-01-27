import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Expressions2Test {
	String filename = "Expressions2.java";

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
	public void test_isLower_a() {
		assertFalse("Don't use the Character class in your code.",usesLibrary("Character"));
		
		boolean expected = true;
		boolean actual = Expressions2.isLower('a');
		
		assertEquals("Checking if a is lower case letter", expected, actual);
	}

	@Test
	public void test_isLower_z() {
		assertFalse("Don't use the Character class in your code.",usesLibrary("Character"));
		
		boolean expected = true;
		boolean actual = Expressions2.isLower('z');
		
		assertEquals("Checking if z is lower case letter", expected, actual);
	}

	@Test
	public void test_isLower_f() {
		assertFalse("Don't use the Character class in your code.",usesLibrary("Character"));
		
		boolean expected = true;
		boolean actual = Expressions2.isLower('f');
		
		assertEquals("Checking if f is lower case letter", expected, actual);
	}

	@Test
	public void test_isLower_A() {
		assertFalse("Don't use the Character class in your code.",usesLibrary("Character"));
		
		boolean expected = false;
		boolean actual = Expressions2.isLower('A');
		
		assertEquals("Checking if A is lower case letter", expected, actual);
	}

	@Test
	public void test_isLower_7() {
		assertFalse("Don't use the Character class in your code.",usesLibrary("Character"));
		
		boolean expected = false;
		boolean actual = Expressions2.isLower('7');
		
		assertEquals("Checking if 7 is lower case letter", expected, actual);
	}

	
	@Test
	public void test_computePolynomial_0_0() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = 47;
		double actual = Expressions2.computePolynomial(0.0);
		
		assertEquals("Value of polynomial at 0.0", expected, actual, 0.00001);
	}

	@Test
	public void test_computePolynomial_100_15() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = 2034944.27425;
		double actual = Expressions2.computePolynomial(100.15);
		
		assertEquals("Value of polynomial at 100.15", expected, actual, 0.000001);
	}

	@Test
	public void test_computePolynomial_negativeNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = 99.638106;
		double actual = Expressions2.computePolynomial(-1.234);
		
		assertEquals("Value of polynomial at -1.234", expected, actual, 0.00001);
	}

	@Test
	public void test_computePolynomial_SmallNegativeNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = -1342103785;
		double actual = Expressions2.computePolynomial(-876.0);
		
		assertEquals("Value of polynomial at -876.0", expected, actual, 0.00001);
	}

	@Test
	public void test_computePolynomial_LargeNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = 1925890706;
		double actual = Expressions2.computePolynomial(987.0);
		
		assertEquals("Value of polynomial at 987.0", expected, actual, 0.00001);
	}

	@Test
	public void test_division_DivisionResultsInWholeNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = 4.0;
		double actual = Expressions2.division(12,3);
		
		assertEquals("Value of (12/3)", expected, actual, 0.00001);
	}

	@Test
	public void test_division_DivisionResultsInNegativeNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = -4;
		double actual = Expressions2.division(12,-3);
		
		assertEquals("Value of (12/-3)", expected, actual, 0.00001);
	}

	@Test
	public void test_division_DivisionResultsInDecimal() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = 0.3333333;
		double actual = Expressions2.division(1,3);
		
		assertEquals("Value of (1/3)", expected, actual, 0.00001);
	}

	@Test
	public void test_division_DivisionResultsLarge() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = 1795095.2;
		double actual = Expressions2.division(8975476,5);
		
		assertEquals("Value of 8975476/4)", expected, actual, 0.00001);
	}

	@Test
	public void test_convertToString_12345() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use the Integer library or the word Integer in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		String expected = "12345";
		String actual = Expressions2.convertToString(12345);
		
		assertEquals("testing 12345", expected, actual);
	}
	
	@Test
	public void test_convertToString_00000() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use the Integer library or the word Integer in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		String expected = "00000";
		String actual = Expressions2.convertToString(0);
		
		assertEquals("testing 00000", expected, actual);
	}

	@Test
	public void test_convertToString_876543() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use the Integer library or the word Integer in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		String expected = "76543";
		String actual = Expressions2.convertToString(876543);
		
		assertEquals("testing 876543", expected, actual);
	}
	
	@Test
	public void test_convertToString_veryLongNumber() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use the Integer library or the word Integer in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		String expected = "12345";
		String actual = Expressions2.convertToString(1234512345);
		
		assertEquals("testing 1234512345", expected, actual);
	}

	@Test
	public void test_convertToString_ShortNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use the Integer library or the word Integer in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		String expected = "00497";
		String actual = Expressions2.convertToString(497);
		
		assertEquals("testing 497", expected, actual);
	}


}
