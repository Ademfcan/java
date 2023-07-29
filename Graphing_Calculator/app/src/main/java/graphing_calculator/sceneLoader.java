package graphing_calculator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class sceneLoader {


    private static final String startUrl = "/FxmlFiles/StartScreenFxml.fxml";
    private static final String mainUrl = "/FxmlFiles/MainScreenFxml.fxml";


    private static Scene startScene;
    private static Scene mainScene;
    public MainScreenController main;
    private MyAnimationTimer myAnimationTimer;


    public sceneLoader() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(sceneLoader.class.getResource(startUrl));
            fxmlLoader.setControllerFactory(c -> new StartSceneController()); // Set controller factory
            Parent startRoot = fxmlLoader.load();
            startScene = new Scene(startRoot);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void changeScene(Scenes scene) {
        if (scene.equals(Scenes.Start)) {
            StartSceneController.mainStage.setScene(startScene);
            if (myAnimationTimer != null) {
                myAnimationTimer.stop();
            }
        } else if (scene.equals(Scenes.Main)) {
            try {

                FXMLLoader mainfxmlLoader = new FXMLLoader(sceneLoader.class.getResource(mainUrl));
                mainfxmlLoader.setControllerFactory(c -> SetMainController()); // Set controller factory
                Parent startRoot = mainfxmlLoader.load();
                mainScene = new Scene(startRoot);
                myAnimationTimer = new MyAnimationTimer();
                myAnimationTimer.start();


            } catch (IOException e) {
                e.printStackTrace();
            }

            StartSceneController.mainStage.setScene(mainScene);

        }
    }


    private MainScreenController SetMainController() {
        main = new MainScreenController();
        return main;
    }
}