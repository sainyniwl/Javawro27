package pl.sda.rafal.zientara.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input1Window {
    private JTextField textField;
    private JLabel label;


    public Input1Window() {
        JFrame frame = new JFrame("Input1Window");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300, 350);

        textField = new JTextField("input 1 text");
        textField.setBounds(50,50,200,100);
        frame.add(textField);

        label = new JLabel("0", SwingConstants.CENTER);
        label.setBounds(50,200,200,100);
        frame.add(label);

        frame.setLayout(null);
        frame.setVisible(true);


    }

    public String getText1() {
        return textField.getText();
    }

    public void setMergedText(String text) {
        label.setText(text);
    }
}

