package hangman;

import java.io.File;

import javax.imageio.ImageIO;

public class HangmanState{
        
    private static int triesLeft;
    private static int state;

    private static final File hangmanState1 = new File("C:\\Projs\\java\\Hangman\\hangman\\4.jpg")

    private static final File hangmanState2 = new File("C:\\Projs\\java\\Hangman\\hangman\\5.jpg");

    private static final File hangmanState3 = new File("C:\\Projs\\java\\Hangman\\hangman\\6.jpg");

    private static final File hangmanState4 = new File("C:\\Projs\\java\\Hangman\\hangman\\7.jpg");

    private static final File hangmanState5 = new File("C:\\Projs\\java\\Hangman\\hangman\\8.jpg");

    private static final File hangmanState6 = new File("C:\\Projs\\java\\Hangman\\hangman\\9.jpg");

    private static final File hangmanState7 = new File("C:\\Projs\\java\\Hangman\\hangman\\10.jpg\\");
    





    public HangmanState(){
            state = 6;
            triesLeft = 7;
    }
    public void reduceState(){
        state -=1;
        triesLeft -=1;
    }
    public String getAsciiState() {
        String[] hangmanStates = {hangmanState1, hangmanState2, hangmanState3, hangmanState4, hangmanState5, hangmanState6, hangmanState7};
        if (state >= 0 && state <= 6) {
            return hangmanStates[state];
        }
        return null;
    }
    public int getState(){
        return state;
    }
    public void reset(){
        state = 6;
        triesLeft = 7;
    }
    public int triesLeft(){
        return triesLeft;
    }
    
    
        
}
