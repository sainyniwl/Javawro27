package pl.sda.rafal.zientara.ZadankaTDD_2801;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfArrayNumbersTest {


    @Test

    public void medianOfSortedIntArray() {

        MedianOfArrayNumbers median = new MedianOfArrayNumbers();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double result = median.medianOfArrayNumbers(numbers);
        assertEquals(5.5, result);
    }

    @Test
    public void medianOfNonSortedIntArray() {

        MedianOfArrayNumbers median = new MedianOfArrayNumbers();
        int[] numbers = {2, 5, 8, 3, 1, 9, 11, 33, 3};
        double result = median.medianOfArrayNumbers(numbers);
        assertEquals(8.33, result);
    }

    @Test
    public void medianOfNonSortedIntArrayDouble1() {

        MedianOfArrayNumbers median = new MedianOfArrayNumbers();
        int[] numbers = {2, 5, 8, 3, 1, 9, 11, 33, 4};
        double result = median.medianOfArrayNumbers(numbers);
        assertEquals(8.44, result);
    }

    @Test
    public void medianOfNonSortedIntArrayDouble2() {

        MedianOfArrayNumbers median = new MedianOfArrayNumbers();
        int[] numbers = {2, 5, 8, 3, 1, 9, 11, 33, 5};
        double result = median.medianOfArrayNumbers(numbers);
        assertEquals(8.55, result);
    }

    @Test
    public void medianOfNonSortedIntArrayDouble3() {

        MedianOfArrayNumbers median = new MedianOfArrayNumbers();
        int[] numbers = {2, 5, 8, 3, 1, 9, 11, 33, 7};
        double result = median.medianOfArrayNumbers(numbers);
        assertEquals(8.77, result);
    }

    @Test
    public void medianOfNonSortedIntArrayDouble4() {
        MedianOfArrayNumbers median = new MedianOfArrayNumbers();
        int[] numbers = {1, 2, 3, 5};
        double result = median.medianOfArrayNumbers(numbers);
        assertEquals(2.75, result);
    }

    @Test
    public void returnIntWhenArrayIsNULL() {
        MedianOfArrayNumbers median = new MedianOfArrayNumbers();
        double result = median.medianOfArrayNumbers(null);
        assertEquals(-1, result);
    }


}