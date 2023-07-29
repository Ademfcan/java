package graphing_calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    public Line[] lines = new Line[400];
    int XSpacer = 33;
    int YSpacer = 26;
    @FXML
    private AnchorPane DrawingArea;

    @FXML
    private Button BackToHome;
    @FXML
    private Slider Scale;
    @FXML
    private TextField inputField;
    private final Label[] PosXlabels = new Label[5];
    private final Label[] PosYlabels = new Label[5];

    private final Label[] NegXlabels = new Label[5];
    private final Label[] NegYlabels = new Label[5];

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0; i < 400; i++) {

            Line line = new Line(i, 150, i, 150);
            line.setScaleX(1);
            line.setScaleY(1);
            DrawingArea.getChildren().add(line);
            lines[i] = line;
        }
        // setting positive x,y labels;
        for (int i = 0; i < 5; i++) {
            Label PosXlabel = new Label();
            Label PosYlabel = new Label();
            PosXlabel.setLayoutX(198 + (i+1) * XSpacer);
            PosXlabel.setLayoutY(126);
            PosXlabel.setText(Integer.toString(i+1));
            DrawingArea.getChildren().add(PosXlabel);
            PosXlabels[i] = PosXlabel;

            PosYlabel.setLayoutX(210);
            PosYlabel.setLayoutY(150 - (i+1) * YSpacer);
            PosYlabel.setText(Integer.toString(i+1));
            DrawingArea.getChildren().add(PosYlabel);
            PosYlabels[i] = PosYlabel;


        }

        // setting negative x,y labels;

        for(int i = 0; i<5;i++){
            Label NegXlabel = new Label();
            Label NegYlabel = new Label();
            NegXlabel.setLayoutX(198  - (i+1) * XSpacer);
            NegXlabel.setLayoutY(126);
            NegXlabel.setText(Integer.toString(i+1));
            DrawingArea.getChildren().add(NegXlabel);
            NegXlabels[i] = NegXlabel;

            NegYlabel.setLayoutX(210);
            NegYlabel.setLayoutY(150 + (i+1) * YSpacer);
            NegYlabel.setText(Integer.toString(i+1));
            DrawingArea.getChildren().add(NegYlabel);
            NegYlabels[i] = NegYlabel;
        }

    }


    public void updateScreen() {
        Grapher.Graph(" ", lines, PosXlabels, PosYlabels,NegXlabels, NegYlabels,XSpacer, YSpacer, Scale, inputField, DrawingArea);


    }

    @FXML
    private void onHome(ActionEvent event) {
        StartSceneController.loader.changeScene(Scenes.Start);
    }


}