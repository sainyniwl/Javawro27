package pl.sda.rafal.zientara.tdd.rps;

import pl.sda.rafal.zientara.tdd.rps.players.Player;
import pl.sda.rafal.zientara.tdd.rps.players.RandomPlayer;
import pl.sda.rafal.zientara.tdd.rps.players.ScannerPlayer;
import pl.sda.rafal.zientara.tdd.rps.players.StonedPlayer;

public class MainRPS {

    public static void main(String[] args) {
        Player player1 = new RandomPlayer("Janusz Dzbanusz");
        Player player2 = new ScannerPlayer("buziaczek32");
//        Player player2 = () -> GameAction.PAPER;//lambda

        System.out.println(player1.getNick() + " vs " + player2.getNick());

        GameAction action1 = player1.getAction();
        GameAction action2 = player2.getAction();

        System.out.println(player1.getNick() + " action: " + action1);
        System.out.println(player2.getNick() + "player 2 action: " + action2);

        GameResult result = getResult(action1, action2);

        System.out.println(result);
    }

    private static GameResult getResult(GameAction action1,
                                        GameAction action2) {
        if (action1 == action2) {
            return GameResult.DRAW;
        }
        if ((action1 == GameAction.PAPER && action2 == GameAction.ROCK) ||
                (action1 == GameAction.ROCK && action2 == GameAction.SCISSORS) ||
                (action1 == GameAction.SCISSORS && action2 == GameAction.PAPER)) {
            return GameResult.PLAYER_1_WIN;
        }
        return GameResult.PLAYER_2_WIN;
    }
}
