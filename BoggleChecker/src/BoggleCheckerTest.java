import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BoggleCheckerTest.
 *
 * @author  Jeremy Ebneyamin
 * @version 2015.4.22
 */
public class BoggleCheckerTest
{
    /**
     * Default constructor for test class BoggleCheckerTest
     */
    public BoggleCheckerTest()
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
    public void testBoggleCheckOne()
    {
        BoggleChecker checker = new BoggleChecker();
        String board = "XQAEZOTSINDLYRUK";
        checker.setBoard(board);
        
        assertTrue(checker.checkWord("XQAESLKURYIZ"));
        assertTrue(checker.checkWord("DNOT"));
        assertTrue(checker.checkWord("NIZOTS"));
        assertTrue(checker.checkWord("KUDL"));
        assertTrue(checker.checkWord("STONI"));
        assertTrue(checker.checkWord("SEAT"));
        assertTrue(checker.checkWord("ONIYR"));
        assertTrue(checker.checkWord("ZONIY"));
        
        assertFalse(checker.checkWord("MY"));
        assertFalse(checker.checkWord("SEAN"));
        assertFalse(checker.checkWord("SETS"));
        assertFalse(checker.checkWord("TOO"));
        assertFalse(checker.checkWord("DOT"));
    }
    
    @Test
    public void testBoggleCheckTwo()
    {
        BoggleChecker checker = new BoggleChecker();
        String board = "XQADEZOTISINDOLYRUNBFAEHK";
        checker.setBoard(board);
        
        assertTrue(checker.checkWord("ZOTIS"));
        assertTrue(checker.checkWord("SIT"));
        assertTrue(checker.checkWord("LOIS"));
        
        assertFalse(checker.checkWord("DOT"));
        assertFalse(checker.checkWord("SLOB"));
    }
}
