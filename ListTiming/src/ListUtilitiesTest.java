import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The test class ListUtilitiesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListUtilitiesTest
{
    /**
     * Default constructor for test class ListUtilitiesTest
     */
    public ListUtilitiesTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testIntersect()
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add( 1 );
        list1.add( 3 );
        list1.add( 5 );
        list1.add( 9 );
        list1.add( 10 );
        
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add( 0 );
        list2.add( 1 );
        list2.add( 2 );
        list2.add( 3 );
        list2.add( 4 );
        
        assertEquals( ListUtilities.intersect( list1, list2), 2);
    }
    
    @Test
    public void testNotIntersect()
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add( 1 );
        list1.add( 2 );
        list1.add( 3 );
        list1.add( 4 );
        list1.add( 5 );
        
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add( 6 );
        list2.add( 7 );
        list2.add( 8 );
        list2.add( 9 );
        list2.add( 10 );
        
        assertEquals( ListUtilities.intersect( list1, list2), 0);
    }
    
    @Test
    public void testFillListSize()
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ListUtilities.fillList( list1, 0, 100);
        
        assertEquals( list1.size(), 100 );
    }
    
    @Test
    public void testFillListSizes()
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ListUtilities.fillList( list1, 0, 100);
        
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ListUtilities.fillList( list2, 100, 100);
        
        assertEquals( list1.size(), list2.size() );
    }
    
    @Test
    public void testFillListNotEqual()
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ListUtilities.fillList( list1, 0, 100);
        
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ListUtilities.fillList( list2, 100, 100);
        
        assertFalse( list1.equals(list2) );
    }
}
