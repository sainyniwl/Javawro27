package pl.sda.rafal.zientara;

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
        if (isOTurn) {
            board[row][col] = FieldStatus.O;
            isOTurn = false;
        } else {
            board[row][col] = FieldStatus.X;
            isOTurn = true;
        }
//        isOTurn = !isOTurn; // inna opcja
    }

    public void printBoard() {
//        getFieldStatus()
//        X|O|EMPTY
//        -+-+-
//        X|O|X
//        -+-+-
//        X|O|X

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                FieldStatus status = getFieldStatus(j, i);
                System.out.print(status.getText());
                if (j < BOARD_SIZE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < BOARD_SIZE - 1) {
                System.out.println("-+-+-");
            }
        }
    }
}
