import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A driver class for running the intersect method of the ListUtilities class.
 * 
 * @author Jeremy Ebneyamin
 * @version 2015.4.16
 */
public class ListUtilitiesDriver
{
    /** First ArrayList object for testing */
    private ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
    /** Second ArrayList object for testing */
    private ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
    
    /** First LinkedList object for testing */
    private LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
    /** Second LinkedList object for testing */
    private LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
    
    /** Number of elements for the warm up phase of testing */
    public static final int kWarmUp = 3000;
    
    /** Number of elements for the first test */
    public static final int kFirstTest = 1000;
    /** Number of elements for the second test */
    public static final int kSecondTest = 2000;
    /** Number of elements for the third test */
    public static final int kThirdTest = 4000;
    /** Number of elements for the fourth test */
    public static final int kFourthTest = 8000;
    /** Number of elements for the fifth test */
    public static final int kFifthTest = 16000;
    
    /** Runs the tests of each list type with the runTest functions */
    public void runTests()
    {
        // Variable for logging the duration of a function
        long duration = 0;
        
        // Warm Up
        System.out.println("Warm Up");
        System.out.println("------------------------------------------");
        fillLists( kWarmUp ); // Fill every list with kWarmUp number of integers
        duration = runArrayListTest(); // Run the ArrayList test
        // Print results
        System.out.println("ArrayList timing for " + arrayList1.size() + " elements: " + duration);
        duration = runLinkedListTest(); // Run the LinkedList test
        // Print results
        System.out.println("LinkedList timing for " + linkedList1.size() + " elements: " + duration);
        // New-line and clear lists for next test
        System.out.println();
        clearLists();
        
        // First Test
        System.out.println("First Test");
        System.out.println("------------------------------------------");
        fillLists( kFirstTest ); // Fill every list with kFirstTest number of integers
        duration = runArrayListTest(); // Run the ArrayList test
        // Print results
        System.out.println("ArrayList timing for " + arrayList1.size() + " elements: " + duration);
        duration = runLinkedListTest(); // Run the LinkedList test
        // Print results
        System.out.println("LinkedList timing for " + linkedList1.size() + " elements: " + duration);
        // New-line and clear lists for next test
        System.out.println();
        clearLists();
        
        // Second Test
        System.out.println("Second Test");
        System.out.println("------------------------------------------");
        fillLists( kSecondTest ); // Fill every list with kSecondTest number of integers
        duration = runArrayListTest(); // Run the ArrayList test
        // Print results
        System.out.println("ArrayList timing for " + arrayList1.size() + " elements: " + duration);
        duration = runLinkedListTest(); // Run the LinkedList test
        // Print results
        System.out.println("LinkedList timing for " + linkedList1.size() + " elements: " + duration);
        // New-line and clear lists for next test
        System.out.println();
        clearLists();
        
        // Third Test
        System.out.println("Third Test");
        System.out.println("------------------------------------------");
        fillLists( kThirdTest ); // Fill every list with kThirdTest number of integers
        duration = runArrayListTest(); // Run the ArrayList test
        // Print results
        System.out.println("ArrayList timing for " + arrayList1.size() + " elements: " + duration);
        duration = runLinkedListTest(); // Run the LinkedList test
        // Print results
        System.out.println("LinkedList timing for " + linkedList1.size() + " elements: " + duration);
        // New-line and clear lists for next test
        System.out.println();
        clearLists();
        
        // Fourth Test
        System.out.println("Fourth Test");
        System.out.println("------------------------------------------");
        fillLists( kFourthTest ); // Fill every list with kFourthTest number of integers
        duration = runArrayListTest(); // Run the ArrayList test
        // Print results
        System.out.println("ArrayList timing for " + arrayList1.size() + " elements: " + duration);
        duration = runLinkedListTest(); // Run the LinkedList test
        // Print results
        System.out.println("LinkedList timing for " + linkedList1.size() + " elements: " + duration);
        // New-line and clear lists for next test
        System.out.println();
        clearLists();
        
        // Fifth Test
        System.out.println("Fifth Test");
        System.out.println("------------------------------------------");
        fillLists( kFifthTest ); // Fill every list with kFifthTest number of integers
        duration = runArrayListTest(); // Run the ArrayList test
        // Print results
        System.out.println("ArrayList timing for " + arrayList1.size() + " elements: " + duration);
        duration = runLinkedListTest(); // Run the LinkedList test
        // Print results
        System.out.println("LinkedList timing for " + linkedList1.size() + " elements: " + duration);
    }
    
    /**
     * Runs the intersect method with the two ArrayList objects
     * arrayList1 and arrayList2
     * 
     * @return the duration in miliseconds for the function to complete
     */
    private long runArrayListTest()
    {
        long startTime = System.currentTimeMillis();
        ListUtilities.intersect( arrayList1, arrayList2 );
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }
    
    /**
     * Runs the intersect method with the two LinkedList objects
     * linkedList1 and linkedList2
     * 
     * @return the duration in miliseconds for the function to complete
     */
    private long runLinkedListTest()
    {
        long startTime = System.currentTimeMillis();
        ListUtilities.intersect( linkedList1, linkedList2 );
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }
    
    /** Method that clears the elements of all lists. */
    private void clearLists()
    {
        arrayList1.clear();
        arrayList2.clear();
        linkedList1.clear();
        linkedList2.clear();
    }
    
    /**
     * Fills the first list of each type with numElements 
     * number of integers starting with 0
     * 
     * Fills the second list of each type with numElements 
     * number of integers starting with numElements
     * 
     * This gives each list an equal number of elements while
     * preventing common elements between lists of the same type
     */
    private void fillLists(int numElements)
    {
        ListUtilities.fillList( arrayList1, 0, numElements );
        ListUtilities.fillList( arrayList2, 0, numElements );
        ListUtilities.fillList( linkedList1, 0, numElements );
        ListUtilities.fillList( linkedList2, 0, numElements );
    }
    
    /** Run the tests */
    public static void main(String[] args)
    {
        new ListUtilitiesDriver().runTests();
    }
}
