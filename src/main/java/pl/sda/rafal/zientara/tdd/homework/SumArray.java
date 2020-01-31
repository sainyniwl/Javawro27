package pl.sda.rafal.zientara.tdd.homework;

public class SumArray {

    public static int sumEven(int[] input) {
        int count = 0;
        for (int element : input) {
            if (element % 2 == 0)
                count += element;
        }
        return count;
    }

}
