import java.util.Scanner;

/**
 * Cipher encrypts and decrypts
 * 
 * Nelson Lin and Jeremy Ebneyamin
 * @version (a version number or a date)
 */
public class CipherRunner
{
   
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String input = "";   //decides encode or decode
        String message = ""; //message to decode or encode
        int shift = 0;
        
        do
        {
            System.out.print("Please enter E for encrypt or D for decrypt (Q to quit): ");
            input = in.next().toUpperCase();
            
            if(input.equals("E"))  //Encryption code
            {
                System.out.print("Please enter message to be encrypted: ");
                in.skip("\n");
                message = in.nextLine();
                
                while (true) {
                    try {
                        System.out.print("Please enter a shift factor (must be a number): ");
                        shift = in.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Not an integer or the number is too large. (Max: " + Integer.MAX_VALUE + ")");
                        in.next();
                    }
                }
                
                System.out.println(ShiftCipher.encrypt(message, shift));
            }
            else if (input.equals("D"))  //Decryption code
            {
                System.out.print("Please enter message to be decrypted: ");
                in.skip("\n");
                message = in.nextLine();
                
                while (true) {
                    try{
                        System.out.print("Please enter a shift factor (must be a number): ");
                        shift = in.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Not an integer or the number is too large. (Max: " + Integer.MAX_VALUE + ")");
                        in.next();
                    }
                }
                
                System.out.println(ShiftCipher.decrypt(message, shift));
            }
            else if(!input.equals("Q"))
            {
                System.out.println("You did not enter a correct input");
            }
        } while(in.hasNextLine() && !input.equals("Q"));
        in.close();
    } 
}
