package pl.sda.rafal.zientara;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositiveNumbersTest {

    PositiveNumbers numbers;

    @Test
    public void sumWhenTabIsEmpty() {
        //given
        numbers = new PositiveNumbers(new int[]{});
        //when
        numbers.sumPositive();
        int result = numbers.getResult();

        //then
        assertEquals(0, result);

    }

    @Test
    public void sumWhenAllNumbersArePositive() {

        //given
        numbers = new PositiveNumbers(new int[]{6, 2, 2, 4, 4, 6, 2});

        //when
        numbers.sumPositive();
        int result = numbers.getResult();

        //then
        assertEquals(26, result);

    }

    @Test
    public void sumWhenAllNumbersAreNegative() {

        //given
        numbers = new PositiveNumbers(new int[]{1, 5, 3, 5, 1, 3, 7});

        //when
        numbers.sumPositive();
        int result = numbers.getResult();

        //then
        assertEquals(0, result);

    }
}