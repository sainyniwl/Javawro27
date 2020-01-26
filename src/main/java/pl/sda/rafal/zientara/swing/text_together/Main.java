package pl.sda.rafal.zientara.swing.text_together;

public class Main {

    public static void main(String[] args) {

        InputWindow1 window1 = new InputWindow1();
        InputWindow2 window2 = new InputWindow2();

        window2.setListener(new InputWindow2.MergeListener() {
            @Override
            public void onMergeClicked() {
               String text1 = window1.getFirstString();
               String text2 = window2.getSecondString();

               window1.setMergedText(text1 + " " + text2);
            }
        });

    }
}
