package pl.sda.rafal.zientara;

import pl.sda.rafal.zientara.tdd.HangMan.Hangman;
import pl.sda.rafal.zientara.tdd.HangMan.Resources;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Siemanko!");
        TicTacToe game = new TicTacToe();
        game.action(0,0);
        game.printBoard();

        Hangman hangman = new Hangman();
        String randomPuzzle = Resources.getRandomPuzzle();
        hangman.setPuzzle(randomPuzzle);

        while(!hangman.gameOver()) {
            System.out.println(hangman.getOutput());
            System.out.println("Podaj litere od a do z");
            Scanner scanner = new Scanner(System.in);
            char c = scanner.nextLine().charAt(0);
            hangman.guessLetter(c);
            System.out.println(hangman.getOutput());
            System.out.println(String.format("HP: %d/%d",hangman.getHp(),7));
        }
        if (hangman.isPuzzleSolved()) {
            System.out.println("Jestes zwyciezca");
        } else System.out.println("Looser");
        System.out.println("Haslo: "+ randomPuzzle);
    }
}
