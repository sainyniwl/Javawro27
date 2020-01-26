package pl.sda.rafal.zientara.Hangman;

import java.util.Scanner;

public class MainHangman {

    public static void main(String[] args) {

        Hangman game = new Hangman();
        Scanner scanner = new Scanner(System.in);
        String randomPuzzle = Resources.getRandomPazzle();
        game.setPuzzle(randomPuzzle);
        System.out.println("Game start");
        System.out.println("--------------");
        while (!game.isGameOver()) {
            System.out.println(String.format("HP: %d/%d", game.getHp(), 7));
            System.out.println("Haslo :" + game.getOutput());
            System.out.println("Enter letter 'a-z' : ");
            String input = scanner.next();
            char c = input.charAt(0);
            game.guessLetter(c);
            System.out.println(game.getOutput());
        }

        if (game.isPuzzleSolved()) {
            System.out.println("--------");
            System.out.println("Brawo xD");
        } else {
            System.out.println("--------------------");
            System.out.println("Nope, wrong word  :(");
            System.out.println("--------------------");
            System.out.println("Puzzle is : " + randomPuzzle);
        }

    }

}
