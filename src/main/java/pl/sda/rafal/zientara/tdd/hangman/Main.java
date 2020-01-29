package pl.sda.rafal.zientara.tdd.hangman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
String puzzle = "quit";
String inputText = "QuIt";
        System.out.println(inputText.equalsIgnoreCase(puzzle));
        HangMan game = new HangMan();
        game.game();


    }
}
