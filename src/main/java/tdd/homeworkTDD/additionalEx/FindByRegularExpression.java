package tdd.homeworkTDD.additionalEx;

import org.joda.time.LocalDate;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindByRegularExpression {
    private String inputRegex="";
    private String inputField = "";
    private String result = "";

    public FindByRegularExpression() {
        JFrame frameWithInputOfStringAndRegex = new JFrame();
        frameWithInputOfStringAndRegex.setSize(400, 500);
        frameWithInputOfStringAndRegex.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Type String
        JTextField fieldWithUsersString = new JTextField("");
        fieldWithUsersString.setBounds(50, 50, 100, 100);
        fieldWithUsersString.setName("Number 1");

        //Type Regular Expression
        JTextField fieldWithUsersRegex = new JTextField("");
        fieldWithUsersRegex.setBounds(150, 50, 100, 100);
        fieldWithUsersRegex.setName("Number 1");

        //My result [Regex] in String
        JLabel resultLabel = new JLabel("My result [Regex] in String");
        resultLabel.setBounds(100, 250, 200, 50);
        frameWithInputOfStringAndRegex.add(resultLabel);

        JButton buttonToGetRegexInString = new JButton("Find regex in String");
        buttonToGetRegexInString.setBounds(100, 150, 100, 100);
        buttonToGetRegexInString.addActionListener(actionEvent -> {
            inputField = fieldWithUsersString.getText();
            inputRegex = fieldWithUsersRegex.getText();
            result = findRegexInString(inputField,inputRegex);
            resultLabel.setText(result);
            System.out.println(result);
        });
        frameWithInputOfStringAndRegex.add(buttonToGetRegexInString);
        frameWithInputOfStringAndRegex.add(fieldWithUsersRegex);
        frameWithInputOfStringAndRegex.add(fieldWithUsersString);

        JButton getResultIntoAFile = new JButton("Save result to file");
        getResultIntoAFile.setBounds(100, 350, 100, 100);
        getResultIntoAFile.addActionListener(actionEvent -> {
            fileWriter(result);
            System.out.println("File has been saved");
        });
        frameWithInputOfStringAndRegex.add(getResultIntoAFile);

        frameWithInputOfStringAndRegex.setResizable(false);
        frameWithInputOfStringAndRegex.setLayout(null);
        frameWithInputOfStringAndRegex.setVisible(true);
    }

    private String findRegexInString(String text, String regex) {
        String resultString = "";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        if (m.find()) {
            resultString = m.group();
        }
        return resultString;
    }
    private void fileWriter(String resultText) {
        try {
            FileWriter writer = new FileWriter("result.txt");
            BufferedWriter out = new BufferedWriter(writer);
            out.write("Local time: "+getDate());
            out.write("\nMy result: "+resultText);
            out.close();
        }catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    private String getDate() {
        LocalDate date = new LocalDate();
        return date.getDayOfMonth()+" "+date.getMonthOfYear()+" "+date.getYear();
    }
}