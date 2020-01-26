package pl.sda.rafal.zientara.tdd.HangMan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {
    Hangman game;

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
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");
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
}