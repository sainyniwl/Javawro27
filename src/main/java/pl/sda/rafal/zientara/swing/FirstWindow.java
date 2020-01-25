package pl.sda.rafal.zientara.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindow {
    private JFrame frame;
    private JButton button;
    private JLabel counter;
    private int counterClick;


    public static void main(String[] args) {
        new FirstWindow();
    }

    public FirstWindow() {
        frame = new JFrame("Cuś");
        frame.setSize(300, 350);

        button = new JButton("Wincyj!");
        button.setBounds(50, 50, 200, 100);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterClick++;
                String text = Integer.toString(counterClick);
                counter.setText(text);
            }
        });
        frame.add(button);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        counter = new JLabel("0", SwingConstants.CENTER);
        counter.setBounds(50, 200, 200, 100);
        frame.add(counter);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
