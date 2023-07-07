package hangman_gui_new;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class EndScreenController implements Initializable {

    @FXML
    private Label EndMessage;

    @FXML
    private Label Difficulty;

    @FXML
    private Label CorrectWord;

    public void initialize(URL location, ResourceBundle resources) {

        // Perform initialization tasks
        Difficulty.setText("Difficulty: " + StartSceneController.diff.toString());
        CorrectWord.setText("Word: "+ hangman.goalWord);
        if(hangman.IsLost){
            EndMessage.setText("You Lost :(");
        }
        else{

            EndMessage.setText("You won in "  + Integer.toString(MainScreenController.TryCount) + " tries");

        }


    }



    @FXML
    private void QuitButton(ActionEvent event){
        System.exit(0);
    }

    @FXML
    private void RestartButton(ActionEvent event){
        MainScreenController.TryCount = 0;
        StartSceneController.eventHandler.changeScreen(Scenes.Start, StartSceneController.primaryStage);
    }
}