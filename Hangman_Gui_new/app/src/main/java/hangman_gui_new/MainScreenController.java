package hangman_gui_new;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.net.URL;

import java.util.ResourceBundle;

public class MainScreenController implements Initializable{
    @FXML
    private Label Difficulty;
    @FXML
    private Label LivesLeft;
    @FXML
    private Label WordState;
    @FXML
    private ImageView GameImage;

    public static int TryCount;
    public MainScreenController(){

    }

    public void initialize(URL location, ResourceBundle resources) {
        // Perform initialization tasks

        hangman.StartGame(StartSceneController.diff);
        Difficulty.setText("Difficulty: " + StartSceneController.diff.toString());
        LivesLeft.setText("Lives left: " + "6");
        WordState.setText(hangman.goal.getAns());
        GameImage.setImage(hangman.currentGame.getImageState());

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        System.out.println(clickedButton.getUserData().toString());

        if (StartSceneController.eventHandler.makeGuess(clickedButton.getUserData().toString().toLowerCase())) {
            clickedButton.setOpacity(0.5);
            clickedButton.setDisable(true);
            clickedButton.setStyle("-fx-background-color: #A8C686; -fx-pref-width: 50.0;");

        } else {
            clickedButton.setOpacity(0.5);
            clickedButton.setDisable(true);
            clickedButton.setStyle("-fx-background-color: #A4031F; -fx-pref-width: 50.0;");
        }
        if(hangman.isGameOver){
            System.out.println("done");
            System.out.println(StartSceneController.primaryStage);
            StartSceneController.eventHandler.changeScreen(Scenes.GameOver, StartSceneController.primaryStage);
        }
        LivesLeft.setText("Lives left: " + Integer.toString(hangman.currentGame.triesLeft()));
        WordState.setText(hangman.goal.getAns());
        GameImage.setImage(hangman.currentGame.getImageState());
        TryCount +=1;

    }



}
