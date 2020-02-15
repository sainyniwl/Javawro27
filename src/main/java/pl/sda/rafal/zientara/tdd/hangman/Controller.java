package pl.sda.rafal.zientara.tdd.hangman;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;

public class Controller {


    @FXML
    public TextField inputField;
    @FXML
    public Button submitButton;
    @FXML
    public Label passwordLabel;
    @FXML
    public Line line1;
    @FXML
    public Line line2;
    @FXML
    public Line line3;
    @FXML
    public Line line4;
    @FXML
    public Line line5;
    @FXML
    public Line line6;
    @FXML
    public Group human;

    private Hangman game ;

    public void initialize() {
        game = new Hangman();
        String randomPuzzle = Resources.getRandomPuzzle();
        game.setPuzzle(randomPuzzle);
        passwordLabel.setText(game.getOutput());
    }

    public void resetGame() {
        initialize();
    }

    private void submitGuess(){
        String text = inputField.getText();
        if (text.length() > 1) {
            game.guessPuzzle(text);
        } else if (text.length() == 1) game.guessLetter(text.charAt(0));
        refreshUi();
       if (game.isPuzzleSolved()) {
            winAlert();
        }
    }

    public void handleConfirm() {
        if (!game.isGameFinished()) {
            submitGuess();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game is started");
            alert.setContentText("You have started again");
            alert.showAndWait();
            resetGame();
        }

    }

    private void refreshUi() {
        refreshPassword();
        refreshHP();
        refreshSubmitButton();
    }

    private void refreshSubmitButton() {
        if (!game.isGameFinished()) {
            submitButton.setText("Ok");
            inputField.clear();
        } else submitButton.setText("RESET");
    }

    private void refreshHP() {
        line1.setVisible(false);
        line2.setVisible(false);
        line3.setVisible(false);
        line4.setVisible(false);
        line5.setVisible(false);
        line6.setVisible(false);
        human.setVisible(false);
        switch (game.getHp()) {
            case 0: gameOverAlert();
                human.setVisible(true);
            case 1: line6.setVisible(true);
            case 2: line5.setVisible(true);
            case 3: line4.setVisible(true);
            case 4: line3.setVisible(true);
            case 5: line2.setVisible(true);
            case 6: line1.setVisible(true);
        }
    }

    private void gameOverAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Looser");
        alert.setContentText("Game Over");
        alert.showAndWait();
}
private void winAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setContentText("Congratulations");
        alert.showAndWait();
}

    private void refreshPassword() {
        passwordLabel.setText(game.getOutput());
    }

}

