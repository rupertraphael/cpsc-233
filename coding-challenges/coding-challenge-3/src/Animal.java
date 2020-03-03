
public class Animal {

	private char type;
	private int age = 0;
	private int health = 50;
	
	public Animal(char type, int age, int health) {
		
		this.setType(type);
		this.setAge(age);
		this.setHealth(health);
		
	}
	
	
	public Animal(Animal animal) {
		this(animal.getType(), animal.getAge(), animal.getHealth());
	}
	
	public char getType() {
		return this.type;
	}
	
	public void setType(char type) {
		if(type != 'm' && type != 'b' && type != 'f' && type != 'r' && type != 'a' && type != 'n') {
			type = 'n';
		}
		
		this.type = type;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		
		switch (this.getType()) {
		case 'm':
			if(age < 0 || age > 100) {				
				return;
			}
			break;
			
		case 'r':
			if(age < 0 || age > 100) {
				return;
			}
			break;
			
		case 'b':
			if(age < 0 || age > 10) {
				return;
			}
			break;
			
		case 'f':
			if(age < 0 || age > 10) {
				return;
			}
			break;
			
		case 'a':
			if(age < 0 || age > 10) {
				return;
			}
			break;
			
		case 'n':
			if(age < 0 || age > 2) {
				return;
			}
		}
		
		this.age = age;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int health) {
		if(health <= 0) {
			return;
		}
		
		this.health = health;
	}
	
	public double getRelativeHealth() {
		double health = this.getHealth();
		
		return health / (101 - this.getAge());
	}
	
	public String getStatus() {
		double health = this.getRelativeHealth();
		
		System.out.println(health);
		
		String status = "";
		
		if(health < 25) {
			status = "critical";
		}else if(health < 50) {
			status = "tenuous";
		}else if(health < 75) {
			status = "good";
		}else if(health >= 75) {
			status = "excellent";
		}
		
		return status;
	}
	
}
