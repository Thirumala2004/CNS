import java.math.BigInteger; 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class SHA {
    public static String getSHA(String input){
    	try {
	    	MessageDigest hash = MessageDigest.getInstance("SHA-256");
		    byte[] messageDigest = hash.digest(input.getBytes());
    		BigInteger no = new BigInteger(1, messageDigest);
	    	String hashtext = no.toString(16);
		    while (hashtext.length() < 32) { 
			    hashtext = "0" + hashtext;
		    }
    		return hashtext;
	    }
	    catch(NoSuchAlgorithmException e){		
		    throw new RuntimeException(e);
	    }   
    }
    public static void main(String args[]) throws NoSuchAlgorithmException{
    	Scanner sc=new Scanner(System.in);
	    System.out.print("Enter the text to generate SHA-256 hash : ");
	    String s=sc.nextLine();
	    System.out.println("Generated  SHA-256 Hash is: " + getSHA(s));
    }
}
