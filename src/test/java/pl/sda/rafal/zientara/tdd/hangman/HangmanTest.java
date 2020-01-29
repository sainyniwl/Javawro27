package pl.sda.rafal.zientara.tdd.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HangmanTest {

    private HangMan game;

    @BeforeEach
    public void setup() {
        game = new HangMan();
        game.setPuzzle("Bunga bunga po Włosku");
    }

    @Test
    public void outPutShouldBeEncrypted() {
        //given

        //when
        String output =  game.getOutput();
        //then

        System.out.println(output+" = "+game.getPuzzle());
        assertEquals("***** ***** ** ******",output);
    }
    @Test
    public void isCorrectLetterIsVisible() {
        //given

        game.guessLetters('n');
        //when
        String output =  game.getOutput();
        //then

        System.out.println(output+" = "+game.getPuzzle());
        assertEquals("**n** **n** ** ******",output);
    }

    @Test
    public void correctLettersshouldBeVisibleIgnoreCase() {
        //given

        game.guessLetters('N');
        //when
        String output =  game.getOutput();
        //then

        System.out.println(output+" = "+game.getPuzzle());
        assertEquals("**n** **n** ** ******",output);
    }


    @Test
    public void correctLettersshouldBeVisibleIgnoreCase2() {
        //given

        game.guessLetters('B');
        //when
        String output =  game.getOutput();
        //then

        System.out.println(output+" = "+game.getPuzzle());
        assertEquals("B**** b**** ** ******",output);
    }

    @Test
    public void correctTwoLettersAreVisible() {
        //given

        game.guessLetters('b');
        game.guessLetters('n');
        game.guessLetters('a');
        game.guessLetters('w');
        //when
        String output =  game.getOutput();
        //then

        System.out.println(output+" = "+game.getPuzzle());
        assertEquals("B*n*a b*n*a ** W*****",output);
    }

    @Test
    public void allLettersAreVisible() {
        //given

        game.guessLetters('b');
        game.guessLetters('u');
        game.guessLetters('n');
        game.guessLetters('g');
        game.guessLetters('a');
        game.guessLetters('p');
        game.guessLetters('o');
        game.guessLetters('w');
        game.guessLetters('ł');
        game.guessLetters('s');
        game.guessLetters('k');

//when
        String output =  game.getOutput();
        //then

        System.out.println(output+" = "+game.getPuzzle());
        assertEquals("Bunga bunga po Włosku",output);
    }


    @Test
    public void wrongGuessCauseDamage() {
        //given

        //when

        game.guessLetters('x');
        String output =  game.getOutput();
        //then

        int hp = game.getHp();
        System.out.println(output+" = "+game.getPuzzle()+" hp="+game.getHp());
        assertEquals(6 ,hp);
    }

    @Test
    public void gameOverThreat() {
        //given

        //when
//Bunga bunga po Włosku
        game.guessLetters('x');
        game.guessLetters('ź');
        game.guessLetters('v');
        game.guessLetters('y');
        game.guessLetters('ś');
        game.guessLetters('ć');
        game.guessLetters('ż');

        String output =  game.getOutput();
        //then

        int hp = game.getHp();
        System.out.println(output+" = "+game.getPuzzle()+" hp="+game.getHp());
        assertEquals(0 ,hp);
    }

    @Test
    public void gameOverNoMorePlay() {
        //given

        //when
//Bunga bunga po Włosku
        game.guessLetters('x');
        game.guessLetters('ź');
        game.guessLetters('v');
        game.guessLetters('y');
        game.guessLetters('ś');
        game.guessLetters('ć');
        game.guessLetters('ż');

        game.guessLetters('b');
        String output =  game.getOutput();
        //then

        int hp = game.getHp();
        System.out.println(output+" = "+game.getPuzzle()+" hp="+game.getHp() + " TEST CZY MOŻNA DALEJ GRAC");
        assertEquals("***** ***** ** ******",output);
    }

    @Test
    public void doubleSameGuessRemovesHealth() {
        //given

        //when
//Bunga bunga po Włosku
        game.guessLetters('x');
        game.guessLetters('x');

        String output =  game.getOutput();
        //then

        int hp = game.getHp();
        System.out.println(output+" = "+game.getPuzzle()+" hp="+game.getHp());
        assertEquals(5 ,hp);
    }

    @Test
    public void gameIsRestartedAfterSettingNewPuzzle(){

        //given
        game.guessLetters('X');
        //when
        game.setPuzzle("Ptoki latajo gupio");
        //than
        assertEquals(7, game.getHp());
        assertEquals("***** ****** *****", game.getOutput());
    }

    @Test
    public void isCorrectAfterAddingFullCorrectAnswer(){
        //given
        game.setInputText("ptoki latajo gupio");
        //when
        game.setPuzzle("Ptoki latajo gupio");
        //than
        assertEquals("Ptoki latajo gupio", game.getOutput());
    }




}