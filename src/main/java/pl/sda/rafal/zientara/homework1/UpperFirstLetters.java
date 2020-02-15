package pl.sda.rafal.zientara.homework1;

public class UpperFirstLetters {

    String text;

    public UpperFirstLetters(String text) {
        this.text = text;
    }

    public String turnFirstLettersUpper() {
        char ch[] = new char[text.length()];

        for (int i = 0; i < ch.length; i++) {
            ch[i] = text.charAt(i);
        }

//        for (char element: ch) {
//            System.out.println(element);
//        }

        StringBuilder sb = new StringBuilder();

        if(Character.isLetter(ch[0])){
            char ch1 = Character.toUpperCase(ch[0]);
            sb.append(ch1);
        }else{
            sb.append(ch[0]);
        }

        for (int i = 1; i < ch.length; i++) {
            if(Character.isLetter(ch[i]) && Character.isLetter(ch[i -1])){
                sb.append(ch[i]);
            }else {
                char ch1 = Character.toUpperCase(ch[i]);
                sb.append(ch1);
            }
        }

        return sb.toString();
    }
}
