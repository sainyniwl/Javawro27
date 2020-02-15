package pl.sda.rafal.zientara.programowanie2.lesson1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class CalcController {

    @FXML
    private TextField screen;

    @FXML
    private void handlerZeroPressed(ActionEvent actionEvent){
        screen.appendText("0");
    }


}
