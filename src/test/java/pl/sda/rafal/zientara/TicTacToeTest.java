package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    TicTacToe game;

    @BeforeEach //żeby za każdyma razem w testach nie umieszczać tej samej linijki
    public void setUp(){
 //       System.out.println("setup");
        game = new TicTacToe();
    }

    @Test
    public void boardIsEmptyAtStart(){
        //given
        //when
        FieldStatus status = game.getFieldStatus(0,0);
        //then
        assertEquals(FieldStatus.EMPTY, status); //pierwszy parametr to expected, drugi to actual
    }

    @Test //każdy test jest adnotowany za pomocą @Test
    public void firstActionOnBardIsX(){
        //given
        //when
        game.action(0,0);
        FieldStatus status = game.getFieldStatus(0,0);
        //then
        assertEquals(FieldStatus.X, status);
    }

    @Test
    public void secondActionOnBardIsO(){
        //given
 //       TicTacToe game = new TicTacToe(); mogę usunąć z każdego testu tą linijkę, bo to generuje się w beforeeach
        //when
        game.action(0,0);
        game.action(0,1);
        FieldStatus status = game.getFieldStatus(0,1);

        game.printBoard();

        //then
        assertEquals(FieldStatus.O, status);
    }

    @Test
    public void actionShouldThrowIfFieldIsTaken(){
        //given
        game.action(0,0);
        //when then
        assertThrows(IllegalStateException.class, new Executable() { //testowanie wyjątków
            @Override
            public void execute() throws Throwable {
                game.action(0,0);

            }
        });
    }

    @Test
    public void playerXCanWinHorizontally(){
        //given
        game.action(0,0);
        game.action(0,1);
        game.action(1,0);
        game.action(1,1);
        game.action(2,0);
        game.printBoard();
        //when
        GameResult result = game.checkResult();
        //then
        assertEquals(GameResult.PLAYER_X_WIN, result);
    }

    @Test
    public void playerXCanWinVertically(){
        //given
        game.action(1,0);
        game.action(0,1);
        game.action(1,1);
        game.action(2,1);
        game.action(1,2);
        game.printBoard();
        //when
        GameResult result = game.checkResult();
        //then
        assertEquals(GameResult.PLAYER_X_WIN, result);
    }

    @Test
    public void playerXCanWinDiagonally(){
        //given
        game.action(0,0);
        game.action(0,1);
        game.action(1,1);
        game.action(1,2);
        game.action(2,2);
        game.printBoard();
        //when
        GameResult result = game.checkResult();
        //then
        assertEquals(GameResult.PLAYER_X_WIN, result);
    }

    @Test
    public void playerXCanWinBackDiagonally(){
        //given
        game.action(2,0);
        game.action(0,1);
        game.action(1,1);
        game.action(1,2);
        game.action(0,2);
        game.printBoard();
        //when
        GameResult result = game.checkResult();
        //then
        assertEquals(GameResult.PLAYER_X_WIN, result);
    }

    @Test
    public void blockTrololo(){
        //given
        game.action(0,0);
        game.action(0,1);
        game.action(1,0);
        game.action(1,1);
        game.action(2,0);
        game.printBoard();
        //when
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                game.action(2,1);
            }
        });
    }

    @Test
    public void draw(){
        //given
        game.action(1,1);
        game.action(2,1);
        game.action(2,0);
        game.action(0,2);
        game.action(1,2);
        game.action(1,0);
        game.action(2,2);
        game.action(0,0);
        game.action(0,1);
        game.printBoard();
        //when
        GameResult result = game.checkResult();
        //then
        assertEquals(GameResult.DRAW, result);
    }

}