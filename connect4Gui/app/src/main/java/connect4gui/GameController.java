package connect4gui;

public class GameController {
    public static CoordinateHandler coords;
    public static void Start(Difficulty diff){
        coords = new CoordinateHandler(diff);
    }


}
