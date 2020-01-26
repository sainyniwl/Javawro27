package pl.sda.rafal.zientara.tdd.swing.zad3.Zad3;

import pl.sda.rafal.zientara.tdd.swing.zad3.LoginWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopSecretWindow {

    private JLabel secretText;
    public TopSecretWindow(){
        JFrame frame = new JFrame("Top Secret");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600,400);

        secretText = new JLabel("wow, ale fajne!", SwingConstants.CENTER);
        frame.add(secretText);
        frame.setVisible(true);
    }
}
