package tictactoegui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class inputHandler {

    // if pvp aka 2 player than store whose turn it is to make x or o
    public static boolean GameOver;
    public static int moves;
    public static boolean isSecondPlayer;


    public static gridStorage grid;

    public static final Logger logger = LoggerFactory.getLogger(inputHandler.class);
    
    private static Random random;
    public static void Start(){
        GameOver = false;
        logger.debug("Enter Start()");
        random = new Random();
        GameOver = false;
        grid = new gridStorage();
        isSecondPlayer = false;
        moves = 0;
        logger.debug("Exiting Start()");
    }

    public static String AddInput(int index){
       if(!GameOver){
           if(StartSceneController.diff.equals(Difficulty.PvP)){
               System.out.println(isSecondPlayer);
               if(!isSecondPlayer){
                   grid.mark(index, "O",false);
                   isSecondPlayer = true;
                   moves++;

                   return "O";
               }
               else{
                   grid.mark(index, "X",false);
                   isSecondPlayer = false;
                   moves++;
                   return"X";

               }

           }
           else{
               grid.mark(index, "O",false);

               moves++;

               return "O";

           }
       }
       return " ";
    }
    // storing the tictactoe squares as an array [0][1][2]
    //                                           [3][4][5]   the index refers to the square
    //                                           [6][7][8]   offset by -1 as arrays start from 0
    public static int FindComputerIndex(){


        if(StartSceneController.diff.equals(Difficulty.Easy)){
            int rand =  RandomIndex();
            return rand;
        }
        if(StartSceneController.diff.equals(Difficulty.Medium)){
            boolean betterMove = false;
            int betterIndex = 0;

            for(String s : grid.availableIndexes){
                int currentIndex = Integer.parseInt(s);
                // checking if any moves will give the computer a win
                grid.mark(currentIndex,"X",true);

                if(grid.isComplete()){
                    betterMove = true;

                    betterIndex = currentIndex;
                    break;

                }
                grid.undoMark(currentIndex);

            }
            if(betterMove){
                System.out.println("Computer found index: " + betterIndex);
                grid.mark(betterIndex,"X",false);
                return betterIndex;
            }
            else{
                int rand = RandomIndex();
                grid.mark(rand,"X",false);
                return rand;

            }

        }
        return 0;

    }


    private static int RandomIndex(){
        if(grid.isComplete()){
            return 0;
        }
        int randomInt = random.nextInt(0,inputHandler.grid.availableIndexes.size());
        int gridIndex = Integer.parseInt(inputHandler.grid.availableIndexes.get(randomInt));
        //System.out.println("Random guess: " + randomInt);
        System.out.println("Random GridIndex:  " + gridIndex);
        grid.mark(gridIndex, "x",false);
        return gridIndex;
    }

}