package pl.sda.rafal.zientara.tdd.hangman;

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
        // given

        // when
        String output = game.getOutput();

        // then
        assertEquals("... .. ....", output);
    }

    @Test
    public void correctLetterShouldBeVisible() {
        // given
        game.guessLetter('m');

        // when
        String output = game.getOutput();

        // then
        assertEquals("... m. ....", output);
    }

    @Test
    public void correctLetterShouldBeVisible_ignoreCase() {
        // given
        game.guessLetter('M');

        // when
        String output = game.getOutput();

        // then
        assertEquals("... m. ....", output);
    }

    @Test
    public void correctLetterShouldBeVisible_ignoreCase2() {
        // given
        game.guessLetter('a');

        // when
        String output = game.getOutput();

        // then
        assertEquals("A.a .a ...a", output);
    }

    @Test
    public void correctTwoLettersShouldBeVisible() {
        // given
        game.guessLetter('a');
        game.guessLetter('m');

        // when
        String output = game.getOutput();

        // then
        assertEquals("A.a ma ...a", output);
    }

    @Test
    public void fullOutputShouldBeVisible() {
        // given
        game.guessLetter('a');
        game.guessLetter('m');
        game.guessLetter('l');
        game.guessLetter('k');
        game.guessLetter('o');
        game.guessLetter('t');

        // when
        String output = game.getOutput();

        // then
        assertEquals("Ala ma kota", output);
    }

    @Test
    public void wrongGuessCauseDamage() {
        // given

        // when
        game.guessLetter('X');

        // then
        int hp = game.getHp();
        assertEquals(6, hp);
    }

    @Test
    public void playerShouldHave7HpAtStart() {
        // given

        // when

        // then
        int hp = game.getHp();
        assertEquals(7, hp);
    }

    @Test
    public void wrongGuessesWillKillYou() {
        // given

        // when
        game.guessLetter('C');
        game.guessLetter('D');
        game.guessLetter('E');
        game.guessLetter('F');
        game.guessLetter('G');
        game.guessLetter('H');
        game.guessLetter('I');

        // then
        int hp = game.getHp();
        assertEquals(0, hp);
    }

    @Test
    public void cantGuessAfterKill() {
        // given
//todo
        // when
        game.guessLetter('C');
        game.guessLetter('D');
        game.guessLetter('E');
        game.guessLetter('F');
        game.guessLetter('G');
        game.guessLetter('H');
        game.guessLetter('I');

        // then
        int hp = game.getHp();
        assertEquals(0, hp);
    }

}