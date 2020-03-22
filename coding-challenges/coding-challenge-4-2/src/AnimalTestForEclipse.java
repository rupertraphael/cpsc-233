import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;

public class AnimalTestForEclipse extends FormatTester{
	public class AnimalMock extends Animal{
		double next;
		
		public AnimalMock(char type, int health){
			super(type, health);
		}
		
		public AnimalMock(AnimalMock c) {
			super(c);
		}
		
		public double getRelativeHealth() {
			return next;
		}	
	}

	public static final String CLASSNAME = "Animal";
	
	public AnimalTestForEclipse() {
		super(CLASSNAME, true);
	}
	
	private void testClassDefinition(){
		String[] instanceVars = {"int health", "char type"};
		assertTrue("Instance variables should be private with correct name and type.", instanceVariablesArePrivate(instanceVars));

		assertTrue("Class should not have the default constructor.", noDefaultConstructor());
		
		String[] abstractMethods = {"double getRelativeHealth()"};
		assertTrue("Class should have abstract method getRelativeHealth that returns a double (minimize whitespace in signature).", hasRequiredAbstractMethods(abstractMethods));
		
		String[] protectedMethods = {"void setType"};
		assertTrue("Class should have protected methods setType.", hasRequiredProtectedMethods(protectedMethods));

	}
	
	
	// Testing constructors
	
	@Test
	public void testConstructor_validType(){
		testClassDefinition();
		Animal c = new AnimalMock('n',10);
		assertEquals("Constructed Animal('n',10) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('n',10) - testing health", 10, c.getHealth());			
		
		c = new AnimalMock('m',10);
		assertEquals("Constructed Animal('m',10) - testing type", 'm', c.getType());
		assertEquals("Constructed Animal('m',10) - testing health", 10, c.getHealth());			
		
		c = new AnimalMock('b',10);
		assertEquals("Constructed Animal('b',10) - testing type", 'b', c.getType());
		assertEquals("Constructed Animal('b',10) - testing health", 10, c.getHealth());			

		c = new AnimalMock('f',10);
		assertEquals("Constructed Animal('f',10) - testing type", 'f', c.getType());
		assertEquals("Constructed Animal('f',10) - testing health", 10, c.getHealth());			
		
		c = new AnimalMock('r',10);
		assertEquals("Constructed Animal('r',10) - testing type", 'r', c.getType());
		assertEquals("Constructed Animal('r',10) - testing health", 10, c.getHealth());			

		c = new AnimalMock('a',10);
		assertEquals("Constructed Animal('a',10) - testing type", 'a', c.getType());
		assertEquals("Constructed Animal('a',10) - testing health", 10, c.getHealth());			
	}

	@Test
	public void testConstructor_invalidType(){
		testClassDefinition();
		Animal c = new AnimalMock('t',10);
		assertEquals("Constructed Animal('t',10) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('t',10) - testing health", 10, c.getHealth());			
		
		c = new AnimalMock('M',10);
		assertEquals("Constructed Animal('M',10) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('M',10) - testing health", 10, c.getHealth());			
		
		c = new AnimalMock('h',10);
		assertEquals("Constructed Animal('h',10) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('h',10) - testing health", 10, c.getHealth());			

		c = new AnimalMock('q',10);
		assertEquals("Constructed Animal('q',10) - testing type", 'n', c.getType());
		assertEquals("Constructed Animal('q',10) - testing health", 10, c.getHealth());			
	}

	@Test
	public void testConstructor_health0(){
		testClassDefinition();
		Animal c = new AnimalMock('a',0);
		assertEquals("Constructed Animal(a,0) - testing health", 50, c.getHealth());
		assertEquals("Constructed Animal(a,0) - testing type", 'a', c.getType());			
	}

	@Test
	public void testConstructor_health1000(){
		testClassDefinition();
		Animal c = new AnimalMock('a',1000);
		assertEquals("Constructed Animal(a,1000) - testing health", 1000, c.getHealth());
		assertEquals("Constructed Animal('a',0) - testing type", 'a', c.getType());			
	}

	@Test
	public void testConstructor_healthNegative(){
		testClassDefinition();
		Animal c = new AnimalMock('a',-1);
		assertEquals("Constructed Animal('a',-1) - testing health", 50, c.getHealth());
	}

	@Test
	public void testConstructor_health1(){
		testClassDefinition();
		Animal c = new AnimalMock('a',1);
		assertEquals("Constructed Animal(a,1) - testing health", 1, c.getHealth());
	}
	
