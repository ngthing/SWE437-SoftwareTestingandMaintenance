import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class hw3_TestCoverage {
	private MyList<Integer> a1 = new MyList<Integer>();
	private MyList<Integer> a2 = new MyList<Integer>();
	
	@Test public void testIfBranch1(){
		MyList<String> alist1 = new MyList<String>();
		alist1.add("this");
		alist1.add("is");
		alist1.add("first");
		alist1.add("if");
		alist1.add("test");
		assertTrue(alist1.equals(alist1));
	}
	
	@Test public void testIfBranch2(){
		MyList<String> alist1 = new MyList<String>();
		alist1.add("this");
		alist1.add("is");
		alist1.add("second");
		alist1.add("if");
		alist1.add("test");
		assertFalse(alist1.equals(new TreeSet<Integer>()));
	}
	
	@Test public void whileLoopNotRun_Test(){
		//branch 1: while loop is skipped
		MyList<String> li1= new MyList<String>();
		li1.add("Not empty");
		MyList<String> li2 = new MyList<String>();
		assertFalse(li1.equals(li2));
		assertFalse(li2.equals(li1));
		li1.remove("Not empty");
		assertTrue(li1.equals(li2));			//this make sure the IF inside whileloop has not run
	}
	
	@Test public void whileLoopHappyPath_Test(){
		//test return true
		MyList<String> list1 = new MyList<String>(Arrays.asList("Testing", "is", "alot of", "fun?"));
		MyList<String> list2 = new MyList<String>(Arrays.asList("Testing", "is", "alot of", "fun?"));
		assertTrue(list1.equals(list2));
		
		//test return false
		MyList<String> list3 = new MyList<String>(Arrays.asList("Testing", "is", "fun", "or not"));
		MyList<String> list4 = new MyList<String>(Arrays.asList("Testing", "is", "fun"));
		assertFalse(list3.equals(list4) || list4.equals(list3));
	}	
	
	@Test public void lastReturnTest(){
		//test return true
		MyList<String> list1 = new MyList<String>(Arrays.asList("Testing", "is", "fun?"));
		MyList<String> list2 = new MyList<String>(Arrays.asList("Testing", "is") );
		MyList<String> list3 = new MyList<String>(Arrays.asList("Testing", "is") );
		assertFalse( list1.equals(list2) || list2.equals(list1) );
		assertTrue( list2.equals(list3)); 
	}
	
	@Test public void whileLoopRun_Test(){
		//cover the case when the express (!(o1==null ? o2==null : o1.equals(o2)))  return o2==null 
		// and the express o2==null  returns false;
		MyList<String> list3 = new MyList<String>(Arrays.asList("Testing", "is", null, "fun?"));
		MyList<String> list4 = new MyList<String>(Arrays.asList("Testing", "is", "very","fun"));	
		assertFalse(list3.equals(list4));
		
		//cover the case when the express (!(o1==null ? o2==null : o1.equals(o2)))  return o1.equals(o2)
		// the the express o1.equals(o2) returns false;
		MyList<String> list7 = new MyList<String>(Arrays.asList("Testing", "is", "sound", "fun?"));
		MyList<String> list8 = new MyList<String>(Arrays.asList("Testing", "is", "seem","fun"));
		assertFalse(list7.equals(list8));
		
		
		// cover the case when the express (!(o1==null ? o2==null : o1.equals(o2)))  returns  o2==null
		// and the express o2==null  returns true; 
		MyList<String> list1 = new MyList<String>(Arrays.asList("Testing", "is", null));
		MyList<String> list2 = new MyList<String>(Arrays.asList("Testing", "is", null));
		assertTrue(list1.equals(list2));
		
		
		//cover the case when the express (!(o1==null ? o2==null : o1.equals(o2)))  return o1.equals(o2)
		// and the express o1.equals(o2)  returns true;
		MyList<String> list5 = new MyList<String>(Arrays.asList("Testing", "is", "seem", "fun"));
		MyList<String> list6 = new MyList<String>(Arrays.asList("Testing", "is", "seem","fun"));
		assertTrue(list5.equals(list6));
		
	}
}	


