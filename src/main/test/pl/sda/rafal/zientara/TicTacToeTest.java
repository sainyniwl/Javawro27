package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    //testy jednostkowe skladaja sie z asercji
private TicTacToe game;

@BeforeEach
public void setup() {
    System.out.println("Setup");
        game = new TicTacToe();
    }

    @Test
    public void boardIsEmptyAtStart() {
        //given
        //when
        FieldStatus status = game.getFieldStatus(0,0);

        //then
        assertEquals(FieldStatus.EMPTY,status);  //moze byc assert true/assert false etc


    }
    @Test
    public void firstActionOnBoardIsX() {

        //when
        game.action(0,0);
        FieldStatus status = game.getFieldStatus(0,0);

        //then
        assertEquals(FieldStatus.X,status);  //moze byc assert true/assert false etc

    }
    @Test
    public void secondActionOnBoardIsO() {

    //when
        game.action(0,0);
        game.action(0,2);
        FieldStatus status = game.getFieldStatus(0,2);

        //then
        assertEquals(FieldStatus.O,status);  //moze byc assert true/assert false etc
    }

   /* @Test
    public void isAlreadyXorO() {

        //when
        game.action(0,0);
        game.action(0,2);
        FieldStatus status = game.getFieldStatus(0,2);

        //then
        assertEquals(FieldStatus.O,status);  //moze byc assert true/assert false etc
    }*/

   @Test
    public void print() {
       game.action(0,0);
       game.action(0,2);
       game.action(2,0);
       game.printBoard();
   }

}