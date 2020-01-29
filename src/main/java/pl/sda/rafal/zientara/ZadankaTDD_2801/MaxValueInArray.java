package pl.sda.rafal.zientara.ZadankaTDD_2801;

public class MaxValueInArray {
    public int getMaxValue(int[] numbers) {

        if (numbers == null) {
            return -1;
        }
        int max = 0;

        for (int i : numbers
        ) {
            max = Math.max(max, Math.abs(i));
        }
        return max;
    }
}
