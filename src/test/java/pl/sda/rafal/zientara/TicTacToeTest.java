package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    TicTacToe game;

    @BeforeEach
    public void setup() {
        System.out.println("Setup");
        //given
        game = new TicTacToe();
    }

    @Test
    public void boardIsEmptyAtStart() {
        //given

        //when
        FieldStatus status = game.getFieldStatus(0, 0);

        //then
        assertEquals(FieldStatus.EMPTY, status);
    }

    @Test
    public void firstActionOnBoardIsX() {

        game.action(0, 0);

        FieldStatus status = game.getFieldStatus(0, 0);

        assertEquals(FieldStatus.X, status);


    }

    @Test
    public void secondActionOnBoardIs0() {

        game.action(0, 0);
        game.action(0, 1);
        FieldStatus status = game.getFieldStatus(0, 1);

        assertEquals(FieldStatus.O, status);

        game.printBoard();


    }

    @Test
    public void actionShouldThrowIfFieldIsTaken() {

        game.action(0, 0);

        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                game.action(0,0);
            }
        });
        game.printBoard();
    }

    @Test
    public void playerXCanWinHorizontally(){

        game.action(0,0);
        game.action(1, 0);
        game.action(0, 1);
        game.action(1, 1);
        game.action(0, 2);
        game.printBoard();

        //when
        GameResult result = game.checkResult();

        //then
        assertEquals(GameResult.PLAYER_X_WIN, result);

    }

    @Test
    public void playerXCanWinVertically(){

        game.action(0,1);
        game.action(1, 0);
        game.action(1, 1);
        game.action(1, 2);
        game.action(2, 1);
        game.printBoard();

        //when
        GameResult result = game.checkResult();

        //then
        assertEquals(GameResult.PLAYER_X_WIN, result);

    }

    @Test
    public void playerOCanWinDiagonally(){

        game.action(0,1);
        game.action(0, 0);
        game.action(1, 2);
        game.action(1, 1);
        game.action(2, 0);
        game.action(2, 2);
        game.printBoard();

        //when
        GameResult result = game.checkResult();

        //then
        assertEquals(GameResult.PLAYER_0_WIN, result);

    }

    @Test
    public void playerOCanWinDiagonallyFromRight(){

        game.action(0,1);
        game.action(0, 2);
        game.action(1, 2);
        game.action(1, 1);
        game.action(2, 1);
        game.action(2, 0);
        game.printBoard();

        //when
        GameResult result = game.checkResult();

        //then
        assertEquals(GameResult.PLAYER_0_WIN, result);

    }
    @Test
    public void isGameOver(){

        //given
        game.action(0,0);
        game.action(1, 0);
        game.action(0, 1);
        game.action(1, 1);
        game.action(0, 2);
        game.printBoard();


        //when then
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                game.action(1,2);
            }
        });
    }

    @Test
    public void isDraw(){

        //given
        game.action(0,1);
        game.action(0,0);
        game.action(0,2);
        game.action(1,1);
        game.action(1,0);
        game.action(1,2);
        game.action(2,1);
        game.action(2,0);
        game.action(2,2);
        game.printBoard();

        //when
        GameResult result = game.checkResult();

        //then
        assertEquals(GameResult.DRAW, result);

    }


}