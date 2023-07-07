package hangman_gui_new;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

enum Scenes {
    Start,
    MainScreen,
    GameOver
}

public class EventHandler {
    private difficulty diff;
    private Scene mainScene;
    private Scene startScene;

    private Scene EndScene;




    public EventHandler() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXMLFiles/startScreen.fxml"));
            fxmlLoader.setControllerFactory(c -> new StartSceneController()); // Set controller factory
            Parent startRoot = fxmlLoader.load();
            startScene = new Scene(startRoot);


        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public void changeScreen(Scenes state, Stage currentStage) {

        if (currentStage == null) {
            System.out.println("NullStage");
        }
        else {
            if (state.equals(Scenes.Start)) {
                currentStage.setScene(startScene);
                currentStage.setResizable(false);

            }
            else if (state.equals(Scenes.MainScreen)) {

                try {
                    // load the scene if first time
                    FXMLLoader MainfxmlLoader = new FXMLLoader(getClass().getResource("/FXMLFiles/MainScreen.fxml"));
                    MainfxmlLoader.setControllerFactory(c -> new MainScreenController()); // Set controller factory
                    Parent mainRoot = MainfxmlLoader.load();
                    mainScene = new Scene(mainRoot);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                currentStage.setScene(mainScene);



            }
            else if (state.equals(Scenes.GameOver)) {

                    try {
                        // if first time loading end scene load
                        FXMLLoader EndfxmlLoader = new FXMLLoader(getClass().getResource("/FXMLFiles/EndScreen.fxml"));
                        EndfxmlLoader.setControllerFactory(c -> new EndScreenController()); // Set controller factory
                        Parent endRoot = EndfxmlLoader.load();
                        EndScene = new Scene(endRoot);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                currentStage.setScene(EndScene);

            }
        }
    }

    public boolean makeGuess(String guess) {
        return hangman.takeGuesses((guess));
    }

    public void setDifficulty(difficulty dif) {
        diff = dif;
    }

    public difficulty getDifficulty() {
        return diff;
    }
}
