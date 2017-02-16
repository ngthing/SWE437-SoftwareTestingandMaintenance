/***
Created: Feb 15, 2017
Author: Kien Nguyen & Thi Nguyen 
SWE 437 - HW#3: More JUnit/Introduction to Coverage http://cs.gmu.edu/~pammann/437/assigns/assign03.html
Test the equals() method in the Java AbstractList class
***/
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
	
	// Test when o == this
	@Test public void testIfBranch1(){
		MyList<String> alist1 = new MyList<String>();
		alist1.add("this");
		alist1.add("is");
		alist1.add("first");
		alist1.add("if");
		alist1.add("test");
		assertTrue(alist1.equals(alist1));
	}
	// Test when o is not an instance of List
	@Test public void testIfBranch2(){
		MyList<String> alist1 = new MyList<String>();
		alist1.add("this");
		alist1.add("is");
		alist1.add("second");
		alist1.add("if");
		alist1.add("test");
		assertFalse(alist1.equals(new TreeSet<Integer>()));
	}
	
	// When either e1.hasNext() or e2.hasNext() or both return false, then 
	// while (e1.hasNext() && e2.hasNext()) will be skipped. The expected result is
	// !(e1.hasNext() || e2.hasNext()) 
	@Test public void whileLoopNotRun_Test(){
		//branch 1: while loop is skipped
		MyList<String> li1= new MyList<String>();
		li1.add("Not empty");
		MyList<String> li2 = new MyList<String>();
		// e2.hasNext() returns False
		assertFalse(li1.equals(li2));
		// e1.hasNext() returns False
		assertFalse(li2.equals(li1));
		li1.remove("Not empty");
		// Both e1.hasNext() & e2.hasNext() return False
		// and both class are empty.
		assertTrue(li1.equals(li2));			//this make sure the IF inside whileloop has not run
	}
	

	@Test public void whileLoopHappyPath_Test(){
		//Both has the same number of identical elements. 
		MyList<String> list1 = new MyList<String>(Arrays.asList("Testing", "is", "alot of", "fun?"));
		MyList<String> list2 = new MyList<String>(Arrays.asList("Testing", "is", "alot of", "fun?"));
		assertTrue(list1.equals(list2));
		
		// When this and o have different number of elements 
		MyList<String> list3 = new MyList<String>(Arrays.asList("Testing", "is", "fun", "or not"));
		MyList<String> list4 = new MyList<String>(Arrays.asList("Testing", "is", "fun"));
		// At one point, e2.hasNext() returns false. 
		assertFalse(list3.equals(list4));
		// At one point, e1.hasNext() returns false. 
		assertFalse(list4.equals(list3));
		// Test when both has the same number of elements, but the last elements are different. 
		MyList<String> list5 = new MyList<String>(Arrays.asList("Testing", "is", "fun"));
		MyList<String> list6 = new MyList<String>(Arrays.asList("Testing", "is", "not fun"));
		
		assertFalse(list5.equals(list6));
	}	
	
	// Testing when either or both e1.hasNext() & e2.hasNext() return false.
	// test the correctness of the last return statement !(e1.hasNext() || e2.hasNext())
	// while (e1.hasNext() && e2.hasNext()){ ... } return !(e1.hasNext() || e2.hasNext());
	@Test public void lastReturnTest(){
		//test return true
		MyList<String> list1 = new MyList<String>(Arrays.asList("Testing", "is", "fun?"));
		MyList<String> list2 = new MyList<String>(Arrays.asList("Testing", "is") );
		MyList<String> list3 = new MyList<String>(Arrays.asList("Testing", "is") );
		// e1.hasNext() == true, return !(true || false) = false
		assertFalse(list1.equals(list2))
		// e2.hasNext() == true, return !(true || false) = false
		assertFalse(list2.equals(list1));
		// e1.hasNext() == false and e2.hasNext() == false return !(false || false) = true
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


