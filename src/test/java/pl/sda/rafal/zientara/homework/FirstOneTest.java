package pl.sda.rafal.zientara.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstOneTest {

    @Test
    public void isEmptyArrayReturnsValue() {
        //given
        int[] input = {};
        FirstOne firstOne = new FirstOne(input);

        //when
        Integer sumOfEvens = firstOne.sumOfEvens();


        //then
        assertEquals(-1, sumOfEvens);
    }

    @Test
    public void isArrayMaking() {
        //given
        int[] input = {1, 2, 3, 4, 5};
        FirstOne firstOne = new FirstOne(input);

        //when
        int counter = 0;
        for (int element : input) {
            counter += element;
        }

        //then
        assertEquals(15, counter);
    }

    @Test
    public void showFirstEvenNumber() {
        //given
        int[] input = {1, 2, 3, 4, 5};
        FirstOne firstOne = new FirstOne(input);

        //when
        Integer firstEven = firstOne.showFirstEven();

        //then
        assertEquals(2, firstEven);
    }

    @Test
    public void sumOfAllElements() {
        //given
        int[] input = {1, 2, 3, 4, 5};
        FirstOne firstOne = new FirstOne(input);

        //when
        Integer sumOfAll = firstOne.sumOfAll();

        //then
        assertEquals(15, sumOfAll);

    }

    @Test
    public void showLastEven() {
        //given
        int[] input = {1, 2, 3, 4, 5};
        FirstOne firstOne = new FirstOne(input);

        //when
        Integer lastEven = firstOne.lastEven();

        //then
        assertEquals(4, lastEven);

    }

    @Test
    public void showSumOfAllEvens() {
        //given
        int[] input = {1, 2, 3, 4, 5};
        FirstOne firstOne = new FirstOne(input);

        //when
        Integer sumOfEvens = firstOne.sumOfEvens();

        //then
        assertEquals(6, sumOfEvens);


    }

}