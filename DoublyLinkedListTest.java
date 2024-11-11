package csu22011_a2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);      
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);     
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);       
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );
		testDLL.insertBefore(9, 9);
		assertEquals("Checking insertBefore to a list into the tail", "7,4,5,6,1,2,3,8,9,9", testDLL.toString());

        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testDeleteAt() {
	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	assertEquals("Checking deletion from empty list", false, testDLL.deleteAt(5));
	testDLL.insertBefore(0, 1);
	assertEquals("Check emptying out the list", true, testDLL.deleteAt(0));
	testDLL.insertBefore(0, 0);
	testDLL.insertBefore(1, 1);
	testDLL.deleteAt(0);
	assertEquals("Check deleting from head of list", "1", testDLL.toString());
	testDLL.insertBefore(1, 2);
    testDLL.insertBefore(2, 3);
	
	testDLL.deleteAt(1);
	assertEquals("Checking deleting from middle of list", "1,3", testDLL.toString());
	testDLL.deleteAt(1);
	assertEquals("Checking deleting from tail of list", "1", testDLL.toString());
	assertEquals("Checking deletion from invalid, negative location", false, testDLL.deleteAt(-5));
	assertEquals("Checking deletion from invalid, positive location", false, testDLL.deleteAt(15));

    }
    
    @Test
    public void testReverse() {
	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.reverse(); 
		assertEquals("Reversing empty", "", testDLL.toString());	
        testDLL.insertBefore(0,1);
		testDLL.reverse(); 
		assertEquals("Reversing single item", "1", testDLL.toString());
        testDLL.insertBefore(1,2);
		testDLL.reverse(); 
		assertEquals("Reversing 1, 2", "2,1", testDLL.toString());		
        testDLL.insertBefore(2,3);
		testDLL.insertBefore(3,4);
		testDLL.reverse();
		assertEquals("Reversing 2, 1, 3, 4", "4,3,1,2", testDLL.toString());

    }
	
	@Test
	public void testGet() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		assertEquals("Getting empty list", null, testDLL.get(0));
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
		assertEquals("Getting invalid item (negative)", null, testDLL.get(-5));
		assertEquals("Getting valid item", Integer.valueOf(2), testDLL.get(1));
		assertEquals("Getting invalid item (positive)", null, testDLL.get(10));
	}
    
    @Test
    public void testUnique() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.makeUnique();
		System.out.println("0");
		assertEquals("Uniquing an empty list", "", testDLL.toString());
        testDLL.insertBefore(0,1);
		testDLL.makeUnique();
		System.out.println("1");
		assertEquals("Uniquing a single element list", "1", testDLL.toString());
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,2);
		testDLL.insertBefore(3,4);
		testDLL.makeUnique();
		System.out.println("1224");
		assertEquals("Uniquing 1, 2, 2, 4", "1,2,4", testDLL.toString());
		testDLL.insertBefore(3,4);
		testDLL.insertBefore(4,4);
		testDLL.insertBefore(5,4);
		testDLL.makeUnique();
		System.out.println("124444");
		assertEquals("Uniquing 1, 2, 4, 4, 4, 4", "1,2,4", testDLL.toString());
		System.out.println("124");
		assertEquals("Uniquing a list with no duplicates", "1,2,4", testDLL.toString());
}
    
}

