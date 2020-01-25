package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}