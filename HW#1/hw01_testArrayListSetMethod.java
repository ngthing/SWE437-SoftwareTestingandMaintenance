/**
 * @author Kien Nguyen & Thi Nguyen
 * @date Feb 1, 2017
 * Agile processes use test cases as a specification mechanism. The purpose of this exercise is to help you understand the power of test cases as a specification mechanism.
 * Consider the specification for the set() method in the Java ArrayList class. https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html#add(E)
 * Assignment: Define test cases (both inputs and expected outputs) based on the documentation.
 * Grading criteria: A plausible set of test cases that exercise all aspects of the documentation. You don't have to format the tests as JUnit, but it would be good practice.
 */

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import org.junit.experimental.theories.Theory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class hw01_testArrayListSetMethod {
	Random rd = new Random(100);
	
	public ArrayList<Integer> generateList(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i=0; i<100; i++){
			al.add(rd.nextInt(20));		//add random number from 0 to 19 to the arraylist
		}
		return al;
	}
	
	/*Test the if the replace is correct which :
	 * 1.  test if the new element is inserted in correct position
	 * 2.  test if set() return values is the element that was previously in the replaced position
	 * 3.  test to make sure all elements before & after the set's position are no changed (in orders and values)
	*/
	@Test 
	public void testReplacement(){
		ArrayList<Integer> list = generateList();
		int index; 				//index of position
		Integer	newElem,		//to hold new element that need to set to ArrayList
			replElem, 			//to hold element that will be replaced
			retElem;			//to hold the return value from set() method
		
		for (int i=0; i<1000; i++){				//test for 1000 replacements
			newElem = rd.nextInt(30);			//bound 0<= elem <30
			index = rd.nextInt(list.size());	// 0<= index < arraysize
			replElem = list.get(index);		//get the current element at the position index 	
			retElem = list.set(index, newElem );
			//test condition 1
			assertEquals(newElem, list.get(index));
			
			//test condition 2
			assertEquals(retElem, replElem);		
			
			
			//test for condition 4: make sure all elements before the index, and after the index are no changed
		}
	}
	
	//Test the exception throw when set to position out of bound
	@Theory
	@Test  (expected = IndexOutOfBoundsException.class) 
	public void testExceptionLowBound(){
		ArrayList<Integer> list = generateList();
		for (int i=0; i<1000; i++) {
			list.set(-1*Math.abs(rd.nextInt()), 1234);		//test lower bound with 1000 negative number
		}
	}
	
	//break into 3 different tests cases
	@Theory
	@Test(expected = IndexOutOfBoundsException.class) 
	public void testException_emptyList(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		//case 1, set to index 0 when list is empty
		list.set(0, 12345);						
	}
	
	@Theory
	@Test(expected = IndexOutOfBoundsException.class) 
	public void testException_setAtSize(){
		ArrayList<Integer> list = generateList();
		//case 2, set to index equal size()
		list.set(list.size(), 12345);					
	}
			
	@Theory
	@Test(expected = IndexOutOfBoundsException.class) 
	public void testException_setAtGtSize(){
		ArrayList<Integer> list = generateList();
		
		//case 3: test with index > size() , 
		for (int i=0; i<1000; i++) {
			list.set(Math.abs(rd.nextInt())+list.size(), 1234);		
		}
	}
	
	
	
}
