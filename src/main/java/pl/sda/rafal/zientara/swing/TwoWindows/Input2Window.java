package pl.sda.rafal.zientara.swing.TwoWindows;

import javax.swing.*;

public class Input2Window {
    private JTextField text;
    private JButton button;

    public Input2Window(){
        JFrame frame = new JFrame("Input 2");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300,350);

        text = new JTextField("input 2 text");
        text.setBounds(50,50,200,100);
        frame.add(text);

        button = new JButton("Połącz");
        button.setBounds(50,200,200,100);
        frame.add(button);


        frame.setLayout(null);
        frame.setVisible(true);
    }


}
