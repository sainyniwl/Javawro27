package pl.sda.rafal.zientara.Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTwoWindows {
    JTextArea firstTextArea;
    JTextArea secondTextArea;
    JLabel label;
    String text;

    public static void main(String[] args) {
        new MyTwoWindows();
    }
    public MyTwoWindows() {
        JFrame f = new JFrame();
        f.setSize(300, 350);
        f.setResizable(false);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);

        JButton merge = new JButton("Merge");
        merge.setBounds(50, 50, 100, 50);
        merge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = ""+firstTextArea+secondTextArea;
                label.setText(text);
            }
        });
        f.add(merge);

        firstTextArea = new JTextArea();
        firstTextArea.setBounds(50,150,50,50);
        f.add(firstTextArea);

        secondTextArea = new JTextArea();
        secondTextArea.setBounds(50,200,50,50);
        f.add(secondTextArea);

        label = new JLabel("aaa",SwingConstants.CENTER);
        secondTextArea.setBounds(150,200,50,50);

    }
    public void merge() {

    }

}
