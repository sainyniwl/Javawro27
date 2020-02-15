package pl.sda.rafal.zientara.programowanie2.lesson1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcController {
    private BigDecimal firstNumber; //żebyśmy mogli operować na ogromnych liczbach

    @FXML
    private TextField screen; //taka sama nazwa jak wpisaliśmy w fx:id w fx Builder

    @FXML
    private Operation currentOperation;

    @FXML
    private void handlerNumberPressed(ActionEvent event){ //Shift + f6 i zmieniamy nazwę, potem enter
        Object obj = event.getSource();
        if (obj instanceof Button){ //sprawdzamy czy obiekt jest klasy button i rzutujemy do Button. instanceof sprawdza czy są powiązania między klasami
            Button button = (Button) obj;
            String text = button.getText();
            screen.appendText(text);
        }
    }

    @FXML
    public void handlePlusPressed(){
        changeOperation(Operation.PLUS);
    }

    @FXML
    public void handleMinusPressed(){
        changeOperation(Operation.MINUS);
    }

    @FXML
    public void handleMultiplyPressed(){
        changeOperation(Operation.MULTIPLY);
    }

    @FXML
    public void handleDividePressed(){
        changeOperation(Operation.DIVIDE);
    }

    @FXML
    public void handleResultPressed(){
        BigDecimal secondNumber = getNumberFromScreen();
        BigDecimal result = getResult(secondNumber);
//        screen.setText(BigDecimal.toString(result));
        screen.setText(String.format("%f",result)); //żeby nie pokazywało liczba z E9
    }

    private BigDecimal getResult(BigDecimal secondNumber) {
        try {
            switch (currentOperation) {
                case PLUS:
                    return firstNumber.add(secondNumber);
                case MINUS:
                    return firstNumber.subtract(secondNumber);
                case DIVIDE:
                    return firstNumber.divide(secondNumber, RoundingMode.valueOf(155484811));
                case MULTIPLY:
                    return firstNumber.multiply(secondNumber);
            }
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ArithmeticException");
            alert.setContentText("Nie dziel przez 0");
            alert.showAndWait();
        }
        return new BigDecimal(0);
    }

    private void changeOperation(Operation operation){
        currentOperation = operation;
        firstNumber = getNumberFromScreen();
        screen.clear();
    }

    private BigDecimal getNumberFromScreen(){
        String text = screen.getText();
        return new BigDecimal(text.replace(",","."));
    }
}
