package homework.Caesar;

public class Caesar {
    private String secret = "";
    private String encrypted = "";
    private String decrypted = "";
    private char[] upperKeys = {'A','B','C','D','E','F','G','H',
                        'I','J','K','L','M','N','O','P','Q',
                        'R','S','T','U','V','W','X','Y','Z'};
    private char[] lowerKeys = {'a','b','c','d','e','f','g','h',
                        'i','j','k','l','m','n','o','p','q',
                        'r','s','t','u','v','w','x','y','z'};
    private int shiftInput = 3;

    public Caesar() {
    }


    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void encrypt() {
        if (encrypted.length() > 0)
            encrypted = "";

        char[] plainTextChars = charSplit(secret);
        for (int i = 0; i < plainTextChars.length; i++) {
            for (int j = 0; j < upperKeys.length; j++) {
                if (Character.isUpperCase(plainTextChars[i])) {
                    if (characterUpperCaseEncryption(j, plainTextChars[i], upperKeys))
                        break;
                } else {
                    if (characterLowerCaseEncryption(j, plainTextChars[i], lowerKeys))
                        break;
                }
            }
        }
    }

    public void decryptEncrypted() {
        if (decrypted.length() > 0)
            decrypted = "";

        char[] plainTextChars = charSplit(encrypted);
        for (int i = 0; i < plainTextChars.length; i++) {
            for (int j = 0; j < upperKeys.length; j++) {
                if (Character.isUpperCase(plainTextChars[i])) {
                    if (characterUpperCaseDecryption(j, plainTextChars[i], upperKeys))
                        break;
                } else {
                    if (characterLowerCaseDecryption(j, plainTextChars[i], lowerKeys))
                        break;
                }
            }
        }
    }

    public void decryptSecret() {
        if (decrypted.length() > 0)
            decrypted = "";

        char[] plainTextChars = charSplit(secret);
        for (int i = 0; i < plainTextChars.length; i++) {
            for (int j = 0; j < upperKeys.length; j++) {
                if (Character.isUpperCase(plainTextChars[i])) {
                    if (characterUpperCaseDecryption(j, plainTextChars[i], upperKeys))
                        break;
                } else {
                    if (characterLowerCaseDecryption(j, plainTextChars[i], lowerKeys))
                        break;
                }
            }
        }
    }

    private boolean characterUpperCaseEncryption(int j, char plainTextChar, char[] upperKeys) {
        if (plainTextChar == upperKeys[j]) {
            encrypted += upperKeys[keyIndexEncryption(j)];
            return true;
        } else if (isComma(plainTextChar)) {
            encrypted += plainTextChar;
            return true;
        }
        return false;
    }

    private boolean characterLowerCaseEncryption(int j, char plainTextChar, char[] lowerKeys) {
        if (plainTextChar == lowerKeys[j]) {
            encrypted += lowerKeys[keyIndexEncryption(j)];
            return true;
        } else if (isComma(plainTextChar)) {
            encrypted += plainTextChar;
            return true;
        }
        return false;
    }

    private boolean characterUpperCaseDecryption(int j, char plainTextChar, char[] upperKeys) {
        if (plainTextChar == upperKeys[j]) {
            decrypted += upperKeys[keyIndexDecryption(j)];
            return true;
        } else if (isComma(plainTextChar)) {
            decrypted += plainTextChar;
            return true;
        }
        return false;
    }

    private boolean characterLowerCaseDecryption(int j, char plainTextChar, char[] lowerKeys) {
        if (plainTextChar == lowerKeys[j]) {
            decrypted += lowerKeys[keyIndexDecryption(j)];
            return true;
        } else if (isComma(plainTextChar)) {
            decrypted += plainTextChar;
            return true;
        }
        return false;
    }

    private int keyIndexEncryption(int index) {
        int counter = 0;
        while (counter != shiftInput){
            if (index < 25){
                index++;
            } else {
                index = 0;
            }
            counter++;
        }

        return index;
    }

    private int keyIndexDecryption(int index) {
        int counter = shiftInput;
        while (counter != 0){
            if (index >= 1 ){
                index--;
            } else {
                index = 25;
            }
            counter--;
        }

        return index;
    }

    private char[] charSplit(String input) {
        char[] chars = new char[input.length()];

        for (int i = 0; i < input.length(); i++)
            chars[i] = input.charAt(i);

        return chars;
    }

    private boolean isComma(char plainTextChar) {
        return plainTextChar == ',' || plainTextChar == '.' || plainTextChar == ' ';
    }

    public String getEncrypted() {
        return encrypted;
    }

    public String getDecrypted() {
        return decrypted;
    }

    public void setShiftInput(int shiftInput) {
        this.shiftInput = shiftInput;
    }
}
