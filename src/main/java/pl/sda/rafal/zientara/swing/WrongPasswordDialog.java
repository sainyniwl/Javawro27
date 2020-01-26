package pl.sda.rafal.zientara.swing;

import javax.swing.*;

public class WrongPasswordDialog {
    public WrongPasswordDialog(JFrame owner){
        JDialog dialog = new JDialog(owner,true); //model - blokuje akcję na poprzednim oknie
        dialog.setSize(300,200);
        JLabel label = new JLabel("Hasło nieprawidłowe!");
        dialog.add(label);

        dialog.setVisible(true);
    }
}
