package pl.sda.rafal.zientara.tdd.swing.zad3;

import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {

    private JFrame loginFrame;
    private JDialog wrongPasswordWindow;
    private JFrame secretWindow;
    private JButton acceptButton;
    private JLabel secretFrameText;
    private JLabel wrongPaswordText;
    private JPasswordField passwordEnter;

    public LoginWindow() {
        initLoginWindow();
    }

    private void initSecretWindow(){
        secretWindow = new JFrame();
        secretWindow.setResizable(false);
        secretWindow.setSize(600,600);
        secretWindow.setLayout(null);
        secretWindow.setVisible(true);
        secretFrameText.setText("It went all well.\nHAVE A NICE DAY !!!");
        secretFrameText.setBounds(20,20,550,550);
        secretFrameText.setFont(new Font("Arial", Font.PLAIN, 30));
        secretWindow.add(secretFrameText);

        secretWindow.setLayout(null);
        secretWindow.setVisible(true);
    }

    private void initLoginWindow(){
        loginFrame = new JFrame();
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
        loginFrame.setSize(215,300);


        passwordEnter = new JPasswordField();
        acceptButton = new JButton();
        passwordEnter.setBounds(25,50,150,50);
        acceptButton.setBounds(50,150,100,60);
        loginFrame.add(passwordEnter);
        loginFrame.add(acceptButton);

        acceptButton.setText("Accept");
        acceptButton.setFont(new Font("Arial", Font.PLAIN, 20));
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Confirmed");
                if(passwordEnter.getText().equals("kolumbryna")){
                    initSecretWindow();
                    secretWindow.setVisible(false);
                }else initWrongPasswordWindow();

            }
        });
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
    }

    private void initWrongPasswordWindow(){
        wrongPasswordWindow = new JDialog(loginFrame);
        wrongPasswordWindow.setResizable(false);
        wrongPasswordWindow.setSize(200,100);
        wrongPasswordWindow.setLayout(null);
        wrongPasswordWindow.setVisible(true);

        wrongPaswordText = new JLabel();
        wrongPaswordText.setText("Wrong password !!");
        wrongPaswordText.setBounds(10,20,190,50);
        wrongPaswordText.setFont(new Font("Arial", Font.PLAIN, 20));
wrongPasswordWindow.add(wrongPaswordText);
        wrongPasswordWindow.setLayout(null);
        wrongPasswordWindow.setVisible(true);
    }



    public void hide(JFrame frame){
        frame.setVisible(false);
    }

}
