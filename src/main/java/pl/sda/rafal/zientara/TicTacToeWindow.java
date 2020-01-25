package pl.sda.rafal.zientara;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeWindow {
    private JFrame frame;
    private JLabel counter;
    private int counterClick;
    private TicTacToe game = new TicTacToe();


    public static void main(String[] args) {
        new TicTacToeWindow();
    }

    public TicTacToeWindow() {
        frame = new JFrame("Cuś");
        frame.setSize(300, 350);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GridLayout experimentLayout = new GridLayout(3, 3);

        for (int i = 0; i < 9; i++) {
            int col = i % TicTacToe.BOARD_SIZE;
            int row = i / TicTacToe.BOARD_SIZE;
            JButton button = new JButton();
            button.setBounds(50, 50, 200, 100);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("col " + col);
                    System.out.println("row " + row);
                    game.action(col, row);
                    FieldStatus status = game.getFieldStatus(col, row);
                    button.setText(status.getText());
                    frame.setTitle(game.checkResult().toString());
                }
            });
            frame.add(button);
        }

        frame.setLayout(experimentLayout);
        frame.setVisible(true);
    }
}
