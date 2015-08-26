import java.util.List;

/**
 * A class for organizing utilities involving Lists
 * 
 * @author Jeremy Ebneyamin
 * CPE 103-01
 * @version 2015.4.16
 */
public class ListUtilities
{
    /**
     * Returns the number of elements in both c1 and c2
     * Assumes no duplicates in either list.
     * 
     * @pre No duplicate values in either list
     * @param c1 first list of integers
     * @param c2 second list of integers
     * @return number of common elements between List c1 and List c2
     */ 
    public static int intersect ( List<Integer> c1, List<Integer> c2 ) 
    { 
        int count = 0; // Number of elements in both lists
        
        //Iterate over the values in list one
        for( int index1 = 0; index1 < c1.size( ); index1++ ) 
        { 
            // Element at the given index for list 1
            int item1 = c1.get( index1 );
            
            // Set up conditions for second loop
            int index2 = 0;
            boolean found = false;
            
            // Iterate over the elements in the second list
            while( index2 < c2.size( ) && !found) 
            {
                // If the item at index2 is equal to item1
                if( c2.get( index2 ) == item1 )
                {
                    found = true; // Set found to true to top the loop
                    count++;      // Increment the count of common elements
                }
                // Else increase the index of index2 and continue the loop
                else
                {
                    index2++;
                }
            }
        } 
        
        return count; 
    }
    
    /**
     * Fills given list with integers from start (inclusive) to [start + numElements] (exclusive)
     * Range: [ start , numElements )
     * 
     * @param list the list to fill with integers
     * @param start the integer to start at when filling the list
     * @param numElements the size of the list after filling
     */
    public static void fillList(List<Integer> list, int start, int numElements)
    {   
        for( int num = start ; num < (start + numElements) ; num++)
        {
            list.add(num);
        }
    }
}
