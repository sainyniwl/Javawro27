package pl.sda.rafal.zientara.tdd.football;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Scanner;

public class FootballViewTest {

    private FootballView footballView = new FootballView();
    private FootballBoard board = new FootballBoard(6, 8);

    @BeforeEach
    public void setup() {
        board.initSides();
        footballView.setBoard(board);
    }

    @Test
    public void test() {
        showMeBoard();
        waitForUser();
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
