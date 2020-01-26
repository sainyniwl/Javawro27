package pl.sda.rafal.zientara.swing;

import java.util.Scanner;

public class ScannerPlayer extends Player {
    public ScannerPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getNick() + " Podaj akcje r/p/s");
        while (true){
        String input = scanner.next().toLowerCase();
            switch (input) {
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
            }
        }
    }
}
