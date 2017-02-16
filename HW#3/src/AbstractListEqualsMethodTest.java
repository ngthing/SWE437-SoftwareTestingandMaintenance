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
		ArrayList<String> hasEntryAList= new ArrayList<String>();
		hasEntryAList.add("I am not empty Array List");
		LinkedList<String> noEntryLList = new LinkedList<String>();
		assertFalse(hasEntryAList.equals(noEntryLList));
		
		ArrayList<String> noEntryAList= new ArrayList<String>();
		LinkedList<String> hasEntryLList = new LinkedList<String>();
		hasEntryLList.add("I am empty Linked List");
		assertFalse(noEntryAList.equals(hasEntryLList));
	}
	
	@Test public void whileLoopRun_Test(){
		ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("Testing", "is", null, "fun?"));
		ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("Testing", "is", null, "fun?"));
		assertTrue(list1.equals(list2));
		
		ArrayList<String> list3 = new ArrayList<String>(Arrays.asList("Testing", "is", null, "fun?"));
		ArrayList<String> list4 = new ArrayList<String>(Arrays.asList("Testing", "is", "very","fun"));
		assertFalse(list3.equals(list4));
		
		ArrayList<String> list5 = new ArrayList<String>(Arrays.asList("Testing", "is", "sound", "fun?"));
		ArrayList<String> list6 = new ArrayList<String>(Arrays.asList("Testing", "is", null,"fun"));
		assertFalse(list5.equals(list6));
	}
	
	@Test public void whileLoopHappyPath_Test(){
		ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("Testing", "is", "alot of", "fun?"));
		ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("Testing", "is", "alot of", "fun?"));
		assertTrue(list1.equals(list2));
	}
}
