package tdd.HangMan;

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
    public void outputShouldBeEncrypted() {
        //given

        //when
        String output = game.getOutput();

        //then
        assertEquals("... .. ....", output);
    }

    @Test
    public void correctLetterShouldBeVisible() {
        game.guessLetter('m');
        String output = game.getOutput();
        assertEquals("... m. ....", output);
    }

    @Test
    public void isLetterCorrect() {
        //given
        game.guessLetter('a');
        //when
        String output = game.getOutput();

        //then
        assertEquals("A.a .a ...a", output);
    }

    @Test
    public void isLetterCorrect2() {
        //given
        game.guessLetter('m');
        //when
        String output = game.getOutput();

        //then
        assertEquals("... m. ....", output);
    }

    @Test
    public void allCorrectLetterShouldBeVisible3() {
        game.guessLetter('a');
        game.guessLetter('l');
        game.guessLetter('m');
        game.guessLetter('k');
        game.guessLetter('t');
        game.guessLetter('o');
        String output = game.getOutput();
        assertEquals("Ala ma kota", output);
    }

    @Test
    public void isntThere() {
        game.guessLetter('z');
        int hpLeft = game.getHp();
        assertEquals(6, hpLeft);
    }

    @Test
    public void playerShouldHave7HpAtStart() {
        int hpLeft = game.getHp();
        assertEquals(7, hpLeft);
    }

    @Test
    public void wrongGuessesWillKillYou() {
        game.guessLetter('d');
        game.guessLetter('b');
        game.guessLetter('g');
        game.guessLetter('n');
        game.guessLetter('v');
        game.guessLetter('x');
        game.guessLetter('z');
        int hpLeft = game.getHp();
        assertEquals(0, hpLeft);
    }

    @Test
    public void cannotGuessAnymore() {
        game.guessLetter('d');
        game.guessLetter('b');
        game.guessLetter('g');
        game.guessLetter('n');
        game.guessLetter('v');
        game.guessLetter('x');
        game.guessLetter('z');
        game.guessLetter('m');

        assertEquals(0, game.getHp());
        assertEquals("... .. ....", game.getOutput());
    }

    @Test
    public void wrongGuessCauseDamageFOrTheSameGuess() {
        game.guessLetter('x');
        game.guessLetter('x');
        int hpLeft = game.getHp();
        assertEquals(5, hpLeft);
    }

    @Test
    public void gameIsRestartedAfterSettingNewPuzzle() {
        //given
        game.guessLetter('x');
        game.setPuzzle("Ptaki latajo kluczem");

        //then
        assertEquals(7, game.getHp());
        assertEquals("..... ...... .......", game.getOutput());
    }
    @Test
    public void wholeTextTest() {
        String s = "Ptaki latajo kluczem";
        game.setPuzzle("Ptaki latajo kluczem");
        game.isWholeWordCorrect(s);
        assertEquals(7,game.getHp());
    }
    @Test
    public void isTypedTextCorrect() {
        String s = "Ptaki latajo kluczem";
        game.setPuzzle("Ptaki latajo kluczem");
        assertTrue(game.isWholeWordCorrect(s));
    }
}