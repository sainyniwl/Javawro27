package pl.sda.rafal.zientara.swing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    private Hangman game;

    @BeforeEach
    public void setup() {
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
    public void correctTwoLetterShouldBeVisible_ignoreCase(){
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
        game.guessLetter('k');
        game.guessLetter('o');
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
        game.guessLetter('d');

        //then
        int hp = game.getHp();
        assertEquals(6,hp);
    }

    @Test
    public void playerShouldHave7HpAtStart(){
        //given

        //when

        //then
        int hp = game.getHp();
        assertEquals(7,hp);
    }

    @Test
    public void wrongGuessesWillKillYou(){
        //given

        //when
        game.guessLetter('d');
        game.guessLetter('b');
        game.guessLetter('c');
        game.guessLetter('d');
        game.guessLetter('g');
        game.guessLetter('h');
        game.guessLetter('i');

        //then
        int hp = game.getHp();
        assertEquals(0,hp);
    }

    @Test
    public void cantGuessesAfterKill(){
        //given
        game.guessLetter('d');
        game.guessLetter('b');
        game.guessLetter('c');
        game.guessLetter('d');
        game.guessLetter('g');
        game.guessLetter('h');
        game.guessLetter('i');

        //when
        game.guessLetter('l');

        //then
        assertEquals(0,game.getHp());
        assertEquals("... .. ....", game.getOutput());
    }

    @Test
    public void wrongGuessCauseDamageForTheSameGuess(){
        //given

        //when
        game.guessLetter('d');
        game.guessLetter('d');

        //then
        int hp = game.getHp();
        assertEquals(5,hp);
    }

    @Test
    public void gameIsRestartedAfterSettingNewPuzzle(){
        //given
        game.guessLetter('x');

        //when
        game.setPuzzle("Ptaki latajo kluczem");

        //then
        assertEquals(7,game.getHp());
        assertEquals("..... ...... .......", game.getOutput());
    }

}