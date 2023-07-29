
package wordcountergui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    private final String mainFxml = "/FxmlFiles/MainScreen.fxml";


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(mainFxml));
        loader.setControllerFactory(c -> new MainSceneController()); // Set controller factory
        Parent startRoot = loader.load();
        Scene startScene = new Scene(startRoot);



        try {
            var appIcon = new Image("/Icons/w.png");
            primaryStage.setScene(startScene);
            primaryStage.getIcons().add(appIcon);





            primaryStage.setTitle("Word Counter");



            primaryStage.show();
        } catch (Exception e) {
            // Print the stack trace of the original exception
            e.printStackTrace();
        }

    }
}
