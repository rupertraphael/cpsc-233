public class Point {
	int xcoord;
	int ycoord;
	

	public Point(int i, int j) {
		this.setXCoord(i);
		this.setYCoord(j);
	}

	public Point(Point p) {
		this(p.xcoord, p.ycoord);
	}
	
	public void moveUp(int i) {
		this.setYCoord(this.getYCoord() - i);
	}

	public void moveDown(int i) {
		this.setYCoord(this.getYCoord() + i);
	}

	public void moveLeft(int i) {
		this.setXCoord(this.getXCoord() - i);
	}

	public void moveRight(int i) {
		this.setXCoord(this.getXCoord() + i);
	}

	public double distance(Point p2) {
		System.out.println();
		
		double aSquared = Math.pow((p2.getXCoord() - this.getXCoord()), 2);
		double bSquared = Math.pow((p2.getYCoord() - this.getYCoord()), 2);
		
		double c = Math.pow(aSquared + bSquared, 0.5);
		
		return c;
	}

	public int getXCoord() {
		return this.xcoord;
	}

	public int getYCoord() {
		return this.ycoord;
	}
	
	public void setXCoord(int i) {
		if(i >= 0) {
			this.xcoord = i;
		}
	}

	public void setYCoord(int i) {
		if(i >= 0) {
			this.ycoord = i;
		}
	}
	
	public boolean equals(Point p) {
		boolean equal = (p.getXCoord() == this.getXCoord()) && (p.getYCoord() == this.getYCoord());
		
		return equal;
	}

}
