package pl.sda.rafal.zientara.LP;


public class MainLP {

    public static void main(String[] args) {

        LoginWindow loginWindow = new LoginWindow();

        loginWindow.setListener(password -> {
            //System.out.println(password);
            if ("okon".equals(password)) {
                loginWindow.hide();
                new TopSecretWindow();
            } else
                new WrongPasswordDialog(loginWindow.getFrame());
        });

    }

}
