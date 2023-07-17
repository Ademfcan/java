package tictactoegui;

import java.util.ArrayList;

public class gridStorage {
    public static final String CELL_AVAILABLE = "_";
    // storing the tictactoe squares as an array [0][1][2]
    //                                           [3][4][5]   the index refers to the square
    //                                           [6][7][8]   offset by -1 as arrays start from 0
    public ArrayList<String> availableIndexes;
    public String[] grid;

    public ArrayList<Integer> winnerButtonIndex;
    public String winnerIdent;
    public gridStorage(){
        winnerButtonIndex = new ArrayList<Integer>();
        grid = new String[9];
        // collectons.fill not working
        for(int i = 0; i<9 ;i++){
            grid[i] = CELL_AVAILABLE;
        }
        availableIndexes = new ArrayList<>(9);
        for(int i = 0; i<9 ;i++){
            availableIndexes.add(Integer.toString(i));
        }

    }

    public void mark(int index, String X_O,boolean isCheck){
        // puts an X or an O in the specified location

        //System.out.println(grid);
        grid[index] = X_O;
        if(!isCheck){
              System.out.println("grid = ");
            for(int i = 1;i<grid.length+1;i++){

                          System.out.print(grid[i-1]);
                        if(i%3 == 0){
                          System.out.println("");
                    }
              }
            availableIndexes.remove(Integer.toString(index));
            //System.out.println("Available Indexes: ");
            //System.out.println(availableIndexes.toString());
        }
    }

    public boolean isComplete(){
        // checks all combinations to see if anyone won


        if(check3(0,1,2) ||
            check3(3,4,5) ||
            check3(6,7,8) ||
            check3(0,3,6) ||
            check3(1,4,7) ||
            check3(2,5,8) ||
            check3(0,4,8) ||
            check3(2,4,6)){
            return true;
        }
        else{
            if(inputHandler.moves >8){

                winnerIdent = "Draw";
                return true;
            }
        }
        return false;

    }

    public void undoMark(int index){
        grid[index] = CELL_AVAILABLE;

    }

    // helper function to make checking 3 vars at once easier
    public boolean check3(int i, int j, int k){
        if(grid[i].equals(grid[j]) && grid[j].equals(grid[k]) && !grid[i].equals(CELL_AVAILABLE)){
            winnerIdent = grid[i];
            winnerButtonIndex.add(i);
            winnerButtonIndex.add(j);
            winnerButtonIndex.add(k);
            return true;
        }
        return false;



    }
}