package connect4gui;


import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class GridStorage {
    // 6x7 grid x marks red circle O marks yellow circle.
    public String Winner;
    public String[][] grid = new String[6][7];
    public GridStorage(){
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = "_";
            }
        }
    }

    public void Add(int xIndex, int yIndex, String marker){
        grid[yIndex][xIndex] = marker;
    }

    public boolean isComplete() {
        // Check for horizontal wins
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (check4(grid[row][col], grid[row][col + 1], grid[row][col + 2], grid[row][col + 3])) {
                    return true;
                }
            }
        }

        // Check for vertical wins
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 3; row++) {
                if (check4(grid[row][col], grid[row + 1][col], grid[row + 2][col], grid[row + 3][col])) {
                    return true;
                }
            }
        }

        // Check for diagonal wins (top-left to bottom-right)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                if (check4(grid[row][col], grid[row + 1][col + 1], grid[row + 2][col + 2], grid[row + 3][col + 3])) {
                    return true;
                }
            }
        }

        // Check for diagonal wins (bottom-left to top-right)
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (check4(grid[row][col], grid[row - 1][col + 1], grid[row - 2][col + 2], grid[row - 3][col + 3])) {
                    return true;
                }
            }
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == "_"){
                    return false; // No win found
                }
            }
        }
        Winner = "Draw :(";
        return true; // No win found


    }

    private boolean check4(String a, String b, String c, String d){
        if (!a.equals("_") && a.equals(b) && b.equals(c) && c.equals(d)) {
            if(a.equals("X")){
                Winner = "Red";
            }
            else{
                Winner = "Yellow";
            }
            return true;
        }
        return false;
    }

}