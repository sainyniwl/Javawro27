package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;



class TicTacToeTest {
    TicTacToe game;
    @BeforeEach
    public void setup(){
        game = new TicTacToe();
    }
    @Test
    public void boardIsEmptyAtStart() {


        FieldStatus status = game.getFieldStatus(0, 0);
game.printBoard();
        assertEquals(status, FieldStatus.EMPTY);
    }

    @Test
    public void FirstAcctionOnBoardIsX() {
        //given


        game.action(0, 0);
        FieldStatus status = game.getFieldStatus(0, 0);
        game.printBoard();
        assertEquals(FieldStatus.X, status);


    }

    @Test
    public void secondAcctionOnBoardIsO() {
        //given


        game.action(0, 0);
        game.action(0, 1);
        FieldStatus status = game.getFieldStatus(0, 1);
        game.printBoard();
        assertEquals(FieldStatus.O, status);


    }
}