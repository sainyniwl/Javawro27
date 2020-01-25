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


}