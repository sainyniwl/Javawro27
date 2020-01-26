package pl.sda.rafal.zientara.tictactoe;

import pl.sda.rafal.zientara.tictactoe.FieldStatus;
import pl.sda.rafal.zientara.tictactoe.GameResult;

public class TicTacToe {

    public static final int BOARD_SIZE = 3;
    private boolean isOTurn = false;

    private FieldStatus[][] board = new FieldStatus[BOARD_SIZE][BOARD_SIZE];

    public TicTacToe() {

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = FieldStatus.EMPTY;
            }
        }
    }

    public FieldStatus getFieldStatus(int row, int col) {
        return board[row][col];
    }

    public void action(int row, int col) {
        FieldStatus status = getFieldStatus(row, col);
        GameResult checkResult = checkResult();

        if (checkResult != GameResult.PENDING) {
            throw new IllegalStateException("Go home");
        }

        if (status != FieldStatus.EMPTY) {
            throw new IllegalStateException("Pole zajęte");
        }

        if (isOTurn) {
            board[row][col] = FieldStatus.O;
            isOTurn = false;
        } else {
            board[row][col] = FieldStatus.X;
            isOTurn = true;
        }
    }

    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.println();
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(getFieldStatus(i, j).getText());
                if (j < BOARD_SIZE - 1) {
                    System.out.print("|");
                }
            }

        }

    }

    public GameResult checkResult() {

       if(isHorizontalWin(FieldStatus.X))
           return GameResult.PLAYER_X_WIN;
       else if(isHorizontalWin(FieldStatus.O))
           return GameResult.PLAYER_0_WIN;

        if(isVerticalWin(FieldStatus.X))
            return GameResult.PLAYER_X_WIN;
        else if(isVerticalWin(FieldStatus.O))
            return GameResult.PLAYER_0_WIN;

        if(isDiagonalWin(FieldStatus.X))
            return GameResult.PLAYER_X_WIN;
        else if(isDiagonalWin(FieldStatus.O))
            return GameResult.PLAYER_0_WIN;

        if(isDiagonalFromRightWin(FieldStatus.X))
            return GameResult.PLAYER_X_WIN;
        else if(isDiagonalFromRightWin(FieldStatus.O))
            return GameResult.PLAYER_0_WIN;

        if(isBoardFull()) return GameResult.DRAW;

        return GameResult.PENDING;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                FieldStatus fieldStatus = getFieldStatus(i, j);
                if(fieldStatus == FieldStatus.EMPTY)
                    return false;
            }
        }
        return true;
    }

    private boolean isHorizontalWin(FieldStatus player){
        for (int i = 0; i < BOARD_SIZE; i++) {
            FieldStatus col1 = getFieldStatus(i, 0);
            FieldStatus col2 = getFieldStatus(i, 1);
            FieldStatus col3 = getFieldStatus(i, 2);
            if(col1 == player && col2 == player && col3 == player){
                return true;
            }
        }
        return false;

    }

    private boolean isVerticalWin(FieldStatus player){
        for (int i = 0; i < BOARD_SIZE; i++) {
            FieldStatus col1 = getFieldStatus(0, i);
            FieldStatus col2 = getFieldStatus(1, i);
            FieldStatus col3 = getFieldStatus(2, i);
            if(col1 == player && col2 == player && col3 == player){
                return true;
            }
        }
        return false;

    }

    private boolean isDiagonalWin(FieldStatus player){

            FieldStatus col1 = getFieldStatus(0, 0);
            FieldStatus col2 = getFieldStatus(1, 1);
            FieldStatus col3 = getFieldStatus(2, 2);
        return col1 == player && col2 == player && col3 == player;

    }

    private boolean isDiagonalFromRightWin(FieldStatus player){

        FieldStatus col1 = getFieldStatus(0, 2);
        FieldStatus col2 = getFieldStatus(1, 1);
        FieldStatus col3 = getFieldStatus(2, 0);
        return col1 == player && col2 == player && col3 == player;

    }


}

