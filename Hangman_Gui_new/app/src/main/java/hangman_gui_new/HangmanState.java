package hangman_gui_new;

import javafx.scene.image.Image;

public class HangmanState{
        
    private static int triesLeft;
    private static int state;

    private static final Image hangmanState1 = new Image("/GameImages/Full_Done.png");

    private static final Image hangmanState2 = new Image("/GameImages/Full_5.png");

    private static final Image hangmanState3 = new Image("/GameImages/Full_4.jpg");

    private static final Image hangmanState4 = new Image("/GameImages/Full_3.jpg");

    private static final Image hangmanState5 = new Image("/GameImages/Full_2.jpg");

    private static final Image hangmanState6 = new Image("/GameImages/Full_1.png");

    private static final Image hangmanState7 = new Image("/GameImages/Full.png");
    





    public HangmanState(){
            state = 6;
            triesLeft = 6;
    }
    public boolean reduceState(){

        state -=1;
        triesLeft -=1;
        if(triesLeft<1){
            return true;
        }
        return false;
    }
    public Image getImageState() {
        Image[] hangmanStates = {hangmanState1, hangmanState2, hangmanState3, hangmanState4, hangmanState5, hangmanState6, hangmanState7};
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
