package pl.sda.rafal.zientara.Swing.ex2;

public class Main {
    public static void main(String[] args) {
        FirstWindow window1 = new FirstWindow();
        SecondWindow window2 = new SecondWindow();
        window2.setListener(new SecondWindow.MergeListener() {
            @Override
            public void onMergeClick() {
                String t1 = window1.getText1();
                String t2 =  window2.getText2();

                window1.setMergedText(t1+t2);
            }
        });
    }
}
