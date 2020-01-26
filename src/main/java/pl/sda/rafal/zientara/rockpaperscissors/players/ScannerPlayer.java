package pl.sda.rafal.zientara.rockpaperscissors.players;

import pl.sda.rafal.zientara.rockpaperscissors.GameAction;

import java.util.Scanner;

public class ScannerPlayer extends Player {

    public ScannerPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println( getNick() + " podaj akcję R/P/S");
        while (true) {
        String next = scanner.next();
            switch (next) {
                case "r":
                case "rock":
                    return GameAction.ROCK;
                case "p":
                case "paper":
                    return GameAction.PAPER;
                case "s":
                case "scissors":
                    return GameAction.SCISSORS;
                default:
                    System.out.println("...");
//                    return getAction(); // można rekurencja, ale wtedy będzie dużo scanner i String
            }
        }
    }
}
