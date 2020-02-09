import java.util.ArrayList;

/* CourseCalculator.java
 * 
 * This program calculates your final grade for CPSC 233 as a weighted average
 * given a set of raw grades in each of five grading categories and the corresponding
 * weights.
 * 
 * Recall that you will have:
 *   10 Individual Assignments (10% or 0.1 of your overall grade)
 *   11 Individual Quizzes (20% or 0.2 of your overall grade)
 *   6 Coding Challenges (30% or 0.3 of your overall grade)
 *   10 Team Quizzes (10% or 0.1 of your overall grade)
 *   1 Team Project (30% or 0.3 of your overall grade)
 */

public class CourseCalculator {
	
	// Raw grades 
	// Values should be between 0 and 4 (U of C's 4-point grading scale)
	// These values can be changed to test whether the grade calculation is accurate
		
	ArrayList<Double> iAssignmentGrades;
	ArrayList<Double> iQuizGrades;
	ArrayList<Double> iCodingChallengeGrades;
	ArrayList<Double> tQuizGrades;
	double tProjectGrade = 1.0;
	double finalGrade = 0.0;

	/* CourseCalculator
	 * Constructor for the class: DO NOT MODIFY 
	 * 
	 * You may wish to note how other methods are called to help you implement them
	 */
		
	public CourseCalculator()
	{
		loadIAssignmentGrades(new double[]{2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0});
		loadIQuizGrades(new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0});
		loadICodingChallengeGrades(new double[]{3.0, 3.0, 3.0, 3.0, 3.0, 3.0});
		loadTQuizGrades(new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0});
		calculateFinalGrade();
	}
	
	// TODO: implement similar methods for each of the other grade categories:
	// iQuizGrades
	// iCodingChallengeGrades
	// tQuizGrades
	// Don't forget to add an appropriate comment block
	
	/* loadIAssignmentGrades(double [] rawAGrades)
	 * @param an array of doubles which should become the elements of
	 *    the ArrayList for the grade category
	 * 
	 */
	
	public void loadIAssignmentGrades(double [] rawAGrades)
	{
		iAssignmentGrades = new ArrayList<Double>();
		for (int arrayCounter = 0; arrayCounter < rawAGrades.length; arrayCounter++)
		{
			iAssignmentGrades.add(new Double(rawAGrades[arrayCounter]));
		}
	}
	
	public void loadIQuizGrades(double [] rawAGrades)
	{
		iQuizGrades = new ArrayList<Double>();
		for (int arrayCounter = 0; arrayCounter < rawAGrades.length; arrayCounter++)
		{
			iQuizGrades.add(new Double(rawAGrades[arrayCounter]));
		}
	}
	
	public void loadICodingChallengeGrades(double [] rawAGrades)
	{
		iCodingChallengeGrades = new ArrayList<Double>();
		for (int arrayCounter = 0; arrayCounter < rawAGrades.length; arrayCounter++)
		{
			iCodingChallengeGrades.add(new Double(rawAGrades[arrayCounter]));
		}
	}
	
	public void loadTQuizGrades(double [] rawAGrades)
	{
		tQuizGrades = new ArrayList<Double>();
		for (int arrayCounter = 0; arrayCounter < rawAGrades.length; arrayCounter++)
		{
			tQuizGrades.add(new Double(rawAGrades[arrayCounter]));
		}
	}
	
	// TODO: modify the calculation methods for each of the other grade categories:
	// iQuizGrades
	// iCodingChallengeGrades
	// tQuizGrades
	// Don't forget to add an appropriate comment block
	 
	public double calculateIAssignmentGrade()
	{
		final double iAssignmentGradeWeight = 0.1;		
		return findAverageGrade(dropNGrades(iAssignmentGrades, 2)) * iAssignmentGradeWeight;
	}
		
	public double calculateIQuizGrade()
	{
		final double iQuizGradeWeight = 0.2;
		return findAverageGrade(dropNGrades(iQuizGrades, 2)) * iQuizGradeWeight;
	}
		
	public double calculateICodingChallengeGrade()
	{
		final double iCodingChallengeGradeWeight = 0.3;
		return findAverageGrade(dropNGrades(iCodingChallengeGrades, 1)) * iCodingChallengeGradeWeight;
	}
		
	public double calculateTQuizGrade()
	{
		final double tQuizGradeWeight = 0.1;
		return findAverageGrade(dropNGrades(tQuizGrades, 2)) * tQuizGradeWeight;
	}
		
	public double calculateTProjectGrade()
	{
			final double tProjectGradeWeight = 0.3;
			return tProjectGrade * tProjectGradeWeight;
	}
		
	/*  calculateFinalGrade()
	 *  Sums up the weighted values of all grade categories
	 * 
	 * DO NOT MODIFY.
	 * 
	 */	
		
	public void calculateFinalGrade()
	{
		finalGrade = calculateIAssignmentGrade() +
				calculateIQuizGrade() +
				calculateICodingChallengeGrade() +
				calculateTQuizGrade() + 
				calculateTProjectGrade();
	}
	
	// TO-DO: write a method which returns a copy of the ArrayList passed in, with the lowest
	// numberToDrop grades removed. 
	// It should not be possible to drop more grades than the ArrayList contains
	// (if fewer grades are passed in than the number requested be dropped, then no grades should be removed)
	
	
	public ArrayList<Double> dropNGrades(ArrayList <Double> gradeList, int numberToDrop)
	{
		ArrayList<Double> smallerGradeList = new ArrayList<Double>();
		
		// Clone all of gradeList into smallerGradeList.
		for(double grade : gradeList) 
		{
			smallerGradeList.add(grade);
		}
		
		
		if(numberToDrop > gradeList.size() || numberToDrop <= 0) 
		{
			return smallerGradeList;
		}
		
		// Drop some grades.
		for(int numberOfDropped = 0; numberOfDropped < numberToDrop; numberOfDropped++)
		{
			int indexWithSmallestGrade = 0;
			
			for(int index = 0; index < smallerGradeList.size(); index++)
			{
				if(smallerGradeList.get(index) < smallerGradeList.get(indexWithSmallestGrade)) 
				{
					indexWithSmallestGrade = index;
				}
			}
			
			smallerGradeList.remove(indexWithSmallestGrade);
		}
		
		return smallerGradeList;
		
	}
	
	/* toString()
	 * Returns a string representation of the class
	 */ 	
	
	public String toString()
	{
		return "Your final grade will be " + finalGrade;
	}
		

		
	/* This method should calculate the mean of all the values in the array.
	 * 
	 * To do this, you should sum all the values in the array and divide 
	 * this sum by the number of values in the array
	 * 
	 *  @param An array of doubles containing the raw grades to be averaged 
	 * 	@return The mean of the values contained in the input array
	 */
	
	public double findAverageGrade(ArrayList<Double> rawGrades)
	{
		double mean = 0.0;
		double sum = 0.0;
		
		for (double rawGrade : rawGrades)
		{
			sum += rawGrade;
		}
		
		mean = sum / rawGrades.size();
		
		if ((mean < 0.0) || (mean > 4.0))
		{
			mean = 0.0;
		}
		// include a check: if your mean is greater than 4.0 or less than 0.0
		// have the method return 0
				
		return mean;	
	}
	
	
	/**
	 * @return the iAssignmentGrades
	 */
	public ArrayList<Double> getIAssignmentGrades() {
		ArrayList<Double> iAssignmentClone = new ArrayList<Double>();
		for (int i = 0; i < iAssignmentGrades.size(); i++)
		{
			iAssignmentClone.add(new Double(iAssignmentGrades.get(i)));
		}
		return iAssignmentClone;
	}

	/**
	 * @return a copy of iQuizGrades
	 * Do not modify.
	 */
	public ArrayList<Double> getIQuizGrades() {
		ArrayList<Double> iQuizClone = new ArrayList<Double>();
		for (int i = 0; i < iQuizGrades.size(); i++)
		{
			iQuizClone.add(new Double(iQuizGrades.get(i)));
		}
		return iQuizClone;
	}

	/**
	 * @return a copy of iCodingChallengeGrades
	 * Do not modify.
	 */
	public ArrayList<Double> getICodingChallengeGrades() {
		ArrayList<Double> iCodingChallengeClone = new ArrayList<Double>();
		for (int i = 0; i < iCodingChallengeGrades.size(); i++)
		{
			iCodingChallengeClone.add(new Double(iCodingChallengeGrades.get(i)));
		}
		return iCodingChallengeClone;
	}

	/**
	 * @return a copy of tQuizGrades
	 * Do not modify.
	 */
	public ArrayList<Double> getTQuizGrades() {
		ArrayList<Double> tQuizClone = new ArrayList<Double>();
		for (int i = 0; i < tQuizGrades.size(); i++)
		{
			tQuizClone.add(new Double(tQuizGrades.get(i)));
		}
		return tQuizClone;
	}

	/**
	 * @return the tProjectGrade
	 */
	public double gettProjectGrade() {
		return tProjectGrade;
	}

	/**
	 * @return the finalGrade
	 */
	public double getFinalGrade() {
		return finalGrade;
	}

	/* main()
	 * Do not modify.
	 */ 
	
	public static void main(String [] args)
	{
		CourseCalculator myCalculator = new CourseCalculator();
		System.out.println(myCalculator.toString());
	}
	
}


