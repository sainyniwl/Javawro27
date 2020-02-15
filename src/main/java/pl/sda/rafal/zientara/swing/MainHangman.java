package pl.sda.rafal.zientara.swing;

import java.util.Scanner;

public class MainHangman {
    public static void main(String[] args) {
        Hangman game = new Hangman();
        Scanner reader = new Scanner(System.in);
        String randomPuzzle = Resources.getRandomPuzzle();
        game.setPuzzle(randomPuzzle);
        String password = "puste";

        while (!game.isGameOver()) {
            System.out.println(String.format("HP: %d/%d", game.getHp(), 7));
            System.out.println("Haslo: " + game.getOutput());
                System.out.println("Podaj literę a-z (bez polskich znakow) bądź 1. aby podać hasło");
                Scanner reader1 = new Scanner(System.in);
                String input = reader.nextLine();
                char c = input.charAt(0);
                if ((int)(c)==49){
                    System.out.println("Podaj hasło");
                    password = reader.nextLine();
                    game.setHp(0);
                } else {
                    game.guessLetter(c);
                }


                if (game.isPuzzleSolved() || randomPuzzle.toLowerCase().contains(password.toLowerCase())) {
                    System.out.println("Brawo! You WIN!");
                } else if (game.getHp()==0){
                    System.out.println("Pudło. Inne hasło");
                }
            }

    }
}
