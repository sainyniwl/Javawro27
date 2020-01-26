package pl.sda.rafal.zientara.LP;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TopSecretWindow {

    private JLabel topSecretMessage;

    public TopSecretWindow() {

        JFrame frame = new JFrame("TopSecretMessage");
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        topSecretMessage = new JLabel("wow ale tajne", SwingConstants.CENTER);
        frame.add(topSecretMessage);

        frame.setVisible(true);
    }
}
