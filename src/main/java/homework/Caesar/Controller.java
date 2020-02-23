package homework.Caesar;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public TextArea secret;
    @FXML
    public TextArea encryptionText;
    @FXML
    public Button encrypt;
    @FXML
    public Button decrypt;
    @FXML
    public TextField shift;

    private Caesar caesar = new Caesar();

    @FXML
    public void secretHandle(){
        setShiftNumber();
        caesar.setSecret(secret.getText());
        caesar.encrypt();
        encryptionText.setText(caesar.getEncrypted());
    }

    @FXML
    public void decryptionHandle(){
        setShiftNumber();
        caesar.setSecret(secret.getText());
        caesar.decryptSecret();
        encryptionText.setText(caesar.getDecrypted());
    }

    private void setShiftNumber() {
        if (shift.getText().equals(""))
            caesar.setShiftInput(3);
        else if (shift.getText().matches("\\d*"))
            caesar.setShiftInput(Integer.parseInt(shift.getText()));
        else
            caesar.setShiftInput(3);
    }


}