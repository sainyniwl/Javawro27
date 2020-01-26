package pl.sda.rafal.zientara.Hangman;

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

        String output = game.getOutput();
        assertEquals("... .. ....", output);

    }

    @Test
    public void correctLetterShouldBeVisible() {

        game.guessLetter('m');
        String output = game.getOutput();
        assertEquals("... m. ....", output);

    }

    @Test
    public void correctLetterShouldBeVisibleIgnoreCase() {

        game.guessLetter('M');
        String output = game.getOutput();
        assertEquals("... m. ....", output);

    }

    @Test
    public void correctLetterShouldBeVisibleIgnoreCase2() {

        game.guessLetter('A');
        String output = game.getOutput();
        assertEquals("A.a .a ...a", output);

    }

    @Test
    public void wrongGuessCauseDamage() {


        game.guessLetter('w');
        int hp = game.getHp();
        assertEquals(6, hp);

    }

    @Test
    public void wrongGuessCauseDamageForTHeSameGuesse() {


        game.guessLetter('w');
        game.guessLetter('w');
        int hp = game.getHp();
        assertEquals(5, hp);

    }

    @Test
    public void playerShouldHave7HpAtStart() {

        int hp = game.getHp();
        assertEquals(7, hp);

    }

    @Test
    public void wrongGuessesWillKillYou() {

        game.guessLetter('f');
        game.guessLetter('s');
        game.guessLetter('g');
        game.guessLetter('h');
        game.guessLetter('j');
        game.guessLetter('b');
        game.guessLetter('q');


        int hp = game.getHp();
        assertEquals(0, hp);

    }

    @Test
    public void cantGuesseAfterKill() {

        game.guessLetter('s');
        game.guessLetter('f');
        game.guessLetter('g');
        game.guessLetter('h');
        game.guessLetter('j');
        game.guessLetter('b');
        game.guessLetter('q');
        game.guessLetter('p');

        assertEquals(0, game.getHp());


    }

    @Test
    public void correctTwoLetterShouldBeVisible() {

        game.guessLetter('a');
        game.guessLetter('m');
        String output = game.getOutput();
        assertEquals("A.a ma ...a", output);

    }

    @Test
    public void fullOutputShouldBeVisible() {

        game.guessLetter('a');
        game.guessLetter('m');
        game.guessLetter('l');
        game.guessLetter('k');
        game.guessLetter('o');
        game.guessLetter('t');
        String output = game.getOutput();
        assertEquals("Ala ma kota", output);

    }

    @Test
    public void gameIsRestartedAfterNewPazzle(){

        game.guessLetter('x');

        game.setPuzzle("Ptaki latajo kluczem");

        assertEquals(7, game.getHp());
        assertEquals("..... ...... .......", game.getOutput());
    }

}