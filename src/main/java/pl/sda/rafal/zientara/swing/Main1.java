package pl.sda.rafal.zientara.swing;

public class Main1 {
    public static void main(String[] args) {
//        Input1Window window1 = new Input1Window();
//        Input2Window window2 = new Input2Window();
//
//        window2.setListener(new Input2Window.MergeListener() {
//            @Override
//            public void onMergeClicked() {
//                String text1 = window1.getText1();
//                String text2 = window2.getText2();
//
//                window1.setMergedText(text1 + text2);
//            }
//        });

        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setListener(new LoginWindow.LoginListener() {
            @Override
            public void onLoginClicked(String password) {
                System.out.println(password);
                System.out.println(password);
                if ("koko".equals(password)) {
                    loginWindow.hide();
                    new TopSecretWindow();

                }else {
                    new WrongPasswordDialog(loginWindow.getFrame());
                }
            }
        });

    }

}
