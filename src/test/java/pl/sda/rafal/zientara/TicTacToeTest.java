package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    TicTacToe game;

    @BeforeEach
    public void setup() {
        System.out.println("setup");
        game = new TicTacToe();
    }

    @Test
    public void actionShouldThrowIfFieldiSTaken() {

        game.action(0, 0);

        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {

                game.action(0, 0);

            }
        });
    }

    @Test
    public void draw() {

        game.action(1, 1);
        game.action(2, 1);
        game.action(2, 0);
        game.action(0, 2);
        game.action(1, 2);
        game.action(1, 0);
        game.action(2, 2);
        game.action(0, 0);
        game.action(0, 1);

        game.printBoard();


        GameResault resault = game.checkStatus();
        assertEquals(GameResault.DRAW, resault);

    }

    @Test
    public void gameOver() {

        game.action(0, 0);//x
        game.action(0, 1);//o
        game.action(1, 0);//x
        game.action(1, 1);//0
        game.action(2, 0);//x
        game.printBoard();

        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {

                game.action(2, 1);

            }
        });
    }

    @Test
    public void playerXCanWinHorizontally() {

        game.action(0, 0);//x
        game.action(0, 1);//o
        game.action(1, 0);//x
        game.action(1, 1);//0
        game.action(2, 0);//x
        game.printBoard();

        GameResault resault = game.checkStatus();

        assertEquals(GameResault.PLAYER_X_WIN, resault);

    }

    @Test
    public void playerXCanWinVertically() {

        game.action(1, 0);//x
        game.action(0, 0);//o
        game.action(1, 1);//x
        game.action(2, 1);//0
        game.action(1, 2);//x
        game.printBoard();

        GameResault resault = game.checkStatus();

        assertEquals(GameResault.PLAYER_X_WIN, resault);

    }

    @Test
    public void isDiagonalWinFromLeft() {

        game.action(0, 0);//x
        game.action(0, 1);//o
        game.action(1, 1);//x
        game.action(2, 1);//0
        game.action(2, 2);//x
        game.printBoard();
        GameResault resault = game.checkStatus();
        assertEquals(GameResault.PLAYER_X_WIN, resault);
    }

    @Test
    public void isDiagonalWinFromRight() {

        game.action(2, 0);//x
        game.action(0, 1);//o
        game.action(1, 1);//x
        game.action(2, 1);//0
        game.action(0, 2);//x
        game.printBoard();
        GameResault resault = game.checkStatus();
        assertEquals(GameResault.PLAYER_X_WIN, resault);
    }

    @Test
    public void boardIsEmptyAtStart() {
        // given

        // when
        FieldStatus status = game.getFieldStatus(0, 0);

        // then
        assertEquals(FieldStatus.EMPTY, status);
    }

    @Test
    public void firstActionOnBoardIsX() {
        // given

        // when
        game.action(0, 0);
        FieldStatus status = game.getFieldStatus(0, 0);

        // then
        assertEquals(FieldStatus.X, status);
    }

    @Test
    public void secondActionOnBoardIsO() {
        // given

        // when
        game.action(0, 0);
        game.action(0, 1);
        FieldStatus status = game.getFieldStatus(0, 1);

        game.printBoard();
        // then
        assertEquals(FieldStatus.O, status);
    }


}