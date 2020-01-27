package tdd.swing.ex3;

public class Main {
    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setListener(new LoginWindow.LoginListener() {
            @Override
            public void onLoginClicked(String password) {
if ("okoń".equals(password)) {
    loginWindow.hide();
    new TopSecretWindow();
} else new WrongPasswordDIalog(loginWindow.getFrame());
            }
        });
    }
}
