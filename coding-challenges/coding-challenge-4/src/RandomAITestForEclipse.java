import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;

public class RandomAITestForEclipse extends FormatTester {
	public static final String CLASSNAME = "RandomAI";
	
	public RandomAITestForEclipse() {
		super(CLASSNAME, true);
	}
		
	private void testInterface() {
		String[] instanceVars = {"int level"};
		assertTrue("Instance variables should be private with correct name and type.", instanceVariablesArePrivate(instanceVars));

		assertTrue("Class should not have the default constructor.", noDefaultConstructor());
		
		assertFalse("Should not override takeTurn.", hasMethod("void takeTurn"));
		assertFalse("Should not override (or call) updateScore.", hasMethod("updateScore"));
		assertFalse("Should not override or call getid", hasMethod("getId"));
		assertFalse("Should not override or call getScore", hasMethod("getScore"));
	}
	
	
	// Testing constructors
	
	@Test
	public void test_Constructor_level_Zero_GoodId(){
		testInterface();
		RandomAI c = new RandomAI(1234,0);
		assertEquals("Created randomAI with invalid 0 level", 1, c.getLevel());
		assertEquals("Created randomAI with valid 1234 id.", 1234, c.getId());
	}
	
	@Test
	public void test_Constructor_level_11_GoodId(){
		testInterface();
		RandomAI c = new RandomAI(1234,11);
		assertEquals("Created randomAI with invalid 11 level", 1, c.getLevel());
		assertEquals("Created randomAI with valid 1234 id.", 1234, c.getId());
	}
	
	@Test
	public void test_Constructor_level_3(){
		testInterface();
		RandomAI c = new RandomAI(1234,3);
		assertEquals("Created randomAI with valid evel 3", 3, c.getLevel());
	}
	
	@Test
	public void test_CopyConstructor() {
		testInterface();
		RandomAI c = new RandomAI(4321,10);
		RandomAI c2 = new RandomAI(c);
		assertEquals("Copied randomAI with level 10", 10, c2.getLevel());
		assertEquals("Created randomAI with 4321 id.", 4321, c2.getId());
	}
	
	@Test
	public void test_CopyConstructor2() {
		testInterface();
		RandomAI c = new RandomAI(5467, 7);
		RandomAI c2 = new RandomAI(c);
		assertEquals("Copied randomAI with 7 level", 7, c2.getLevel());
		assertEquals("Created randomAI with 5467 id.", 5467, c2.getId());
	}


// Testing setter and getters

	@Test
	public void test_setter_and_getter_level_0(){
		testInterface();
		RandomAI c = new RandomAI(5555,2);
		c.setLevel(0);
		assertEquals("Set level to invalid 0, should have left unchanged from 2", 2, c.getLevel());
	}
	
	@Test
	public void test_setter_and_getter_level_1(){
		testInterface();
		RandomAI c = new RandomAI(5555,2);
		c.setLevel(1);
		assertEquals("Set level to lowest valid: 1", 1, c.getLevel());
	}
	
	@Test
	public void test_setter_and_getter_level_99(){
		testInterface();
		RandomAI c = new RandomAI(5555,2);
		c.setLevel(10);
		assertEquals("Set level to highest valid: 10", 10, c.getLevel());
	}
	
	@Test
	public void test_setter_and_getter_level_100(){
		testInterface();
		RandomAI c = new RandomAI(5555,2);
		c.setLevel(11);
		assertEquals("Set level to invalid 11, should have been unchanged from 2", 2, c.getLevel());
	}
	
	@Test
	public void test_nextMove() {
		testInterface();
		RandomAI c = new RandomAI(1234,1);
		assertEquals("nextMove should always return 'Random'", "Random", c.nextMove());

		c = new RandomAI(4532,7);
		assertEquals("nextMove should always return 'Random'", "Random", c.nextMove());

		c = new RandomAI(1,1);
		assertEquals("nextMove should always return 'Random'", "Random", c.nextMove());
	}
	
