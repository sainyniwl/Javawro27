package pl.sda.rafal.zientara.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindow {
    private JButton button;
    private JLabel counter;
    private int clickcount=0;

    public static void main(String[] args) { //psvm
        new FirstWindow();
    }
    public FirstWindow() {
        JFrame frame = new JFrame("First");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //ctrl+spacja i pokazuje opcje do wstawienia
        frame.setResizable(false);
        frame.setVisible(true); //żeby się okno pokazało

        button = new JButton("More!");
        button.setBounds(50, 50, 200, 100);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("click!");
                clickcount++;
                String text = Integer.toString(clickcount);
                counter.setText(text);
            }
        });
        frame.add(button);

        counter = new JLabel("0", SwingConstants.CENTER);
        counter.setBounds(50, 200, 200, 100);

        frame.add(counter);

        frame.setLayout(null);
        frame.setSize(300, 350);
    }

}
