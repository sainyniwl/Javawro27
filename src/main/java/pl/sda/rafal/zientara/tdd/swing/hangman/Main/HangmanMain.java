package pl.sda.rafal.zientara.tdd.swing.hangman.Main;

import pl.sda.rafal.zientara.tdd.swing.hangman.Hangman;
import pl.sda.rafal.zientara.tdd.swing.hangman.Resources;

import java.util.Scanner;

public class HangmanMain {
    public static void main(String[] args) {
        Hangman game = new Hangman();
        Scanner reader = new Scanner(System.in);
        String randomPuzzle = Resources.getRandomPuzzle();
        game.setPuzzle(randomPuzzle);

        while(!game.isGameOver()) {
            System.out.println(String.format("HP: %d/%d", game.getHp(), 7));
            System.out.println("Haslo: " + game.getOutput());
            System.out.println("Podaj litere od a do z(bez polsich znakow)");
            String input = reader.next();
            char c = input.charAt(0);
            game.guessLetter(c);
        }
        if(game.isPuzzleSolved()){
            System.out.println("Brawo ziomek!");
        } else {
            System.out.println("Nope. Inne hasło. " + randomPuzzle);
        }
    }
}