	@Test
	public void test_chooseMove_from0ScoreLevel1() {
		testInterface();
		int[] scores = new int[10];
		for (int index = 0; index < 10; index ++) {
			scores[index] = 0;
		}
		
		for (int counter = 0; counter < 10000; counter++){
			RandomAI c = new RandomAI(1234, 1);
			int score = c.chooseMove();
			assertFalse("At level one, move should be between 0 and 9 points (inclusive), not " + score, score<0 || score>9);
			scores[score]++;
		}
		
		assertTrue("Expected 0 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[0] > 0);
		assertTrue("Expected 1 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[1] > 0);
		assertTrue("Expected 2 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[2] > 0);
		assertTrue("Expected 3 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[3] > 0);
		assertTrue("Expected 4 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[4] > 0);
		assertTrue("Expected 5 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[5] > 0);
		assertTrue("Expected 6 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[6] > 0);
		assertTrue("Expected 7 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[7] > 0);
		assertTrue("Expected 8 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[8] > 0);
		assertTrue("Expected 9 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[9] > 0);
	}

	@Test
	public void test_chooseMove_from0ScoreLevel9() {
		testInterface();
		int[] scores = new int[10];
		for (int index = 0; index < 10; index ++) {
			scores[index] = 0;
		}
		
		for (int counter = 0; counter < 10000; counter++){
			RandomAI c = new RandomAI(1234, 9);
			int score = c.chooseMove();
			assertFalse("At level nine, move should be between 0 and 81 points (inclusive), not " + score, score<0 || score>81);
			scores[score/9]++;
		}
		
		assertTrue("Expected 0 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[0] > 0);
		assertTrue("Expected 9 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[1] > 0);
		assertTrue("Expected 18 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[2] > 0);
		assertTrue("Expected 27 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[3] > 0);
		assertTrue("Expected 36 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[4] > 0);
		assertTrue("Expected 45 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[5] > 0);
		assertTrue("Expected 54 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[6] > 0);
		assertTrue("Expected 63 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[7] > 0);
		assertTrue("Expected 72 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[8] > 0);
		assertTrue("Expected 81 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[9] > 0);
	}

	@Test
	public void test_chooseMove_from0ScoreLevel5() {
		testInterface();
		int[] scores = new int[10];
		for (int index = 0; index < 10; index ++) {
			scores[index] = 0;
		}
		
		for (int counter = 0; counter < 10000; counter++){
			RandomAI c = new RandomAI(1234, 5);
			int score = c.chooseMove();
			assertFalse("At level five, move should be between 0 and 45 points (inclusive), not " + score, score<0 || score>45);
			scores[score/5]++;
		}
		
		assertTrue("Expected 0 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[0] > 0);
		assertTrue("Expected 5 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[1] > 0);
		assertTrue("Expected 10 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[2] > 0);
		assertTrue("Expected 15 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[3] > 0);
		assertTrue("Expected 20 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[4] > 0);
		assertTrue("Expected 25 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[5] > 0);
		assertTrue("Expected 30 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[6] > 0);
		assertTrue("Expected 35 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[7] > 0);
		assertTrue("Expected 40 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[8] > 0);
		assertTrue("Expected 45 to be randomly chosen at least once when doing 10000 random choices, but it was not.", scores[9] > 0);
	}

	
	// ToString
	
	@Test
	public void test_toString1() {
		testInterface();
		assertTrue("Should override toString and it should invoke parent toString (not getter methods in parent).", toStrInvokesParentToStr());

		RandomAI c = new RandomAI(3421, 5);
		c.updateScore(50);

		assertEquals("[Random Level 5] ID: 3421 Score: 50 nextMove: Random", c.toString());
	}

	@Test
	public void test_toString2() {
		testInterface();
		assertTrue("Should override toString and it should invoke parent toString (not getter methods in parent).", toStrInvokesParentToStr());

		RandomAI c = new RandomAI(1234, 2);
		c.updateScore(21);

		assertEquals("[Random Level 2] ID: 1234 Score: 21 nextMove: Random", c.toString());
	}
}
