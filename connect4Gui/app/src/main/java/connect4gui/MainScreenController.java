package connect4gui;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    private Label EndMessage;

    @FXML
    private GridPane MainPane;

    @FXML
    private GridPane EndPane;

    @FXML
    private StackPane StoragePane;
    @FXML
    private AnchorPane CircleShower;

    @FXML
    private Label topLabel;

    @FXML
    private Label Difficulty;

    @FXML
    private Circle TurnCircle;

    boolean IsRed;

    boolean GameOver;


    Color red = new Color(1,0,0,1);
    Color blue = new Color(1,1,0,1);

    Color currentColor;
    String colorMarker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IsRed = true;
        currentColor = red;
        colorMarker = "X";
        TurnCircle.setFill(currentColor);
        topLabel.setText(StartSceneController.diff.toString());
        Difficulty.setText(StartSceneController.diff.toString());
        CircleShower.setMouseTransparent(true);
    }

    @FXML
    private void OnQuit(ActionEvent event){
        System.exit(0);
    }
    @FXML
    private void OnRestart(ActionEvent event){
        StartSceneController.loader.changeScene(Scenes.Start);
    }

    @FXML
    private void ButtonClick(ActionEvent event){
        if(!GameOver){
            Button b = (Button) event.getSource();
            int rowClicked = Integer.parseInt(b.getUserData().toString());
            int ypos =  GameController.coords.userInput(rowClicked, colorMarker);
            System.out.println("Clicked");
            if(ypos <6){

                XYCoordinate TopCircleCoords  = GameController.coords.getPreciseCoords(rowClicked,0);
                XYCoordinate CurrentCircleCoords  = GameController.coords.getPreciseCoords(rowClicked,ypos);

                Line path = new Line(TopCircleCoords.Xcoord,-40, CurrentCircleCoords.Xcoord, CurrentCircleCoords.Ycoord);

                Circle moved = new Circle();

                moved.setRadius(25);
                moved.setFill(currentColor);


                System.out.println(TopCircleCoords.Xcoord);
                CircleShower.getChildren().add(moved);

                // Create the PathTransition and set its properties



                PathTransition transition = new PathTransition(Duration.seconds(1), path, moved);
                transition.setCycleCount(1); // Play the transition only once
                transition.setAutoReverse(false); // Don't reverse the animation
                transition.setOnFinished(event1 -> {
                    // Optionally, you can remove the circle from the AnchorPane after the animation
                    System.out.println("Done");
                });
                transition.play();

                if(IsRed){
                    IsRed = false;
                    currentColor = blue;
                    colorMarker = "O";
                }
                else{
                    IsRed = true;
                    currentColor = red;
                    colorMarker = "X";
                }


            }
        }
        System.out.println("Current board = ");
        GameController.coords.PrintGrid();
        if(GameController.coords.grid.isComplete()){
            GameOver = true;
            if(GameController.coords.grid.Winner.equals("Draw :(")){
                EndMessage.setText(GameController.coords.grid.Winner + " better luck next time");

            }
            else{
                EndMessage.setText(GameController.coords.grid.Winner + " is the Winner!");

            }


            StoragePane.getChildren().setAll(MainPane,CircleShower,EndPane);

        }

        if(!GameOver){
            TurnCircle.setFill(currentColor);
        }


    }
}