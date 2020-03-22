public abstract class Player{
	
	private int id = 1000;
	private int score = 0;
	
		
	public Player(int id){
		this.setId(id);
		this.score = 0;
		
		
	}
	
	public Player(Player toCopy){
		this(toCopy.getId());
		this.score = toCopy.getScore();
	}
	
	public String toString() {
		return "ID: " + this.getId() + " Score: " + this.getScore() + " nextMove: " + this.nextMove();
	}
	
	protected void setId(int anID){
		if(anID >= 1000 && anID <= 9999)
			this.id = anID;
		else {
			this.id = 1111;
		}
	}
	
	protected int getId(){
		return this.id;
	}
	
	protected void updateScore(int amount) {
		if(amount >= 0) {
			this.score += amount;
		}
	}
	
	public int getScore() {
		return this.score;
	}
	
	public abstract int chooseMove();
	public abstract String nextMove();
	
	public void takeTurn(){
		int divisor = this.getScore() % 7;
		
		if(divisor == 0) {
			divisor = 1;
		}
		
		this.updateScore(this.chooseMove() / divisor);
	}
	
	public String getCategory(){
		int score = this.getScore();
		
		String category = "";
		
		if(score >= 0 && score <= 10) {
			category = "beginner";
		}else if(score >= 11 && score <= 100) {
			category = "intermediate";
		}else {
			category = "expert";
		}
		
		return category;
	}
		
}