package pl.sda.rafal.zientara.tdd.Zadanka;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZadankaTest {
    private int[] items;
    private Zadanka algorithms;

    @BeforeEach
    public void start() {
        algorithms = new Zadanka(items);
    }

    @Test
    public void sumEvenFigures() {
        items = new int[]{1, 2, 3, 5, 1, 6, 2, 1, 9, 11, 13};

        int sum = algorithms.sum(items);

        assertEquals(10, sum);
    }

    @Test
    public void sumEvenFigures2() {
        items = new int[]{1, 2, 3, 5, 1, 6, 2, 1, 9, 11, 13,2};

        int sum = algorithms.sum(items);

        assertEquals(12, sum);
    }

    @Test
    public void sumEvenFiguresEmptyTableShouldReturnNegativeOne() {
        items = new int[]{};

        int sum = algorithms.sum(items);

        assertEquals(-1, sum);
    }

    @Test
    public void medianCheckWithTableSizeEven(){
        items = new int[]{1, 2, 3, 4, 5};

        double median = algorithms.median(items);

        assertEquals(3, median);
    }

    @Test
    public void medianCheckWithTableSizeEven2(){
        items = new int[]{1, 2, 3, 4, 5, 7, 9, 10, 11, 16, 17};

        double median = algorithms.median(items);

        assertEquals(7, median);
    }

    @Test
    public void medianCheckWithTableSizeOdd(){
        items = new int[]{1, 2, 3, 5};
        double median = algorithms.median(items);

        assertEquals(2.50, median);
    }

    @Test
    public void medianCheckWithTableSizeOdd2(){
        items = new int[]{1, 2, 3, 5, 7, 8, 9, 10};

        double median = algorithms.median(items);

        assertEquals(6, median);
    }

    @Test
    public void medianCheckWithTableSizeZero(){
        items = new int[]{};

        double median = algorithms.median(items);

        assertEquals(-1, median);
    }

    @Test
    public void isTheArithmeticAverageMethodWorksProperlyAsItShouldForGodSake(){
        items = new int[]{2,2,2,2,2,2};

        double arithmetic = algorithms.arithmeticAvg(items);
        System.out.printf("Avarage: %.2f", arithmetic);

        assertEquals(2,arithmetic);

    }

    @Test
    public void isMaxWorksWithEmpty(){
        items = new int[]{};

        int max = algorithms.max(items);

        assertEquals(-1,max);
    }

    @Test
    public void isMaxWorksWithNegativesOnly(){
        items = new int[]{-59, -30, -100, -3920};

        int max = algorithms.max(items);

        assertEquals(-30,max);
    }

    @Test
    public void isMaxWorksWithPositiveFigures(){
        items = new int[]{100, 3, 5, 200};

        int max = algorithms.max(items);

        assertEquals(200,max);
    }

    @Test
    public void isMaxWorksWithPositiveFigures2(){
        items = new int[]{100, 3, 5, 2};

        int max = algorithms.max(items);

        assertEquals(100,max);
    }


}