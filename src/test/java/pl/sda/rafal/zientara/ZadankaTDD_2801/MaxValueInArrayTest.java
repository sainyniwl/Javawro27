package pl.sda.rafal.zientara.ZadankaTDD_2801;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxValueInArrayTest {

    @Test
    public void maxValueOfSortedArray() {

        MaxValueInArray maxValue = new MaxValueInArray();
        int[] numbers = {100, 3, 5, 200};
        int result = maxValue.getMaxValue(numbers);
        assertEquals(200, result);
    }

    @Test
    public void maxValueOfSortedArray2() {

        MaxValueInArray maxValue = new MaxValueInArray();
        int[] numbers = {100, 3, 5, 2};
        int result = maxValue.getMaxValue(numbers);
        assertEquals(100, result);
    }


    @Test
    public void maxNegativeValueOfIntArray() {

        MaxValueInArray maxValue = new MaxValueInArray();
        int[] numbers = {-59, -30, -100, -3920};
        int result = maxValue.getMaxValue(numbers);
        assertEquals(3920, result);
    }

}