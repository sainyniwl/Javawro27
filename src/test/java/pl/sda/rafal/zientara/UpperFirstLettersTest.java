package pl.sda.rafal.zientara;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpperFirstLettersTest {

    @Test
    public void areFirstUpper1(){
        //given
        UpperFirstLetters uFL = new UpperFirstLetters("Wrocław");

        //when
        String uFL1 = uFL.turnFirstLettersUpper();

        //then
        assertEquals("Wrocław", uFL1);
    }

    @Test
    public void areFirstUpper2(){
        //given
        UpperFirstLetters uFL = new UpperFirstLetters("wrocław");

        //when
        String uFL1 = uFL.turnFirstLettersUpper();

        //then
        assertEquals("Wrocław", uFL1);
    }

    @Test
    public void areFirstUpper3(){
        //given
        UpperFirstLetters uFL = new UpperFirstLetters("ala ma kota");

        //when
        String uFL1 = uFL.turnFirstLettersUpper();

        //then
        assertEquals("Ala Ma Kota", uFL1);
    }

    @Test
    public void areFirstUpper4(){
        //given
        UpperFirstLetters uFL = new UpperFirstLetters("szklarska Poręba");

        //when
        String uFL1 = uFL.turnFirstLettersUpper();

        //then
        assertEquals("Szklarska Poręba", uFL1);
    }

    @Test
    public void areFirstUpper5(){
        //given
        UpperFirstLetters uFL = new UpperFirstLetters("kędzierzyn - koźle");

        //when
        String uFL1 = uFL.turnFirstLettersUpper();

        //then
        assertEquals("Kędzierzyn - Koźle", uFL1);
    }

    @Test
    public void areFirstUpper6(){
        //given
        UpperFirstLetters uFL = new UpperFirstLetters("zenek dąbrowski-Nowakowski");

        //when
        String uFL1 = uFL.turnFirstLettersUpper();

        //then
        assertEquals("Zenek Dąbrowski-Nowakowski", uFL1);
    }
}