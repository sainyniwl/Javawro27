package pl.sda.rafal.zientara.homework;

public class ArithmeticAverage {

    public static void arithmetic(int[] array){
        double sum = 0;
        String averageDotTwo = "";

        for (int element: array) {
            sum += element;
        }
        double average = sum / (array.length);
//        averageDotTwo = String.valueOf(average);

//        String.format("%.2f", averageDotTwo);

        System.out.format("%.2f", average);
    }

    public static void main(String[] args) {

        int[] input = {1, 3, 8, 10, 20};
        arithmetic(input);

    }
}
