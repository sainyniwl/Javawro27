package pl.sda.rafal.zientara.swing.zad3;

import javax.swing.*;

public class WrongPasswordDialog {

    public WrongPasswordDialog(JFrame owner) {
        JDialog dialog = new JDialog(owner, true); // blokuj akcję na poprzednim oknie
        JLabel label = new JLabel("Hasło nieprawidłowe");
        dialog.setSize(300, 200);
        dialog.add(label);

        dialog.setVisible(true);
    }
}
