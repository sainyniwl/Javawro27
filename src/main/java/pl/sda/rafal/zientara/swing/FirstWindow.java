package pl.sda.rafal.zientara.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindow {

    private JButton button;
    private JLabel label;
    private int counter = 0;

    public FirstWindow(){

        JFrame frame = new JFrame("Siema");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setResizable(false);

        button = new JButton("Wincyj!");
        button.setBounds(50, 50, 200, 100);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               counter ++;
                String text = Integer.toString(counter);
                System.out.println(counter);
                label.setText(text);
            }
        });
        frame.add(button);

        label = new JLabel("0", SwingConstants.CENTER);
        label.setBounds(50, 200, 200, 100);
        frame.add(label);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

       new FirstWindow();


    }
}
