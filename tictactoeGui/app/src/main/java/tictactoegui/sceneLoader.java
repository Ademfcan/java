package tictactoegui;


import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;

import java.io.IOException;

public class sceneLoader {


    private static final String startUrl = "/FxmlFIles/StartScreenTic.fxml";
    private static final String mainUrl = "/FxmlFIles/MainScreenTic.fxml";
    private static final String endUrl = "/FxmlFIles/EndScreenTic.fxml";


    private static Scene startScene;
    private static Scene mainScene;
    private static Scene endScene;


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
                FXMLLoader mainfxmlLoader = new FXMLLoader(sceneLoader.class.getResource(mainUrl));
                mainfxmlLoader.setControllerFactory(c -> new MainSceneController()); // Set controller factory
                Parent startRoot = mainfxmlLoader.load();
                mainScene = new Scene(startRoot);


            } catch (IOException e) {
                e.printStackTrace();
            }

            StartSceneController.mainStage.setScene(mainScene);

        } else if (scene.equals(Scenes.End)) {
            Parent endRoot = null;
            try {


                FXMLLoader endfxmlLoader = new FXMLLoader(sceneLoader.class.getResource(endUrl));
                endfxmlLoader.setControllerFactory(c -> new EndSceneController()); // Set controller factory
                endRoot = endfxmlLoader.load();
                endScene = new Scene(endRoot);




            } catch (IOException e) {
                e.printStackTrace();
            }

            ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), endRoot);
            scaleTransition.setFromX(0.0);
            scaleTransition.setToX(1.0);
            scaleTransition.setFromY(0.0);
            scaleTransition.setToY(1.0);
            StartSceneController.mainStage.setScene(endScene);
            scaleTransition.play();
        }
    }
}