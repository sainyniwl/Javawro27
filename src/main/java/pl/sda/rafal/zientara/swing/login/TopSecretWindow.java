package pl.sda.rafal.zientara.swing.login;

import javax.swing.*;

public class TopSecretWindow {
    private JLabel secretText;


    public TopSecretWindow() {
        JFrame frame = new JFrame("Top secret");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 400);
        secretText = new JLabel("Taaajności", SwingConstants.CENTER);
        frame.add(secretText);
        frame.setVisible(true);
    }
}
