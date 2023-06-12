public class factorial {
    public static void main(String[] args) {
        System.out.println(fac(5));
    }
    private static int fac(int n){
        if(n == 0){
            return 1;
        }
        return n * fac(n-1);
    }
    
}