package pl.sda.rafal.zientara.hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hangman game = new Hangman();
        Scanner reader = new Scanner(System.in);
        String randomPuzzle = Resources.getRandomPuzzle();
        game.setPuzzle(randomPuzzle);

        while (!game.isGameOver()) {
            System.out.println(String.format("HP: %d/%d", game.getHp(),7));
            System.out.println("Hasło: " + game.getOutput());
            System.out.println("Podaj literę a-z (bez polskich znaków)");
            String input = reader.next();
            char c = input.charAt(0);
            game.guessLetter(c);
        }
        if (game.isPuzzleSolved()){
            System.out.println(game.getOutput());
            System.out.println("Brawooooooo! Jesteś zwycięzcą! Nowa gra? ");
        }else{
            System.out.println("Żle!");
        }
    }
}
