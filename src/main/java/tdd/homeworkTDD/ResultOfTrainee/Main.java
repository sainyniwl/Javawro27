package tdd.homeworkTDD.ResultOfTrainee;

public class Main {

    public static void main(String[] args) {
        Input1Window window1 = new Input1Window();
        Input2Window window2 = new Input2Window();

        window2.setListener(new Input2Window.MergeListener() {
            @Override
            public void onMergeClicked() {
                String text1 = window1.getText1();
                String text2 = window2.getText2();
                //window.zmienna;
                //window.funkcja();
                window1.setMergedText(text1 + text2);
            }
        });

    }
}
