package pl.sda.rafal.zientara.swing;

import javax.swing.*;

public class TopSecretWindow {
    private JLabel secretText;


    public TopSecretWindow() {
        JFrame frame = new JFrame("TopSecret");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 400);

        secretText = new JLabel("Wiadomość Top Secret", SwingConstants.CENTER);
        frame.add(secretText);

        frame.setVisible(true);
    }

}

