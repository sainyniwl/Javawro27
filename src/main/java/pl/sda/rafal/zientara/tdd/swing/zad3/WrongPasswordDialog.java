package pl.sda.rafal.zientara.tdd.swing.zad3;

import javax.swing.*;

public class WrongPasswordDialog {

    public WrongPasswordDialog(JFrame owner) {
        JDialog dialog = new JDialog(owner, true);//modal - blokuj akcje na poprzednim oknie
        dialog.setSize(300, 200);
        JLabel label = new JLabel("Hasło nieprowidłowe!");
        dialog.add(label);

        dialog.setVisible(true);
    }
}
