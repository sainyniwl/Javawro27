package pl.sda.rafal.zientara.tdd.rps.players;

import pl.sda.rafal.zientara.tdd.rps.GameAction;

import java.util.Scanner;

public class ScannerPlayer implements Player {
    @Override
    public GameAction getAction() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj akcje r/p/s");
        while (true) {
            String input = scanner.next().toLowerCase();
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
//                return getAction();//mozna rekurencja ale bedzie tworzyc duzo Scanner i String
            }
        }
    }
}

