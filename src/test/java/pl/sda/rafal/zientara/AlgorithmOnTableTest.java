package pl.sda.rafal.zientara;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmOnTableTest {

    AlgorithmOnTable numbers;

    @Test
    public void sumWhenTabIsEmpty() {
        //given
        numbers = new AlgorithmOnTable(new int[]{});
        //when
        numbers.sumPositive();
        int result = numbers.getResult();

        //then
        assertEquals(0, result);

    }

    @Test
    public void sumWhenAllNumbersArePositive() {

        //given
        numbers = new AlgorithmOnTable(new int[]{6, 2, 2, 4, 4, 6, 2});

        //when
        numbers.sumPositive();
        int result = numbers.getResult();

        //then
        assertEquals(26, result);

    }

    @Test
    public void sumWhenAllNumbersAreNegative() {

        //given
        numbers = new AlgorithmOnTable(new int[]{1, 5, 3, 5, 1, 3, 7});

        //when
        numbers.sumPositive();
        int result = numbers.getResult();

        //then
        assertEquals(0, result);

    }

    @Test
    public void countMedianWhenTabIsEmpty() {
        //given
        numbers = new AlgorithmOnTable(new int[]{});
        //when
        numbers.countMedian();
        double result = numbers.countMedian();

        //then
        assertEquals(-1,result );

    }

    @Test
    public void countMedianWhenElementsArePlusAndMinus() {
        //given
        numbers = new AlgorithmOnTable(new int[]{-3,-1,0,7,9});
        //when
        numbers.countMedian();
        double result = numbers.countMedian();

        //then
        assertEquals(0,result );

    }

    @Test
    public void testForArithmeticalAverage() {

        //given
        numbers = new AlgorithmOnTable(new int[]{ 6, 3, 5,4, 7});

        //when
        double result;
        result = numbers.arithmeticalAverage();

        //then
        assertEquals(5, result);

    }

    @Test
    public void testForArithmeticalAverageWhenIsEmpty() {

        //given
        numbers = new AlgorithmOnTable(new int[0]);

        //when
        double result;
        result = numbers.arithmeticalAverage();

        //then
        assertEquals(-1, result);

    }


    @Test
    public void testForArithmeticalAverageForDoubleValue() {

        //given
        numbers = new AlgorithmOnTable(new int[]{ 6, 3, 5,4, 7});

        //when
        double result;
        result = numbers.arithmeticalAverage();
        System.out.printf("Avarage: %.2f", result);


        //then
        assertEquals(5, result);

    }

    @Test
    public void findTheBiggestValueWhenIsEmpty() {

        //given
        numbers = new AlgorithmOnTable(new int[0]);

        //when
        int max = numbers.theBiggestValue();

        //then
        assertEquals(-1, max);

    }

    @Test
    public void findTheBiggestValueWhenEveryValueIsPositive() {

        //given
        numbers = new AlgorithmOnTable(new int[]{100, 3, 5, 2});

        //when
        int max = numbers.theBiggestValue();

        //then
        assertEquals(100, max);

    }

    @Test
    public void findTheBiggestValueWhenEveryValueIsNegative() {

        //given
        numbers = new AlgorithmOnTable(new int[]{-59, -30, -100, -3920});

        //when
        int max = numbers.theBiggestValue();

        //then
        assertEquals(-30, max);

    }

    @Test
    public void findTheBiggestValueWhenPartValueIsNegativeAndPositive() {

        //given
        numbers = new AlgorithmOnTable(new int[]{-59, -30, 100, -3920});

        //when
        int max = numbers.theBiggestValue();

        //then
        assertEquals(100, max);

    }
}