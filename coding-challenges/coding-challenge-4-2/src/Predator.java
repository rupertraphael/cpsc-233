public class Predator extends Animal {
	
	public Predator(char type, int health, String huntStyle) {
		super( '\u0000',0);
		
	}
	
	public Predator(Predator toCopy){
		super(null);
		
	}
	
	public String getHuntStyle() {
		return "";
	}
	public void setHuntStyle(String aHuntStyle) {
		
	}
	
	public double getRelativeHealth() {
		return 0.0;
	}
	
	public String toString() {
		return "";
	}
}