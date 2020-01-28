package tdd.homeworkTDD.ListOfExercisesByRafal;

import java.util.Arrays;

public class Homework {
    public int countSum(int[] ints) {
        if (ints.length==0) return -1;
        double sum=0;
        for (int anInt : ints) {
            if (anInt % 2 == 0) sum += anInt;
        }
        return (int)sum;
    }
    public double returnMedian(double[] randomInts){
        if (randomInts.length==0) return -1;
        Arrays.sort(randomInts);
        double result =0;
        int middleIndex = randomInts.length/2;
        if (randomInts.length%2==0) result = (randomInts[middleIndex]+randomInts[middleIndex-1])/2;
        else result= randomInts[middleIndex];
        return result;
    }
    public double calcArithmeticalAverage(int[] randomIntsArray){
double result = 0;
        for (int value : randomIntsArray) {
            result += value;
        }
        return result/randomIntsArray.length;
    }
    public int maxValue(int[] randomIntArray) {
        if (randomIntArray.length==0) return -1;
        int maxValue=randomIntArray[0];
        for (int i = 1; i <randomIntArray.length; i++) {
            if (randomIntArray[i]<0) throw new NumberIsLessThan0Exception();
            if (randomIntArray[i] > maxValue) maxValue = randomIntArray[i];
        }
        return maxValue;
    }



}
