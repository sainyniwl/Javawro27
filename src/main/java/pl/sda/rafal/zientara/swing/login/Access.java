package pl.sda.rafal.zientara.swing.login;

import javax.swing.*;

public class Access {

    JLabel label;

    public Access() {

        JFrame accesFrame = new JFrame("Top Secret");
        accesFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        accesFrame.setSize(600, 400);
        accesFrame.setResizable(false);

        label = new JLabel("Super tajna treść", SwingConstants.CENTER);
        accesFrame.add(label);


        accesFrame.setVisible(true);

    }

    public static void main(String[] args) {

    }


}
