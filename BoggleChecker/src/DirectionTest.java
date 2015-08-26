import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DirectionTest.
 *
 * @author  Jeremy Ebneyamin
 * @version 2015.4.22
 */
public class DirectionTest
{
    /**
     * Default constructor for test class DirectionTest
     */
    public DirectionTest()
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
    public void testDirection()
    {
        Direction north = Direction.NORTH;
        assertEquals(north, Direction.NORTH);
    }
    
    @Test
    public void testOffset()
    {
        Direction north = Direction.NORTH;
        assertEquals(north.rowOffset(), -1);
        assertEquals(north.colOffset(), 0);
        
        Direction east = Direction.EAST;
        assertEquals(east.rowOffset(), 0);
        assertEquals(east.colOffset(), 1);
        
        Direction south = Direction.SOUTH;
        assertEquals(south.rowOffset(), 1);
        assertEquals(south.colOffset(), 0);
        
        Direction west = Direction.WEST;
        assertEquals(west.rowOffset(), 0);
        assertEquals(west.colOffset(), -1);
    }
    
    @Test
    public void testOpposite()
    {
        Direction north = Direction.NORTH;
        assertEquals(north.opposite(), Direction.SOUTH);
        
        Direction east = Direction.EAST;
        assertEquals(east.opposite(), Direction.WEST);
        
        Direction south = Direction.SOUTH;
        assertEquals(south.opposite(), Direction.NORTH);
        
        Direction west = Direction.WEST;
        assertEquals(west.opposite(), Direction.EAST);
    }
    
    @Test
    public void testNext()
    {
        Direction north = Direction.NORTH;
        assertEquals(north.next(), Direction.EAST);
        
        Direction east = Direction.EAST;
        assertEquals(east.next(), Direction.SOUTH);
        
        Direction south = Direction.SOUTH;
        assertEquals(south.next(), Direction.WEST);
        
        Direction west = Direction.WEST;
        assertEquals(west.next(), Direction.NORTH);
    }
}
