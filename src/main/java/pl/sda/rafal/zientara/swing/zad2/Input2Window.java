package pl.sda.rafal.zientara.swing.zad2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input2Window {

    private JTextField textView2;
    private JButton button;
    private MergeListener listener;



    public Input2Window() {

        JFrame frame = new JFrame("Input2");
        frame.isResizable();
        frame.setSize(300, 350);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        textView2 = new JTextField("input2 text");
        textView2.setBounds(50, 50, 200, 100);
        frame.add(textView2);


        button = new JButton("Połącz");
        button.setBounds(50, 200, 200, 100);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.onMergeClicked();
            }
        });
        frame.add(button);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public String getText2() {
        return textView2.getText();
    }

    public interface MergeListener{
        void onMergeClicked();
    }

    public void setListener(MergeListener listener) {
        this.listener = listener;
    }
}
