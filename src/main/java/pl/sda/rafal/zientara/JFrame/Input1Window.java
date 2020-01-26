package pl.sda.rafal.zientara.JFrame;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Input1Window {

    private final JLabel label;
    private JTextField textField;
    private String text;


    public Input1Window() {
        JFrame frame = new JFrame("Input1Window");
        frame.setSize(300, 350);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        textField = new JTextField();
        textField.setBounds(50, 50, 200, 100);
                /*button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("Click");
                clickCount++;
                String text = Integer.toString(clickCount);
                counter.setText(text);
            }
        });*/
        frame.add(textField);
        label = new JLabel("0", SwingConstants.CENTER);
        label.setBounds(50, 200, 200, 100);
        frame.add(label);

        frame.setLayout(null);
        frame.setVisible(true);

    }


    public String getInputText1() {
        return textField.getText();
    }

    public void setMergedText(String s) {
        label.setText(s);
    }
}
