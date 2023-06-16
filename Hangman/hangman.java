import java.security.DigestInputStream;
import java.util.HashSet;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class hangman {
    private static WordBank words;
    private static String goalWord;
    private static wordCheck goal;
    private static HangmanState currentGame;
    private static String diff;
    private static String tryAgain;

    public static void main(String[] args) {
        System.out.println("Hangman: The objective of this game is correctly guess the given word");
        sleep.sleep(1);
        System.out.println("However, every time you miss a letter, your hangman looses a limb");
        sleep.sleep(1);
        System.out.println("Try to correcly guess the word before you die!!");
        sleep.sleep(1);
        while(Start());

    }

    private static boolean Start() {

        reset();

        

        sleep.sleep(2);
        System.out.println(
                "The hangman will start out with all of his limbs intact, try not to loose too many as Mr.Haang loves his limbs");
        System.out.println(currentGame.getAsciiState());
        sleep.sleep(2);
        System.out.println("The word you will have to guess has " + goal.getWordLength() + " letters.");
        sleep.sleep(2);
        takeGuesses();
        return finishOrRestart();

    }

    private static void takeGuesses(){
        HashSet<Character> guessedChars = new HashSet<Character>();

        // put comments
        while (currentGame.getState() != 0 && !goal.isComplete()) {
            sleep.sleep(1);
            String guess2 = inputSystem.input("What is your guess?");

            if (guessedChars.contains(guess2.charAt(0))) {
                System.out.println("You have already picked this!");

            } else {
                guessedChars.add(guess2.charAt(0));
                if (!goal.contains(guess2.charAt(0))) {

                    currentGame.reduceState();
                    System.out.println("OOpsie, thats wrong");
                    System.out.println("Answer: " + goal.getAns());
                    System.out.println(currentGame.getAsciiState());
                } else {

                    System.out.println("Correct!");
                    System.out.println(goal.getAns());
                    System.out.println(currentGame.getAsciiState());

                }
            }

        }
    }

    private static difficulty setDifficulty(boolean calledAgain) {
        difficulty gameDifficulty = difficulty.EASY;
        if (!calledAgain) {
            System.out.println("The 3 difficulty options are: EASY, MEDIUM, HARD");
        }
        sleep.sleep(1);
        diff = inputSystem.input("What difficulty level do you want?");
        if (diff.toLowerCase().equals("easy")) {
            gameDifficulty = difficulty.EASY;
        } else if (diff.toLowerCase().equals("medium")) {
            gameDifficulty = difficulty.MEDIUM;
        } else if (diff.toLowerCase().equals("hard")) {
            gameDifficulty = difficulty.HARD;
        } else {
            System.out.println("To specify difficulty please type in: easy, medium, or hard");
            setDifficulty(true);
        }
        sleep.sleep(1);
        System.out.printf("The hangman game with difficulty %s is ready\n", diff);
        return gameDifficulty;
    }

    private static boolean finishOrRestart() {
        if (goal.isComplete()) {
            System.out.println("Congradulations on correctly guessing the word " + goalWord + "!");
            System.out.println("You have now passed level " + diff.toLowerCase());
            tryAgain = inputSystem.input("Would you like to try again?(y/n)").toLowerCase();

        } else {
            System.out.println("Game Over:(");
            System.out.println("The word was " + goalWord);
            System.out.println("It seems that level " + diff.toLowerCase() + " was a bit of a challenge");
            tryAgain = inputSystem.input("Would you like to try again?(y/n)").toLowerCase();

        }
        return(tryAgain.toLowerCase().equals("y"));
    }
    private static void reset(){
        words = new WordBank(setDifficulty(false));

        goalWord = words.randomString();
        goal = new wordCheck("sleep");
        currentGame = new HangmanState();
        
    }

}