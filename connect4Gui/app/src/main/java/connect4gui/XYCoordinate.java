package connect4gui;

public class XYCoordinate {
    public int Xcoord;
    public int Ycoord;

    public XYCoordinate(int X, int Y){
        Xcoord = X;
        Ycoord = Y;
    }

    public int getX(){
        return Xcoord;
    }

    public int getY(){
        return Ycoord;
    }

    public void PrintCoords(){
        System.out.println("X coordinate: " + Xcoord + "\n Y coordinate: " + Ycoord);
    }
}