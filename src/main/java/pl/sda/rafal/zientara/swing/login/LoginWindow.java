package pl.sda.rafal.zientara.swing.login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {

    public void hide() {

        frame.setVisible(false);
    }

    public void setListener(LoginListener listener) {
        this.listener = listener;
    }

    private JButton loginButton;
    private JTextField passwordInput;
    private LoginListener listener;
    private JFrame frame;

    public LoginWindow(){

        frame = new JFrame("Podaj hasło");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setResizable(false);

        passwordInput = new JPasswordField("Password");
        passwordInput.setBounds(50, 50, 200, 100);
        frame.add(passwordInput);

        loginButton = new JButton("Log in!");
        loginButton.setBounds(50, 200, 200, 100);

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

    public JFrame getFrame() {
        return frame;
    }


    public interface LoginListener {
        void onLoginClicked(String password);
    }


//    public static void main(String[] args) {
//
//        LoginWindow loginWindow = new LoginWindow();
//        loginWindow.setListener(new LoginListener() {
//            @Override
//            public void onLoginClicked(String password) {
//                System.out.println(password);
//            }
//        });
//
//    }
}

