package pl.sda.rafal.zientara.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {
    private JTextField passwordInput;
    private JButton loginButton;
    private LoginListener listener;
    private JFrame frame;


    public LoginWindow() {
        frame = new JFrame("LoginWindow");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300, 350);

        passwordInput = new JPasswordField("password");
        passwordInput.setBounds(50,50,200,100);
        frame.add(passwordInput);

        loginButton = new JButton("Login");
        loginButton.setBounds(50,200,200,100);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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

    public String getText2() {
        return passwordInput.getText();
    }

    public void hide() {
        frame.setVisible(false);
    }

    public JFrame getFrame() {
        return frame;
    }

    public interface LoginListener {
        void  onLoginClicked(String password);
    }
}

