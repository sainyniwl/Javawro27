package pl.sda.rafal.zientara.tdd.Zadanka;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class Zadanka {
    private int[] items;

    public Zadanka(int[] items) {
        this.items = items;
    }


    public double median(int[] items){
        if (items.length == 0) return -1;
        if (items.length % 2 != 0){
            return items[items.length/2];
        } else {
            double a = items[items.length/2-1];
            double b = items[items.length/2];
            return (a+b)/2;
        }
    }

    public int sum(int[] items){
        if (items.length > 0) {
            int sum = Arrays.stream(items)
                    .filter(item -> item % 2 == 0)
                    .sum();
            return sum;
        } else {
            return -1;
        }
    }


    public double arithmeticAvg(int[] items){
        double sum = 0;
        for (int x: items)
            sum+=x;

        double result = Math.round(sum/items.length);

        return result;
    }

    public int max(int[] items){
        if (items.length == 0) return -1;
        int max = items[0];
        for (int x: items)
            if (max<x)
                max = x;

        return max;
    }




}
