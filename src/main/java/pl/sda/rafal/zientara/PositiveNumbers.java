package pl.sda.rafal.zientara;

public class PositiveNumbers {
    public static final int TAB_SIZE = 7;
    public int[] num;
    private int result = 0;

    public PositiveNumbers(int[] num) {
        this.num = num;
    }

    public void sumPositive() {

        for (int i = 0; i < num.length; i++) {
            if (num [i] % 2 == 0)
                result += num[i];
            }
        System.out.println("Sum of positive numbers is: "+ result);
    }

    public int getResult() {
        return result;
    }

    public static void main(String[] args) {
        PositiveNumbers num = new PositiveNumbers(new int []{1, 2, 3, 5, 1, 6, 2});
         num.sumPositive();
    }

//    public boolean isEmpty() {
//        for (int i = 0; i <num.length ; i++) {
//
//            if (num[i])
//
//        }
//    }
}
