package tdd.homeworkTDD.ex5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CountLettersAndWords {
private JTextField textInput1;
private int wordsCount;
private int lettersCount;

   public CountLettersAndWords() {
       JFrame f = new JFrame("Add or Difference");
       f.setSize(400, 400);
       f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       textInput1 = new JTextField();
       textInput1.setBounds(150, 50, 100, 100);
       textInput1.setName("Number 1");
       f.add(textInput1);

       JLabel numberOfWords = new JLabel("0", SwingConstants.CENTER);
       numberOfWords.setBounds(100,250,100,100);
       numberOfWords.setForeground(Color.red);
       numberOfWords.setFont(numberOfWords.getFont().deriveFont(30.0f));
       f.add(numberOfWords);

       JLabel numberOfLetters = new JLabel("0",SwingConstants.CENTER);
       numberOfLetters.setBounds(200,250,100,100);
       numberOfLetters.setForeground(Color.red);
       numberOfLetters.setFont(numberOfLetters.getFont().deriveFont(30.0f));
       f.add(numberOfLetters);

       JButton countWords = new JButton("Count words");
       countWords.setBounds(50, 150, 100, 100);
       countWords.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               wordsCount = textInput1.getText().split(" ").length;
               numberOfWords.setText(String.valueOf(wordsCount));
           }
       });

       JButton countLetters = new JButton("Count letters");
       countLetters.setBounds(150, 150, 100, 100);
       countLetters.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
              lettersCount = Arrays.toString(textInput1.getText().split(" ")).split("").length;
               numberOfLetters.setText(String.valueOf(lettersCount));
           }
       });
f.add(countLetters);
f.add(countWords);
       f.setResizable(false);
       f.setLayout(null);
       f.setVisible(true);

   }

}
