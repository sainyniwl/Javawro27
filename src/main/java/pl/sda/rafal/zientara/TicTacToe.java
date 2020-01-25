package pl.sda.rafal.zientara;

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
        GameResult result = checkResult();
        if (result != GameResult.PENDING){
            throw new IllegalStateException("Go home!");
        }
        FieldStatus status = getFieldStatus(col, row);

        if (status != FieldStatus.EMPTY) {
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
                FieldStatus status = getFieldStatus(row, column);
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
        if (isHorizontalWin(FieldStatus.X) || isVerticalWin(FieldStatus.X) || isDiagonalLeftWin(FieldStatus.X) || isDiagonalRightWin(FieldStatus.X))
            return GameResult.PLAYER_X_WIN;
        if (isHorizontalWin(FieldStatus.O) || isVerticalWin(FieldStatus.O) || isDiagonalLeftWin(FieldStatus.X) || isDiagonalRightWin(FieldStatus.X))
            return GameResult.PLAYER_O_WIN;
        if (isBoardFull()){
            return GameResult.DRAW;
        }
        return GameResult.PENDING;
    }

    public boolean isBoardFull(){
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                FieldStatus status = getFieldStatus(row, column);
                if (status == FieldStatus.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isVerticalWin(FieldStatus player) {
        for (int col = 0; col < BOARD_SIZE; col++) {
            FieldStatus row1 = getFieldStatus(col, 0);
            FieldStatus row2 = getFieldStatus(col, 1);
            FieldStatus row3 = getFieldStatus(col, 2);
            if(row1 == player && row2 == player && row3 == player) {
                return true;
            }
        }
        return false;
    }

    private boolean isHorizontalWin(FieldStatus player) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            FieldStatus col1 = getFieldStatus(0, row);
            FieldStatus col2 = getFieldStatus(1, row);
            FieldStatus col3 = getFieldStatus(2, row);
            if (col1 == player && col2 == player && col3 == player) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalLeftWin(FieldStatus player) {
            FieldStatus check1 = getFieldStatus(0, 0);
            FieldStatus check2 = getFieldStatus(1, 1);
            FieldStatus check3 = getFieldStatus(2, 2);
            return check1 == player && check2 == player && check3 == player;
    }

    private boolean isDiagonalRightWin(FieldStatus player) {
        FieldStatus check1 = getFieldStatus(2, 0);
        FieldStatus check2 = getFieldStatus(1, 1);
        FieldStatus check3 = getFieldStatus(0, 2);
        return check1 == player && check2 == player && check3 == player;
    }
}