package tdd.homeworkTDD.ListOfExercisesByRafal;

public class Main {
    public static void main(String[] args) {
        Homework homework = new Homework();
        double[] doubles = {2,4,1,5,8,3,0,1};
        int[] ints ={2,4,-1,5,8,3,3,1};
        System.out.println("Sum: "+ homework.countSum(ints));
        System.out.println("Median: "+ homework.returnMedian(doubles));
        System.out.printf("Arithmetical Average: %.2f \n", homework.calcArithmeticalAverage(ints));
        try {
            System.out.println("Max value: " + homework.maxValue(ints));
        }catch(NumberIsLessThan0Exception e) {
            e.print();
        }
    }
}
