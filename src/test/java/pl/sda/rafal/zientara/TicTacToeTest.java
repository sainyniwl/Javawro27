package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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



}