package pl.sda.rafal.zientara.hangman;

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
    public void outputShouldBeEncrypted() {

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
    public void correctLetterShouldBeVisible_2(){
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
        game.guessLetter('o');
        game.guessLetter('k');
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
        game.guessLetter('x');

        //then
        int hp = game.getHp();
        assertEquals(6, hp);
    }

    @Test
    public void playerShouldHave7HpOnStart(){
        //given

        //when

        //then
        int hp = game.getHp();
        assertEquals(7, hp);
    }

    @Test
    public void wrongGuessesWillKillYou(){
        //given

        //when
        game.guessLetter('C');
        game.guessLetter('D');
        game.guessLetter('E');
        game.guessLetter('F');
        game.guessLetter('G');
        game.guessLetter('H');
        game.guessLetter('I');

        //then
        int hp = game.getHp();
        assertEquals(0, hp);
    }

    @Test
    public void cantGuessAfterDeath(){
        //given
        game.guessLetter('C');
        game.guessLetter('D');
        game.guessLetter('E');
        game.guessLetter('F');
        game.guessLetter('G');
        game.guessLetter('H');
        game.guessLetter('I');

        //when
        game.guessLetter('m');

        //then
        int hp = game.getHp();
        assertEquals(0, hp);
        assertEquals("... .. ....", game.getOutput());

    }

    @Test
    public void sameLetterCauseDamage(){
        //given

        //when
        game.guessLetter('x');
        game.guessLetter('x');

        //then
        int hp = game.getHp();
        assertEquals(5, hp);
    }

    @Test
    public void gameIsRestartedAfterSettingNewPuzzle(){
        //given
//        game.guessLetter('a');

        //when
        game.setPuzzle("Ptaki latajo kluczem");

        //then
        assertEquals(7, game.getHp());
        assertEquals("..... ...... .......", game.getOutput());


    }

}