
/**
 * Object representation of the position in the Kaboom grid field.
 * 
 * @author Jeremy Ebneyamin
 * @version 2015.4.15
 */
public class Coordinate
{
    private int row;
    private int column;

    /**
     * Constructor for objects of class Coordinate
     * @param row the row number starting from 0 to KaboomGame.kSize - 1 (inclusive)
     * @param column the columnumn number starting from 0 to KaboomGame.kSize - 1 (inclusive)
     */
    public Coordinate(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
    
    /**
     * Constructor for objects of class Coordinate
     * @param row the row number starting from 0 to KaboomGame.kSize - 1 (inclusive)
     * @param column the columnumn number starting from 0 to KaboomGame.kSize - 1 (inclusive)
     */
    public Coordinate(String coord)
    {
        this.row = Character.toUpperCase(coord.charAt(0)) - 'A';
        this.column = coord.charAt(1) - '0';
    }

    public static Coordinate parseCoordinate(String coord)
    {
        return new Coordinate( (Character.toUpperCase(coord.charAt(0)) - 'A') , coord.charAt(1) - '0' );
    }
    
    public Coordinate relativeCoordinate(int deltaRow, int deltaCol)
    {
        Coordinate result = new Coordinate(row + deltaRow, column + deltaCol);
        
        if( !result.isValidCoordinate() )
        {
            result = new Coordinate(row, column);
        }
        
        return result;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return column;
    }
    
    public void setRow(int row)
    {
        this.row = row;
    }
    
    public void setCol(int column)
    {
        this.column = column;
    }
    
    public boolean isValidCoordinate()
    {
        boolean result = true;
        
        if( row < 0 || column < 0 )
        {
            result = false;
        }
        else if( row >= KaboomGame.kSize || column >= KaboomGame.kSize)
        {
            result = false;
        }
        
        return result;
    }
    
    public boolean equals(Object other)
    {
        if( other instanceof Coordinate )
        {
            return (row == ((Coordinate) other).row) && (column == ((Coordinate) other).column);
        }
        else
        {
            return false;
        }
    }
}
