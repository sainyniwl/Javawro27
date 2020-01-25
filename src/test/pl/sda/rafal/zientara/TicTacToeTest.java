package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicTacToeTest {
    TicTacToe game;

    @BeforeEach
    public void setup(){
        game = new TicTacToe();
    }

    @Test
    public void boardIsEmptyAtStart(){
        //given

        //when
        FieldStatus status = game.getFieldStatus(0, 0);

        //then
        assertEquals(FieldStatus.EMPTY, status);
    }

    @Test
    public void firstActionOnBoradIsX(){
        //given

        //when
        game.action(0, 0);
        game.printBoard();
        FieldStatus status = game.getFieldStatus(0, 0);

        //then
        assertEquals(FieldStatus.X, status);
    }

    @Test
    public void secondActionOnBoradIsO(){
        //given

        //when
        game.action(0, 0);
        game.action(0, 1);
        FieldStatus status = game.getFieldStatus(0, 1);

        game.printBoard();
        //then
        assertEquals(FieldStatus.O, status);
    }

    @Test
    public void actionShouldThrowIfFieldIsTaken(){
        //given
        game.action(0,0);

        //when
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                game.action(0,0);
            }
        });

    }

    @Test
    public void playerXCanWinHorizontally(){
        game.action(0,0);
        game.action(1,0);
        game.action(0,1);
        game.action(1,1);
        game.action(0,2);
        game.printBoard();


        GameResult result = game.checkResult();

        assertEquals(GameResult.PLAYER_X_WIN, result);
    }

    @Test
    public void playerXCanWinVerically(){
        game.action(0,1);
        game.action(1,0);
        game.action(1,1);
        game.action(1,2);
        game.action(2,1);


        game.printBoard();


        GameResult result = game.checkResult();

        assertEquals(GameResult.PLAYER_X_WIN, result);
    }

    @Test
    public void isDiagonalWinFromLeft(){
        game.action(0,0);
        game.action(1,0);
        game.action(1,1);
        game.action(2,1);
        game.action(2,2);
        game.printBoard();


        GameResult result = game.checkResult();

        assertEquals(GameResult.PLAYER_X_WIN, result);

    }

    @Test
    public void isDiagonalWinFromRight(){
        game.action(2,0);
        game.action(0,1);
        game.action(1,1);
        game.action(2,1);
        game.action(0,2);
        game.printBoard();


        GameResult result = game.checkResult();

        assertEquals(GameResult.PLAYER_X_WIN, result);

    }

    @Test
    public void trololo(){
        game.action(0,0);
        game.action(1,0);
        game.action(0,1);
        game.action(1,1);
        game.action(0,2);
        game.printBoard();


        GameResult result = game.checkResult();

        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                game.action(1,2);
            }
        });

    }

    @Test
    public void isDraw(){
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

        GameResult result = game.checkResult();

        assertEquals(GameResult.DRAW, result);

    }


}