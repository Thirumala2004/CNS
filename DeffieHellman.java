import java.util.Scanner;
public class DeffieHellman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a prime number (p): ");
        long p = scanner.nextLong();
        System.out.print("Enter the value of base (g): ");
        long g = scanner.nextLong();
        System.out.print("Enter Alice's private key: ");
        long a = scanner.nextLong();
        System.out.print("Enter Bob's private key: ");
        long b = scanner.nextLong();
        long A = (long) (Math.pow(g, a) % p);
        long B = (long) (Math.pow(g, b) % p);
        long sharedKeyAlice = (long) (Math.pow(B, a) % p);
        long sharedKeyBob = (long) (Math.pow(A, b) % p);
        System.out.println("Shared Key for Alice is : " + sharedKeyAlice);
        System.out.println("Shared Key for bob is : " + sharedKeyBob);
        scanner.close();
    }
}
