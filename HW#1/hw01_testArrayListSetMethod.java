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

public class hw01_ArrayListSetMethodTest 
{
	private ArrayList<Integer> arrayList; 
	 
	@Before // Sets up - Called before every test method.
	public void setUp()
	{
		Random rd = new Random(100);
		for (int i=0; i<100; i++){
			//add random number from 0 to 19 to the arraylist
			arrayList.add(rd.nextInt(20));		
		}
	}
	
	@After // Called after every test method.
	public void tearDown()
	{
		arrayList = null;
	}

	/*  test case : set() is call when the list is not empty
	 *  	input : index with values < 0
	 *  	expect outcome :  throw IndexOutofBound exception
	 */
	@Theory
	@Test  (expected = IndexOutOfBoundsException.class) 
	public void testForCorrectException_WhenIndexSmallerThanBound(){
		Random rd = new Random(100);
		for (int i=0; i<1000; i++) {
			arrayList.set(-1*Math.abs(rd.nextInt()), 1234);		//test lower bound with 1000 negative number
		}
	}
	
	/* test case : set() with index = 0 when list is empty
	 *  	input : empty list, index = 0
	 *  	expect outcome : throw IOB Exception
	 */
	@Theory
	@Test(expected = IndexOutOfBoundsException.class) 
	public void testForCorrectException_IndexIsZeroOnEmptyList(){
		arrayList.set(0, 12345);						
	}
	
	/* test case : set() with index equal or greater than list's size()
	 * 	input : element, index ( >= current list size
	 */
	@Theory
	@Test(expected = IndexOutOfBoundsException.class) 
	public void testForCorrectException_WhenIndexAtHighThanBound(){
		Random rd = new Random(100);
		for (int i=0; i<1000; i++) {
			arrayList.set(Math.abs(rd.nextInt())+arrayList.size(), 1234);		
		}
		list.set(arrayList.size(), 12345);		//include this line because above loop may miss this circumstance
	}

	@Test 
	public void testForNullList()
	{

	}
	@Test
	public void testForNullElement()
	{

	}

	@Test 
	public void testForReturnedElement()
	{

	}

	@Test
	public void testForTheNewElementIsInsertedAtTheRightIndex()
	{

	}
	
	@Test 
	public void testIfTheRestOfTheArrayIsUnchanged()
	{
		
	}
		
	
	
}
