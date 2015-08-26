import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Kaboom is a game that resembles the popular game Minesweeper.
 * The object of the game is to find all ten hidden bombs in a
 * ten by ten grid by uncover all the squares that don't contain
 * a bomb. If you select a square containing a bomb, you lose.
 * 
 * @author Jeremy Ebneyamin
 * @version 2015.4.9
 */
public class KaboomGame
{
    /** The grid kSize of the game: kSize x kSize squares */
    protected static final int kSize = 10;
    /** The number of bombs in the game */
    protected static final int kBombs = 10;
    /** The number of flags toggled so far */
    private int flags;
    /** The number of revealed squares */
    private int revealed;
    /**
     * A two dimensional array, also known as a matrix, that represents the minefield.
     * A mine is denoted as 'X'.
     * Numbers denote the number of bombs in the adjacent squares
     */
    private char[][] mineField;
    /**
     * A two dimensional array, also known as a matrix, that holds the field
     * displayed to the user.
     */
    private char[][] visibleField;
    /**
     * An object of the Random class for randomizing the placement of the bombs.
     */
    private Random numGenerator;  //
    /**
     * An object of the Scanner class for taking in user input.
     */
    private Scanner scanner;
    
    /**
     * Default constructor for the KaboomGame class.
     * Gives values to variables and calls the field initializer function.
     */
    public KaboomGame()
    {
        flags = 0;
        mineField = new char[kSize][kSize];
        visibleField = new char[kSize][kSize];
        numGenerator = new Random();
        scanner = new Scanner(System.in);
        initializeFields();
    }
    
    /**
     * Initializes the values in the two dimensional character arrays.
     */
    private void initializeFields()
    {
        int count = 0;
        revealed = 0;
        
        // Fill the mineField array with 0's to signify no bombs yet
        for( char[] row : mineField )
        {
            Arrays.fill( row , ' ' );
        }
        
        // Fill the visibleField array with '-' to signify an uncovered spot
        for( char[] row : visibleField )
        {
            Arrays.fill( row , '-' );
        }
        
        // While count is less than the number of kBombs to place in the grid
        while( count < kBombs )
        {
            // Randomly generate a row and column
            int row = numGenerator.nextInt(kSize);
            int col = numGenerator.nextInt(kSize);
            
            // If the randomly generated square is not already a bomb ('X')
            if( mineField[row][col] != 'X')
            {
                mineField[row][col] = 'X'; // Set the square to be a bomb 
                incrementAdjacentSquares(row, col); // Increment the adjacent squares by 1
                count++; // Increment count by 1 to signify a bomb placed
            }
        }
    }
    
    /**
     * Increments the value in the squares adjacent to the given
     * row and column number.
     * 
     * @param row the index of the row in the grid
     * @param col the index of the col in the grid
     */
    private void incrementAdjacentSquares(int row, int col)
    {
        // Iterate over the rows surrounding the given square at row, col
        for ( int adjRow = row - 1 ; adjRow <= (row + 1) ; adjRow++ )
        {
            // Iterate over the columns surrounding the given square at row, col
            for ( int adjCol = col - 1 ; adjCol <= (col + 1) ; adjCol++ )
            {
                if( (adjRow >= 0 && adjCol >= 0) && (adjRow < kSize && adjCol < kSize) )
                {
                    // If the square being accesed is not a bomb
                    if( mineField[adjRow][adjCol] != 'X' )
                    {
                        if( Character.isDigit(mineField[adjRow][adjCol]) )
                        {
                            // Increment that square by 1
                            mineField[adjRow][adjCol] += 1;
                        }
                        else
                        {
                            mineField[adjRow][adjCol] = '1';
                        }
                    }
                }
            }
        }
    }
    
    private boolean isAlreadyRevealed(Coordinate coord)
    {
        return visibleField[coord.getRow()][coord.getCol()] != '-';
    }
    
    private void revealCorners(Coordinate coord)
    {
        boolean topLeft = isAlreadyRevealed( coord.relativeCoordinate( -1 , -1 ) );
        boolean topRight = isAlreadyRevealed( coord.relativeCoordinate( -1 , 1 ) );
        boolean bottomLeft = isAlreadyRevealed( coord.relativeCoordinate( 1 , -1 ) );
        boolean bottomRight = isAlreadyRevealed( coord.relativeCoordinate( 1 , 1 ) );
        
        if( topLeft )
        {
            revealCoordinate( coord.relativeCoordinate( -1 , 0 ));
            revealCoordinate( coord.relativeCoordinate( 0 , -1));
        }
        if( topRight )
        {
            revealCoordinate( coord.relativeCoordinate( -1 , 0 ));
            revealCoordinate( coord.relativeCoordinate( 0 , 1));
        }
        if( bottomLeft )
        {
            revealCoordinate( coord.relativeCoordinate( 1 , 0 ));
            revealCoordinate( coord.relativeCoordinate( 0 , -1));
        }
        if( bottomRight)
        {
            revealCoordinate( coord.relativeCoordinate( 1 , 0));
            revealCoordinate( coord.relativeCoordinate( 0 , 1));
        }
    }
    
    private boolean revealCoordinate(Coordinate coord)
    {
        boolean result = false;
        if( coord.isValidCoordinate() && !isAlreadyRevealed(coord) )
        {
            char val = mineField[coord.getRow()][coord.getCol()];
            if( val == 'X' )
            {
                result = true;
            }
            else if( Character.isDigit(val) )
            {
                visibleField[coord.getRow()][coord.getCol()] = val;
                revealed++;
            }
            else if( Character.isWhitespace(val) )
            {
                recursiveReveal(coord);
            }
        }
        return result;
    }
    
