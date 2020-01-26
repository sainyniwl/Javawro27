package pl.sda.rafal.zientara.RockPaperScissors.Players;

import pl.sda.rafal.zientara.RockPaperScissors.GameAction;

import java.util.Scanner;

public class ScanerPlayer implements Player {
    @Override
    public GameAction getAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Padaj akcje r/p/s :");
        while (true) {
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
                    System.out.println("... :/");
            }
        }

    }
}
