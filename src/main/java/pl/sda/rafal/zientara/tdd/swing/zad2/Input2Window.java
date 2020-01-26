package pl.sda.rafal.zientara.tdd.swing.zad2;

import javax.swing.*;

public class Input2Window {
    private JTextField textView;
    private JButton button;

    public Input2Window(){
        JFrame frame = new JFrame("Input 1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300,350);

        textView = new JTextField("input 1 text");
        textView.setBounds(50,50, 200,100);
        frame.add(textView);

        button = new JButton("Połącz");
        button.setBounds(50,200,200,100);
        frame.add(button);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
