import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class WordCounter {
    public static void main(String[] args) {
        // Author: Adem Can
        
        Dictionary dic = new Dictionary(); // Create a dictionary object
        System.out.println("Word Counter");
        String readFile = input("Please provide the file you would like me to count"); // Prompt user for file name
        ArrayList<String> errors = new ArrayList<String>(); // Create an ArrayList to store errors
        int wordCount = 0; // Variable to keep track of word count
        int errorCount  = 0; // Variable to keep track of error count
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(readFile)); // Open the file for reading
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" "); // Split the line into an array of words
                
                for (String s : words) {
                    if (s.length() < 1) {
                        continue; // Skip empty words
                    }
                    
                    try {
                        Integer.parseInt(s);
                        continue; // Skip words that can be parsed as integers
                    } catch (Exception e) {
                        // Word is not an integer
                    }
                    
                    if (dic.Check(s.toLowerCase()) == false) {
                        errorCount += 1; // Increment error count
                        errors.add(s); // Add the invalid word to the errors list
                    }
                }
                
                wordCount += words.length; // Increment word count by the number of words in the line
            }
            
            reader.close(); // Close the file reader
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur during file reading
        }
        
        System.out.println("You have " + wordCount + " words in your file, there are " + errorCount + " errors;");
        
        if (input("Would you like to see the errors (y/n)").toLowerCase().equals("y")) {
            System.out.println("The errors are " + errors.toString());
        }
    }

    // Prompt the user for input
    private static String input(String prompt) {
        Scanner read = new Scanner(System.in);
        System.out.println(prompt);
        String filePath = read.nextLine();
        return filePath;
    }
}
