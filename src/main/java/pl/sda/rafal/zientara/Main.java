package pl.sda.rafal.zientara;


import pl.sda.rafal.zientara.JFrame.Input1Window;
import pl.sda.rafal.zientara.JFrame.Input2Window;

public class Main {

    public static void main(String[] args) {

        Input1Window window1 = new Input1Window();
        Input2Window window2 = new Input2Window();

        window2.setListener(() -> {
            String text1 = window1.getInputText1();
            String text2 = window2.getInputText2();

            window1.setMergedText(text1 + text2);
        });

    }
}
