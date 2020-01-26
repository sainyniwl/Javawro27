import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {
    Hangman game;

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
    public void correctTwoLetterShouldBeVisible(){
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
        game.guessLetter('m');
        game.guessLetter('l');
        game.guessLetter('k');
        game.guessLetter('o');
        game.guessLetter('t');

        //when
        String output = game.getOutput();

        //then
        assertEquals("Ala ma kota", output);
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
    public void wrongGuessCauseDamage(){
        //given

        //when
        game.guessLetter('r');

        //then
        int hp = game.getHp();
        assertEquals(6,hp);
    }

    @Test
    public void wrongGuessCauseDamageForTheSameGuess(){
        //given

        //when
        game.guessLetter('r');
        game.guessLetter('r');

        //then
        int hp = game.getHp();
        assertEquals(5,hp);
    }

    @Test
    public void wrongGuessesWillKillYou(){
        //given

        //when
        game.guessLetter('r');
        game.guessLetter('x');
        game.guessLetter('s');
        game.guessLetter('d');
        game.guessLetter('e');
        game.guessLetter('z');
        game.guessLetter('ł');

        //then
        int hp = game.getHp();
        assertEquals(0,hp);
    }

    @Test
    public void cantGuessAfterDeath(){
        //given
        game.guessLetter('r');
        game.guessLetter('x');
        game.guessLetter('s');
        game.guessLetter('d');
        game.guessLetter('e');
        game.guessLetter('z');
        game.guessLetter('ł');
        //when
        game.guessLetter('m');

        //then
        int hp = game.getHp();
        assertEquals(0,hp);
        assertEquals("... .. ....", game.getOutput());
    }

    @Test
    public void gameIsRestartedAfterSettingNewPuzzle(){
        //given
        game.guessLetter('r');

        //when
        game.setPuzzle("Ptaki latajo kluczem");

        //then
        assertEquals(7,game.getHp());
        assertEquals("..... ...... .......", game.getOutput());
    }
}