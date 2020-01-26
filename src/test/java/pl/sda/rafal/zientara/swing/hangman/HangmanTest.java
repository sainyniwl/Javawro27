package pl.sda.rafal.zientara.swing.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {
    private Hangman game;

    @BeforeEach
    public void setup(){
        game = new Hangman();
        game.setPuzzle("Ala ma kota");
    }


    @Test
    public void outputShouldBeEncrypted(){
        //given

        //when
        String output = game.getOutput();

        //then
        assertEquals("... .. ....", output);
    }

    @Test
    public void correctLetterShouldBeVisible(){
        //given
        game.guessLetter('m');

        //when
        String output = game.getOutput();

        //then
        assertEquals("... m. ....", output);
    }

    @Test
    public void correctLetterShouldBeVisible_ignoreCase(){
        //given
        game.guessLetter('M');

        //when
        String output = game.getOutput();

        //then
        assertEquals("... m. ....", output);
    }

    @Test
    public void correctLetterShouldBeVisible_ignoreCase2(){
        //given
        game.guessLetter('a');

        //when
        String output = game.getOutput();

        //then
        assertEquals("A.a .a ...a", output);
    }

    @Test
    public void correctToLetterShouldBeVisible(){
        //given
        game.guessLetter('a');
        game.guessLetter('m');

        //when
        String output = game.getOutput();

        //then
        assertEquals("A.a ma ...a", output);
    }

    @Test
    public void fullOutputShouldBeVisible(){
        //given
        game.guessLetter('a');
        game.guessLetter('l');
        game.guessLetter('m');
        game.guessLetter('o');
        game.guessLetter('k');
        game.guessLetter('t');

        //when
        String output = game.getOutput();

        //then
        assertEquals("Ala ma kota", output);
    }

    @Test
    public void wrongGuessCauseDamage(){
        //given

        //when
        game.guessLetter('X');

        //then
        int hp = game.getHp();
        assertEquals(6, hp);
    }

    @Test
    public void playerShouldHpAtStart(){
        //given

        //when


        //then
        int hp = game.getHp();
        assertEquals(7, hp);
    }
//ctrl + shift + strzałki- przenoszenie linijek
    @Test
    public void wrongGuessWillKillYou(){
        //given

        //when
        game.guessLetter('C');
        game.guessLetter('D');
        game.guessLetter('E');
        game.guessLetter('F');
        game.guessLetter('G');
        game.guessLetter('H');
        game.guessLetter('I');

        //then
        int hp = game.getHp();
        assertEquals(0, hp);
    }

    @Test
    public void wrongGuessAfterKill(){
        //given
        game.guessLetter('C');
        game.guessLetter('D');
        game.guessLetter('E');
        game.guessLetter('F');
        game.guessLetter('G');
        game.guessLetter('H');
        game.guessLetter('I');

        //when
        game.guessLetter('m');

        //then

        assertEquals(0, game.getHp());
        assertEquals("... .. ....", game.getOutput());
    }

    @Test
    public void wrongCanGuessCauseDamage(){
        //given

        //when
        game.guessLetter('X');
        game.guessLetter('X');

        //then
        int hp = game.getHp();
        assertEquals(5, hp);
    }

    @Test
    public void gameIsRestartedAfterSettingNewPuzzle(){
        //given
        game.guessLetter('X');
        game.guessLetter('X');

        //when
        game.setPuzzle("Ptaki latajo kluczem");

        //then
        assertEquals(7, game.getHp());
        assertEquals("..... ...... .......", game.getOutput());
    }


}