public final class ShiftCipher {

    private ShiftCipher() {};
    
    public static String encrypt(String message, int shift)
    {
	String newMessage = "";

	for(char ch : message.toCharArray())
	{
	    if(Character.isWhitespace(ch))
		newMessage += ch;
	    else
		newMessage += (char) (((int) ch) + shift);
	}

	return newMessage;
    }
    
    public static String decrypt(String message, int shift)
    {
	String oldMessage = "";
	
	for(char ch : message.toCharArray())
	{
	    if(Character.isWhitespace(ch))
		oldMessage += ch;
	    else
		oldMessage += (char) (((int) ch) - shift);
	}

	return oldMessage;
    }

}
