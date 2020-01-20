public class Expressions2 {
	public static boolean isLower(char character) {
		return character >= 'a' && character <= 'z';
	}
	
	public static double computePolynomial(double number) {
		number = (2  * (number * number * number)) + 3*((7 - number)* (7 - number)) - 100;
		
		System.out.println(number);
		
		return number;
	}
	
	public static String convertToString(int number) {
		
		String newString = String.format("%05d", number);
		
		newString = newString.substring(newString.length()-5);
		
		return newString;
	}
	
	public static double division(int dividend, int divisor) {
		return (double) dividend/divisor;
	}
	
}
