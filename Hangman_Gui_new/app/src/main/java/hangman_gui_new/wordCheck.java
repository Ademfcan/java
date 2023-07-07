package hangman_gui_new;

public class wordCheck {
    private String word;
    private char[] answer;
    private char[] wordSplit;
    private boolean wordComplete;
    
    public wordCheck(String goalWord) {
        this.word = goalWord.toLowerCase();
        setup();
    }

    private void setup() {
        this.wordSplit = word.toCharArray();
        this.wordComplete = false;
        this.answer = new char[word.length()];
        for (int i = 0; i < this.answer.length; i++) {
            this.answer[i] = '_';


        }
    }
  
    public boolean contains(char c) {
    boolean charFound = false;
    for (int i = 0; i < this.wordSplit.length; i++) {
        if (this.wordSplit[i] == c) {
            if(i==0){
                this.answer[i] = String.valueOf(c).toUpperCase().charAt(0);
            }
            else{
                this.answer[i] = c;
            }
            charFound = true;
        }
    }
        System.out.println(answer);
    return charFound;
}

    public boolean isComplete(){
        for (char b : answer) {
            if (b == '_') {
                this.wordComplete = false;
                break;
                
            }
            else{
                this.wordComplete =true;
            }

            
        }
        return this.wordComplete;
    }


    public String getAns() {
        StringBuilder sb = new StringBuilder();
        for(char a : answer){
            sb.append(a + " ");
        }
        return sb.toString();
    }
    
    public int getWordLength() {
        return this.word.length();
    }
    
}
