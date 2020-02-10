package pl.sda.rafal.zientara.zadaniaTDD_09_02;

public class TextCorrector {

    public String wordToUpperCase(String text) {
        if (text == null) {
            return null;
        }
        return capitalizeString(text.toLowerCase());
    }


    private String capitalizeString(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        char ch = ' ';
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '-' && text.charAt(i - 1) != ' ' && text.charAt(i + 1) != ' ')
                text = text.replace("-", " - ");
            if (ch == ' ' && text.charAt(i) != ' ')
                stringBuilder.append(Character.toUpperCase(text.charAt(i)));
            else
                stringBuilder.append(text.charAt(i));
            ch = text.charAt(i);
        }
        return stringBuilder.toString().trim();
    }

}
