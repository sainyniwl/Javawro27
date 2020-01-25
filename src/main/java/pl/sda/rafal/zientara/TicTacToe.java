package pl.sda.rafal.zientara;

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
            System.out.println("");
            for (int j = 0; j < BOARD_SIZE; j++) {
                    System.out.print(getFieldStatus(i, j).getText());
                if(j < BOARD_SIZE - 1) {
                    System.out.print("|");
                }
                }

            }

        }

}

