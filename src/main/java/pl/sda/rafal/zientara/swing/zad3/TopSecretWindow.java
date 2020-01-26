package pl.sda.rafal.zientara.swing.zad3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopSecretWindow {


    private JLabel secretText;

    public TopSecretWindow() {

        JFrame frame = new JFrame("Top secret");
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        secretText = new JLabel("wow ale tajne", SwingConstants.CENTER);
        frame.add(secretText);


        frame.setVisible(true);
    }


}
