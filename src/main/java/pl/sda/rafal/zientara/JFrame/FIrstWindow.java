package pl.sda.rafal.zientara.JFrame;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class FIrstWindow {

    private final JLabel counter;
    private JButton button;
    private int clickCount = 0;

    public FIrstWindow() {
        JFrame frame = new JFrame("Label");
        frame.setSize(300, 350);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        button = new JButton("Button");
        button.setBounds(50, 50, 200, 100);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // System.out.println("Click");
                clickCount++;
                String text = Integer.toString(clickCount);
                counter.setText(text);
            }
        });


        frame.add(button);

        counter = new JLabel("0", SwingConstants.CENTER);
        counter.setBounds(50, 200, 200, 100);
        frame.add(counter);

        frame.setLayout(null);
        frame.setVisible(true);
    }

}
