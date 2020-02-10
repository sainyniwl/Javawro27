package pl.sda.rafal.zientara.tdd.tddExcercises.ex2;

public class LettersExc {

    public static String firtsLetterToUpperCase(String text){

        if(text != null) {
            if(text.length()>0) {
                String[] textArr = new String[text.length()];
                for (int i = 0; i < textArr.length; i++) {
                    textArr[i] = String.valueOf(text.charAt(i));
                }
                if (Character.isLetter(textArr[0].charAt(0))) textArr[0] = textArr[0].toUpperCase();
                text = textArr[0];

                for (int i = 1; i < textArr.length; i++) {
                    if (!Character.isLetter(textArr[i - 1].charAt(0)) && Character.isLetter(textArr[i].charAt(0)))
                        textArr[i] = textArr[i].toUpperCase();
                    text += textArr[i];
                }
            }
            return text;

        }
        return  null;
    }

}
