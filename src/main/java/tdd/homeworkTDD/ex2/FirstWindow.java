package tdd.homeworkTDD.ex2;
import javax.swing.*;

public class FirstWindow {
    private JTextField textView;
    private JLabel label;
    String text= "";

    public static void main(String[] args) {
        new FirstWindow();
    }

    public FirstWindow(){
        JFrame frame = new JFrame("Input 1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300,350);

        textView = new JTextField("input 1 text");
        textView.setBounds(50,50, 200,50);

        textView.setText(text);
        frame.add(textView);

        label = new JLabel("0", SwingConstants.CENTER);
        label.setBounds(50,150,200,100);
        frame.add(label);


        frame.setLayout(null);
        frame.setVisible(true);
    }


    public String getText1() {
        return textView.getText();
    }

    public void setMergedText(String s) {
        label.setText(s);
    }
}