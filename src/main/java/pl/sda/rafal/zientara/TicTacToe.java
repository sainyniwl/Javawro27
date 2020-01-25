package pl.sda.rafal.zientara;

public class TicTacToe {
    public static final int size = 3;
    private FieldStatus[][] tab = new FieldStatus[size][size];
    private boolean isOTurn = false;

    public TicTacToe() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tab[i][j] = FieldStatus.EMPTY;
            }
        }
    }

    public FieldStatus getFieldStatus(int col, int row) {
        return tab[row][col];
    }

    public void action(int col, int row) {
        GameResult result = checkResult();
        if (result != GameResult.PENDING) {
            throw new IllegalStateException("Go Home");
        }
        FieldStatus status = getFieldStatus(col, row);
        if (status != FieldStatus.EMPTY) throw new IllegalStateException("Pole zajęte");
        if (isOTurn) {
            tab[row][col] = FieldStatus.O;
        } else {
            tab[row][col] = FieldStatus.X;
        }
        isOTurn = !isOTurn;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                FieldStatus status = getFieldStatus(j, i);
                System.out.print(status.getEmpty());

                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("-+-+-");
            }
        }
    }

    public GameResult checkResult() {
        if (isPlayerWin(FieldStatus.X)) return GameResult.PLAYER_X_WIN;
        if (isPlayerWin(FieldStatus.O)) return GameResult.PLAYER_O_WIN;
        if (checkIfDraw()) return GameResult.DRAW;
        return GameResult.PENDING;
    }


    private boolean isHorizontalWin(FieldStatus player) {

        for (int row = 0; row < size; row++) {
            FieldStatus col1 = getFieldStatus(0, row);
            FieldStatus col2 = getFieldStatus(1, row);
            FieldStatus col3 = getFieldStatus(2, row);
            if (col1 == player && col2 == player && col3 == player) {
                return true;
            }
        }
        return false;
    }

    private boolean isVerticalWin(FieldStatus player) {
        for (int col = 0; col < size; col++) {
            FieldStatus row1 = getFieldStatus(col, 0);
            FieldStatus row2 = getFieldStatus(col, 1);
            FieldStatus row3 = getFieldStatus(col, 2);
            if (row1 == player && row2 == player && row3 == player) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalWinLeft(FieldStatus player) {
        FieldStatus pos1 = getFieldStatus(0, 0);
        FieldStatus pos2 = getFieldStatus(1, 1);
        FieldStatus pos3 = getFieldStatus(2, 2);
        return pos1 == player && pos2 == player && pos3 == player;
    }

    private boolean isDiagonalWinRight(FieldStatus player) {
        FieldStatus pos1 = getFieldStatus(0, 2);
        FieldStatus pos2 = getFieldStatus(1, 1);
        FieldStatus pos3 = getFieldStatus(2, 0);
        return pos1 == player && pos2 == player && pos3 == player;
    }

    private boolean isPlayerWin(FieldStatus player) {
        if (isHorizontalWin(player)) return true;
        if (isHorizontalWin(player)) return true;
        if (isVerticalWin(player)) return true;
        if (isVerticalWin(player)) return true;
        if (isDiagonalWinLeft(player)) return true;
        if (isDiagonalWinLeft(player)) return true;
        if (isDiagonalWinRight(player)) return true;
        return isDiagonalWinRight(player);
    }

    private boolean checkIfDraw() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                FieldStatus drawStatus = getFieldStatus(row, col);
                if (drawStatus == FieldStatus.EMPTY) return false;
            }
        }
        return true;
    }
}
