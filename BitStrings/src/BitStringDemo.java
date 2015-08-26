public class BitStringDemo
{
    public static void main(String[] args)
    {
        System.out.println(no00String(8));
        System.out.println(no00String(7));
        System.out.println(no00String(6));
        System.out.println(no00String(5));
        System.out.println(no00String(4));
        System.out.println(no00String(3));
        System.out.println(no00String(2));
        System.out.println(no00String(1));
    }

    /**
     * Returns the number of Bit Strings of the given
     * length that do not contain two consecutive 0s.
     *
     * @param length length of the bit string
     * @return the number of possible bit strings that
     * do not contain two consecutive 0s
     */
    public static double no00String(int length)
    {
        return no00String(length, 0) + no00String(length, 1);
    }

    /**
     * Calculates the number of possible bit strings given a
     * length and an ending bit number (either 0 or 1).
     *
     * @param length the length of the bit string to calculate
     * @param end the value of the last bit in the string
     * @return the number of possible bit strings that
     * do not contain two consecutive 0s
     */
    private static double no00String(int length, int end)
    {
        if(length <= 1)
        {
            return 1.0;
        }
        else if(end == 0)
        {
            return no00String(length - 1, 1);
        }
        else if(end == 1)
        {
            return no00String(length - 1, 0) + no00String(length - 1, 1);
        }
        else
        {
            return 0;
        }
    }

}
