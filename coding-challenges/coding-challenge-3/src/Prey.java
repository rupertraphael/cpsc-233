
public class Prey extends Animal {
	
	private String defence = "stampede";
	private int herdSize = 1;
	
	public Prey(char type, int health, String defence) {
		super(type, 0, health);
		this.setDefence(defence);
	}
	
	public Prey(Prey prey) {
		super(prey);
		this.setDefence(prey.getDefence());
	}

	public String getDefence() {
		return defence;
	}

	public void setDefence(String defence) {
		if(!defence.equals("stampede") && !defence.equals("huddle") && !defence.equals("hide")) {
			return;
		}
		
		this.defence = defence;
	}

	public int getHerdSize() {
		return herdSize;
	}

	public void setHerdSize(int herdSize) {
		if(herdSize < 1) {
			return;
		}
		
		this.herdSize = herdSize;
	}
	
	public double getRelativeHealth() {
		if(this.getDefence().equals("hide")) {			
			return this.getHealth();
		}
		
		double health = this.getHealth();
		health = health * herdSize/10;
		
		return health;
	}
	
}
