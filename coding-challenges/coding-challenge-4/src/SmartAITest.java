import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;

public class SmartAITest extends FormatTester {
	public static final String CLASSNAME = "SmartAI";

	public SmartAITest() {
		super(CLASSNAME, false);
	}
	private void testInterface() {
		// No instance variables

		assertTrue("Class should not have the default constructor.", noDefaultConstructor());
		
		assertFalse("Should not override takeTurn.", hasMethod("void takeTurn"));
		assertFalse("Should not override (or call) updateScore.", hasMethod("updateScore"));
		assertFalse("Should not override or call getid", hasMethod("getId"));
		assertFalse("Should not override getScore", hasMethod("int getScore"));
	}
	
	
	// Testing constructors
	
	@Test
	public void test_Constructor_GoodId(){
		testInterface();
		SmartAI c = new SmartAI(1234);
		assertEquals("Created smartAI with valid 1234 id.", 1234, c.getId());
	}
	
	
	@Test
	public void test_CopyConstructor() {
		testInterface();
		SmartAI c = new SmartAI(4321);
		SmartAI c2 = new SmartAI(c);
		assertEquals("Created smartAI with 4321 id.", 4321, c2.getId());
	}
	
	@Test
	public void test_CopyConstructor2() {
		testInterface();
		SmartAI c = new SmartAI(5467);
		SmartAI c2 = new SmartAI(c);
		assertEquals("Created smartAI with 5467 id.", 5467, c2.getId());
	}

	@Test
	public void test_nextMove_initialScore() {
		testInterface();
		SmartAI c = new SmartAI(3452);
		assertEquals("At initial score, no updates done", "99", c.nextMove());
	}
	
	@Test
	public void test_nextMove_lowScore() {
		testInterface();
		SmartAI c = new SmartAI(3452);
		c.updateScore(5);
		assertEquals("100", c.nextMove());
	}

	@Test
	public void test_chooseMove_LoopOnce() {
		testInterface();
		SmartAI c = new SmartAI(1234);
		int score = c.chooseMove();
		assertEquals("Should have looped once", 99, score);
	}

	@Test
	public void test_chooseMove_ZeroLoops() {
		testInterface();
		SmartAI c = new SmartAI(1234);
		c.updateScore(6);
		int score = c.chooseMove();
		assertEquals("Should not have looped at all", 100, score);
	}

	@Test
	public void test_chooseMove_FiveLoops() {
		testInterface();
		SmartAI c = new SmartAI(1234);
		c.updateScore(11);
		int score = c.chooseMove();
		assertEquals("Should have looped five times", 95, score);
	}

	@Test
	public void test_chooseMove_FiveLoopsHighScore() {
		testInterface();
		SmartAI c = new SmartAI(1234);
		c.updateScore(109);
		int score = c.chooseMove();
		assertEquals("Should have looped five times on a high score", 95, score);
	}

	// ToString
	
	@Test
	public void test_toString() {
		testInterface();
		assertTrue("Should override toString and it should invoke parent toString (not getter methods in parent).", toStrInvokesParentToStr());

		SmartAI c = new SmartAI(9876);
		c.updateScore(123);

		assertEquals("[Smart] ID: 9876 Score: 123 nextMove: 95", c.toString());
	}
		
	@Test
	public void test_toString2() {
		testInterface();
		assertTrue("Should override toString and it should invoke parent toString (not getter methods in parent).", toStrInvokesParentToStr());

		SmartAI c = new SmartAI(9876);
		c.updateScore(122);

		assertEquals("[Smart] ID: 9876 Score: 122 nextMove: 96", c.toString());
	}
	
	// Check that parent method correctly calls overridden method
	
	@Test
	public void test_takeTurnInParent(){
		testInterface();
		SmartAI c = new SmartAI(1234);
		c.updateScore(122);
		
		c.takeTurn();
		
		assertEquals("Parent should have called (overridden) getMove, which returned 96", 154, c.getScore());
	}
		
	@Test
	public void test_takeTurnInParent2(){
		testInterface();
		SmartAI c = new SmartAI(1);
		c.updateScore(109);
		
		c.takeTurn();
		
		assertEquals("Parent should have called (overridden) getMove, which returned 95", 132, c.getScore());
	}
		
}
