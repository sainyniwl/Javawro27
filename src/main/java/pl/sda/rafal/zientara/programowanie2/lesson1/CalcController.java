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
    private TextField screen;

    @FXML
    private void handlerNumberPressed(ActionEvent actionEvent) {
        Object obj = actionEvent.getSource();
        if (obj instanceof Button) {
            Button button = (Button) obj;
            String text = button.getText();
            screen.appendText(text);
        }
    }

    private Operation currentOperation;
    private BigDecimal firstNumber;
    private BigDecimal secondNumber;

    private void changeOperation(Operation operation) {
        currentOperation = operation;
        firstNumber = getNumberFromScreen();
        screen.clear();
    }

    @FXML
    public void handlePlusPressed() {
        changeOperation(Operation.PLUS);
    }

    @FXML
    public void handleMinusPressed() {
        changeOperation(Operation.MINUS);
    }

    @FXML
    public void handleMultiplyPressed() {
        changeOperation(Operation.MULTIPLY);
    }

    @FXML
    public void handleDividePressed() {
        changeOperation(Operation.DIVIDE);
    }

    private BigDecimal getNumberFromScreen(){
        String text = screen.getText();
        return new BigDecimal(text.replace(",", "."));
    }

    private BigDecimal getResult (BigDecimal secondNumber){
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
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setContentText("Nie dziel przez 0!");
            alert.showAndWait();
        }
        return new BigDecimal(0);
    }

    @FXML
    public void handleResultPressed() {
        secondNumber = getNumberFromScreen();
        BigDecimal result = getResult(secondNumber);
        screen.setText(String.format("%f", result));
    }

    @FXML
    public void handleClearPressed(){
        screen.clear();
    }

    @FXML
    public void handleComaPressed(){
        String text = screen.getText();
        if (!text.contains("."))
        screen.appendText(".");

    }

}

