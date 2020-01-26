package pl.sda.rafal.zientara.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input2Window {
    private JTextField textField;
    private JButton button;
    private MergeListener listener;


    public Input2Window() {
        JFrame frame = new JFrame("Input2Window");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300, 350);

        textField = new JTextField("input 2 text");
        textField.setBounds(50,50,200,100);
        frame.add(textField);

        button = new JButton("Połącz");
        button.setBounds(50,200,200,100);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.onMergeClicked();
            }
        });
        frame.add(button);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void setListener(MergeListener listener) {
        this.listener = listener;
    }

    public String getText2() {
        return textField.getText();
    }

    public interface MergeListener {
        void  onMergeClicked();
    }
}

