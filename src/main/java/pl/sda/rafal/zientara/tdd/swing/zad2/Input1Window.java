package pl.sda.rafal.zientara.tdd.swing.zad2;

import javax.swing.*;

public class Input1Window {
    private JTextField textView;
    private JLabel label;

    public Input1Window(){
        JFrame frame = new JFrame("Input 1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300,350);

        textView = new JTextField("input 1 text");
        textView.setBounds(50,50, 200,100);
        frame.add(textView);

        label = new JLabel("0", SwingConstants.CENTER);
        label.setBounds(50,200,200,100);
        frame.add(label);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
