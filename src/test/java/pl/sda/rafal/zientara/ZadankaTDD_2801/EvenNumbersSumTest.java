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
}