package wordcountergui;



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dictionary
{
    String[] words = new String[112282];
    String dicLocation = Dictionary.class.getResource("/FxmlFiles/dic.txt").getPath();
    public Dictionary(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(dicLocation));
            String nextLine = reader.readLine();
            int index = 0;
            while(nextLine != null){
                words[index] = nextLine.toLowerCase();
                nextLine = reader.readLine();
                index ++;
            }
            System.out.println("Done");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean CheckIfContains(String word){

        while(word.length() > 0 && (CheckChars(word.charAt(word.length()-1)))){
            word = word.substring(0,word.length()-1);
        }
        while(word.length() > 0 && CheckChars(word.charAt(0))){
            word = word.substring(1);
        }

        String finalWord = word.toLowerCase();

        List<String> words1 = Arrays.stream(words)
                                .filter(p -> p!= null)
                                .filter(p -> p.equals(finalWord))
                                .collect(Collectors.toList());
        return words1.size() > 0;
    }

    private boolean CheckChars(char c){
        return (c == ',' || c == '.' ||
                c == '?' || c == ')' ||
                c == '(' || c == '!' ||
                c == '"' || c == ':' ||
                c == ';');


    }
}
