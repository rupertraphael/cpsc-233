
public class Line {
	
	private Point start;
	private Point end;

	public Line(Point point, Point point2) {
		this.setStart(new Point(point));
		this.setEnd(new Point(point2));
	}

	public double length() {
		return this.start.distance(this.end);
	}

	public Point getStart() {
		return new Point(this.start);
	}

	public Point getEnd() {
		return new Point(this.end);
	}

	public void setEnd(Point p1) {
		this.end = new Point(p1);
	}

	public void setStart(Point p1) {
		this.start = new Point(p1);
	}

}
