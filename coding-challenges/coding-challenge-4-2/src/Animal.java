public abstract class Animal{
	
	private char type;
	private int health;
	
	public Animal(char type, int health) {
		this.setType(type);
		this.setHealth(health);
	}
	
	public Animal(Animal toCopy){
		this(toCopy.getType(), toCopy.getHealth());
	}
	
	public char getType() {
		return  this.type;
	}
	
	protected void setType(char aType) {
		
		char type;
		
		if(aType == 'm') {
			type = 'm';
		}else if(aType == 'b') {
			type = 'b';
		}else if(aType == 'f') {
			type = 'f';
		}else if(aType == 'a') {
			type = 'a';
		}else if(aType == 'n') {
			type = 'n';
		}else if(aType == 'r') {
			type = 'r';
		}else {
			type = 'n';
		}
		
		this.type = type;
		
	}
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int health) {
		if(health > 0) {
			this.health = health;
		}else {
			this.health = 50;
		}
	}
	
	public abstract double getRelativeHealth();
	
	public String getStatus() {
		String status = "excellent";
		
		double health = this.getRelativeHealth();
		
		if(health < 25) {
			status = "critical";
		}else if(health < 50) {
			status = "tenuous";
		}else if(health < 75) {
			status = "good";
		}
		
		return status;
	}
	
	public String toString() {
		return "Type: " + this.getType()  + " Health: " + this.getRelativeHealth();
	}
}