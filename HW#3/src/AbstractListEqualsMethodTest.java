import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;

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
	@Test public void testIfBranch2(){
		ArrayList<String> alist1 = new ArrayList<String>();
		alist1.add("this");
		alist1.add("is");
		alist1.add("second");
		alist1.add("if");
		alist1.add("test");
		assertFalse(alist1.equals(new TreeSet<Integer>()));
	}
	@Test public void whileLoopNotRun_Test(){
		//branch 1: while loop is skipped
		ArrayList<String> li1= new ArrayList<String>();
		li1.add("Not empty");
		ArrayList<String> li2 = new ArrayList<String>();
		assertFalse(li1.equals(li2));
		assertFalse(li2.equals(li1));
		li1.remove("Not empty");
		assertTrue(li1.equals(li2));			//this make sure the IF inside whileloop has not run
	}
	
	@Test public void whileLoopHappyPath_Test(){
		//test return true
		ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("Testing", "is", "alot of", "fun?"));
		ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("Testing", "is", "alot of", "fun?"));
		assertTrue(list1.equals(list2));
		
		//test return false
		ArrayList<String> list3 = new ArrayList<String>(Arrays.asList("Testing", "is", "fun", "or not"));
		ArrayList<String> list4 = new ArrayList<String>(Arrays.asList("Testing", "is", "fun"));
		assertFalse(list3.equals(list4) || list4.equals(list3));
	}	
	
	@Test public void lastReturnTest(){
		//test return true
		ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("Testing", "is", "fun?"));
		ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("Testing", "is") );
		ArrayList<String> list3 = new ArrayList<String>(Arrays.asList("Testing", "is") );
		assertFalse( list1.equals(list2) || list2.equals(list1) );
		assertTrue( list2.equals(list3)); 
	}
	
	@Test public void whileLoopRun_Test(){
		// cover the case when the express (!(o1==null ? o2==null : o1.equals(o2)))  returns  o2==null
		// and the express o2==null  returns true; 
		ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("Testing", "is", null, "fun?"));
		ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("Testing", "is", null, "fun?"));
		assertTrue(list1.equals(list2));
		
		//cover the case when the express (!(o1==null ? o2==null : o1.equals(o2)))  return o2==null 
		// and the express o2==null  returns false;
		ArrayList<String> list3 = new ArrayList<String>(Arrays.asList("Testing", "is", null, "fun?"));
		ArrayList<String> list4 = new ArrayList<String>(Arrays.asList("Testing", "is", "very","fun"));
		assertFalse(list3.equals(list4));
		
		//cover the case when the express (!(o1==null ? o2==null : o1.equals(o2)))  return o1.equals(o2)
		// and the express o1.equals(o2)  returns true;
		ArrayList<String> list5 = new ArrayList<String>(Arrays.asList("Testing", "is", "sound", "fun?"));
		ArrayList<String> list6 = new ArrayList<String>(Arrays.asList("Testing", "is", "seem","not fun"));
		assertFalse(list5.equals(list6));
		
		//cover the case when the express (!(o1==null ? o2==null : o1.equals(o2)))  return o1.equals(o2)
		// the the express o1.equals(o2)  returns false;
		ArrayList<String> list7 = new ArrayList<String>(Arrays.asList("Testing", "is", "sound", "fun?"));
		ArrayList<String> list8 = new ArrayList<String>(Arrays.asList("Testing", "is", "seem","fun"));
				assertFalse(list7.equals(list8));
	}

}
