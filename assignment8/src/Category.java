

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*****************************
 * class Category
 * 
 * This class represents any category of grades used for the course. 
 * It contains the following instance variables:
 * 	name: a String which identifies the category
 *  weight: a value between 0.0 and 1.0 which defines how much the category is worth
 *  grades: an ArrayList of Doubles containing grades for the course, which should be between 0.0 and 4.3
 *
 */

public abstract class Category {
	private String name = "";
	private static List<String> permittedCategories = Arrays.asList("", "Project", "iQuiz", "tQuiz", "iCodingChallenge", "iAssignment"); 
	protected double weight;
	protected ArrayList<Double> grades;
	
	
	/* CourseCalculator()
	 * Constructor for the class
	 * 
	 * You may wish to note how other methods are called to help you implement them
	 */
	
	public Category()
	{
		this.grades = new ArrayList<Double>();
	}
	
	/* Category(String, double, double[])
	 * Constructor for the class
	 * 
	 * @param newName the name that will be used for the new instance of the class
	 * @param newWeight the weight that will be used for the new instance of the class
	 * @param rawGrades the individual grades that will be used for the new instance of the class
	 * 	Ignore grades that are invalid (for instance, if they are less than 0 or greater than 4.3)
	 * 
	 * Ensure that this method tries, catches and throws CategoryNotValidException appropriately.
	 * To do this, it is good practice to ensure that you are using getters and setters instead of directly
	 * access instance variables. 
	 * 
	 */
	
	
	public Category(String newName, double newWeight, double [] rawGrades) throws CategoryNotValidException
	{
		
		try {
			this.setName(newName);
		} catch(CategoryNotValidException e) {
			throw e;
		}

		this.setWeight(newWeight);
		
		this.grades= new ArrayList<Double>();
		for (int arrayCounter = 0; arrayCounter < rawGrades.length; arrayCounter++)
		{
			if ((rawGrades[arrayCounter] >= 0.0) && (rawGrades[arrayCounter] <= 4.3))
				grades.add(new Double(rawGrades[arrayCounter]));
		}
		
	}
	
	/* calculateGrade()
	 * Turn this into an abstract method
	 */
	public abstract double calculateGrade();

	// getters and setters, toString methods
	
	public String getName() {
		return name;
	}

	/***************
	 * setName(String name)
	 * 
	 * Make sure that this method checks the value of name to ensure that it is
	 * contained in the permittedCategories List. If name is not in permittedCategories, then
	 * this method should throw CategoryNotValidException with an appropriate message.
	 * 
	 * @param name
	 * @throws CategoryNotValidException
	 */
	
	
	public void setName(String name) throws CategoryNotValidException { 
		for(String category : Category.permittedCategories) {
			if(category.equals(name)) {
				this.name = name;
				return;
			}
		}

		throw new CategoryNotValidException();
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setGrade(int index, double newGrade)
	{
		try 
		{
			grades.set(index, new Double(newGrade));
		}
		catch(IndexOutOfBoundsException ie)
		{
			
		}
	}
	
	public void addGrade(double newGrade)
	{
		grades.add(new Double(newGrade));
	}
	
	public ArrayList<Double> getGrades()
	{
		ArrayList<Double> gradesClone = new ArrayList<Double>();
			for (int i = 0; i < grades.size(); i++)
			{
				gradesClone.add(new Double(grades.get(i)));
			}
			return gradesClone;
	}
		
	public String toString()
	{
		return name + " has weight " + weight + " and grades: " + grades.toString();
	}
}
