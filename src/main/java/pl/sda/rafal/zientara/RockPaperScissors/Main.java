package pl.sda.rafal.zientara.RockPaperScissors;

import pl.sda.rafal.zientara.RockPaperScissors.players.Player;
import pl.sda.rafal.zientara.RockPaperScissors.players.RandomPlayer;
import pl.sda.rafal.zientara.RockPaperScissors.players.ScannerPlayer;

public class Main {

    public static void main(String[] args) {
        Player player1 = new ScannerPlayer();
        Player player2 = new RandomPlayer();

        GameAction action1 = player1.getAction();
        GameAction action2 = player2.getAction();

        GameResult result = getResult(action1, action2);
        System.out.println("Player 1 action: " + action1);
        System.out.println("Player 2 action: " + action2);
        System.out.println(result);
    }

    private static GameResult getResult(GameAction action1, GameAction action2) {
        if (action1 == action2) {
            return GameResult.DRAW;
        } else if ((action1 == GameAction.PAPER && action2 == GameAction.ROCK)
                || (action1 == GameAction.ROCK && action2 == GameAction.SCISSORS)
                || (action1 == GameAction.SCISSORS && action2 == GameAction.PAPER)) {
            return GameResult.PLAYER_1_WIN;
        } else return GameResult.PLAYER_2_WIN;


    }
}
