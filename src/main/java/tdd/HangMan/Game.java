package tdd.HangMan;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
    private Hangman hangman = new Hangman();
    private String randomPuzzle;
    private int choice;

    private void startAGame() {
        randomPuzzle = Resources.getRandomPuzzle();
        hangman.setPuzzle(randomPuzzle);
    }

    private void choiceMenu() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press 1 to try to unhide a letter");
            System.out.println("Press 2 to try to type whole word");
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            e.getMessage();
            System.out.println("Podaj odpowiednią LICZBĘ!");
        }
    }

    private boolean matcher(char c) {
        return Pattern.matches("[A-Za-z]",String.valueOf(c));
    }

    public void playAGame() {
        startAGame();
        while (!hangman.gameOver()) {
            System.out.println(hangman.getOutput());
            choiceMenu();
    if (choice == 1) {
        System.out.println(hangman.getOutput());
        System.out.println("Podaj litere od a do z");
        Scanner scanner = new Scanner(System.in);
        char c = scanner.nextLine().charAt(0);
        if (matcher(c)) {
            hangman.guessLetter(c);
            System.out.println(hangman.getOutput());
            System.out.println(String.format("HP: %d/%d", hangman.getHp(), 7));
        }
        else System.out.println("Podaj litere");
    }
    if (choice == 2) {
        hangman.typeWholeWord();
    }
        }
        if (hangman.isPuzzleSolved()) {
            System.out.println("Jestes zwyciezca");
        }
        if (hangman.getHp() == 0) System.out.println("Looser");
        System.out.println("Haslo: " + randomPuzzle);
    }
}
