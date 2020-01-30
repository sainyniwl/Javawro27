package pl.sda.rafal.zientara.homework;

public class SecondOne {

    private int[] array;

    public SecondOne(int[] input) {
        this.array = input;
    }


    public int showFirstNumber() {
        return array[0];
    }

    public int lastNumber() {
        return array[array.length - 1];
    }

    public int sumOfAllElements() {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }


    public double showMedian() {
        double median = 0;

        if (array.length == 0) {
            return -1;
        } else {
            if (array.length % 2 == 1) {
                median = array[(array.length / 2)];
            } else {
                median = (array[array.length / 2 - 1] + array[(array.length / 2)]) / 2;
            }
            return median;
        }
    }
}
