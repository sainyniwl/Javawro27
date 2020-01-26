package pl.sda.rafal.zientara;

public class Main {

    public static void main(String[] args) {
        System.out.println("Siemanko!");
        TicTacToe game = new TicTacToe();
        game.action(0,0);
        game.printBoard();
    }
}
