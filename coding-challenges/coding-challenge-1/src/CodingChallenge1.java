
public class CodingChallenge1 {

	public static boolean isLowercaseChar(char aChar) {
		return aChar > 'Z';
	}
	
	public static int firstLowercaseChar(String str) {
		for(int index = 0; index < str.length(); index++) {
			if(isLowercaseChar(str.charAt(index)))
				return index;
		}
		
		return -1;
	}
	
	public static long ceilingOfMultiplication(int num1, double num2) {
		double difference = 0;
		
		difference = (long) (num1*num2) - (num1*num2);
		
		if(difference <= 0.0001 && difference >= -0.0001) {
			return (long) (num1*num2);
		}
		
		return (long) (num1*num2) + 1;
	}
	
	public static int addOctalDigits(int num) {
		
		int total;
		
		for(total = 0; num > 0; num = num / 8) {			
			total += num % 8;
		}
		
		return total;
		
	}

}
