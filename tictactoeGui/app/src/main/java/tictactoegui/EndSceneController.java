package tictactoegui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class EndSceneController implements Initializable {
    @FXML
    private Label EndMessage;
    @FXML
    private Label Difficulty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(inputHandler.grid.winnerIdent.equals("Draw")){
            EndMessage.setText("Draw :(");
        }
        else{
            EndMessage.setText("The winner is "+ inputHandler.grid.winnerIdent);
        }

        Difficulty.setText("Difficulty: " + StartSceneController.diff.toString());
    }

    @FXML
    private void OnRestart(ActionEvent event){
        StartSceneController.loader.changeScene(Scenes.Start);

    }

    @FXML
    private void OnQuit(ActionEvent event){
        System.exit(0);
    }
}