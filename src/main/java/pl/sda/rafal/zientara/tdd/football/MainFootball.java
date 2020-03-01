package pl.sda.rafal.zientara.tdd.football;

import javax.swing.*;

public class MainFootball {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Football");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        FootballView footballView = new FootballView();
        frame.add(footballView);
        frame.setVisible(true);
    }
}
