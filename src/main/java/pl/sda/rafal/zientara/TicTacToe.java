package pl.sda.rafal.zientara;

import java.lang.reflect.Field;

public class TicTacToe {
    public static final int BOARD_SIZE = 3;

    private FieldStatus[][] board = new FieldStatus[BOARD_SIZE][BOARD_SIZE];
    private boolean isOTurn = false;

    public TicTacToe() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                board[row][column] = FieldStatus.EMPTY;
            }
        }
    }

    public FieldStatus getFieldStatus(int col, int row) {
        return board[row][col];
    }


    public void action(int col, int row) {
        if (isOTurn) {
            board[row][col] = FieldStatus.O;
        } else {
            board[row][col] = FieldStatus.X;
        }
        isOTurn = !isOTurn;
    }

    public void printBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                FieldStatus status = getFieldStatus(row,column);
                System.out.print(status.getText());
                if (column < BOARD_SIZE - 1)
                    System.out.print("|");
            }
            System.out.println();
            if (row < BOARD_SIZE - 1)
            System.out.println("-+-+-");
        }
    }
}
