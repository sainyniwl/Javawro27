package pl.sda.rafal.zientara.swing;

public class MainRPS {
    public static void main(String[] args) {
//        Player player1 = new StonedPlayer();
//        Player player1 = new RandomPlayer();
        Player player1 = new ScannerPlayer("koko");
//        Player player2 = new StonedPlayer();
        Player player2 = new RandomPlayer("loko");
        GameAction action1 = player1.getAction();
        GameAction action2 = player2.getAction();

        GameResult result = getResult(action1,action2);
        System.out.println(player1.getNick() + " action " + action1);
        System.out.println(player2.getNick() + " action " + action2);
        System.out.println(result);
    }

    private static GameResult getResult(GameAction action1, GameAction action2) {
        if(action1.equals(action2)){ //enumy możemy porównywać za pomocą ==
            return GameResult.DRAW;
        }
        if (action1 == GameAction.PAPER && action2 == GameAction.ROCK){
            return GameResult.PLAYER_1_WIN;
        }
        if (action1 == GameAction.ROCK && action2 == GameAction.SCISSORS){
            return GameResult.PLAYER_1_WIN;
        }
        if (action1 == GameAction.SCISSORS && action2 == GameAction.PAPER){
            return GameResult.PLAYER_1_WIN;
        }
        return GameResult.PLAYER_2_WIN;
    }
}
