import java.math.BigInteger; 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class MD5{
    public static String getMd5(String input){
	    try {
	    	MessageDigest md = MessageDigest.getInstance("MD5");
    		    byte[] messageDigest = md.digest(input.getBytes());
	    	BigInteger no = new BigInteger(1, messageDigest);
    		String hashtext = no.toString(16);
		    while (hashtext.length() < 32) { 
	    		hashtext = "0" + hashtext;
    		}
		    return hashtext;
	    }
    	catch (NoSuchAlgorithmException e) {
		    throw new RuntimeException(e);
	    }
    }
    public static void main(String args[]) throws NoSuchAlgorithmException
    {
    	Scanner sc =new Scanner(System.in);
	    System.out.print("Enter the text to generate MD5 hash : ");
    	String s=sc.nextLine();
	    System.out.println("Generated MD5 hash  is: " + getMd5(s));
    }
}
