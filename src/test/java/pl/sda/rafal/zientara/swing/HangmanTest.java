package pl.sda.rafal.zientara.swing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    @Test
    public void outputShouldBeEncrypted(){
        //given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        //when
        String output = game.getOutput();

        //then
        assertEquals("... .. ....", output);
    }

}