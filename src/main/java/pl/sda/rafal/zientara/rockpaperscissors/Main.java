package pl.sda.rafal.zientara.rockpaperscissors;

import pl.sda.rafal.zientara.rockpaperscissors.players.Player;
import pl.sda.rafal.zientara.rockpaperscissors.players.RandomPlayer;
import pl.sda.rafal.zientara.rockpaperscissors.players.ScannerPlayer;
import pl.sda.rafal.zientara.rockpaperscissors.players.StonedPlayer;

public class Main {

    public static void main(String[] args) {

        Player player1 = new ScannerPlayer();
        Player player2 = new RandomPlayer();

        GameAction action1 = player1.getAction();
        GameAction action2 = player2.getAction();

        System.out.println("Player1 action: " + action1);
        System.out.println("Player2 action: " + action2);

        GameResult result = getResult(action1, action2);

        System.out.println(result);

    }

    private static GameResult getResult(GameAction action1, GameAction action2) {
        if (action1 == action2) {
            return GameResult.DRAW;
        } else if (action1 == GameAction.PAPER && action2 == GameAction.ROCK ||
                action1 == GameAction.ROCK && action2 == GameAction.SCISSORS ||
                action1 == GameAction.SCISSORS && action2 == GameAction.PAPER) {
            return GameResult.PLAYER_1_WIN;
        }
        return GameResult.PLAYER_2_WIN;
    }
}
