package pl.sda.rafal.zientara;

public class TicTacToe {
    public static final int size =3;
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
        if (isOTurn) {
            tab[row][col] = FieldStatus.O;
        }
        else {
            tab[row][col] = FieldStatus.X;

        }
        isOTurn=!isOTurn;
    }
    public void printBoard() {
        for (int row = 0; row <size; row++) {
            for (int col = 0; col <size; col++) {
                FieldStatus status = getFieldStatus(row,col);
                System.out.print(status.getEmpty());
                if (col<size-1) System.out.print("|");
            }
            if (row<size-1) {
                System.out.println();
                System.out.println("-+-+-");
            }
        }
    }

}
