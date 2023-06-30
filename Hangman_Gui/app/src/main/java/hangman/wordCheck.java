package hangman;

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
            this.answer[i] = c;
            charFound = true;
        }
    }
    return charFound;
}

    public boolean isComplete(){
        for (char b : answer) {
            if (b == '_') {
                this.wordComplete = false;
                break;
                
            }
            
        }
        return this.wordComplete;
    }


    public String getAns() {
        return new String(answer);
    }
    
    public int getWordLength() {
        return this.word.length();
    }
    
}
