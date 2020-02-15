package pl.sda.rafal.zientara.tdd.hangman;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;

public class Controller {

    @FXML public Button submitButton;
    @FXML public Label passwordLabel;
    @FXML public TextField input;
    @FXML public Line line1;
    @FXML public Line line2;
    @FXML public Line line3;
    @FXML public Line line4;
    @FXML public Line line5;
    @FXML public Line line6;
    @FXML public Group human;

    private Hangman game;

    public void initialize() {
        game = new Hangman();
        String randomPuzzle = Resources.getRandomPuzzle();
        game.setPuzzle(randomPuzzle);
    }
}
