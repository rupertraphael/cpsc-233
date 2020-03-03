
public class Ball {

	private int height = 1;
	private double bounciness = 0.5;
	
	public Ball(double d, int i) {
		this.setBounciness(d);
		this.setHeight(i);
	}

	public Ball(Ball c) {
		this(c.getBounciness(), c.getHeight());
	}

	public void setBounciness(double i) {
		if(Double.compare(i, 0.0) > 0 && Double.compare(i, 1.0) < 0) {
			this.bounciness = i;
		}else {
			this.bounciness = 0.5;
		}
	}

	public void setHeight(int i) {
		if(i > 0) {
			this.height = i;
		}else {
			this.height = 1;
		}
	}

	public void bounce() {
		int height = (int) (this.getHeight() * this.getBounciness());
		
		this.height = height;
	}

	public double getBounciness() {
		return this.bounciness;
	}

	public int getHeight() {
		return this.height;
	}

	public int numberOfBounces() {

		int numberOfBounces = 0;
		
		for(int simulatedHeight = this.getHeight(); simulatedHeight >= 1; simulatedHeight *= this.getBounciness()) {
			numberOfBounces++;
		}
		
		
		return numberOfBounces;
	}
	
	public boolean equals(Ball c) {
		return Double.compare(this.getBounciness(), c.getBounciness()) == 0 && this.getHeight() == c.getHeight();
	}

}
