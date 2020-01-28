package Swing;

import tdd.HangMan.Game;
import tdd.HangMan.Hangman;
import tdd.HangMan.Resources;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Siemanko!");
        TicTacToe game = new TicTacToe();
        game.action(0,0);
        game.printBoard();

        Game hangmanGame = new Game();
        hangmanGame.playAGame();
    }
}
