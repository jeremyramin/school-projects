/**
 * Enumeration class Direction
 * Represents an four-way directional compass system
 * ordered in a clockwise manner, starting with NORTH.
 * This is designed to make transversing a 2D array easier.
 * 
 * @author Jeremy Ebneyamin
 * @version 2015.4.22
 */
public enum Direction
{
    NORTH(-1, 0),
    EAST(0, 1),
    SOUTH(1, 0),
    WEST(0, -1);
    
    private int rowOffset;
    private int colOffset;
    public static final int kDirections = values().length;
    
    private Direction(int row, int col)
    {
        rowOffset = row;
        colOffset = col;
    }
    
    /** 
     * Returns the row offset of the direction.
     * This number will be in the range of -1 to 1 inclusive.
     */
    public int rowOffset()
    {
        return rowOffset;
    }
    
    /** 
     * Returns the column offset of the direction.
     * This number will be in the range of -1 to 1 inclusive.
     */
    public int colOffset()
    {
        return colOffset;
    }
    
    /**
     * Returns the opposite direction.
     */
    public Direction opposite()
    {
        return values()[(this.ordinal() + kDirections/2) % kDirections];
    }
    
    /**
     * Returns the next direction in clockwise order.
     */
    public Direction next()
    {
        return values()[(this.ordinal() + 1) % kDirections];
    }
}
