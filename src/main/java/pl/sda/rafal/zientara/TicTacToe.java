public class TicTacToe {

    public static final int BOARD_SIZE = 3;

    private FieldStatus[][] board = new FieldStatus[BOARD_SIZE][BOARD_SIZE];
    private boolean isOTurn = false;

    public TicTacToe() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = FieldStatus.EMPTY;
            }
        }
    }

    public FieldStatus getFieldStatus(int col, int row) {
        return board[row][col];
    }

    public void action(int col, int row) {
        FieldStatus status = getFieldStatus(col, row);
        if(status != FieldStatus.EMPTY) {
            throw new IllegalStateException("Pole zajęte");
        }

        if(isOTurn) {
            board[row][col] = FieldStatus.O;
            isOTurn = false;
        } else {
            board[row][col] = FieldStatus.X;
            isOTurn = true;
        }
    }

    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                FieldStatus status = getFieldStatus(j, i);
                System.out.print(status.getText());
                if(j < BOARD_SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if(i < BOARD_SIZE - 1) {
                System.out.println("-+-+-+-+-");
            }
        }
    }

    public GameResult checkResult() {
        for(int i = 0; i < BOARD_SIZE; i++) {
            FieldStatus col1 = getFieldStatus(0, i);
            FieldStatus col2 = getFieldStatus(1, i);
            FieldStatus col3 = getFieldStatus(2, i);
            if(col1 == FieldStatus.X && col2 == FieldStatus.X && col3 == FieldStatus.X) {
                return GameResult.PLAYER_X_WIN;
            }
        }

        for(int i = 0; i < BOARD_SIZE; i++) {
            FieldStatus row1 = getFieldStatus(i, 0);
            FieldStatus row2 = getFieldStatus(i, 1);
            FieldStatus row3 = getFieldStatus(i, 2);
            if(row1 == FieldStatus.X && row2 == FieldStatus.X && row3 == FieldStatus.X) {
                return GameResult.PLAYER_X_WIN;
            }
        }

        return GameResult.PENDING;
    }
}
