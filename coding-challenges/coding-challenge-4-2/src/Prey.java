public class Prey extends Animal {
	
	private String defence = "stampede";
	private int herdSize = 1;
	
	public Prey(char type, int health, String defence) {
		super(type, health);
		this.setDefence(defence);
		
	}
	
	public Prey(Prey toCopy){
		super(toCopy);
		this.setDefence(toCopy.defence);
	}
	
	public String getDefence() {
		return this.defence;
	}
	public void setDefence(String aDefence) {
		if(aDefence.equals("stampede")) {
			this.defence = aDefence;
		}else if(aDefence.equals("hide")) {
			this.defence = aDefence;
		}else if(aDefence.equals("huddle")) {
			this.defence = aDefence;
		}
	}
	
	public int getHerdSize() {
		return this.herdSize;
	}
	
	public void setHerdSize(int size) {
		if(size > 0) {
			this.herdSize = size;
		}
	}
	
	public double getRelativeHealth() {
		if(!this.getDefence().equals("hide")) {
			
			double health = (this.getHealth() * this.herdSize);
			health /= 10;
			
			return health;
		}
		
		return this.getHealth();
	}
	
	public String toString() {
		return "[Prey] " + super.toString() + " Defence: " + this.getDefence();
	}
}