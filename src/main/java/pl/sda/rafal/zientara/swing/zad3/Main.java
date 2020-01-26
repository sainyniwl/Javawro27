package pl.sda.rafal.zientara.swing.zad3;

public class Main {

    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setListener(new LoginWindow.LoginListener() {
            @Override
            public void onLoginClicked(String password) {
                System.out.println(password);
                if ("okoń".equals(password)){
                    //hasło prawidłowe
                    loginWindow.hide();
                    new TopSecretWindow();
                } else {
                    new WrongPasswordDialog(loginWindow.getFrame());
                }
            }
        });
    }
}
