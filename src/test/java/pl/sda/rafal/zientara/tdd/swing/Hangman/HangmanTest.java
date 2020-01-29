package pl.sda.rafal.zientara.tdd.swing.Hangman;

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
        String output = game.getOutput();
        assertEquals("... .. ....", output);
    }

    @Test
    public void correctLetterShouldBeVisible(){
        game.guessLetter('m');

        String output = game.getOutput();
        assertEquals("... m. ....", output);
    }

    @Test
    public void correctLetterShouldBe_ignoreCase(){
        game.guessLetter('M');

        String output = game.getOutput();
        assertEquals("... m. ....", output);
    }

    @Test
    public void correctLetterShouldBe_ignoreCase2(){
        game.guessLetter('a');

        String output = game.getOutput();
        assertEquals("A.a .a ...a", output);
    }

    @Test
    public void twoLettersShouldBeVisible(){
        game.guessLetter('a');
        game.guessLetter('m');

        String output = game.getOutput();
        assertEquals("A.a ma ...a", output);
    }

    @Test
    public void fullOutputShouldBeVisible(){
        game.guessLetter('a');
        game.guessLetter('l');
        game.guessLetter('m');
        game.guessLetter('k');
        game.guessLetter('o');
        game.guessLetter('t');


        String output = game.getOutput();
        assertEquals("Ala ma kota", output);
    }

    @Test
    public void wrongGuessCauseDamage(){
        game.guessLetter('z');

        int hp = game.getHp();
        assertEquals(6, hp);
    }

    @Test
    public void playerShouldHave7HPAtStart(){

        int hp = game.getHp();
        assertEquals(7, hp);
    }

    @Test
    public void wrongGuessesWillKillYou(){

        game.guessLetter('h');
        game.guessLetter('p');
        game.guessLetter('r');
        game.guessLetter('v');
        game.guessLetter('x');
        game.guessLetter('y');
        game.guessLetter('z');

        int hp = game.getHp();
        assertEquals(0, hp);
    }

    @Test
    public void cantGuessAfterKill(){
        game.guessLetter('h');
        game.guessLetter('p');
        game.guessLetter('r');
        game.guessLetter('v');
        game.guessLetter('x');
        game.guessLetter('y');
        game.guessLetter('z');

        game.guessLetter('m');

        assertEquals(0, game.getHp());
        assertEquals("... .. ....", game.getOutput());
    }


    @Test
    public void wrongGuessCauseDamageForTheSameGuess(){

        game.guessLetter('h');
        game.guessLetter('h');

        int hp = game.getHp();
        assertEquals(5, hp);
    }

    @Test
    public void gameIsRestartedAfterSettingNewPuzzle(){
        game.guessLetter('X');

        game.setPuzzle("Ptaki latajo kluczem");

        assertEquals(7, game.getHp());
        assertEquals("..... ...... .......", game.getOutput());
    }

    @Test
    public void guessingWholePasswordAtOnce(){

        game.setPuzzle("Bardzo tajne haslo");

        game.guessLetter("Bardzo tajne haslo");
        assertEquals("Bardzo tajne haslo", game.getOutput());
    }

    @Test
    public void playerCantGuessPasswordPartially(){

        game.setPuzzle("Bardzo tajne haslo");

        game.guessLetter("tajne haslo");
        assertEquals("...... ..... .....", game.getOutput());
    }

    @Test
    public void GuessingPartiallyCauseDamage(){

        game.setPuzzle("Bardzo tajne haslo");

        game.guessLetter("tajne haslo");

        assertEquals("...... ..... .....", game.getOutput());
        assertEquals(6,game.getHp());
    }

}