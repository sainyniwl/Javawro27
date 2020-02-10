package pl.sda.rafal.zientara.tdd.tddExcercises.ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LettersExcTest {

    @Test
    void testing1(){
        assertEquals(LettersExc.firtsLetterToUpperCase("mateusz niedbal"),"Mateusz Niedbal");
    }
    @Test
    void testing2(){
        assertEquals(LettersExc.firtsLetterToUpperCase("kedzierzyn - kozle"),"Kedzierzyn - Kozle");
    }
    @Test
    void testing3(){
        assertEquals(LettersExc.firtsLetterToUpperCase("ala ma kota, ktory zdechl"),"Ala Ma Kota, Ktory Zdechl");
    }
    @Test
    void testing4(){
        assertEquals(LettersExc.firtsLetterToUpperCase("szklarska poreba"),"Szklarska Poreba");
    }
    @Test
    void testing5(){
        assertEquals(LettersExc.firtsLetterToUpperCase(null),null);
    }
    @Test
    void testing6(){
        assertEquals(LettersExc.firtsLetterToUpperCase(""),"");
    }
    @Test
    void testing7(){
        assertEquals(LettersExc.firtsLetterToUpperCase(" , ")," , ");
    }
    @Test
    void testing8(){
        assertEquals(LettersExc.firtsLetterToUpperCase("Zenek dąbrowski-nowacki"),"Zenek Dąbrowski-Nowacki");
    }
    @Test
    void testing9(){
        assertEquals(LettersExc.firtsLetterToUpperCase("banan"),"Banan");
    }
    @Test
    void testing10(){
        assertEquals(LettersExc.firtsLetterToUpperCase("MARCIN SZWED"),"MARCIN SZWED");
    }
    @Test
    void testing11(){
        assertEquals(LettersExc.firtsLetterToUpperCase("kędzierzyn koźle"),"Kędzierzyn Koźle");
    }
    @Test
    void testing12(){
        assertEquals(LettersExc.firtsLetterToUpperCase("nOWA szZKOla"),"NOWA SzZKOla");
    }


}