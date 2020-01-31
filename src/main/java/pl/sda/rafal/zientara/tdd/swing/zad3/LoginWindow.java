package pl.sda.rafal.zientara.tdd.swing.zad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class LoginWindow {

    private static JFrame loginFrame;
    private static JPasswordField passwordEnter;

    LoginWindow() {
        initLoginWindow();
    }

    private void initSecretWindow() {
        JFrame secretWindow = new JFrame();
        JLabel secretFrameText = new JLabel();
        secretWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        secretWindow.setResizable(false);
        secretWindow.setSize(600, 600);
        secretFrameText.setFont(new Font("Arial", Font.PLAIN, 30));
        secretFrameText.setText("It went all well.\nHAVE A NICE DAY !!!");
        secretFrameText.setBounds(20, 20, 550, 550);
        secretWindow.add(secretFrameText);
        secretWindow.setLayout(null);
        secretWindow.setVisible(true);
    }

    private void initLoginWindow() {
        loginFrame = new JFrame();
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
        loginFrame.setSize(215, 300);
        passwordEnter = new JPasswordField();
        JButton acceptButton = new JButton();
        passwordEnter.setBounds(25, 50, 150, 50);
        acceptButton.setBounds(50, 150, 100, 60);
        loginFrame.add(passwordEnter);
        loginFrame.add(acceptButton);
        passwordEnter.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 10) {
                    passwordEnter.getText();
                    initSecretWindow();
                    loginFrame.setVisible(false);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        acceptButton.setText("Accept");
        acceptButton.setFont(new Font("Arial", Font.PLAIN, 20));
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Confirmed");
                if (passwordEnter.getText().equals("kolumbryna")) {
                    initSecretWindow();
                    loginFrame.setVisible(false);
                } else initWrongPasswordWindow();

            }
        });
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
    }

    private void initWrongPasswordWindow() {
        JDialog wrongPasswordWindow = new JDialog(loginFrame, true);
        wrongPasswordWindow.setResizable(false);
        wrongPasswordWindow.setSize(200, 100);
        JLabel wrongPasswordText = new JLabel();
        wrongPasswordText.setText("Wrong password !!");
        wrongPasswordText.setBounds(10, 20, 190, 50);
        wrongPasswordText.setFont(new Font("Arial", Font.PLAIN, 20));
        wrongPasswordWindow.add(wrongPasswordText);
        wrongPasswordWindow.setLayout(null);
        wrongPasswordWindow.setVisible(true);
    }
}
