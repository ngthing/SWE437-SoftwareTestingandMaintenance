import static org.junit.Assert.*;

import org.junit.Test;

public class AbstractListEqualsMethodTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test public void testIfBranch1(){
		ArrayList<String> alist1 = new ArrayList<String>();
		alist1.add("this");
		alist1.add("is");
		alist1.add("first");
		alist1.add("if");
		alist1.add("test");
		assertTrue(alist1.equals(alist1));
	}
	@Test public void testIfBranch1(){
		ArrayList<String> alist1 = new ArrayList<String>();
		alist1.add("this");
		alist1.add("is");
		alist1.add("first");
		alist1.add("if");
		alist1.add("test");
		assertTrue(alist1.equals(alist1));
	}
	
}
