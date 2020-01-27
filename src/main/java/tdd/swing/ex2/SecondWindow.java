package tdd.swing.ex2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondWindow {
        private JTextField textView;
        private JButton button;
        private MergeListener listener;


    public SecondWindow(){
            JFrame frame = new JFrame("Input 2");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setSize(350,350);

            textView = new JTextField();
            textView.setBounds(50,50, 200,50);

            frame.add(textView);

            frame.setLayout(null);
            frame.setVisible(true);

            button = new JButton("Merge");
            button.setBounds(50, 150, 200, 100);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    listener.onMergeClick();
                }
        });
            frame.add(button);
    }

    public String getText2() {
        return textView.getText();
    }

    public interface MergeListener {
            void onMergeClick();
    }

    public void setListener(MergeListener listener) {
        this.listener = listener;
    }
}

