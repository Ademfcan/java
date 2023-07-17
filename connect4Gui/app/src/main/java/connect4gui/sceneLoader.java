package connect4gui;


import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;

import java.io.IOException;

public class sceneLoader {


    private static final String startUrl = "/FxmlFiles/StartSceneFxml.fxml";
    private static final String mainUrl = "/FxmlFiles/MainScreenFxml.fxml";


    private static Scene startScene;
    private static Scene mainScene;


    public sceneLoader(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(sceneLoader.class.getResource(startUrl));
            fxmlLoader.setControllerFactory(c -> new StartSceneController()); // Set controller factory
            Parent startRoot = fxmlLoader.load();
            startScene = new Scene(startRoot);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void changeScene(Scenes scene){
        if(scene.equals(Scenes.Start)){
            StartSceneController.mainStage.setScene(startScene);
        }
        else if(scene.equals(Scenes.Main)){
            try {
                GameController.Start(StartSceneController.diff);
                FXMLLoader mainfxmlLoader = new FXMLLoader(sceneLoader.class.getResource(mainUrl));
                mainfxmlLoader.setControllerFactory(c -> new MainScreenController()); // Set controller factory
                Parent startRoot = mainfxmlLoader.load();
                mainScene = new Scene(startRoot);


            } catch (IOException e) {
                e.printStackTrace();
            }

            StartSceneController.mainStage.setScene(mainScene);

        }
    }
}