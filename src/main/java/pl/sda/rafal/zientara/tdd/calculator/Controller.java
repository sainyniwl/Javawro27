package pl.sda.rafal.zientara.tdd.calculator;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Controller {

    @FXML
    private TextField screen;

    private Operation currentOperation;
    private BigDecimal firstNumber;

    @FXML
    private void handleNumberPressed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj instanceof Button) {
            Button button = (Button) obj;
            String text = button.getText();
            screen.appendText(text);
        }
    }

    @FXML
    private void handlePlusPressed() {
        changeOperation(Operation.PLUS);
    }

    @FXML
    private void handleMinusPressed() {
        changeOperation(Operation.MINUS);
    }

    @FXML
    private void handleMultiplyPressed() {
        changeOperation(Operation.MULTIPLY);
    }

    @FXML
    private void handleDividePressed() {
        changeOperation(Operation.DIVIDE);
    }

    private void changeOperation(Operation operation) {
        currentOperation = operation;
        firstNumber = getNumberFromScreen();
        screen.clear();
    }

    @FXML
    private void handleResultPressed() {
        BigDecimal secondNumber = getNumberFromScreen();
        BigDecimal result = getResult(secondNumber);
        screen.setText(String.format("%f", result));
    }

    private BigDecimal getResult(BigDecimal secondNumber) {
        try {
            switch (currentOperation) {
                case PLUS:
                    return firstNumber.add(secondNumber);
                case MINUS:
                    return firstNumber.subtract(secondNumber);
                case DIVIDE:
                    return firstNumber.divide(secondNumber, RoundingMode.FLOOR);
                case MULTIPLY:
                    return firstNumber.multiply(secondNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Arithmetic Exception");
            alert.setHeaderText("Error!");
            alert.showAndWait();
        }

        return new BigDecimal(0);
    }

    private BigDecimal getNumberFromScreen() {
        String text = screen.getText();
        return new BigDecimal(text.replaceAll(",", "."));
    }
}
