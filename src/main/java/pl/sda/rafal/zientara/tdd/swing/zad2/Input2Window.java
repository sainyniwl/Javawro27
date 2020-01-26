package pl.sda.rafal.zientara.tdd.swing.zad2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Input2Window {
    private JTextField textView;
    private JButton button;
    private MergeListener listener;

    public Input2Window(){
        JFrame frame = new JFrame("Input 1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300,350);

        textView = new JTextField("input 1 text");
        textView.setBounds(50,50, 200,100);
        frame.add(textView);

        button = new JButton("Połącz");
        button.setBounds(50,200,200,100);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onMergeClicked();
            }
        });
        frame.add(button);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void setListener(MergeListener listener){
        this.listener = listener;
    }

    public String getText2() {
        return textView.getText();
    }


    public interface MergeListener{
        void onMergeClicked();
    }
}
