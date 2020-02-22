package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.sda.rafal.zientara.tdd.tictactoe.FieldStatus;
import pl.sda.rafal.zientara.tdd.tictactoe.GameResult;
import pl.sda.rafal.zientara.tdd.tictactoe.TicTacToe;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    TicTacToe game;

    @BeforeEach
    public void setup() {
        System.out.println("setup");
        game = new TicTacToe();
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


    @Test
    public void actionShouldThrowIfFieldIsTaken() {
        // given
        game.action(0, 0);

        // when then
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                game.action(0, 0);
            }
        });
    }

    @Test
    public void playerXCanWinHorizontally() {
        //given
        game.action(0,0);//x
        game.action(0,1);//o
        game.action(1,0);//x
        game.action(1,1);//o
        game.action(2,0);//x
        game.printBoard();

        // when
        GameResult result = game.checkResult();

        // then
        assertEquals(GameResult.PLAYER_X_WIN, result);
    }


    @Test
    public void playerXCanWinVertically() {
        //given
        game.action(1,0);//x
        game.action(0,1);//o
        game.action(1,1);//x
        game.action(2,1);//o
        game.action(1,2);//x
        game.printBoard();

        // when
        GameResult result = game.checkResult();

        // then
        assertEquals(GameResult.PLAYER_X_WIN, result);
    }

    @Test
    public void playerXCanWinDiagonallyFromLeft() {
        //given
        game.action(0,0);//x
        game.action(0,1);//o
        game.action(1,1);//x
        game.action(1,2);//o
        game.action(2,2);//x
        game.printBoard();

        // when
        GameResult result = game.checkResult();

        // then
        assertEquals(GameResult.PLAYER_X_WIN, result);
    }

    @Test
    public void playerXCanWinDiagonallyFromRight() {
        //given
        game.action(2,0);//x
        game.action(1,0);//o
        game.action(1,1);//x
        game.action(2,1);//o
        game.action(0,2);//x
        game.printBoard();

        // when
        GameResult result = game.checkResult();

        // then
        assertEquals(GameResult.PLAYER_X_WIN, result);
    }

    @Test
    public void blockTrololo() {
        //given
        game.action(0,0);//x
        game.action(0,1);//o
        game.action(1,0);//x
        game.action(1,1);//o
        game.action(2,0);//x
        game.printBoard();

        // when then
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                game.action(2,1);//o
            }
        });
    }

    @Test
    public void draw() {
        //given
        game.action(1,1);//x 1
        game.action(2,1);//o 2
        game.action(2,0);//x 3
        game.action(0,2);//o 4
        game.action(1,2);//x 5
        game.action(1,0);//o 6
        game.action(2,2);//x 7
        game.action(0,0);//o 8
        game.action(0,1);//x 9
        game.printBoard();

        // when
        GameResult result = game.checkResult();

        // then
        assertEquals(GameResult.DRAW, result);
    }


}