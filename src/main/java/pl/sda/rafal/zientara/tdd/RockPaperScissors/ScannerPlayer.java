package pl.sda.rafal.zientara.tdd.RockPaperScissors;

import java.util.Scanner;

public class ScannerPlayer implements Player {

    @Override
    public GameAction getAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-paper");
        System.out.println("2-scissors");
        System.out.println("3-rock");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: return GameAction.paper;
            case 2: return GameAction.scissors;
            case 3: return GameAction.rock;
            default: return null;
        }
    }
}
