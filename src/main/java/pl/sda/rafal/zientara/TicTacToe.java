package pl.sda.rafal.zientara;

public class TicTacToe {
    public static final int BOARD_SIZE = 3; //static daje to, że istnieje tylko jedna taka zmienna na cały program
    private FieldStatus [][] board = new FieldStatus[BOARD_SIZE][BOARD_SIZE];
    private boolean isOTurn = false;

    public TicTacToe() {
        for (int i = 0; i < BOARD_SIZE; i++) { //ctrl+d zrobi duplikat linijki
            //ctrl+alt+l robi wcięcia
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j]=FieldStatus.EMPTY;
            }
        }
    }

    public FieldStatus getFieldStatus(int col, int row) {
        return board[row][col];
    }

    public void action(int col, int row) {
        if (isOTurn){
            board[row][col] = FieldStatus.O;
        } else {
            board[row][col] = FieldStatus.X;
        }
        isOTurn =!isOTurn; //po ruchu przestawiamy z X na O i odwrotnie
}

    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(" "+getFieldStatus(j,i).getText());
                if (j!=BOARD_SIZE-1){
                    System.out.print(" |");
                }
            }
            if(i!=BOARD_SIZE-1) {
                System.out.println();
                System.out.println(" - + - + - ");
            }
        }
    }
}
