package pl.sda.rafal.zientara;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TicTacToeWindow {
    //  private final JLabel counter;
    //  private JButton button;
    private int clickCount = 0;
    private TicTacToe game = new TicTacToe();

    public TicTacToeWindow() {
        JFrame frame = new JFrame("Label");
        frame.setSize(300, 350);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        GridLayout gridLayout = new GridLayout(3, 3);

        for (int i = 0; i < 9; i++) {
            int col = i % TicTacToe.BOARD_SIZE;
            int row = i / TicTacToe.BOARD_SIZE;
            String text = Integer.toString(i + 1);
            JButton button = new JButton();
            button.setBounds(50, 50, 200, 100);
            button.addActionListener(e -> {
                //System.out.println("col " + col);
                //System.out.println("row " + row);
                try {
                    game.action(col, row);
                    FieldStatus fieldStatus = game.getFieldStatus(col, row);
                    button.setText(fieldStatus.getText());
                    frame.setTitle(game.checkStatus().toString());
                } catch (Exception error) {
                    frame.setTitle(error.getMessage());
                }
            });
            frame.add(button);
        }

        frame.setLayout(gridLayout);
        frame.setVisible(true);
    }

}
