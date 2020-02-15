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

    private Operation currentOperation;

    private BigDecimal firstNumber;

    @FXML
    private void handlerNumberPressed(ActionEvent actionEvent){

        Object obj = actionEvent.getSource();

        if(obj instanceof Button){
            Button button = (Button) obj;
            String text = button.getText();
            screen.appendText(text);
        }
    }

    @FXML
    private void handlePlusPressed(ActionEvent actionEvent){
        changeOperation(Operation.PLUS);
    }

    @FXML
    private void handleMinusPressed(ActionEvent actionEvent){
        changeOperation(Operation.MINUS);
    }

    @FXML
    private void handleMultiplyPressed(ActionEvent actionEvent){
        changeOperation(Operation.MULTIPLY);
    }

    @FXML
    private void handleDividePressed(ActionEvent actionEvent){
        changeOperation(Operation.DIVIDE);
    }

    private void changeOperation(Operation operation){
        currentOperation = operation;
        firstNumber = getNumberFromScreen();
        screen.clear();
    }

    @FXML
    private void handleEqualsPressed(){
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
                    return firstNumber.divide(secondNumber, RoundingMode.UNNECESSARY);
                case MULTIPLY:
                    return firstNumber.multiply(secondNumber);
            }
        }catch(Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Arithmetical Exception");
            alert.setContentText("Nie można tak!");
            alert.showAndWait();
        }

        return new BigDecimal(0);
    }

    private BigDecimal getNumberFromScreen(){
        String text = screen.getText();
        return new BigDecimal(text.replace(",", "."));
    }

    @FXML
    private void handleClearPressed(){
        screen.clear();
    }

    @FXML
    private void handleCommaPressed() {
        String text = screen.getText();
        if (!text.contains(".")) {
            screen.appendText(".");
        }
    }

}
