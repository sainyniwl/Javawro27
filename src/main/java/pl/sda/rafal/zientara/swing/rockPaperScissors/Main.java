package pl.sda.rafal.zientara.swing.rockPaperScissors;

import pl.sda.rafal.zientara.swing.rockPaperScissors.players.Player;
import pl.sda.rafal.zientara.swing.rockPaperScissors.players.RandomPlayer;
import pl.sda.rafal.zientara.swing.rockPaperScissors.players.ScannerPlayer;
import pl.sda.rafal.zientara.swing.rockPaperScissors.players.StonedPlayer;

public class Main {

    public static void main(String[] args) {
        Player player1 = new RandomPlayer("Ktoś ");
        Player player2 = new ScannerPlayer("Buziaczek");

        GameAction action1 = player1.getAction();
        GameAction action2 = player2.getAction();

        System.out.println(player1.getNick());
        System.out.println(player2.getNick());

        System.out.println("player1 action: " + action1);
        System.out.println("player2 action: " + action2);

        GameResult result = getResult(action1,action2);

        System.out.println(result);

    }

    private static GameResult getResult(GameAction action1, GameAction action2) {
        if (action1 == action2){ //przy enumach porównujemy adresy w pamięci
            return GameResult.DRAW;
        } if (action1 == GameAction.PAPER && action2 == GameAction.ROCK){
            return GameResult.PLAYER_1_WIN;
        }if (action1 == GameAction.ROCK && action2 == GameAction.SCISSORS){
            return GameResult.PLAYER_1_WIN;
        }if (action1 == GameAction.SCISSORS && action2 == GameAction.PAPER){
            return GameResult.PLAYER_1_WIN;
        }
        return GameResult.PLAYER_2_WIN;
    }

}
