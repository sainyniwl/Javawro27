package pl.sda.rafal.zientara.tdd.swing.zad3;

import pl.sda.rafal.zientara.tdd.swing.zad2.Input1Window;
import pl.sda.rafal.zientara.tdd.swing.zad2.Input2Window;

public class Main {
    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setListener(new LoginWindow.LoginListener() {
            @Override
            public void onLoginClicked(String password) {
                System.out.println(password);
                if ("okoń".equals(password)) {
                    loginWindow.hide();
                    new TopSecretWindow();
                } else {
                    new WrongPasswordDialog(loginWindow.getFrame());
                }
            }
        });

    }

}
