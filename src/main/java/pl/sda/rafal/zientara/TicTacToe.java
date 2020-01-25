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

    public FieldStatus getFieldStatus(int col,int row) {
        return board[row][col];
    }


    public void action(int col,int row) {
        FieldStatus status = getFieldStatus(col,row);

        if (status!=FieldStatus.EMPTY){
            throw new IllegalStateException("Pole zajęte");
        }

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

    public GameResult checkResult() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            FieldStatus col1 = getFieldStatus(0,row);
            FieldStatus col2 = getFieldStatus(1,row);
            FieldStatus col3 = getFieldStatus(2,row);
            if (col1==FieldStatus.X && col2==FieldStatus.X && col3==FieldStatus.X) {
                return GameResult.PLAYER_X_WIN;
            }
        }
        for (int col = 0; col < BOARD_SIZE; col++) {
            FieldStatus row1 = getFieldStatus(col,0);
            FieldStatus row2 = getFieldStatus(col,1);
            FieldStatus row3 = getFieldStatus(col,2);
            if (row1==FieldStatus.X && row2==FieldStatus.X && row3==FieldStatus.X) {
                return GameResult.PLAYER_X_WIN;
            }
        }
        return GameResult.PENDING;
    }
}
