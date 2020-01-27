package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindow {
    private JButton b;
    private JLabel counter;
    private int counterInt=0;


    public static void main(String[] args) {
        new FirstWindow();
    }

    public FirstWindow() {
        JFrame f = new JFrame("Label Example");
        f.setSize(300, 350);
        f.setResizable(false);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);

        GridLayout gridLayout = new GridLayout(3,3);

        for (int i = 0; i <9; i++) {


        b = new JButton("Wincyj!");
        b.setBounds(50, 50, 200, 100);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("click");
                counterInt+=100;
                String text = String.valueOf(counterInt);
                counter.setText(text);
            }
        });

        f.add(b);
        }
        counter = new JLabel("0", SwingConstants.CENTER);
        counter.setBounds(50, 200, 200, 100);
        f.add(counter);
    }
}
