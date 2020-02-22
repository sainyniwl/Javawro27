package pl.sda.rafal.zientara.tdd.swing.zad3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginWindow {
    private JFrame frame;
    private JTextField passwordInput;
    private JButton loginButton;
    private LoginListener listener;

    public LoginWindow() {
        frame = new JFrame("Podaj hasło");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300, 350);

        passwordInput = new JPasswordField("password?");
        passwordInput.setBounds(50, 50, 200, 100);
        passwordInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e);
                if (e.getKeyChar() == 10) {
                    listener.onLoginClicked(passwordInput.getText());
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
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onLoginClicked(passwordInput.getText());
            }
        });
        frame.add(loginButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void setListener(LoginListener listener) {
        this.listener = listener;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void hide() {
        frame.setVisible(false);
    }

    public interface LoginListener {
        void onLoginClicked(String password);
    }

}
