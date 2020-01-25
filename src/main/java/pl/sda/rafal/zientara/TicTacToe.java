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
        GameResult result = checkResult();
        if (result!=GameResult.PENDING){
            throw new IllegalStateException("Game Over");
        }
        FieldStatus status = getFieldStatus(col,row);
        if (status!=FieldStatus.EMPTY){
            throw new IllegalStateException("Pole zajęte");
        }
        if (isOTurn){
            board[row][col] = FieldStatus.O;
        } else {
            board[row][col] = FieldStatus.X;
        }
        isOTurn =!isOTurn; //po ruchu przestawiamy z X na O bądź odwrotnie
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

    public GameResult checkResult() {
        if(isHorizontalWin(FieldStatus.X) ||
                isVerticalWin(FieldStatus.X) ||
                isDiagonalWin(FieldStatus.X) ||
                isBackDiagonalWin(FieldStatus.X)){
                return GameResult.PLAYER_X_WIN;
            }
        if(isHorizontalWin(FieldStatus.O) ||
                isVerticalWin(FieldStatus.O) ||
                isDiagonalWin(FieldStatus.O) ||
                isBackDiagonalWin(FieldStatus.O)){
            return GameResult.PLAYER_O_WIN;
        }
        if(isBoardFull()){
            return GameResult.DRAW;
        }
        return GameResult.PENDING;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                FieldStatus fieldStatus = getFieldStatus(i,j);
                if (fieldStatus == FieldStatus.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isHorizontalWin(FieldStatus player){
        for (int i = 0; i < BOARD_SIZE; i++) { //i oznacza wiersz
            FieldStatus col1 = getFieldStatus(0,i);
            FieldStatus col2 = getFieldStatus(1,i);
            FieldStatus col3 = getFieldStatus(2,i);
            if(col1==player && col2 == player
                    && col3 == player){
                return true;
            }
        }
        return false;
    }
    private boolean isVerticalWin(FieldStatus player){
        for (int i = 0; i < BOARD_SIZE; i++) {
            FieldStatus row1 = getFieldStatus(i,0);
            FieldStatus row2 = getFieldStatus(i,1);
            FieldStatus row3 = getFieldStatus(i,2);
            if(row1==player && row2 == player
                    && row3 == player){
                return true;
            }
        }
        return false;
    }
    private boolean isDiagonalWin(FieldStatus player){
            FieldStatus poz1 = getFieldStatus(0,0);
            FieldStatus poz2 = getFieldStatus(1,1);
            FieldStatus poz3 = getFieldStatus(2,2);
        return poz1 == player && poz2 == player
                && poz3 == player;
    }
    private boolean isBackDiagonalWin(FieldStatus player){
        FieldStatus poz1 = getFieldStatus(2,0);
        FieldStatus poz2 = getFieldStatus(1,1);
        FieldStatus poz3 = getFieldStatus(0,2);
        return poz1 == player && poz2 == player
                && poz3 == player;
    }
}
