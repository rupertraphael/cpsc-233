import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalTest extends FormatTester {
	
	public AnimalTest() {
		super("Animal", false);
	}
	
	private void testClassDefinition(){
		String[] instanceVars = {"char type", "int age", "int health"};
		assertTrue("Instance variables should be private with correct name and type.", instanceVariablesArePrivate(instanceVars));

		assertTrue("Class should not have the default constructor.", noDefaultConstructor());
	}
	
	class AnimalMock extends Animal {
		double next = 0;
		public AnimalMock(char type, int age, int health) {
			super(type, age, health);
		}
		public double getRelativeHealth(){
			return next;
		}
	}
	
	@Test
	public void testConstructor_validType(){
		Animal c = new Animal('n',0,10);
		assertEquals("Constructed Animal('n',0,10) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('n',0,10) - testing age", 0, c.getAge());			
		assertEquals("Constructed Animal('n',0,10) - testing health", 10, c.getHealth());			
		
		c = new Animal('m',0,10);
		assertEquals("Constructed Animal('m',0,10) - testing type", 'm', c.getType());
		assertEquals("Constructed Animal(m,0,10) - testing age", 0, c.getAge());
		assertEquals("Constructed Animal('m',0,10) - testing health", 10, c.getHealth());			
		
		c = new Animal('b',0,10);
		assertEquals("Constructed Animal('b',0,10) - testing type", 'b', c.getType());
		assertEquals("Constructed Animal('b',0,10) - testing age", 0, c.getAge());
		assertEquals("Constructed Animal('b',0,10) - testing health", 10, c.getHealth());			

		c = new Animal('f',0,10);
		assertEquals("Constructed Animal('f',0,10) - testing type", 'f', c.getType());
		assertEquals("Constructed Animal('f',0,10) - testing age", 0, c.getAge());
		assertEquals("Constructed Animal('f',0,10) - testing health", 10, c.getHealth());			
		
		c = new Animal('r',0,10);
		assertEquals("Constructed Animal('r',0,10) - testing type", 'r', c.getType());
		assertEquals("Constructed Animal('r',0,10) - testing age", 0, c.getAge());
		assertEquals("Constructed Animal('r',0,10) - testing health", 10, c.getHealth());			

		c = new Animal('a',0,10);
		assertEquals("Constructed Animal('a',0,10) - testing type", 'a', c.getType());
		assertEquals("Constructed Animal('a',0,10) - testing age", 0, c.getAge());
		assertEquals("Constructed Animal('a',0,10) - testing health", 10, c.getHealth());			
	}

	@Test
	public void testConstructor_invalidType(){
		Animal c = new Animal('t',0,10);
		assertEquals("Constructed Animal('t',0,10) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('t',0,10) - testing age", 0, c.getAge());			
		assertEquals("Constructed Animal('t',0,10) - testing health", 10, c.getHealth());			
		
		c = new Animal('M',0,10);
		assertEquals("Constructed Animal('M',0,10) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('M',0,10) - testing age", 0, c.getAge());
		assertEquals("Constructed Animal('M',0,10) - testing health", 10, c.getHealth());			
		
		c = new Animal('h',0,10);
		assertEquals("Constructed Animal('h',0,10) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('h',0,10) - testing age", 0, c.getAge());
		assertEquals("Constructed Animal('h',0,10) - testing health", 10, c.getHealth());			

		c = new Animal('q',0,10);
		assertEquals("Constructed Animal('q',0,10) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('q',0,10) - testing age", 0, c.getAge());
		assertEquals("Constructed Animal('q',0,10) - testing health", 10, c.getHealth());			
	}

	@Test
	public void testConstructor_negativeAge(){
		Animal c = new Animal('n',-1,50);
		assertEquals("Constructed Animal('n',-1,50) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('n',-1,50) - testing age", 0, c.getAge());						
		assertEquals("Constructed Animal('n',-1,50) - testing health", 50, c.getHealth());			
	}

	@Test
	public void testConstructor_age_Boundaries(){
		Animal c = new Animal('m',0,60);
		assertEquals("Age of 0 is smallest valid for mammals", 0, c.getAge());

		c = new Animal('m',100,60);
		assertEquals("Age of 100 is largest valid for mammals", 100, c.getAge());

		c = new Animal('m',50,60);
		assertEquals("Age of 50 is valid for mammals", 50, c.getAge());

		
		c = new Animal('r',0,75);
		assertEquals("Age of 0 is smallest valid for reptiles", 0, c.getAge());

		c = new Animal('r',100,75);
		assertEquals("Age of 100 is largest valid for reptiles", 100, c.getAge());

		c = new Animal('r',50,75);
		assertEquals("Age of 50 is valid for reptiles", 50, c.getAge());

		c = new Animal('n',0,60);
		assertEquals("Age of 0 is smallest valid for anothropod", 0, c.getAge());

		c = new Animal('n',2,60);
		assertEquals("Age of 2 is largest valid for anthropods", 2, c.getAge());

		c = new Animal('n',1,60);
		assertEquals("Age of 1 is valid for anthropods", 1, c.getAge());

		c = new Animal('b',0,60);
		assertEquals("Age of 0 is smallest valid for birds", 0, c.getAge());

		c = new Animal('b',10,60);
		assertEquals("Age of 10 is largest valid for birds", 10, c.getAge());

		c = new Animal('b',5,60);
		assertEquals("Age of 5 is valid for birds", 5, c.getAge());

		
		c = new Animal('f',0,75);
		assertEquals("Age of 0 is smallest valid for fish", 0, c.getAge());

		c = new Animal('f',10,75);
		assertEquals("Age of 10 is largest valid for fish", 10, c.getAge());

		c = new Animal('f',5,75);
		assertEquals("Age of 5 is valid for fish", 5, c.getAge());

		c = new Animal('a',0,75);
		assertEquals("Age of 0 is smallest valid for amphibians", 0, c.getAge());

		c = new Animal('a',10,75);
		assertEquals("Age of 10 is largest valid for amphibians", 10, c.getAge());

		c = new Animal('a',5,75);
		assertEquals("Age of 5 is valid for amphibians", 5, c.getAge());
	}

	@Test
	public void testConstructor_healthLarge(){
		Animal c = new Animal('n',1,69346);
		assertEquals("Constructed Animal('n',1 ,69346) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('n',1,69346) - testing health", 69346, c.getHealth());						
	}
	
	@Test
	public void testConstructor_healthInvalid(){
		Animal c = new Animal('n',1,0);
		assertEquals("Constructed Animal('n',1 ,0) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('n',1,0) - testing health", 50, c.getHealth());						

		c = new Animal('n',1,-10);
		assertEquals("Constructed Animal('n',1 ,-10) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('n',1,-10) - testing health", 50, c.getHealth());						
	}
	
	@Test
	public void testCopyConstructor(){
		Animal p = new Animal('m',56, 45);
		Animal p2 = new Animal(p);
		assertEquals("Copied Animal ('m',56,45) - testing type", 'm', p2.getType());
		assertEquals("Copied Animal ('m',56,45) - testing age", 56, p2.getAge());
		assertEquals("Copied Animal ('m',56,45) - testing health", 45, p2.getHealth());
	}

	@Test
	public void testCopyConstructor2(){
		Animal p = new Animal('a',5,200);
		Animal p2 = new Animal(p);
		assertEquals("Copied Animal ('a',5,200) - testing type", 'a', p2.getType());
		assertEquals("Copied Animal ('a',5,200) - testing age", 5, p2.getAge());
		assertEquals("Copied Animal ('a',5,200) - testing health", 200, p2.getHealth());
	}



	// Testing setter and getters
	
		@Test
		public void test_setter_and_getter_type_invalid(){
			Animal c = new Animal('n',0,0);
			c.setType('g');
			assertEquals("g, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('e');
			assertEquals("e, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('c');
			assertEquals("c, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('d');
			assertEquals("d, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('i');
			assertEquals("i, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('N');
			assertEquals("N, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('k');
			assertEquals("k, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('.');
			assertEquals("., is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('A');
			assertEquals("A, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('$');
			assertEquals("$, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('-');
			assertEquals("-, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('q');
			assertEquals("q, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('w');
			assertEquals("w, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('T');
			assertEquals("T, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('u');
			assertEquals("u, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('W');
			assertEquals("W, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('x');
			assertEquals("x, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('y');
			assertEquals("y, is not valid, expected default of n", 'n', c.getType());
			c = new Animal('n',0,0);
			c.setType('z');
			assertEquals("z, is not valid, expected default of n", 'n', c.getType());
		}
		
		@Test
		public void test_setter_and_getter_type_valid(){
			Animal c = new Animal('n',0,0);
			c.setType('m');
			assertEquals("m valid class.", 'm', c.getType());
			c = new Animal('n',0,0);
			c.setType('b');
			assertEquals("b valid class.", 'b', c.getType());
			c = new Animal('n',0,0);
			c.setType('f');
			assertEquals("f valid class.", 'f', c.getType());
			c = new Animal('n',0,0);
			c.setType('r');
			assertEquals("r valid class.", 'r', c.getType());
			c = new Animal('n',0,0);
			c.setType('a');
			assertEquals("a valid class.", 'a', c.getType());
			c = new Animal('n',0,0);
			c.setType('n');
			assertEquals("n valid class.", 'n', c.getType());
		}
		
		@Test
		public void test_setter_and_getter_type_default(){
			Animal c = new Animal('n',0,0);
			assertEquals("Expected 'n' as class default (setter method not called)", 'n', c.getType());
		}
		
		@Test
		public void test_getter_and_setter_age_boundaries() {
			Animal c = new Animal('n',0,0);
			c.setType('m');
			c.setAge(0);
			assertEquals("Age of 0 is smallest valid for mammals", 0, c.getAge());
			c.setAge(100);
			assertEquals("Age of 100 is largest valid for mammals", 100, c.getAge());
			c.setAge(50);
			assertEquals("Age of 50 is valid for mammals", 50, c.getAge());
			c = new Animal('n',0,0);
			c.setType('r');
			c.setAge(0);
			assertEquals("Age of 0 is smallest valid for reptiles", 0, c.getAge());
			c.setAge(100);
			assertEquals("Age of 100 is largest valid for reptiles", 100, c.getAge());
			c.setAge(50);
			assertEquals("Age of 50 is valid for reptiles", 50, c.getAge());

			c = new Animal('n',0,0);
			c.setType('b');
			c.setAge(0);
			assertEquals("Age of 0 is smallest valid for birds", 0, c.getAge());
			c.setAge(10);
			assertEquals("Age of 10 is largest valid for birds", 10, c.getAge());
			c.setAge(5);
			assertEquals("Age of 5 is valid for birds", 5, c.getAge());
			c = new Animal('n',0,0);
			c.setType('f');
			c.setAge(0);
			assertEquals("Age of 0 is smallest valid for fish", 0, c.getAge());
			c.setAge(10);
			assertEquals("Age of 10 is largest valid for fish", 10, c.getAge());
			c.setAge(5);
			assertEquals("Age of 5 is valid for fish", 5, c.getAge());
			c = new Animal('n',0,0);
			c.setType('a');
			c.setAge(0);
			assertEquals("Age of 0 is smallest valid for amphibians", 0, c.getAge());
			c.setAge(10);
			assertEquals("Age of 10 is largest valid for amphibians", 10, c.getAge());
			c.setAge(5);
			assertEquals("Age of 5 is valid for amphibians", 5, c.getAge());

			c = new Animal('n',0,0);
			c.setType('n');
			c.setAge(0);
			assertEquals("Age of 0 is smallest valid for anthropods", 0, c.getAge());
			c.setAge(2);
			assertEquals("Age of 2 is largest valid for anthropods", 2, c.getAge());
			c.setAge(1);
			assertEquals("Age of 50 is valid for anthropods", 1, c.getAge());
		}

		@Test
		public void test_getter_and_setter_age_negative() {
			Animal c = new Animal('n',0,0);
			c.setType('n');
			c.setAge(-1);
			assertEquals("Age -1 is invalid for anthropods.", 0, c.getAge());
			c.setType('m');
			c.setAge(-1);
			assertEquals("Age -1 is invalid for mammals.", 0, c.getAge());
			c.setType('b');
			c.setAge(-1);
			assertEquals("Age -1 is invalid for birds.", 0, c.getAge());
			c.setType('f');
			c.setAge(-1);
			assertEquals("Age -1 is invalid for fish.", 0, c.getAge());
			c.setType('r');
			c.setAge(-1);
			assertEquals("Age -1 is invalid for reptiles.", 0, c.getAge());
			c.setType('a');
			c.setAge(-1);
			assertEquals("Age -1 is invalid for amphibians.", 0, c.getAge());
		}
		
		@Test
		public void test_getter_and_setter_age_tooLarge() {
			Animal c = new Animal('n',0,0);
			c.setAge(1);
			c.setType('n');
			c.setAge(3);
			assertEquals("Age 3 is invalid for anthropods.  Should be unchanged from 1.", 1, c.getAge());
			c.setType('b');
			c.setAge(6);
			c.setAge(11);
			assertEquals("Age 11 is invalid for birds.  Should be unchanged from 6.", 6, c.getAge());
			c.setType('f');
			c.setAge(4);
			c.setAge(11);
			assertEquals("Age 11 is invalid for fish.  Should be unchanged from 4.", 4, c.getAge());
			c.setType('a');
			c.setAge(7);
			c.setAge(13);
			assertEquals("Age 13 is invalid for amphibians.  Should be unchanged from 7.", 7, c.getAge());
			c.setType('m');
			c.setAge(56);
			c.setAge(101);
			assertEquals("Age 101 is invalid for mammals.  Should be unchanged from 56.", 56, c.getAge());
			c.setType('r');
			c.setAge(34);
			c.setAge(103);
			assertEquals("Age 103 is invalid for reptiles.  Should be unchanged from 34.", 34, c.getAge());
		}
		
		@Test
		public void test_getter_and_setter_health_zero() {
			Animal c = new Animal('n',0,0);
			c.setHealth(0);
			assertEquals("Health of 0 is invalid, expecting default 50.", 50, c.getHealth());
		}

		@Test
		public void test_getter_and_setter_health_positive() {
			Animal c = new Animal('n',0,0);
			c.setHealth(30);
			assertEquals("Set health to 30.", 30, c.getHealth());
		}
		
		@Test
		public void test_getter_and_setter_health_negative() {
			Animal c = new Animal('n',0,0);
			c.setHealth(-1);
			assertEquals("Setting health to negative number, which is not valid.", 50, c.getHealth());
		}
		
		@Test
		public void test_getRelativeHealth_Age0() {
			Animal c = new Animal('n',0,0);
			c.setType('m');
			c.setAge(0);
			c.setHealth(50);
			assertEquals("Health 50 and age 0", .4950, c.getRelativeHealth(),0.0001);
		}

		@Test
		public void test_getRelativeHealth_Age50Health1() {
			Animal c = new Animal('n',0,0);
			c.setType('r');
			c.setAge(50);
			c.setHealth(1);
			assertEquals("Health 1 and age 50", 0.0196, c.getRelativeHealth(),0.00001);
		}

		@Test
		public void test_getRelativeHealth_Age3Health100() {
			Animal c = new Animal('n',0,0);
			c.setType('f');
			c.setAge(3);
			c.setHealth(100);
			assertEquals("Health 100 and age 3", 1.0204, c.getRelativeHealth(),0.00001);
		}
		@Test
		public void test_getStatus_critical(){
			testClassDefinition();
			AnimalMock c = new AnimalMock('a', 1, 1);
			c.next = -10.0;
			String actualStatus = c.getStatus();
			assertEquals("relative health of -10.0", "critical", actualStatus);
			c.next = 1;
			actualStatus = c.getStatus();
			assertEquals("relative health of 10", "critical", actualStatus);
			c.next = 24.999;
			actualStatus = c.getStatus();
			assertEquals("relative health of 24.999", "critical", actualStatus);
		}
			
		@Test
		public void test_getStatus_tenuous(){
			testClassDefinition();
			AnimalMock c = new AnimalMock('a', 1, 1);
			c.next = 25.0;
			String actualStatus = c.getStatus();
			assertEquals("relative health of 25.0", "tenuous", actualStatus);
			c.next = 40;
			actualStatus = c.getStatus();
			assertEquals("relative health of 40", "tenuous", actualStatus);
			c.next = 49.999;
			actualStatus = c.getStatus();
			assertEquals("relative health of 49.999", "tenuous", actualStatus);
		}
			
		@Test
		public void test_getStatus_good(){
			testClassDefinition();
			AnimalMock c = new AnimalMock('a', 1, 1);
			c.next = 50.0;
			String actualStatus = c.getStatus();
			assertEquals("relative health of 50.0", "good", actualStatus);
			c.next = 65.45;
			actualStatus = c.getStatus();
			assertEquals("relative health of 65.45", "good", actualStatus);
			c.next = 74.999;
			actualStatus = c.getStatus();
			assertEquals("relative health of 74.999", "good", actualStatus);
		}
		
		@Test
		public void test_getStatus_excellent(){
			testClassDefinition();
			AnimalMock c = new AnimalMock('a', 1, 1);
			c.next = 75.0;
			String actualStatus = c.getStatus();
			assertEquals("relative health of 75.0", "excellent", actualStatus);
			c.next = 112.45;
			actualStatus = c.getStatus();
			assertEquals("relative health of 112.45", "excellent", actualStatus);
			c.next = 5432.634;
			actualStatus = c.getStatus();
			assertEquals("relative health of 5432.634", "excellent", actualStatus);
		}

}
