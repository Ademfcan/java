package connect4gui;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;


public class StartSceneController extends Application implements Initializable {
    public static Stage mainStage;
    public static Difficulty diff;

    public static boolean isPlayerFirst;

    public static sceneLoader loader;

    @FXML
    private CheckBox First;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        First.selectedProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                isPlayerFirst = true;

            } else {
                isPlayerFirst = false;

            }
            //System.out.println(isPlayerFirst);
        });
    }

    @Override
    public void start(Stage primaryStage){

        StartSceneController.mainStage = primaryStage;
        loader = new sceneLoader();


        try {


            loader.changeScene(Scenes.Start);
            primaryStage.setResizable(false);
            var icon = new Image("/Icons/icon.jpg");

            primaryStage.setTitle("Connect 4");
            primaryStage.getIcons().add(icon);




            primaryStage.show();
        } catch (Exception e) {
            // Print the stack trace of the original exception
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        launch(args);
    }



    @FXML
    private void easyButton(ActionEvent event){
        diff = Difficulty.Easy;
        loader.changeScene(Scenes.Main);


    }

    @FXML
    private void mediumButton(ActionEvent event){
        diff = Difficulty.Medium;
        loader.changeScene(Scenes.Main);
    }

    @FXML
    private void hardButton(ActionEvent event){
        diff = Difficulty.Hard;
        loader.changeScene(Scenes.Main);
    }

    @FXML
    private void pvp(ActionEvent event){
        diff = Difficulty.PvP;
        loader.changeScene(Scenes.Main);
    }

    @FXML
    private void onQuit(ActionEvent event) {
        System.exit(0);
    }
}