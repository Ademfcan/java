package connect4gui;


public class CoordinateHandler {
    private int[] xCoords = new int[7];
    private int[] yCoords = new int[6];
    private Difficulty diff;

    public GridStorage grid;


    public CoordinateHandler(Difficulty diff){
        Initialize();
        grid = new GridStorage();
        this.diff = diff;

    }

    private void Initialize(){
        // grid info 6X7 grid [0][1][2][4][5][6][7]
        //                    [1][ ][ ][ ][ ][ ][ ]
        //                    [2][ ][ ][ ][ ][ ][ ]
        //                    [3][ ][ ][ ][ ][ ][ ]
        //                    [4][ ][ ][ ][ ][ ][ ]
        //                    [5][ ][ ][X][ ][ ][ ]
        // sets the exact coordinates for the grid Ex:: the coordinate [4][5] aka (4+1 -->5, 5+1 -->6) is the X
        // the exact coordinates for this X on the screen is 361,370 as shown below


        xCoords[0] =117;
        xCoords[1] =178;
        xCoords[2] =239;
        xCoords[3] =300;
        xCoords[4] =361;
        xCoords[5] =422;
        xCoords[6] =483;
        yCoords[0] = 61;
        yCoords[1] = 122;
        yCoords[2] = 183;
        yCoords[3] = 245;
        yCoords[4] = 307;
        yCoords[5] = 370;

    }

    public XYCoordinate getPreciseCoords(int x, int y){
        // for each square on the grid there are precise coordinates that the coordinateHandlerGets
        return new XYCoordinate(xCoords[x],yCoords[y]);
    }

    public int userInput(int row, String marker){
        int yPos = 10;
        for(int i = 5; i>=0 ; i--){
            if(grid.grid[i][row] == "_"){
                yPos = i;
                break;
            }
        }
        if(yPos <6){
            grid.Add(row,yPos,marker);

        }
        return yPos;


    }

    public void PrintGrid(){
        for (int row = 0; row < grid.grid.length; row++) {
            for (int col = 0; col < grid.grid[row].length; col++) {
                System.out.print(grid.grid[row][col]);
            }
            System.out.println("");
            // Print a line to separate each row for a better visualization
            System.out.println("");
        }
    }
}