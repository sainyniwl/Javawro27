package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    //testy jednostkowe skladaja sie z asercji
private TicTacToe game;

@BeforeEach
public void setup() {
    System.out.println("Test");
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

    @Test
    public void actionShouldThrowIsFieldIsTaken() {

        //when
        game.action(0,0);
        game.action(0,2);
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                game.action(0,0);
            }
        });

    }

   @Test
    public void print() {
           game.action(0, 0);
           game.action(0, 2);
        game.printBoard();
   }

   @Test
    public void playerXCanWinHorizontally() {
        //given
        game.action(0,0);
        game.action(0,1);
        game.action(1,0);
        game.action(1,1);
        game.action(2,0);
        game.printBoard();

        //when
       GameResult result = game.checkResult();

       assertEquals(GameResult.PLAYER_X_WIN,result);
    }

    @Test
    public void playerXCanWinVertically() {
        //given
        game.action(1,0);
        game.action(0,1);
        game.action(1,1);
        game.action(2,1);
        game.action(1,2);
        game.printBoard();

        //when
        GameResult result = game.checkResult();

        assertEquals(GameResult.PLAYER_X_WIN,result);
    }
    @Test
    public void playerXCanWinDiagonallyFromLeft() {
        //given
        game.action(0,0);
        game.action(0,1);
        game.action(1,1);
        game.action(1,2);
        game.action(2,2);
        game.printBoard();

        //when
        GameResult result = game.checkResult();

        assertEquals(GameResult.PLAYER_X_WIN,result);
    }


    @Test
    public void gameDraw() {
        //given
        System.out.println("DRAW");
        game.action(0,1);
        game.action(0,0);
        game.action(0,2);
        game.action(1,1);
        game.action(1,0);
        game.action(1,2);
        game.action(2,1);
        game.action(2,0);
        game.action(2,2);
        game.printBoard();

        //when
        GameResult result = game.checkResult();

        assertEquals(GameResult.DRAW,result);
    }
    @Test
    public void blockTrololo() {
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
            public void execute() {
                game.action(2,1);
            }
        });
    }
}