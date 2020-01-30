package pl.sda.rafal.zientara.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondOneTest {

    @Test
    public void isArrayMaking() {
        //given

        int[] input = {1, 3, 8, 10, 20};
        SecondOne secondOne = new SecondOne(input);

        //when
        int counter = 0;
        for (int element : input) {
            counter += element;
        }

        //then
        assertEquals(42, counter);
    }

    @Test
    public void showFirstNumberFromArray(){
        //given
        int[] input = {1, 3, 8, 10, 20};
        SecondOne secondOne = new SecondOne(input);

        //when
        int firstNumber = secondOne.showFirstNumber();

        //then
        assertEquals(1, firstNumber);

    }

    @Test
    public void showLastNumberFromArray(){
        //given
        int[] input = {1, 3, 8, 10, 20};
        SecondOne secondOne = new SecondOne(input);

        //when
        int lastNumber = secondOne.lastNumber();

        //then
        assertEquals(20, lastNumber);
    }

    @Test
    public void sumAllElementFromArray(){
        //given
        int[] input = {1, 3, 8, 10, 20};
        SecondOne secondOne = new SecondOne(input);

        //when
        int sum = secondOne.sumOfAllElements();

        //then
        assertEquals(42, sum);
    }

    @Test
    public void showMedianIfOddElements(){
        //given
        int[] input = {1, 3, 8, 10, 20};
        SecondOne secondOne = new SecondOne(input);

        //when
        double median = secondOne.showMedian();

        //then
        assertEquals(8, median);
    }

    @Test
    public void showMedianIfEvenElements(){
        //given
        int[] input = {1, 3, 8, 10, 20, 30};
        SecondOne secondOne = new SecondOne(input);

        //when
        double median = secondOne.showMedian();

        //then
        assertEquals(9, median);
    }

    @Test
    public void doesMethodCheckIfArrayIsEmpty(){
        //given
        int[] input = {};
        SecondOne secondOne = new SecondOne(input);

        //when
        double median = secondOne.showMedian();

        //then
        assertEquals(-1, median);
    }

}