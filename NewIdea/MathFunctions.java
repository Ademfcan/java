import java.util.Scanner;

public class MathFunctions {
    private static int A = 0;
    private static int B = 0;
    private static int C = 0;
    private static double delta = 0;

    
    
    public static void solveQuadratic() {
        String mess = input("What are the A,B,C values?(Separate with comma): ");
        String[] abc = mess.split(",", 0);
        String complexDelta;
        A = Integer.parseInt(abc[0]);
        B = Integer.parseInt(abc[1]);
        C = Integer.parseInt(abc[2]);

        delta = (B*B)-4*A*C;

        if(delta < 0){
            delta *= -1;
            complexDelta  = "Sqrt(" +  delta + ") i";

        }
        else{
            complexDelta  = "Sqrt(" +  delta + ")";
        }
        String equation = -B +" +- " +  complexDelta + "/ "+ 2*A;
        System.out.println(equation);



        


        
    }


    public static String input(String Input) {
        System.out.print(Input);
        Scanner checkline = new Scanner(System.in);
        String theinput = checkline.nextLine();
        return theinput;
    }
}
