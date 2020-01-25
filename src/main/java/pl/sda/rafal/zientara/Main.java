public class Main {

    public static void main(String[] args) {
        System.out.println("test");

        TicTacToe game = new TicTacToe();
        game.action(0, 0);
        game.action(0, 1);
        game.action(2, 1);
        game.action(2, 1);
        game.action(1, 1);
        game.action(2, 2);
        game.action(2, 2);
        game.printBoard();
    }

}
