package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
// aby dodać plik testowy wchodzimy na nazwę metody - alt+enter - wybieramy createTest a następnie fix, i tworzy się taka sama clasa z nazwą test
TicTacToe game;

    @BeforeEach // wywołanie przed kazdym testem
    public void setup() {
        //given
        System.out.println("setup");
        game = new TicTacToe();
    }
    @Test
    public void boardIsEmptyAtStart(){
        //given

        //when
        FieldStatus status = game.getFieldStatus(0,0);

        //then
        assertEquals(FieldStatus.EMPTY, status);
    }
    @Test
    public void firstActionOnBoardIsX() {
        //given

        //when
        game.action(0, 0);
        FieldStatus status = game.getFieldStatus(0, 0);

        //then
        assertEquals(FieldStatus.X, status);
    }

        @Test
    public void secondActionOnBoardIsO(){
        //given

        //when
        game.action(0,0);
        game.action(0,1);
        FieldStatus status = game.getFieldStatus(0,1);

        game.printBoard();
        //then
        assertEquals(FieldStatus.O, status);
    }
}