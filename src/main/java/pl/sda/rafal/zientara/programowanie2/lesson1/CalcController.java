package pl.sda.rafal.zientara.programowanie2.lesson1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcController {

    @FXML
    private TextField screen; // fx:id
    private Operation currentOperation;
    private BigDecimal firstNumber;
    private BigDecimal secondNumber;

    @FXML
    public void handlePlusPressed() {
        changeOperation(Operation.PLUS);
    }

    @FXML
    public void handleDividePressed() {
        changeOperation(Operation.DIVIDE);
    }

    @FXML
    public void handleMultiplyPressed() {
        changeOperation(Operation.MULTIPLY);
    }

    @FXML
    public void handleMinusPressed() {
        changeOperation(Operation.MINUS);
    }

    @FXML
    public void handleResultPressed() {
        secondNumber = getNumberFromScreen();
        BigDecimal result = getResult();
        screen.setText(String.format("%f", result));
    }

    private BigDecimal getResult() {
        try {
            switch (currentOperation) {
                case PLUS:
                    return firstNumber.add(secondNumber);
                case MINUS:
                    return firstNumber.subtract(secondNumber);
                case DIVIDE:
                    return firstNumber.divide(secondNumber, RoundingMode.valueOf(100500));
                case MULTIPLY:
                    return firstNumber.multiply(secondNumber);

            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ArithmeticException");
            alert.setContentText("nope");
            alert.showAndWait();
        }
        return new BigDecimal(0);
    }

    @FXML
    public void handleClearPressed() {
        screen.clear();
    }

    @FXML
    public void handleComaPressed() {
        String text = screen.getText();
        if (!text.contains(".")) {
            screen.appendText(".");
        }

    }


    @FXML
    public void handleNumberPressed(ActionEvent event) {
        Object object = event.getSource();
        if (object instanceof Button) {
            Button button = (Button) object;
            String text = button.getText();
            screen.appendText(text);
        }
    }

    private void changeOperation(Operation operation) {
        currentOperation = operation;
        firstNumber = getNumberFromScreen();
        screen.clear();
    }

    private BigDecimal getNumberFromScreen() {
        String text = screen.getText();
        return new BigDecimal(text.replace(",", "."));

    }

}
