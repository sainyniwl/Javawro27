package pl.sda.rafal.zientara.tdd.RockPaperScissors;

public class Main {
    public static void main(String[] args) {
        Player player1 = new ScannerPlayer();
        Player player2 = new RandomPlayer();

        while (true) {
            System.out.println(ReturnRandomInt.random());
            GameAction action1 = player1.getAction();
            GameAction action2 = player2.getAction();
            GameResult result = getResult(action1, action2);
            System.out.println("Player 1: " + action1);
            System.out.println("Player 2: " + action2);
            System.out.println(result);
        }
    }

    private static GameResult getResult(GameAction action1, GameAction action2) {
        //mozna porownywac == bo istnieje tylko 1 enum na caly program ->adresy wiec beda takie same
        if (action1 == GameAction.rock && action2 == GameAction.scissors) return GameResult.PLAYER_1_WIN;
        if (action1 == GameAction.scissors && action2 == GameAction.paper) return GameResult.PLAYER_1_WIN;
        if (action1 == GameAction.paper && action2 == GameAction.rock) return GameResult.PLAYER_1_WIN;
        if (action1==action2) return GameResult.DRAW;
        else return GameResult.PLAYER_2_WIN;
    }
}
