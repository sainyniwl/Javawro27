package pl.sda.rafal.zientara.LP;

import javax.swing.*;

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
