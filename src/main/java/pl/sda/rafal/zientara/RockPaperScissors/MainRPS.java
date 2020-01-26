package pl.sda.rafal.zientara.RockPaperScissors;

import pl.sda.rafal.zientara.RockPaperScissors.Players.Player;
import pl.sda.rafal.zientara.RockPaperScissors.Players.RandomPlayer;
import pl.sda.rafal.zientara.RockPaperScissors.Players.ScanerPlayer;


public class MainRPS {

    public static void main(String[] args) {

        Player player1 = new RandomPlayer();
        Player player2 = new ScanerPlayer();

        GameAction action1 = player1.getAction();
        GameAction action2 = player2.getAction();
        System.out.println("Player 1 action " + action1);
        System.out.println("Player 2 action " + action2);

        GameResult result = getResault(action1, action2);


        System.out.println(result);

    }

    private static GameResult getResault(GameAction action1, GameAction action2) {

        if (action1 == action2) {
            return GameResult.DRAW;
        }
        if ((action1 == GameAction.PAPER && action2 == GameAction.ROCK) ||
                (action1 == GameAction.ROCK && action2 == GameAction.SCISSORS) ||
                (action1 == GameAction.SCISSORS && action2 == GameAction.PAPER)
        ) {
            return GameResult.PLAYER_1_WIN;
        }

        return GameResult.PLAYER_2_WIN;
    }
}
