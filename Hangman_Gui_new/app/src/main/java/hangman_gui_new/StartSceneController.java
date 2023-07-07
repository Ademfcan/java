package hangman_gui_new;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StartSceneController extends Application {

    public static difficulty diff;
    public static Stage primaryStage;




    public static EventHandler eventHandler;

    @Override
    public void start(Stage primaryStage) {
        diff = difficulty.Easy;
        StartSceneController.primaryStage = primaryStage;
        //System.out.println(primaryStage);

        try {
            var appIcon = new Image("images/HangmanICon.png");
            eventHandler = new EventHandler();
            eventHandler.changeScreen(Scenes.Start, primaryStage);

            primaryStage.getIcons().add(appIcon);

            primaryStage.setTitle("Hangman");



            primaryStage.show();
        } catch (Exception e) {
            // Print the stack trace of the original exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    @FXML
    private void easyButton(ActionEvent event) {
        diff = difficulty.Easy;
        eventHandler.setDifficulty(difficulty.Easy);
        eventHandler.changeScreen(Scenes.MainScreen, primaryStage);




    }

    @FXML
    private void mediumButton(ActionEvent event) {
        diff = difficulty.Medium;
        eventHandler.setDifficulty(difficulty.Medium);
        eventHandler.changeScreen(Scenes.MainScreen, primaryStage);





    }

    @FXML
    private void hardButton(ActionEvent event) {
        diff = difficulty.Hard;
        eventHandler.setDifficulty(difficulty.Hard);
        eventHandler.changeScreen(Scenes.MainScreen, primaryStage);





    }

    @FXML
    private void onQuit(ActionEvent event) {
        System.exit(0);
    }


}
