package pl.sda.rafal.zientara.tdd.swing.ex3;

import javax.swing.*;

public class WrongPasswordDIalog {

    public WrongPasswordDIalog(JFrame owner) {
        JDialog dialog = new JDialog(owner,true);
        JLabel label = new JLabel("Incorrect Password", SwingConstants.CENTER);
        dialog.setSize(200, 100);
        dialog.add(label);
        dialog.setVisible(true);
    }
}
