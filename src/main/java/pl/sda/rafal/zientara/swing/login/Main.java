package pl.sda.rafal.zientara.swing.login;

import pl.sda.rafal.zientara.swing.login.Access;
import pl.sda.rafal.zientara.swing.login.LoginWindow;
import pl.sda.rafal.zientara.swing.login.WrongPassword;

public class Main {

    public static void main(String[] args){

        LoginWindow login = new LoginWindow();
        login.setListener(new LoginWindow.LoginListener() {
            @Override
            public void onLoginClicked(String password) {
                if("okoń".equals(password)){
                    login.hide();
                    new Access();
                }else{
                    new WrongPassword(login.getFrame());
                }
            }
        });


    }

}
