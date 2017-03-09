

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMin {
    private List list;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Before
    public void initData(){
        list = new ArrayList(Arrays.asList(2,3,4,5,-1) );
    }
    @After 
    public void cleanup(){ 
        list =null;
    }
    
    @SuppressWarnings("unchecked")
    @Test 
    public void listWithOneElement() throws Exception {
        assertEquals((Integer) (-1), Min.min(list));
    }
    
    @SuppressWarnings("unchecked")
    @Test 
    public void listWithManyElement() throws Exception {
        Object obj = Min.min(list);
        assertTrue("Single Element List", obj.equals(-1));
    }
    @Test
    public void testThrowNPE_ListIsNull() throws Exception {
        try {
            Min.min(null);
            fail("expect min() to throw NullPointerException if "
                    + "the list is null");
        } catch (NullPointerException expected) {
            assertTrue(expected.getMessage().equals("list cannot be null"));    
        }
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testThrowNPE_ListHasNull() throws Exception {
        list.add(null);
        try {
            Min.min(list);
            fail("expect min() to throw NullPointerException if "
                    + "the list has null element");
        } catch (NullPointerException expected) {
            assertTrue(expected.getMessage().equals(
                    "list cannot contain null element"));   
        }
    }
    
  
    @SuppressWarnings("unchecked")
    @Test
    public void testThrowIAE_ListEmpty() throws Exception {
        list.clear();
        try {
            Min.min(list);
            fail("expect min() to throw IllegalArgumentException if "
                    + "the list is empty");
        } catch (IllegalArgumentException expected) {
            assertTrue(expected.getMessage().equals(
                    "list cannot be empty"));   
        }
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testThrowCCE_NonComparableElem() throws Exception {
        list.add("one");
        try {
            Min.min(list);
            fail("expect min() to throw ClassCastException if "
                    + "the list element is not comparable");
        } catch (ClassCastException expected) {
            assertTrue(expected.getMessage().equals(
                    "list's elements must be comparable")); 
        }
    }
}