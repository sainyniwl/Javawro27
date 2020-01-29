package pl.sda.rafal.zientara.tdd.swing.Hangman;

import java.util.Scanner;

public class MainHangman {

    public static void main(String[] args) {
        Hangman game = new Hangman();
        Scanner reader = new Scanner(System.in);

        String randomPuzzle = Resources.getRandomPuzzle();
        game.setPuzzle(randomPuzzle);

        while(!game.isGameOver()) {
            System.out.println(String.format("HP: %d/%d", game.getHp(), 7));
            System.out.println("Podaj litere od a-z, bądź całe hasło (bez polskich znaków):");
            System.out.println("Hasło: " + game.getOutput());
            String input = reader.nextLine();
            game.guessLetter(input);
            System.out.println(game.getOutput());
        }

        if (game.isPuzzleSolved()){
            System.out.println(game.getOutput());
            System.out.println("Brawo ziomek xD");
        } else {
            System.out.println("Nope, inne hasło. D:");
        }


    }
}