	@Test
	public void testCopyConstructor(){
		testClassDefinition();
		AnimalMock p = new AnimalMock('a',1234);
		Animal p2 = new AnimalMock(p);
		assertEquals("Copied player with health 1234 and type a - testing health", 1234, p2.getHealth());
		assertEquals("Copied player with health 1234 and type a - testing type", 'a', p2.getType());
	}

	@Test
	public void testCopyConstructor2(){
		testClassDefinition();
		AnimalMock p = new AnimalMock('a', 5485);
		Animal p2 = new AnimalMock(p);
		assertEquals("Copied player with health 5485 and type a - testing health", 5485, p2.getHealth());
		assertEquals("Copied player with health 5485 and type a - testing type", 'a', p2.getType());
	}

// Testing setter and getters

	@Test
	public void test_setter_and_getter_health_zero(){
		testClassDefinition();
		Animal c = new AnimalMock('a', 1000);
		c.setHealth(0);
		assertEquals("0, is not valid, expected default of 50", 50, c.getHealth());
	}
	
	@Test
	public void test_setter_and_getter_health_1(){
		testClassDefinition();
		Animal c = new AnimalMock('a', 890);
		c.setHealth(1);
		assertEquals("1 is lowest valid health.", 1, c.getHealth());
	}

	@Test
	public void test_setter_and_getter_type_invalid(){
		testClassDefinition();
		Animal c = new AnimalMock('m',0);
		c.setType('g');
		assertEquals("g, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('e');
		assertEquals("e, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('c');
		assertEquals("c, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('d');
		assertEquals("d, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('i');
		assertEquals("i, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('N');
		assertEquals("N, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('k');
		assertEquals("k, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('.');
		assertEquals("., is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('A');
		assertEquals("A, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('$');
		assertEquals("$, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('-');
		assertEquals("-, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('q');
		assertEquals("q, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('w');
		assertEquals("w, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('T');
		assertEquals("T, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('u');
		assertEquals("u, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('W');
		assertEquals("W, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('x');
		assertEquals("x, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('y');
		assertEquals("y, is not valid, expected default of n", 'n', c.getType());
		c = new AnimalMock('m',0);
		c.setType('z');
		assertEquals("z, is not valid, expected default of n", 'n', c.getType());
	}
	
	@Test
	public void test_setter_and_getter_type_valid(){
		testClassDefinition();
		Animal c = new AnimalMock('n',0);
		c.setType('m');
		assertEquals("m valid type.", 'm', c.getType());
		c = new AnimalMock('n',0);
		c.setType('b');
		assertEquals("b valid type.", 'b', c.getType());
		c = new AnimalMock('n',0);
		c.setType('f');
		assertEquals("f valid type.", 'f', c.getType());
		c = new AnimalMock('n',0);
		c.setType('r');
		assertEquals("r valid type.", 'r', c.getType());
		c = new AnimalMock('n',0);
		c.setType('a');
		assertEquals("a valid type.", 'a', c.getType());
		c = new AnimalMock('a',0);
		c.setType('n');
		assertEquals("n valid type.", 'n', c.getType());
	}
	
	@Test
	public void test_setter_and_getter_health_negative(){
		testClassDefinition();
		Animal c = new AnimalMock('a', 45);
		c.setHealth(-1);
		assertEquals("Negative not valid for health, expected default 50.", 50, c.getHealth());
	}
	
	@Test
	public void test_setter_and_getter_health_negative50(){
		testClassDefinition();
		Animal c = new AnimalMock('a', 1000);
		c.setHealth(-50);
		assertEquals("-5 is not valid, expecting default 50", 50, c.getHealth());
	}
	
	@Test
	public void test_getStatus_critical(){
		testClassDefinition();
		AnimalMock c = new AnimalMock('a', 1);
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
		AnimalMock c = new AnimalMock('a', 1);
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
		AnimalMock c = new AnimalMock('a', 1);
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
		AnimalMock c = new AnimalMock('a', 1);
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
		

		
	//ToString
	
	@Test
	public void test_toString() {
		testClassDefinition();
		AnimalMock c = new AnimalMock('a', 2314);
		c.next = 21;

		assertEquals("Type: 'a', relative health: 21", "Type: a Health: 21.0", c.toString());
	}
		
	@Test
	public void test_toString2() {
		testClassDefinition();
		AnimalMock c = new AnimalMock('a', 2314);
		c.next = 0.01;

		assertEquals("Type: 'a', relative health: 0.01", "Type: a Health: 0.01", c.toString());
	}
		
	@Test
	public void test_toString3() {
		testClassDefinition();
		AnimalMock c = new AnimalMock('a', 2314);
		c.next = 123.4;

		assertEquals("Type: 'a', relative health: 123.4", "Type: a Health: 123.4", c.toString());
	}
}
