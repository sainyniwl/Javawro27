package pl.sda.rafal.zientara.Swing;

import pl.sda.rafal.zientara.FieldStatus;
import pl.sda.rafal.zientara.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTocWindow {
    private TicTacToe game = new TicTacToe();


    public static void main(String[] args) {
        new TicTocWindow();
    }

    public TicTocWindow() {
        JFrame f = new JFrame("Label Example");
        f.setSize(300, 350);
        f.setResizable(false);

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        GridLayout gridLayout = new GridLayout(3,3);

        for (int i = 0; i <9; i++) {
            int col = i% TicTacToe.size;
            int row = i/TicTacToe.size;

            JButton b = new JButton();
            b.setBounds(50, 50, 200, 100);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                    game.action(col, row);
                    FieldStatus status = game.getFieldStatus(col, row);
                    b.setText(status.getEmpty());
                    f.setTitle(game.checkResult().toString());
                }catch (Exception e){
                        f.setTitle(e.getMessage());
                    }

                }
            });
            f.add(b);
        }
        f.setLayout(gridLayout);
        f.setVisible(true);
    }
}
