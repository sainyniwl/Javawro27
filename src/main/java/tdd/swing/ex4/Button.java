package tdd.swing.ex4;

import javax.swing.*;
import java.awt.*;

public class Button {
private JTextField textInput1;
private JTextField textInput2;

   public Button() {
       JFrame f = new JFrame("Add or Difference");
       f.setSize(400, 400);
       f.setResizable(false);
       f.setLayout(null);
       f.setVisible(true);
       f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       textInput1 = new JTextField();
       textInput1.setBounds(50, 50, 100, 100);
       textInput1.setName("Number 1");
       f.add(textInput1);
       textInput2 = new JTextField();
       textInput2.setBounds(150, 50, 100, 100);
       f.add(textInput2);
       textInput1.setName("Number 2");

       JLabel result = new JLabel("Result of operation",SwingConstants.CENTER);
       result.setBounds(100,250,100,100);
       result.setForeground(Color.red);
       result.setFont(result.getFont().deriveFont(50.0f));
       f.add(result);

       JButton buttonToSum = new JButton("Sum");
       buttonToSum.setBounds(50, 150, 100, 100);
       buttonToSum.addActionListener(actionEvent -> result.setText(String.valueOf(sum())));

       JButton buttonToDifference = new JButton("Difference");
       buttonToDifference.setBounds(150, 150, 100, 100);
       buttonToDifference.addActionListener(actionEvent -> result.setText(String.valueOf(diff())));
       f.add(buttonToSum);
       f.add(buttonToDifference);
   }

    private int getNumber1() {
        return Integer.parseInt(textInput1.getText());
    }
    private int getNumber2() {
        return Integer.parseInt(textInput2.getText());
    }

    private int sum() {
       return getNumber1()+getNumber2();
   }
   private int diff() {
       return getNumber1()-getNumber2();
   }

}
