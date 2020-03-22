

/*****************************
 * class ProjectCategory
 * 
 * This class represents the project grade of the course. 
 * It contains the following instance variables:
 * 
 */


public class ProjectCategory extends Category {
	
	private double adjustmentFactor = 1.0;
	
	public ProjectCategory(double weight, double rawGrade) throws CategoryNotValidException
	{
		super("Project", weight, new double[]{rawGrade});
	}
	
	/********
	 * TODO: Ensure that this constructor handles CategoryNotValidException in an appropriate way.
	 * 
	 * @param weight
	 * @param rawGrade
	 * @param adjustmentFactor
	 */
	
	
	public ProjectCategory(double weight, double rawGrade, double adjustmentFactor) throws CategoryNotValidException
	{
		super("Project", weight, new double[] {rawGrade});
		this.setAdjustmentFactor(adjustmentFactor);
	}
	
	/*******
	 * getAdjustedGrade()
	 * 
	 * @return double the adjusted grade (i.e. adjustment factor * grade)
	 */
	
	
	public double getAdjustedGrade()
	{
		double adjustedGrade = 0.0;
		if (grades.size() == 1)
			adjustedGrade = grades.get(0).doubleValue() * adjustmentFactor;
				
		if (adjustedGrade > 4.3)
			adjustedGrade = 4.3;
		
		return adjustedGrade;
	}
	/****
	 * calculateGrade()
	 * calculates the weighted grade based upon the adjusted 
	 * grade. It should still check that the weight is valid (i.e. greater than 0 and less than
	 * or equal to 1.0), and return 0 if it is not.
	 * @return double: the calculated grade (adjusted grade * weight)
	 */
	
	@Override
	public double calculateGrade()
	{
		boolean validWeight = ((this.weight > 0) && (this.weight <= 1.0));
		if(validWeight)
		{
			return this.getAdjustedGrade() * weight;
		}
		else
			return 0.0;
	}

	/****
	 * Getters and Setters
	 * */
	
	public double getAdjustmentFactor() {
		return adjustmentFactor;
	}

	public void setAdjustmentFactor(double adjustmentFactor) {
		if (adjustmentFactor > 0)
		{
			this.adjustmentFactor = adjustmentFactor;
		}
	}	
	
	
}
