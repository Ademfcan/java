package graphing_calculator;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.lang.reflect.GenericArrayType;

/**
 * @author Adem Firat Can
 */
public class Grapher {


    public static void Graph(String func, Line[] lines, Label[] PosXLabels, Label[] PosYLabels, Label[] NegXLabels, Label[] NegYLabels,int XSpacing, int YSpacing, Slider slid, TextField txt, AnchorPane pane) {
        double PosXval = 0;
        double NegXval = 0;

        double Ylimit = 300 * lines.length * slid.getValue();
        char[] wantedChars = {'x'};
        //System.out.println(txt.getText());
        if (!txt.getText().isBlank()) {

            try{
                // Getting positive X vals
                for (int i = lines.length/2+1; i < lines.length; i++) {
                    int ycoord = (int) evaluateExpression(txt.getText().toLowerCase(), "x", PosXval);
                    double Yval = -5*evaluateExpression(txt.getText().toLowerCase(), "x", PosXval);
                    lines[i].setLayoutY(Yval);


                    double D = Math.round(PosXval * 40);
                    //System.out.println(i);
                    //System.out.println("Xval:" + Xval);
                    //System.out.println("Yval: " + Yval);



                    PosXval += 1/XSpacing + slid.getValue();


                }
                // Getting Negative X vals
                for (int i = lines.length/2; i >=0; i--) {
                    int ycoord = (int) evaluateExpression(txt.getText().toLowerCase(), "x", NegXval);
                    double Yval =  -5*evaluateExpression(txt.getText().toLowerCase(), "x", NegXval);
                    lines[i].setLayoutY(Yval);


                    double D = Math.round(NegXval * 40);
                    //System.out.println(i);
                    //System.out.println("Xval:" + Xval);
                    //System.out.println("Yval: " + Yval);



                    NegXval -= 1/XSpacing + slid.getValue();


                }
                PosXval = 0;
                NegXval = 0;
            }
            catch (Exception e){

            }

        }

    }

    public static double evaluateExpression(String expression, String variableName, double variableValue) {
        Expression e = new ExpressionBuilder(expression)
                .variable(variableName)
                .build()
                .setVariable(variableName, variableValue);

        return e.evaluate();
    }


}
