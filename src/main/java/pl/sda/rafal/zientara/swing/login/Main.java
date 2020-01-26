package pl.sda.rafal.zientara.swing.login;

import pl.sda.rafal.zientara.swing.TwoWindows.Input1Window;
import pl.sda.rafal.zientara.swing.TwoWindows.Input2Window;

public class Main {
    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setListener(new LoginWindow.LoginListener() {
            @Override
            public void onLoginClicked(String password) {
                System.out.println(password);
                if ("okon".equals(password)){
                    loginWindow.hide();
                    new TopSecretWindow();
                }else new WrongPasswordDialog(loginWindow.getFrame());
            }
        });


    }
}
