package pl.sda.rafal.zientara.swing;

import pl.sda.rafal.zientara.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindow {

    private JButton button;
    private JLabel counter;
    private int clickCount = 0;

    public static void main(String[] args) {
            new FirstWindow();

    }

    public FirstWindow() {
        JFrame frame = new JFrame("Siema ");
        frame.isResizable();
        frame.setSize(300, 350);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        button = new JButton("Wincyj");
        button.setBounds(50, 50, 200, 100);
        button.addActionListener(new ActionListener() { // pokazywanie kliknięć
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click");
                clickCount++;                                    //zliczanie kliknięć
                String text = Integer.toString(clickCount);
                counter.setText(text);

            }
        });
        frame.add(button);


        counter = new JLabel("0", SwingConstants.CENTER);
        counter.setBounds(50, 50, 200, 100);
        frame.add(counter);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
