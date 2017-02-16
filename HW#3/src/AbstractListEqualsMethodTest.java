import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;

import java.util.*;

@RunWith (Theories.class)
public class AbstractListEqualsMethodTest {
	
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
	
	@DataPoint 
	public static ArrayList<String> a1 = new ArrayList<String>(); 
	
}
