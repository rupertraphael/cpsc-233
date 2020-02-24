/*****************************
 * class ProjectCategory
 * 
 * This class represents the project grade of the course. 
 * It contains the following instance variables:
 * 
 */


public class ProjectCategory extends Category {
	public ProjectCategory(double weight, double rawGrade)
	{
		super("Project", weight, new double[]{rawGrade});
	}


}
