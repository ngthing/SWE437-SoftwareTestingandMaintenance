/**
 * @author Kien Nguyen & Thi Nguyen
 * @date Feb 1, 2017
 * Agile processes use test cases as a specification mechanism. The purpose of this exercise is to help you understand the power of test cases as a specification mechanism.
 * Consider the specification for the set() method in the Java ArrayList class. https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html#add(E)
 * Assignment: 
 * 		Define test cases (both inputs and expected outputs) based on the documentation.
 * 		Grading criteria: A plausible set of test cases that exercise all aspects of the documentation. 
 * 		You don't have to format the tests as JUnit, but it would be good practice.
 */

import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theory;

import static org.junit.Assert.assertEquals;

//@RunWith (Theories.class)
public class hw01_testArrayListSetMethod 
{
	private ArrayList<Integer> arrayList; 
	private Random rd;
	
	@Before // Sets up - Called before every test method.
	public void setUp()
	{
		arrayList = new ArrayList<Integer>(); 			//initialize arrayList here
		rd = new Random(100);							//initialize random generator with seed = 100;
		for (int i=0; i<100; i++){
			//add random number from 0 to 19 to the arraylist
			arrayList.add(rd.nextInt(20));		
		}
	}
	
	@After // Called after every test method.
	public void tearDown()
	{
		arrayList = null;
		rd = null;
	}

	/*  Test case 1 : set() is call when the list is not empty
	 *  	input : index with values < 0, randome element
	 *  	expect outcome :  throw IndexOutofBound exception 	 */
	@Theory
	@Test  (expected = IndexOutOfBoundsException.class) 
	public void testForCorrectException_WhenIndexSmallerThanBound(){
		for (int i=0; i<1000; i++) {
			arrayList.set(-1*Math.abs(rd.nextInt()), 1234);		//test lower bound with 1000 negative number
		}
	}
	
	/* Test case 2: test set() when list is empty
	 *  	input : empty list, index = 0
	 *  	expect outcome : throw IOB Exception	 	*/
	@Theory
	@Test(expected = IndexOutOfBoundsException.class) 
	public void testForCorrectException_IndexIsZeroOnEmptyList(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.set(0, 12345);						
	}
	
	/* Test case 3: test set() with index equals or greater than list's size()
	 * 		input : random element, index >= current list size				 
	 *		expect outcome : throw IOB exception 		
	 * */
	@Theory
	@Test(expected = IndexOutOfBoundsException.class) 
	public void testForCorrectException_WhenIndexAtHighThanBound(){
		for (int i=0; i<1000; i++) {
			arrayList.set(Math.abs(rd.nextInt())+arrayList.size(), 1234);		
		}
		arrayList.set(arrayList.size(), 12345);		//include this line because above loop may miss this circumstance
	}

	
	/* Test case 4: test set() when the ArrayList is null 
	 * 		input:  array list
	 * 	 	expect outcome:  throw NPE 
	 * */
	@Test (expected = NullPointerException.class)
	public void testForNullList()
	{
		arrayList = null;			
		arrayList.set(1,3);			
	}
	
	/* Test case 5: when Set() is called when the ArrayList is null  */ 
	/* Hi Thi, I dont think this test is relevant to set() method 
	 * 	because  it accepts any elements include null value 
	 *  so I comment it out.
	@Test(expected = NullPointerException.class)
	public void testForNullElement()
	{
		int index = 1; // index of position 
		arrayList.set(index,null);
	}*/
	
	
	/* Test case 6: verify if the set() put the new element in correct position  
	 * *  	input : newElement, index
	 *  	expect: after set() is invoke, the element that is currently at position 
	 *  			<index> must equals new element
	 * */ 
	@Test
	public void testForTheNewElementIsInsertedAtTheRightIndex()
	{
		int index; 									// index of position 
		Integer	newElement;	 						// The new element that need to set to ArrayList
		for (int i = 0; i < 1000; i++) 				//test for 1000 replacements
		{
			newElement = rd.nextInt(50); 			// Create a newElement to replace bound 0 <= elem <30			
			index = rd.nextInt(arrayList.size());	// 0 <= index < arraysize
			arrayList.set(index, newElement);
			assertEquals(newElement, arrayList.get(index));
		}
	}
	

	/* Test case 7: verify if the set() replaces correct element. 
	 * New element will replace the current element at given index. 
	 *  	input : index, element current at the position index
	 *  	output : replaced element
	 *  	expect : after set() is invoked, the return element must equals the element 
	 *  			that previously at the position <index>
	 *  */
	@Test 
	public void testForCorrectReturnedElement()
	{
		int index; // index of position 
		Integer	newElement,		 					// The new element that need to set to ArrayList
				elementAtSpecifiedIndex, 			// The element that will be replaced
				returnedElement ;  					// The returned value from set() method
		for (int i = 0; i < 1000; i++) 				//test for 1000 replacements
		{
			newElement = rd.nextInt(30); 						// Create a newElement to replace bound 0 <= elem <30			
			index = rd.nextInt(arrayList.size());				// 0 <= index < arraysize
			elementAtSpecifiedIndex = arrayList.get(index);		//get the current element at the position index 	
			returnedElement = arrayList.set(index, newElement);
			assertEquals(elementAtSpecifiedIndex,returnedElement);		
		}

	}

	/* Test case 8:  test if set() does not affect values and order of other element
			input : elements of original array,  index : position of the element to be replaced
			expect : all other elements except the element at <index> position
	*/
	@Test 
	public void testIfTheRestOfTheArrayIsUnchanged()
	{
		ArrayList<Integer> originalList;
		int index;
		Integer	newElement; 
		//using copy construct, originalList will have same element as arrayList
		//but modification to arrayList will not affect originalList
		//	originalList = arrayList;
		
		for (int i=0; i<100; i++) {					//do 100 invoke to set() and each time verify if other elements are no affected 
			newElement = rd.nextInt(30); 			// new randomized element
			index = rd.nextInt(arrayList.size());	// new randomized index that [0...size)
			
			//make the copy of arrayList
			//using copy constructor so originalList will have same element as arrayList
			//but modification to arrayList will not affect originalList. 
			//note : using ogiginalList = arrayList will actually refer to the same object.
			originalList = new ArrayList<Integer>(arrayList);
			arrayList.set(index, newElement);
			
			//now check if size is unchanged
			assertEquals(arrayList.size(), originalList.size());
			
			//and check if all other elements are not affected by invoke of the set()
			for (int k=0; k < index; k++) 
				assertEquals(arrayList.get(k), originalList.get(k));
			for (int k=index + 1; k < arrayList.size(); k++)
				assertEquals(arrayList.get(k), originalList.get(k));
		}
	}
		
	
}
