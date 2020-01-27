package tdd.HangMan;

import java.util.InputMismatchException;
import java.util.Scanner;

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
        choice = scanner.nextInt();
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
                char c='a';
                try {
                    c = scanner.nextLine().charAt(0);
                }catch(WrongSymbolException e) {
                    e.print(c);
                }
                hangman.guessLetter(c);
                System.out.println(hangman.getOutput());
                System.out.println(String.format("HP: %d/%d", hangman.getHp(), 7));
            }
            if (choice == 2) {
                if (hangman.typeWholeWord(randomPuzzle)) {
                    System.out.println("Jesteś zwycięzcą");
                    return;
                } else hangman.takeOneHp();
            }
        }
        if (hangman.isPuzzleSolved()) {
            System.out.println("Jestes zwyciezca");
        }
        if (hangman.getHp() == 0) System.out.println("Losser");
        System.out.println("Haslo: " + randomPuzzle);
    }
}
