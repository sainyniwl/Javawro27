package pl.sda.rafal.zientara.swing.text_together;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputWindow2 {

    private JButton button;
    private JTextField secondText;
    private MergeListener listener;

    public void setListener(MergeListener listener) {
        this.listener = listener;
    }

    public InputWindow2(){



        JFrame frame = new JFrame("Second Window");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setResizable(false);

        secondText = new JTextField();
        secondText.setBounds(50, 50, 200, 100);
        frame.add(secondText);

        button = new JButton("Połącz teksty!");
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

    public String getSecondString() {
        return secondText.getText();
    }


    public interface MergeListener{

        void onMergeClicked();
    }

}

