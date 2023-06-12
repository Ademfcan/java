import java.math.BigInteger;
import java.util.Scanner;



public class PrimeNumberChecker {
    private static final BigInteger zero = new BigInteger("0");
    private static final BigInteger one = new BigInteger("1");
    private static final BigInteger two = new BigInteger("2");
    private static final BigInteger n = new BigInteger("2");
    public static void main(String[] args) {
        int limit = Integer.parseInt(input("How many digits would you like to go up to: "));
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger n = new BigInteger("2");
        System.out.println(n);
        while(Math.log(n.doubleValue()) < limit){
            n = power(2, n);
            n = n.subtract(one);
            System.out.println(n);     
        }

        
    }

    public static String input(String prompt){
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        String response = scan.nextLine();
        scan.close();
        return response;
    }

    public static BigInteger power(Integer base, BigInteger exponent){
        BigInteger baseB = new BigInteger(base.toString());
        BigInteger results = new BigInteger("1");
        do{
            exponent = exponent.subtract(one);
            results = results.multiply(baseB);
        }
        while(!exponent.equals(zero));
        return results;
        

    }
}
