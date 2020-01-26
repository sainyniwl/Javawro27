package pl.sda.rafal.zientara.tdd.swing.RockPaperScissors;

import pl.sda.rafal.zientara.tdd.swing.RockPaperScissors.players.RandomPlayer;
import pl.sda.rafal.zientara.tdd.swing.RockPaperScissors.players.ScannerPlayer;
import pl.sda.rafal.zientara.tdd.swing.RockPaperScissors.players.StonedPlayer;

public class MainRPS {
    public static void main(String[] args) {
        Player player1 = new ScannerPlayer("użytkownik");
        Player player2 = new RandomPlayer("komputer");

        System.out.println(player1.getNick()+ " vs " + player2.getNick());

        GameAction action1 = player1.getAction();
        GameAction action2 = player2.getAction();

        System.out.println("player 1 action: " + action1);
        System.out.println("player 2 action: " + action2);

        GameResult result = getResult(action1, action2);

        System.out.println(result);


    }

    private static GameResult getResult(GameAction action1, GameAction action2) {
        if(action1 == action2){         //lub action1.equals(action2)
            return GameResult.DRAW;
        }
        if(action1 == GameAction.PAPER && action2 == GameAction.ROCK){
            return GameResult.PLAYER_1_WIN;
        }
        if(action1 == GameAction.ROCK && action2 == GameAction.SCISSORS){
            return GameResult.PLAYER_1_WIN;
        }
        if(action1 == GameAction.SCISSORS && action2 == GameAction.PAPER){
            return GameResult.PLAYER_1_WIN;
        }
        else return GameResult.PLAYER_2_WIN;
    }
}
