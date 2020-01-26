package pl.sda.rafal.zientara.tdd.swing.zad3;

import javax.swing.*;

public class TopSecretWindow {
    private JLabel secretText;

    public TopSecretWindow(){
        JFrame frame = new JFrame("Top Secret!");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600,400);
        secretText = new JLabel("wow ale tajne",SwingConstants.CENTER);
        frame.add(secretText);
        frame.setVisible(true);
    }
}

