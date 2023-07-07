package hangman_gui_new;

public class hangman {
    public static WordBank words;
    public static String goalWord;
    public static wordCheck goal;
    public static HangmanState currentGame;

    public static Boolean isGameOver;

    public static Boolean IsLost;
    // true = ran out of tries(lost)   false = completed word(won)





    public static boolean takeGuesses(String guess2) {

        // put comments

                isGameOver = false;
                IsLost = false;


                if (!goal.contains(guess2.charAt(0))) {
                    // take away a life
                    if(currentGame.reduceState()){
                        isGameOver = true;
                        IsLost = true;
                        System.out.println("Game over " + isGameOver + " cause Lost? " + IsLost);
                        // game over but lost game
                    }


                    // change image on mainscreen
                    //System.out.println(currentGame.getFileState());
                    //returns false so the eventHandler knows to make the button red
                    return false;
                } else {
                    if(goal.isComplete()){
                        isGameOver = true;
                        IsLost = false;
                        System.out.println("Game over " + isGameOver + " cause Lost? " + IsLost);
                        // game over but won game
                    }
                    System.out.println(goal.isComplete());
                    // does not reduce lives
                    // updates image on screen
                    //System.out.println(currentGame.getFileState());
                    // returns true so eventHandler can change button color to green
                    return true;


                }



    }


    public static void StartGame(difficulty diff){
        currentGame = new HangmanState();
        words = new WordBank(diff);

        goalWord = words.randomString();
        goal = new wordCheck(goalWord);
        System.out.println(goalWord);

        
    }

}