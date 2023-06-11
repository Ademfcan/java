import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
public class Dictionary {
    private static HashSet<String> commonWords;
    private static HashSet<Character> punctuations;
    public  Dictionary(){
        String file  = "C:\\Projs\\Java\\WordCounter\\american-english";
        commonWords = new HashSet<>();
        punctuations = new HashSet<>();
        punctuations.add(';');
        punctuations.add(':');
        punctuations.add(',');
        punctuations.add('.');
        punctuations.add('?');
        punctuations.add('!');
        
        

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                commonWords.add(line.toLowerCase());
            }


        } catch (Exception e) {
            
            System.out.println(e.getStackTrace().toString());
        }
        
    }

    public boolean Check(String word){
        return commonWords.contains(word) || 
               (punctuations.contains(word.charAt(word.length()-1)) &&
                commonWords.contains(word.substring(0, word.length()-1))
               );
       
       
    }

    



}
