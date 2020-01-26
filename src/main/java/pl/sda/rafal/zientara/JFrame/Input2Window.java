package pl.sda.rafal.zientara.JFrame;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Input2Window {

    private final JButton button;
    //  private JButton button;
    //  private int clickCount = 0;
    private JTextField textField2;
    private String inputText;
    private MergeListener listener;

    public Input2Window() {

        JFrame frame = new JFrame("Input2Window");
        frame.setSize(300, 350);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        textField2 = new JTextField();
        textField2.setBounds(50, 50, 200, 100);

        frame.add(textField2);
        button = new JButton("Polacz");
        button.setBounds(50, 200, 200, 100);
        button.addActionListener(e -> listener.onMergeClick());
        frame.add(button);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    private void setInputText(String text
    ) {
        this.inputText = text;
    }

    public String getInputText2() {
        return textField2.getText();
    }

    public void setListener(MergeListener listener) {
        this.listener = listener;
    }

    public interface MergeListener {

        void onMergeClick();

    }

}
