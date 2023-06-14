import java.util.Scanner;

public class CmdCalculator{
    
    public static void main(String[] args) {
        System.out.println("Cmd Calculator\n The available functions are: Factoring A Quadratic Equation |");
        MathFunctions.solveQuadratic();
    }



    public static String input(String Input) {
        System.out.println(Input);
        Scanner checkline = new Scanner(System.in);
        String theinput = checkline.nextLine();
        return theinput;
    }
}