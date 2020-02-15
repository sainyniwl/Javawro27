package pl.sda.rafal.zientara.tdd.homework;

public class Average {
    /**
     * Count average value - use varargs
     */
    public static float count(int... input) {
        if (input.length == 0)
            return -1;
        else {
            float sum = 0;
            for (int element : input) {
                sum += element;
            }
            return sum / input.length;
        }
    }
}
