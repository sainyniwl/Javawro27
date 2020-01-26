package pl.sda.rafal.zientara.swing.login;

import javax.swing.*;

public class WrongPassword {

    public WrongPassword(JFrame owner) {
        JDialog dialog = new JDialog(owner, true);
        dialog.setSize(300, 200);
        JLabel label = new JLabel("Hasło nieprawdiłowe!");
        dialog.add(label);

        dialog.setVisible(true);
    }
}
