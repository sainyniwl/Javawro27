package pl.sda.rafal.zientara.ZadankaTDD_2801;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenNumbersSumTest {

    @Test
    public void hasReturnSumOfEvenNumbers() {
        EvenNumbersSum sum = new EvenNumbersSum();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = sum.sumOfEven(numbers);
        assertEquals(30, result);
    }
    @Test
    public void hasReturnSumOfEvenNumbersOfNonSortedArray() {
        EvenNumbersSum sum = new EvenNumbersSum();
        int[] numbers = {4, 3, 8, 4, 5, 1, 3, 12, 44, 11};
        int result = sum.sumOfEven(numbers);
        assertEquals(72, result);
    }

    @Test
    public void hasReturnZeroWhenGetNPE() {
        EvenNumbersSum sum = new EvenNumbersSum();
        int result = sum.sumOfEven(null);
        assertEquals(0, result);
    }
}