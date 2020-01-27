package tdd.swing.ex3;

import javax.swing.*;

public class TopSecretWindow {
    private JLabel text;

    public TopSecretWindow() {
        JFrame frame = new JFrame("Top Secret");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 400);
        text = new JLabel("Top Secret message", SwingConstants.CENTER);
        frame.add(text);
        frame.setVisible(true);
    }
}