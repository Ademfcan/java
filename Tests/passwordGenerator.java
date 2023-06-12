
import java.time.Year;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class passwordGenerator {
    enum Strength{
        Hard,
        Medium,
        Easy



    }
    public static void main(String[] args) {
        System.out.println("This program Can rate your current password strength or create a new strong password.");
      
        if(input("Would you like to create a password?(Y/N)").toLowerCase().equals("y")){
            System.out.println("Running Create password \n");
            createPass();
        }
        else{
            System.out.println("Running Check Password \n");
            checkPass();
        }
       
        
       
    }

    private static Strength checkPass(){
        String currentPassword = input("What is the password you would like to check?");
        return Strength.Easy;
    }

    private static void createPass(){
        int passwordLength = Integer.parseInt(input("How many characters will your password be?"));
        char[] password = new char[passwordLength];
        for(int i = 0; i<passwordLength ;i++){
            int number1 = randomNumber(48, 57);
            int number2 = randomNumber(65, 90);
            int number3 = randomNumber(97, 122);
            int randomNum = randomNumber(1, 3);
            ;
            if(randomNum == 1){
                password[i] = ((char) number1);
            }
            else if(randomNum == 2){
                password[i] = ((char) number2);
            }
            else{
                password[i] = ((char) number3);
            }


            
            
            ;
            
            
        }
        System.out.println(new String(password));  
    }
    
    
    
    
    private static String input(String prompt){
        Scanner scan  = new Scanner(System.in);
        System.out.print(prompt + " : ");
        String response  = scan.nextLine();
        return response;
    }

    private static int randomNumber(int range1, int range2){
        int ans = ThreadLocalRandom.current().nextInt(range1,range2);
        return ans;
    }

    

}
