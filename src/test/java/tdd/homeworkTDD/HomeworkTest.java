package tdd.homeworkTDD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.homeworkTDD.ListOfExercisesByRafal.Homework;
import tdd.homeworkTDD.ListOfExercisesByRafal.NumberIsLessThan0Exception;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

    Homework homework;

    @BeforeEach
    public void createObject() {
        homework = new Homework();
    }

    @Test
    public void sumOnlyOddNumbers() {
        int[] ints = {5, 3, 1};
        int zero = homework.countSum(ints);
        assertEquals(zero, 0);
    }

    @Test
    public void ifArrayIsEmptyReturn() {
        int[] ints = {};
        int minus = homework.countSum(ints);
        assertEquals(minus, -1);
    }

    @Test
    public void returnMedianIfArrayHasOddQuantityOfValues() {
        double[] oddNumberOfDoubles = {2, 5, 3, 7, 1};
        double result = homework.returnMedian(oddNumberOfDoubles);
        assertEquals(result, 3);
    }

    @Test
    public void returnMedianIfArrayHasEvenQuantityOfValues() {
        double[] oddNumberOfDoubles = {2, 5, 3, 7, 1, 4};
        double result = homework.returnMedian(oddNumberOfDoubles);
        assertEquals(result, 3.5);
    }

    @Test
    public void checkMaximumForEmptyArray() {
        int[] ints = {};
        int result = homework.maxValue(ints);
        assertEquals(result, -1);
    }

    @Test
    public void checkMaximumForFirstValueOfArray() {
        int[] ints = {100, 3, 5, 2};
        int result = homework.maxValue(ints);
        assertEquals(result, 100);
    }

    @Test
    public void checkMaximumForLastValueOfArray() {
        int[] ints = {100, 3, 5, 200};
        int result = homework.maxValue(ints);
        assertEquals(result, 200);
    }

    @Test
    public void checkForValuesThatAreLessThan0() {
        int[] ints = {-59, -30, -100, -3920};
        assertThrows(NumberIsLessThan0Exception.class, () -> homework.maxValue(ints));
    }

}