public class HangmanState{
        
    
    private static int state;

    private static final String hangmanState1 = 
    "  +---+\n" +
    "  |   |\n" +
    "      |\n" +
    "      |\n" +
    "      |\n" +
    "      |\n" +
    "=========";

    private static final String hangmanState2 = 
    "  +---+\n" +
    "  |   |\n" +
    "  O   |\n" +
    "      |\n" +
    "      |\n" +
    "      |\n" +
    "=========";

    private static final String hangmanState3 =
    "  +---+\n" +
    "  |   |\n" +
    "  O   |\n" +
    "  |   |\n" +
    "      |\n" +
    "      |\n" +
    "=========";

    private static final String hangmanState4 = 
    "  +---+\n" +
    "  |   |\n" +
    "  O   |\n" +
    " /|   |\n" +
    "      |\n" +
    "      |\n" +
    "=========";

    private static final String hangmanState5 = 
    "  +---+\n" +
    "  |   |\n" +
    "  O   |\n" +
    " /|\\  |\n" +
    "      |\n" +
    "      |\n" +
    "=========";

    private static final String hangmanState6 = 
    "  +---+\n" +
    "  |   |\n" +
    "  O   |\n" +
    " /|\\  |\n" +
    " /    |\n" +
    "      |\n" +
    "=========";

    private static final String hangmanState7 = 
    "  +---+\n" +
    "  |   |\n" +
    "  O   |\n" +
    " /|\\  |\n" +
    " / \\  |\n" +
    "      |\n" +
    "=========";





    public HangmanState(){
            state = 6;
    }
    public void reduceState(){
        state -=1;
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
    
    
        
}
