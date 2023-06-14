import java.math.BigInteger;
import java.util.Scanner;

public class CollatzTest {
    private static final BigInteger zero = new BigInteger("0");
    private static final BigInteger one = new BigInteger("1");
    private static final BigInteger two = new BigInteger("2");
    private static final BigInteger three = new BigInteger("3");
    public static void main(String[] args) {
        BigInteger n = input("What number would you like to start with: ");
        while (!n.equals(one)) {
            System.out.println(n);
            if (n.mod(two).equals(zero)) {
                n = n.divide(two);
            } else {
                n = n.multiply(three).add(one); 
                
            }
        }
        System.out.println(n); // Print the final value of n (1)
    }

    public static BigInteger input(String prompt) {
        BigInteger number;
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        number = new BigInteger(scan.nextLine());
        scan.close();
        return number;
    }
}
