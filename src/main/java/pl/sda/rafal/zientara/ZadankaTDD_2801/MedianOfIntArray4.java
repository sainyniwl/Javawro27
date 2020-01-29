package pl.sda.rafal.zientara.ZadankaTDD_2801;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MedianOfIntArray4 {
    public double getMedianOfArray(int[] numbers) {

        double result;

        if (numbers == null) {
            return -1;
        }

        Arrays.sort(numbers);

        if (numbers.length % 2 == 0) {
            result = ((double) numbers[numbers.length / 2] + (double) numbers[numbers.length / 2 - 1]) / 2;
        } else result = numbers[numbers.length / 2];


        return result;
    }
}
