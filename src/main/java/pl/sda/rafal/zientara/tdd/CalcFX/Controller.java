package pl.sda.rafal.zientara.tdd.CalcFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Controller {

    @FXML
    private TextField display;

    @FXML
    private void handlerNumericButton(ActionEvent event) {
        Object obj = event.getSource();
        if (obj instanceof Button) {
            Button button = (Button) obj;
            String text = button.getText();
            display.appendText(text);
        }
    }

    @FXML
    private void deleteLine() {
        display.clear();
    }


    @FXML
    private Operations currentOperation;
    private BigDecimal firstNumber;
    private BigDecimal result;

    @FXML
    private BigDecimal getNumberFromScreen() {
        String savedValue = display.getText();
        return new BigDecimal(savedValue.replace(",", "."));
    }

    @FXML
    private void changeOperation(Operations operation) {
        currentOperation = operation;
        firstNumber = getNumberFromScreen();
        display.clear();
    }

    @FXML
    private void handlePlusPressed() {
        changeOperation(Operations.PLUS);
    }

    @FXML
    private void handleMinusPressed() {
        changeOperation(Operations.MINUS);
    }

    @FXML
    private void handleMultiplyPressed() {
        changeOperation(Operations.MULTIPLY);
    }

    @FXML
    private void handleDividePressed() {
        changeOperation(Operations.DIVIDE);
    }

    @FXML
    private void handleCommaPressed(){
String text = display.getText();
if (!text.contains(","))
        display.appendText(",");
    }

//functional ....

    @FXML
    private void result() {
        BigDecimal secondNumber = getNumberFromScreen();
        result = getResult(secondNumber);
        display.setText(String.format("%f", result));
    }

    private BigDecimal getResult(BigDecimal secondNumber) {
        /*if (result.compareTo(BigDecimal.ZERO)!=0) {
            firstNumber=result;
        }
        else firstNumber = new BigDecimal(0);*/
        try {
            switch (currentOperation) {
                case PLUS:
                    return firstNumber.add(secondNumber);
                case MINUS:
                    return firstNumber.subtract(secondNumber);
                case MULTIPLY:
                    return firstNumber.multiply(secondNumber);
                case DIVIDE:
                    return firstNumber.divide(secondNumber, RoundingMode.HALF_DOWN);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ArithmeticException");
            alert.setContentText("NOPE");
            alert.showAndWait();
        }
        return new BigDecimal(0);
    }

}
