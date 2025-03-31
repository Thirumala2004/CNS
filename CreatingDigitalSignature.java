import java.security.*;
import java.util.Scanner;
import java.util.Base64;
public class CreatingDigitalSignature {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a message to sign : ");
        String originalMessage = sc.nextLine();
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048); 
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();
        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privateKey);
        sign.update(originalMessage.getBytes());
        byte[] digitalSignature = sign.sign();
        String encodedSignature = Base64.getEncoder().encodeToString(digitalSignature);
        System.out.print("Generated Digital Signature : ");
        System.out.println(encodedSignature);
        System.out.print("Enter a message to verify : ");
        String verifyMessage = sc.nextLine();
        sc.close();
        Signature verifySign = Signature.getInstance("SHA256withDSA");
        verifySign.initVerify(publicKey);
        verifySign.update(verifyMessage.getBytes());
        boolean isVerified = verifySign.verify(digitalSignature);
        if (isVerified) {
            System.out.println("Signature verified successfully!");
        } else {
            System.out.println("Signature verification failed!");
        }
    }
}
