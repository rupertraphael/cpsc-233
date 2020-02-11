import java.util.ArrayList;

public class BallPit {

	private String name;
	private ArrayList<Ball> ballList = new ArrayList<Ball>();
	
	public BallPit(String string) {
		this.name = string;
	}

	public void addBall(Ball m) {
		if(this.ballList == null) {
			this.ballList = new ArrayList<Ball>();
		}
		
		this.ballList.add(new Ball(m));
	}
	
	public String getName() {
		return this.name;
	}

	public ArrayList<Ball> getBallList() {
		ArrayList<Ball> balls = new ArrayList<Ball>();
		
		for(Ball ball : this.ballList) {
			balls.add(new Ball(ball));
		}
		
		return balls;
	}

	public Ball getBallWithMostBounces() {
		
		if(this.getBallList().isEmpty()) {
			return null;
		}
		
		Ball bounciestBall = this.getBallList().get(0);
		
		for(Ball ball : this.getBallList()) {
			if(ball.numberOfBounces() > bounciestBall.numberOfBounces()) {
				bounciestBall = ball;
			}
		}
		
		return bounciestBall;
		
		
	}

}
