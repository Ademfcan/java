import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class WordCounter {
    public static void main(String[] args) {
        Dictionary dic  = new Dictionary();
        System.out.println("Word Counter");
        String readFile = input("Please provide the file you would like me to count");
        ArrayList<String> errors = new ArrayList<String>();
        int wordCount = 0;
        int errorCount  = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(readFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");

                for(String s :words){
                    if(s.length()<1){
                        continue;
                    }
                    try {
                        Integer.parseInt(s);
                        continue;
                    } catch (Exception e) {
                        
                    }
                    

                    if(dic.Check(s.toLowerCase()) == false){
                        errorCount +=1;
                        errors.add(s);
                    }
                }
                wordCount += words.length;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("You have " + wordCount + " words in your file, there are " + errorCount +" errors;");
        
        if(input("Would you like to see the errors (y/n)").toLowerCase().equals("y")){
            System.out.println("The errors are " + errors.toString());
        }
    }

    private static String input(String prompt) {
        Scanner read = new Scanner(System.in);
        System.out.println(prompt);
        String filePath = read.nextLine();
        return filePath;
    }
}
