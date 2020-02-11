package pl.sda.rafal.zientara.tictactoe;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeWindow {

    private JButton button;
    private JLabel label;
    private int counter = 0;
    private TicTacToe game = new TicTacToe();

    public TicTacToeWindow(){

        JFrame frame = new JFrame("Siema");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setResizable(false);
        frame.setTitle(game.checkResult().toString());

        GridLayout gridLayout = new GridLayout(3, 3);

        for (int i = 0; i < 9; i++) {
            int col = i % TicTacToe.BOARD_SIZE;
            int row = i / TicTacToe.BOARD_SIZE;
            String text = Integer.toString(i);
            JButton button = new JButton("");
            button.setBounds(50, 50, 200, 100);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("Row" + row);
                    System.out.println("Col" + col);
                    game.action(row, col);
                    FieldStatus fieldstatus = game.getFieldStatus(row, col);
                    button.setText(fieldstatus.getText());
                    frame.setTitle(game.checkResult().toString());
                }
            });
            frame.add(button);
        }

//        label = new JLabel("0", SwingConstants.CENTER);
//        label.setBounds(50, 200, 200, 100);
//        frame.add(label);

        frame.setLayout(gridLayout);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

       new TicTacToeWindow();


    }
}
