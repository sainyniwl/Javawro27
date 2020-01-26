package pl.sda.rafal.zientara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sda.rafal.zientara.tdd.swing.hangman.Hangman;

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
        //when
        String output = game.getOutput();
        //then
        assertEquals("... .. ....", output);
    }
    @Test
    public void correctLetterShouldBeVisible(){
        //given
        game.guessLetter('M');
        //when
        String output = game.getOutput();
        //then
        assertEquals("... m. ....", output);
    }
    @Test
    public void correctLetterShouldBeVisible2(){
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
    public void playerShouldHave7hpAtStart(){
        int hpLeft = game.getHp();
        assertEquals(7, hpLeft);
    }
    @Test
    public void WrongGuessCauseDamage(){
        game.guessLetter('X');
        int hp = game.getHp();
        assertEquals(6,hp);
    }
    @Test
    public void WrongGuessCauseDamageForTheSameGuess(){
        game.guessLetter('X');
        game.guessLetter('X');
        int hp = game.getHp();
        assertEquals(5,hp);
    }
    @Test
    public void WrongGuessWillKillYou() {
        game.guessLetter('b');
        game.guessLetter('c');
        game.guessLetter('d');
        game.guessLetter('e');
        game.guessLetter('f');
        game.guessLetter('g');
        game.guessLetter('h');
        int hp = game.getHp();
        assertEquals(0, hp);
    }
    @Test
    public void cantGuessAfterKill() {
        game.guessLetter('b');
        game.guessLetter('c');
        game.guessLetter('d');
        game.guessLetter('e');
        game.guessLetter('f');
        game.guessLetter('g');
        game.guessLetter('h');

        game.guessLetter('m');

        assertEquals(0, game.getHp());
        assertEquals("... .. ....", game.getOutput());
    }
    @Test
    public void gameIsRestartedAfterSettingNewPuzzle(){
        game.guessLetter('X');
        game.setPuzzle("Ptaki latajo kluczem");
        assertEquals(7, game.getHp());
        assertEquals("..... ...... .......", game.getOutput());
    }
}