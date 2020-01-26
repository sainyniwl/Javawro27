package pl.sda.rafal.zientara.LP;

import javax.swing.*;

public class WrongPasswordDialog {

    public WrongPasswordDialog(JFrame owner) {

        JDialog dialog = new JDialog(owner, true);
        dialog.setSize(200, 100);
        JLabel label = new JLabel("Wrong password", SwingConstants.CENTER);
        dialog.setResizable(false);
        dialog.add(label);

        dialog.setVisible(true);

    }
}
