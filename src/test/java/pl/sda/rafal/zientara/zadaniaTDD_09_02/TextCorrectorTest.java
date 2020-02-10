package pl.sda.rafal.zientara.zadaniaTDD_09_02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextCorrectorTest {
    TextCorrector textCorrector;

    @BeforeEach
    public void setup() {
        textCorrector = new TextCorrector();
    }

    @Test
    public void firstLetterToUpperCaseInWholeString() {
        String text = "ala ma kota";
        String result = textCorrector.wordToUpperCase(text);
        assertEquals("Ala Ma Kota", result);
    }

    @Test
    public void firstLetterToUpperCaseWhenIncludeUpperCase() {
        String text = "Ala Ma Kota";
        String result = textCorrector.wordToUpperCase(text);
        assertEquals("Ala Ma Kota", result);
    }

    @Test
    public void firstLetterToUpperCaseIncludeTextSeparator() {
        String text = "ala ma kota, banan and AnanaS";
        String result = textCorrector.wordToUpperCase(text);
        assertEquals("Ala Ma Kota, Banan And Ananas", result);
    }

    @Test
    public void allVariantsInOneSentences() {
        String text = "ala ma kota, Zenek Dąbrowkski-Nowakowski, walaszko-nowicka, szklarska poreba";
        String result = textCorrector.wordToUpperCase(text);
        assertEquals("Ala Ma Kota, Zenek Dąbrowkski - Nowakowski, Walaszko - Nowicka, Szklarska Poreba", result);
    }


    @Test
    public void firstLetterToUpperCaseStringAllLetterWithUpperCase() {
        String text = "ALA MA KOTA";
        String result = textCorrector.wordToUpperCase(text);
        assertEquals("Ala Ma Kota", result);
    }

    @Test
    public void firstLetterToUpperCaseStringWithSpacesAndDashInLongString() {
        String text = "Zenek Dąbrowkski-Nowakowski";
        String result = textCorrector.wordToUpperCase(text);
        assertEquals("Zenek Dąbrowkski - Nowakowski", result);
    }

    @Test
    public void firstLetterToUpperCaseStringWithDashAndWithoutWhitespaces() {
        String text = "walaszko-nowicka";
        String result = textCorrector.wordToUpperCase(text);
        assertEquals("Walaszko - Nowicka", result);
    }

    @Test
    public void firstLetterToUpperCaseTwoWordString() {
        String text = "szklarska poreba";
        String result = textCorrector.wordToUpperCase(text);
        assertEquals("Szklarska Poreba", result);
    }

    @Test
    public void firstLetterToUpperCaseInWholeStringWithDifferentCase() {
        String text = "aLa mA koTa";
        String result = textCorrector.wordToUpperCase(text);
        assertEquals("Ala Ma Kota", result);
    }

    @Test
    public void firstLetterToUpperCaseInSimpleWord() {
        String text = "banan";
        String result = textCorrector.wordToUpperCase(text);
        assertEquals("Banan", result);
    }

    @Test
    public void firstLetterToUpperCaseInSimpleWordWithDifferentCase() {
        String text = "baNaN";
        String result = textCorrector.wordToUpperCase(text);
        assertEquals("Banan", result);
    }

    @Test
    public void ifStringIsNull() {
        String result = textCorrector.wordToUpperCase(null);
        assertNull(result);
    }

    @Test
    public void ifStringIsEmpty() {
        String text = "";
        String result = textCorrector.wordToUpperCase(text);
        assertEquals("", result);
    }

}