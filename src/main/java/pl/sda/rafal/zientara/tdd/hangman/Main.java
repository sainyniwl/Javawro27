package pl.sda.rafal.zientara.tdd.hangman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        HangMan game = new HangMan();
        Scanner reader = new Scanner(System.in);
        game.setPuzzle(Resources.getRandomPuzzle());

        String input = "";
        while(!input.equals("quit")) {
            while (!game.isOver() && !input.equals("quit")) {
                System.out.println(String.format("HP: %d/%d", game.getHp(), 7));
                System.out.println(game.getOutput());
                System.out.print("Podaj literę: ");
                input = reader.next();
                char c = input.charAt(0);
                game.guessLetters(c);
            }
            if(!input.equals("quit")) System.out.println("\n\nNOWA GRA:\n");
            game.setPuzzle(Resources.getRandomPuzzle());

        }
    }
}
