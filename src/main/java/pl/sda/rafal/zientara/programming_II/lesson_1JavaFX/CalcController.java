package pl.sda.rafal.zientara.programming_II.lesson_1JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

public class CalcController {

    @FXML
    private TextField screen; // fx:id tak jak w scene builder

    private CalcOperation currentOperation;
    private BigDecimal firstNumber;

    //metoda kopiująca tekst z buttona
    @FXML
    private void handleNumberPressed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj instanceof Button){ // instanceof sprawdza powiązania z inną klasą
            Button button = (Button) obj;
            String text = button.getText();
            screen.appendText(text);
        }
    }
    @FXML
    private void handlePlusPressed(ActionEvent event){
        changeOperation(CalcOperation.PLUS);
    }

    @FXML
    private void handleMinusPressed(ActionEvent event){
        changeOperation(CalcOperation.MINUS);
    }

    @FXML
    private void handleMultiplyPressed(ActionEvent event){
        changeOperation(CalcOperation.MULTIPLY);
    }
    @FXML
    private void handleDividePressed(ActionEvent event){
        changeOperation(CalcOperation.DIVIDE);

    }
    private void changeOperation(CalcOperation operation){
        currentOperation = operation;
        firstNumber = getNumberFromScreen();
        screen.clear();
    }
    @FXML
    public void handleResultPressed(){
        String text = screen.getText();
        BigDecimal secondNumber = new BigDecimal(text);
        BigDecimal result = getResult(secondNumber);
        screen.setText(String.format("%f", result));
    }

    private BigDecimal getNumberFromScreen(){
        String text = screen.getText();
        return new BigDecimal(text);
    }

    private BigDecimal getResult(BigDecimal secondNumber){
        try{
        switch(currentOperation) {
            case PLUS:
                return firstNumber.add(secondNumber);
            case MINUS:
                return firstNumber.subtract(secondNumber);
            case MULTIPLY:
                return firstNumber.multiply(secondNumber);
            case DIVIDE:
                return firstNumber.divide(secondNumber);


        }
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(("ArithmeticException"));
            alert.setHeaderText("nope1");
            alert.setContentText("nope");

            alert.showAndWait();
        }
        return new BigDecimal(0);

    }

    @FXML
    public void handleClearPressed(){
        screen.clear();
    }

    @FXML
    public void handleCommaPressed(){
        String text = screen.getText();
        if (!text.contains(".")) {
            screen.appendText(".");
        }
    }




}
