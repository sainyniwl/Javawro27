package pl.sda.rafal.zientara.LP;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LoginWindow {

    private final JButton loginButton;
    //  private JButton button;
    //  private int clickCount = 0;
    private JTextField passwordInput;
    private String inputText;
    private LoginListener listener;
    private JFrame frame;

    public LoginWindow() {

        frame = new JFrame("Password");
        frame.setSize(300, 350);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        passwordInput = new JPasswordField();

        passwordInput.setBounds(50, 50, 200, 100);
        passwordInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e);
                if (e.getKeyChar() == 10) {
                    listener.onLoginClick(passwordInput.getText());
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        frame.add(passwordInput);
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 200, 200, 100);
        loginButton.addActionListener(e -> listener.onLoginClick(passwordInput.getText()));
        frame.add(loginButton);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    private void setInputText(String text
    ) {
        this.inputText = text;
    }

    public String getInputText2() {
        return passwordInput.getText();
    }

    public void setListener(LoginListener listener) {
        this.listener = listener;
    }

    public void hide() {
        frame.setVisible(false);
    }

    public JFrame getFrame() {
        return frame;
    }

    public interface LoginListener {

        void onLoginClick(String password);

    }

}
