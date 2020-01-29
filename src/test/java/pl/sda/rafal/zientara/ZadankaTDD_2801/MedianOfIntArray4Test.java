package pl.sda.rafal.zientara.ZadankaTDD_2801;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfIntArray4Test {


    @Test
    public void medianTest1() {

        MedianOfIntArray4 array4 = new MedianOfIntArray4();
        int[] numbers = {1, 2, 3, 4};
        double result = array4.getMedianOfArray(numbers);
        assertEquals(2.5, result);

    }

    @Test
    public void medianTest2() {

        MedianOfIntArray4 array4 = new MedianOfIntArray4();
        int[] numbers = {1, 2, 3, 4, 5};
        double result = array4.getMedianOfArray(numbers);
        assertEquals(3, result);

    }
    @Test
    public void unSortedMedianTest1() {

        MedianOfIntArray4 array4 = new MedianOfIntArray4();
        int[] numbers = {4, 5, 1, 3, 2};
        double result = array4.getMedianOfArray(numbers);
        assertEquals(3, result);

    }

    @Test
    public void isArrayIsNull() {

        MedianOfIntArray4 array4 = new MedianOfIntArray4();
        double result = array4.getMedianOfArray(null);
        assertEquals(-1, result);

    }


}