package pl.sda.rafal.zientara.tdd.football;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.*;
import java.util.Scanner;

public class FootballViewTest {

    private FootballContract.View view;
    private FootballContract.Presenter presenter;

    private FootballView footballView = new FootballView();
    private FootballBoard board = new FootballBoard(12, 14);

    @BeforeEach
    public void setup() {
        view = footballView;
        presenter = new FootballPresenter(view, board);
        board.initSides();
        footballView.setBoard(board);
        presenter.init();
    }

    @AfterEach
    public void test() {
        showMeBoard();
        waitForUser();
    }

    @Test
    public void yolo() {
        presenter.moveTop();
        presenter.moveRight();
        presenter.moveBottomLeft();
        presenter.moveBottom();
        System.out.println("Run");
    }

    private void waitForUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press ENTER");
        scanner.nextLine();
    }

    private void showMeBoard() {
        JFrame frame = new JFrame("Football");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(footballView);
        frame.setVisible(true);
    }
}
