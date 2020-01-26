package pl.sda.rafal.zientara.tdd.RockPaperScissor.Players;

import pl.sda.rafal.zientara.tdd.RockPaperScissor.GameAction;

import java.util.Scanner;

public class ScannerPlayer implements Player{
    @Override
    public GameAction getAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj Akcji r/p/s");
        while(true) {
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "r":
                case "rock":
                    return GameAction.ROCK;
                case "s":
                case "scissors":
                    return GameAction.SCISSORS;
                case "p":
                case "paper":
                    return GameAction.PAPER;
                default:
                    System.out.println("... :/");
            }
        }
    }
}