    private void recursiveReveal(Coordinate coord)
    {
        char val = mineField[coord.getRow()][coord.getCol()];
        if( !isAlreadyRevealed(coord) )
        {
            if( Character.isWhitespace(val) )
            {
                if( visibleField[coord.getRow()][coord.getCol()] == 'F' )
                {
                    flags--;
                }
                visibleField[coord.getRow()][coord.getCol()] = val;
                revealed++;
                recursiveReveal( coord.relativeCoordinate( -1, 0 ));
                recursiveReveal( coord.relativeCoordinate( 1, 0 ));
                recursiveReveal( coord.relativeCoordinate( 0, -1 ));
                recursiveReveal( coord.relativeCoordinate( 0, 1 ));
            }
            else
            {
                revealCoordinate(coord);
                revealCorners(coord);
            }
        }
    }
    
    private boolean isCleared()
    {
        return ((kSize * kSize) - kBombs) <= revealed;
    }
    
    public void play()
    {
        String input = "";
        /** A boolean representing the living status of the player */
        boolean dead = false;
        Coordinate coord;
        
        System.out.println("Designed by Jeremy Ebneyamin");
        System.out.println("CPE 103-01");
        System.out.println("April 14, 2015");
        System.out.println();
        System.out.println("The point of Kaboom is to uncover every square that is not a bomb.\n" +
                            "If you select a square that is a bomb then you lose.\n" + 
                            "Select a square by typing the Coordinate with the row letters and column numbers.\n" +
                            "For example: D5 signifies the square in row D and column 5.\n" +
                            "Putting a \'.\' before a Coordinate signfies that you want to put a flag at that Coordinate.\n" + 
                            "For example: .D5 signifies that a flag be placed at that Coordinate.");
        
        while(!dead && !input.equalsIgnoreCase("Q") && !isCleared())
        {
            System.out.println();
            printField();
            System.out.println();
            System.out.print("Enter a Coordinate or one of the options listed above: ");
            input = scanner.nextLine().toUpperCase();
            
            if(input.length() == 1)
            {
                if(input.equalsIgnoreCase("N"))
                {
                    initializeFields();
                }
                else if(input.equalsIgnoreCase("R"))
                {
                    // Fill the visibleField array with '-' to signify an uncovered spot
                    for( char[] row : visibleField )
                    {
                        Arrays.fill( row , '-' );
                    }
                }
                else if(input.equalsIgnoreCase("C"))
                {
                    revealField();
                    System.out.print("You lost. Press enter to restart.");
                    scanner.nextLine();
                    initializeFields();
                }
                else if(!input.equalsIgnoreCase("Q"))
                {
                    System.out.print("Error: Invalid input, please try again.");
                    scanner.nextLine();
                }
            }
            else if(input.length() == 2)
            {
                coord = new Coordinate(input);
                if( coord.isValidCoordinate() )
                {
                    if( isAlreadyRevealed( coord ) )
                    {
                        System.out.print("Error: You already revealed this Coordinate.");
                        scanner.nextLine();
                    }
                    else
                    {
                        if( revealCoordinate( coord ) )
                        {
                            dead = true;
                            mineField[coord.getRow()][coord.getCol()] = '*';
                        }
                    }
                }
                else
                {
                    System.out.print("Error: Invalid Coordinate, please try again.");
                    scanner.nextLine();
                }
            }
            else if(input.length() == 3)
            {
                if(input.charAt(0) == '.')
                {
                    coord = new Coordinate(input.substring(1));
                    if( coord.isValidCoordinate() )
                    {
                        if( visibleField[coord.getRow()][coord.getCol()] == 'F' )
                        {
                            visibleField[coord.getRow()][coord.getCol()] = '-';
                            flags--;
                        }
                        else if( !isAlreadyRevealed( coord ) )
                        {
                            visibleField[coord.getRow()][coord.getCol()] = 'F';
                            flags++;
                        }
                        else
                        {
                            System.out.print("Error: You cannot flag a spot that has been revealed.");
                            scanner.nextLine();
                        }
                    }
                    else
                    {
                        System.out.print("Error: Invalid Coordinate, please try again.");
                        scanner.nextLine();
                    }
                }
                else
                {
                    System.out.print("Error: Invalid input, please try again.");
                    scanner.nextLine();
                }
            }
            else
            {
                System.out.print("Error: Invalid input, please try again.");
                scanner.nextLine();
            }
        }
        
        if( dead )
        {
            System.out.println("You selected a bomb and died.");
            System.out.print("Press enter to reveal the board.");
            scanner.nextLine();
            revealField();
        }
        else if( isCleared() )
        {
            revealField();
            System.out.println("You win!");
        }
    }
    
    private String fieldToString(char[][] field)
    {
        // Number of flags in use at the moment
        String result = "Flags: " + flags + "/10\n";
        
        // First row of the displayed grid
        result += "     0  1  2  3  4  5  6  7  8  9".substring(0,3 * (kSize + 1));
        
        // First letter for the rows of the grid
        char rowLetter = 'A';
        
        // Iterate over the rows in the visibleField
        for( char[] row : field )
        {
            // Move to a new line and place the row letter
            result += "\n " + rowLetter++ + ":  ";
            // Iterate over the columns in each row
            for ( char col : row )
            {
                // Place the column values, separated by spaces
                result += col + "  ";
            }
        }
        
        // Put the separator line between the grid and the options
        result += "\n --------------------------------";
        
        // Place the options line at the bottom
        result += "\n  N)New R)Restart C)Cheat Q)Quit";
        
        return result;
    }
    
    public void printField()
    {
        System.out.println(fieldToString(visibleField));
    }
    
    public void revealField()
    {
        System.out.println(fieldToString(mineField));
    }
}
