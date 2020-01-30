package pl.sda.rafal.zientara;

public class AlgorithmOnTable {
    public int[] num;
    private int result = 0;

    public AlgorithmOnTable(int[] num) {
        this.num = num;
    }


    public void sumPositive() {

        for (int value : num) {
            if (value % 2 == 0)
                result += value;
        }
        System.out.println("Sum of positive numbers is: " + result);
    }

    public int getResult() {
        return result;
    }

    public double countMedian() {

        if (num.length == 0) {
            return -1;
        }
        if (num.length % 2 != 0) {
            int indexOfPivot = (num.length + 1) / 2;
            return num[indexOfPivot - 1];
        } else {
            int indexOfPivot = num.length / 2;
            return ((double) num[indexOfPivot] + (double) num[indexOfPivot - 1]) / 2;
        }
    }

    public double arithmeticalAverage() {
        if (num.length == 0) {
            return -1;
        }
        double sum = 0;
        for (double elem : num) {
            sum += elem;

        }
        return sum / num.length;

    }

    public int theBiggestValue() {
        if (num.length == 0) return -1;
        int max = num[0];
        for (int elem: num)
            if (max<elem)
                max = elem;

        return max;
    }


    public static void main(String[] args) {
        AlgorithmOnTable med = new AlgorithmOnTable(new int[]{1, 2, 3, 4});
        med.sumPositive();
        med.countMedian();

        AlgorithmOnTable med2 = new AlgorithmOnTable(new int[]{1, 2, 3, 4, 5});
        med2.sumPositive();
        med2.countMedian();
    }

}


