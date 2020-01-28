package pl.sda.rafal.zientara.ZadankaTDD_2801;

public class EvenNumbersSum {

    public int sumOfEven(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                result += number;
            }
        }
        return result;
    }
}
