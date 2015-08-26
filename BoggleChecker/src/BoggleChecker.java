/** 
 * Class for checking the player moves in a Boggle game.
 * 
 * @author  Jeremy Ebneyamin
 * @version 2015.4.22
 */
public class BoggleChecker
{
    /** 2D Array matrix for storing the board. */
    private char[][] boardMatrix;
    
    /** Board as a String. */
    private String board;
    
    /** Set the board for this checker.
     * @param board a String containing the letters in a 4x4 or 5x5 board
     * in row-major order.  
     * @pre board.length() is 16 or 25.
     * @pre board contains only upper case letters.
     */
    public void setBoard(String board)
    {
        // Save a copy of the board String for reference later
        this.board = board;
        // Get the length of the board side
        int length = (int) Math.sqrt( board.length() );
        // Initialize the 2d array
        boardMatrix = new char[length][length];
        // Start a counter for iterating through the board String
        int counter = 0;
        
        while( counter < board.length() )
        {
            // Calculate the row and column
            int row = counter / length;
            int col = counter % length;
            
            // Place the character into the 2D array
            boardMatrix[row][col] = board.charAt(counter);
            counter++;
        }
    }
    
    /** Determine if the given word exists in the current Boggle board. 
     * @param word is a player's guess
     * @pre word contains only letters
     * @pre word.length() > 1
     * @pre a board has been set for this checker.
     */
    public boolean checkWord(String word)
    {
        // Boolean for while loop readability
        boolean verified = false;
        // First letter of the word
        char firstLetter = word.charAt(0);
        // See if the first letter of the word exists in the board
        int index = board.indexOf(firstLetter);
        
        // While the first letter exists and the word has not been verified
        while( index != -1 && !verified )
        {
            // Calculate row and column
            int row = index / boardMatrix.length;
            int col = index % boardMatrix.length;
            
            // Index of the next character in the word
            int letterIndex = 1;
            
            // Find the direction of the next character if it exists
            Direction dir = directionOf(row, col, word.charAt(letterIndex), null);
            
            /** 
             * While next character exists, continue finding characters.
             * If character does not exist, then dir = null and the loop ends.
             */
            while(dir != null)
            {
                // Apply offset to current row and column
                row += dir.rowOffset();
                col += dir.colOffset();
                
                // Advance to the next letter
                letterIndex++;
                
                // If there are still characters to find
                if( letterIndex < word.length() )
                {
                    // Find the next character
                    dir = directionOf(row, col, word.charAt(letterIndex), dir.opposite());
                }
                // Else set dir to null to end the loop
                else
                {
                    dir = null;
                }
            }
            
            // If the loop terminated and index == word.length()
            if( letterIndex == word.length() )
            {
                // Then the word was verified
                verified = true;
            }
            // Else the loop terminated without verifying the word
            else
            {
                // See if the first letter exists somewhere else in the board
                index = board.indexOf(firstLetter, index + 1);
            }
        }
        
        return verified;
    }
    
    /** 
     * Checks the letters adjacent to the given row and column
     * for the given letter and then returns the direction.
     * If the given letter is not found then -1 is returned.
     * 
     * @param row the row of the letter to look around
     * @param col the column of the letter to look around
     * @param letter the letter to find
     * @param ignore the direction to ignore when searching or null
     * 
     * @return the direction of the letter or null if not found
     */
    private Direction directionOf( int row, int col, char letter, Direction ignore )
    {
        // Default value for result if no direction found
        Direction result = null;
        
        // Index for directions and while loop readability
        int dirIndex = 0;
        
        // Total number of directions to consider
        int numDirections = Direction.kDirections;
        
        // Boolean representing if the letter was found yet or not
        boolean found = false;
        
        // While looking through the directions and letter not found
        while( dirIndex < numDirections && !found )
        {
            // Get the direction at the current index
            Direction dir = Direction.values()[dirIndex];
            
            // If the current direction is not listed as ignore
            if( ignore == null || dir != ignore )
            {
                // Apply offset to row to find adjacent row
                int adjRow = row + dir.rowOffset();
                
                // If the adjacent row is not out of bounds
                if( adjRow >= 0 && adjRow < boardMatrix.length )
                {
                    // Apply offset to column to find adjacent column
                    int adjCol = col + dir.colOffset();
                    
                    // If the adjacent column is not out of bounds
                    if( adjCol >= 0 && adjCol < boardMatrix.length )
                    {
                        // If the adjacent letter is the target search letter
                        if( boardMatrix[adjRow][adjCol] == letter )
                        {
                            // Set result to the current direction
                            result = dir;
                            // Set found value to true
                            found = true;
                        }
                    }
                }
            }
            
            // Advance to the next direction
            dirIndex++;
        }
        
        return result;
    }
}
