package pl.sda.rafal.zientara.swing.text_together;
import javax.swing.*;

public class InputWindow1 {

    private JTextField firstText;
    private JLabel label;

    public InputWindow1(){

        JFrame frame = new JFrame("First Window");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setResizable(false);

        firstText = new JTextField();
        firstText.setBounds(50, 50, 200, 100);
        frame.add(firstText);

        label = new JLabel("0", SwingConstants.CENTER);
        label.setBounds(50, 200, 200, 100);
        frame.add(label);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    public String getFirstString() {
        return firstText.getText();
    }

    public void setMergedText(String wynik) {
        label.setText(wynik);

    }
}
