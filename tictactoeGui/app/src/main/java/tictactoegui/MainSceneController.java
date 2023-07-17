package tictactoegui;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

;

public class MainSceneController implements Initializable {
    @FXML
    private Label topLabel;

    @FXML
    private Button button0;

    @FXML
    private StackPane StoragePane;

    @FXML
    private GridPane MainPane;

    @FXML
    private GridPane EndPane;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Label EndMessage;
    @FXML
    private Label Difficulty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputHandler.Start();
        topLabel.setText("Difficulty: " + StartSceneController.diff.toString());
        Button[] buttons = {button0,button1,button2,button3,button4,button5,button6,button7,button8};
        if(!StartSceneController.isPlayerFirst){
            if(!StartSceneController.diff.equals(tictactoegui.Difficulty.PvP)){
                int compIndex = inputHandler.FindComputerIndex();

                buttons[compIndex].setText("X");

                buttons[compIndex].setDisable(true);
                inputHandler.moves ++;
            }
        }

    }


    @FXML

    private void buttonClick(ActionEvent event) {

        Button[] buttons = {button0, button1, button2, button3, button4, button5, button6, button7, button8};

        Button clickedButton = (Button) event.getSource();
        inputHandler.logger.debug(clickedButton.toString());
        clickedButton.setText(inputHandler.AddInput(Integer.parseInt(clickedButton.getUserData().toString())));
        clickedButton.setDisable(true);





        PauseTransition endPause = new PauseTransition(Duration.seconds(1)); // 1-second delay
        endPause.setOnFinished(e -> {

            if(inputHandler.grid.isComplete() && !inputHandler.GameOver){
                inputHandler.GameOver = true;
                System.out.println("Checking for win");
                StoragePane.getChildren().setAll(MainPane,EndPane);
                if(inputHandler.grid.winnerIdent.equals("Draw")){
                    EndMessage.setText("Draw :(");
                }
                else{
                    EndMessage.setText("The winner is "+ inputHandler.grid.winnerIdent);
                }

                Difficulty.setText("Difficulty: " + StartSceneController.diff.toString());

            }



        });
        if(inputHandler.grid.winnerButtonIndex.size() == 3){
            for(int i : inputHandler.grid.winnerButtonIndex){
                buttons[i].setStyle("-fx-background-color: #43AA8B; -fx-pref-height: 122 ; -fx-pref-width: 122; -fx-border-color:  #2B2D42");
            }
        }

        if (!StartSceneController.diff.equals(tictactoegui.Difficulty.PvP) && !inputHandler.GameOver) {
            PauseTransition pause = new PauseTransition(Duration.seconds(.5)); // 1-second delay
            pause.setOnFinished(e -> {
                int compIndex = inputHandler.FindComputerIndex();
                buttons[compIndex].setText("X");
                buttons[compIndex].setDisable(true);
                inputHandler.moves++;
                endPause.play();

            });

            pause.play();

        }
        else{
            endPause.play();
        }
        //System.out.println("GameOver :" + inputHandler.GameOver);
        //System.out.println("Complete:" + inputHandler.grid.isComplete());
    }


    @FXML
    private void OnRestart(ActionEvent event){
        StartSceneController.loader.changeScene(Scenes.Start);
        StoragePane.getChildren().setAll(EndPane,MainPane);

    }

    @FXML
    private void OnQuit(ActionEvent event){
        StoragePane.getChildren().setAll(EndPane,MainPane);
        System.exit(0);
    }



}