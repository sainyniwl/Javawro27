package tdd.HangMan;

import java.util.InputMismatchException;

public class WrongSymbolException extends InputMismatchException {
    public boolean print(char c) {
        if (String.valueOf(c).equals("[a-zA-Z]")) return true;
        else {
            System.out.println("Błędny znak");
            return false;
        }
    }
}
