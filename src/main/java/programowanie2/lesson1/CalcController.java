package programowanie2.lesson1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Bidi;


public class CalcController {

    @FXML
    private TextField screen;


    private Operation currentOperation;
    private BigDecimal firstNumber;

    @FXML
    private void handlePlusPressed(ActionEvent event){
        changeOperation(Operation.PLUS);
    }

    @FXML
    private void handleMinusPressed(ActionEvent event){
        changeOperation(Operation.MINUS);
    }

    @FXML
    private void handleDividePressed(ActionEvent event){
        changeOperation(Operation.DIVIDE);
    }

    @FXML
    private void handleMultipyPressed(ActionEvent event){
        changeOperation(Operation.MULTIPLY);
    }

    @FXML
    public void handleResultPressed(){
        BigDecimal secondNumber = getNumberFromScreen();
        BigDecimal result = getResult(secondNumber);
        screen.setText(String.format("%f",result));
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
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ArithmeticException");
            alert.setHeaderText("nope");
            alert.setContentText("nope");
        }
        return new BigDecimal(0);
    }

    private void changeOperation(Operation operation) {
        currentOperation = operation;
        firstNumber = getNumberFromScreen();
        screen.clear();
    }


    private BigDecimal getNumberFromScreen(){
        String text = screen.getText();
        return new BigDecimal(text.replace(',','.'));
    }

    @FXML
    private void handlerNumberPressed(ActionEvent event){
        Object obj = event.getSource();
        if (obj instanceof Button) {
            Button button = (Button) obj;
            String text = button.getText();
            screen.appendText(text);
        }
    }
}
