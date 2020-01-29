package pl.sda.rafal.zientara.ZadankaTDD_2801;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ArithmeticArrayNumbers {
    public double medianOfArrayNumbers(int[] numbers) {

        if (numbers == null) {
            return -1;
        }
        double result;
        double temp = 0;
        for (int number : numbers
        ) {
            temp += number;
        }
        double tempp = temp / numbers.length;
        BigDecimal bigDecimal = new BigDecimal(tempp).setScale(2, RoundingMode.DOWN);
        result = bigDecimal.doubleValue();
        return result;
    }
}
