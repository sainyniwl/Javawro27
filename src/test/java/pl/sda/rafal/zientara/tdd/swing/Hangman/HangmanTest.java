package pl.sda.rafal.zientara.tdd.swing.Hangman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    @Test
    public void outputShouldBeEncrypted(){
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        String output = game.getOutput();
        assertEquals("... .. ....", output);
    }

    @Test
    public void correctLetterShouldBeVisible(){
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");
        game.guessLetter('m');

        String output = game.getOutput();
        assertEquals("... m. ....", output);
    }

    @Test
    public void correctLetterShouldBe_ignoreCase(){
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");
        game.guessLetter('M');

        String output = game.getOutput();
        assertEquals("... m. ....", output);
    }

    @Test
    public void correctLetterShouldBe_ignoreCase2(){
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");
        game.guessLetter('a');

        String output = game.getOutput();
        assertEquals("A.a .a ...a", output);
    }

}