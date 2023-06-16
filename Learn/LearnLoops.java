public class LearnLoops {
    public static void main(String[] args) {
        int x = 0;

        // Won't enter here.
        while (x > 0)
        {
            System.out.println("while: " + x);
            x--;
        }

        do
        {
            System.out.println("do " + x);
            x--;
        }
        while (x > 0);

        int[] fibo = {1,1,2,3,5,8};

        for (int i=0;i<fibo.length;i++)
        {
            System.out.println(fibo[i]);
        }

        for (int val : fibo)
        {
            System.out.println(val);
        }
    }
}
