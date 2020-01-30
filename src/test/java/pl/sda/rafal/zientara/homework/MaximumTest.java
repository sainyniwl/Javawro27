package pl.sda.rafal.zientara.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumTest {

    @Test
    public void whenArrayIsEmpty(){
        //given
        int[] input = {};
        Maximum maximum = new Maximum(input);

        //when
        int max = maximum.returnMaxValue();

        //then
        assertEquals(-1, max);
    }

    @Test
    public void whenFirstElementIsMax(){
        //given
        int[] input = {100, 3, 5, 2};
        Maximum maximum = new Maximum(input);

        //when
        int max = maximum.returnMaxValue();

        //then
        assertEquals(100, max);
    }

    @Test
    public void whenLastElementIsMax(){
        //given
        int[] input = {100, 3, 5, 200};
        Maximum maximum = new Maximum(input);

        //when
        int max = maximum.returnMaxValue();

        //then
        assertEquals(200, max);
    }

    @Test
    public void whenArrayIsWithMinusOnly(){
        //given
        int[] input = {-59, -30, -100, -3920};
        Maximum maximum = new Maximum(input);

        //when
        int max = maximum.returnMaxValue();

        //then
        assertEquals(0, max);
    }



}