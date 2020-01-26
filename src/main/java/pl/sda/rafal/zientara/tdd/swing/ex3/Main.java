package pl.sda.rafal.zientara.tdd.swing.ex3;

public class Main {
    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setListener(new LoginWindow.LoginListener() {
            @Override
            public void onLoginClicked(String password) {
                System.out.println(password);

                TopSecretWindow window = new TopSecretWindow();
            }
        });

    }
}
