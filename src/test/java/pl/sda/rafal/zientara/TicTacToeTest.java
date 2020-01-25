package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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


}