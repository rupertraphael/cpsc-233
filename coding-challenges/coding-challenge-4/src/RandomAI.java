import java.util.Random;

public class RandomAI extends Player{
	
	private int level = 1;
	
	public RandomAI(int id, int level){
		super(id);
		this.setLevel(level);
	}
	
	public RandomAI(RandomAI toCopy){
		super(toCopy);
		this.setLevel(toCopy.getLevel());
		
	}
	
	public void setLevel(int aLevel) {
		if(aLevel > 0 && aLevel <= 10) {
			System.out.println(aLevel);
			
			this.level = aLevel;
		}
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int chooseMove() {
		int move = new Random().nextInt(10);
		
		return move * this.getLevel();
	}
	
	public String toString() {
		return "[Random Level " + this.getLevel() + "] " + super.toString();
	}

	@Override
	public String nextMove() {
		return "Random";
	}	
}