import java.util.Random;

public class SmartAI extends Player{
	
	public SmartAI(int id){
		super(id);
	}
	
	public SmartAI(SmartAI toCopy){
		super(toCopy);
	}
	
	public int chooseMove() {
		int move = 100;
		int score = this.getScore();
		
		while((move + score) % 7 != 1 && (move + score) % 7 != 0) {
			move -= 1;
		}
		
		return move;
	}
	
	public String toString() {
		return "[Smart] " + super.toString();
	}

	@Override
	public String nextMove() {
		Integer move = this.chooseMove();
		
		return move.toString();
	}	
}