package wordcountergui;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;


import java.awt.*;
import java.net.URL;

import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainSceneController implements Initializable {

    private Dictionary dic;

    @FXML
    private TextArea WordInputArea;

    @FXML
    private TextArea ErrorArea;

    @FXML
    private Label ErrorLabel;
    @FXML
    private Label WordLabel;

    @FXML
    private Label PageLabel;

    int CaretPosition;


    private LinkedList<String> errors;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errors = new LinkedList<String>();
        dic = new Dictionary();

        WordInputArea.setStyle("-fx-control-inner-background: #1B263B; -fx-prompt-text-fill: #E0E1DD; -fx-text-fill: #E0E1DD  ");
        ErrorArea.setStyle("-fx-control-inner-background: #1B263B ; -fx-prompt-text-fill: #E0E1DD ; -fx-text-fill: #E0E1DD ");
        WordInputArea.textProperty().addListener((observable, oldValue, newValue) -> {
            OnTextUpdate(newValue);
            CaretPosition =  WordInputArea.getCaretPosition();
        });
    }


    private void OnTextUpdate(String value){
        PauseTransition bigPause = new PauseTransition(Duration.seconds(1));
        bigPause.setOnFinished(e ->{
            int StartIndex = value.lastIndexOf(' ', CaretPosition-1)+1;
            int EndIndex = value.indexOf(' ', CaretPosition);
            if (EndIndex == -1) {
                EndIndex = value.length();
            }
            String excludedWord = WordInputArea.getText(StartIndex,EndIndex);
            System.out.println("Word selected: " + excludedWord);
            //System.out.println("Start Index = " + StartIndex);
            //System.out.println("End index = " + EndIndex);
            errors.clear();
            if(value.length()>=1){
                Pattern pattern = Pattern.compile(" ");


                Stream<String> errorStream = pattern.splitAsStream(value).filter(word -> !dic.CheckIfContains(word));
                Long ErrCount = pattern.splitAsStream(value)
                        .filter(word -> !dic.CheckIfContains(word))
                        .filter(word -> !word.equals(excludedWord)).count();
                errorStream.forEach(word -> errors.add(word));

                Stream<String> correctWordStream = pattern.splitAsStream(value).filter(word -> dic.CheckIfContains(word));

                Long WordCount = correctWordStream.count();
                WordLabel.setText(WordCount.toString());
                ErrorLabel.setText(ErrCount.toString());
                ErrorArea.setText(errors.toString());
            }
            System.out.println("OnTextUpdate is called");

        });// 1-second delay
        bigPause.play();

    }


}
