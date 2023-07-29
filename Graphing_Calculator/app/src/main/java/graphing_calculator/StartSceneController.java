package graphing_calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class StartSceneController extends Application implements Initializable {
    public static Stage mainStage;

    public static sceneLoader loader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void start(Stage primaryStage) {

        StartSceneController.mainStage = primaryStage;
        loader = new sceneLoader();


        try {


            loader.changeScene(Scenes.Start);
            primaryStage.setResizable(false);

            var icon = new Image("/Icons/graphingcalcIcon.png");

            primaryStage.setTitle("Graphing Calculator");
            primaryStage.getIcons().add(icon);


            primaryStage.show();
        } catch (Exception e) {
            // Print the stack trace of the original exception
            e.printStackTrace();
        }

    }

    @FXML
    private void start(ActionEvent event) {

        loader.changeScene(Scenes.Main);


    }


    @FXML
    private void onQuit(ActionEvent event) {
        System.exit(0);
    }
}