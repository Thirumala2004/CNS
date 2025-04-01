import java.util.Scanner;
public class RSA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two prime numbers: ");
        long p = scanner.nextLong(), q = scanner.nextLong();
        long n = p * q, phi = (p - 1) * (q - 1), e = 3;
        while (gcd(e, phi) != 1) 
           e += 2;
        long d = modInverse(e, phi);
        System.out.println("Public Key: (" + e + ", " + n + ")");
        System.out.println("Private Key: (" + d + ", " + n + ")");
        System.out.print("Enter message to encrypt: ");
        long message = scanner.nextLong(), encrypted = modPow(message, e, n);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + modPow(encrypted, d, n));
        scanner.close();
    }
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static long modInverse(long a, long m) {
        for (long x = 1; x < m; x++) 
            if ((a * x) % m == 1) 
                return x;
        return 1;
    } 
    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1)  
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}
