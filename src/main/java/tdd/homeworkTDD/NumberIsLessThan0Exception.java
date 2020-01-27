package tdd.homeworkTDD;

public class NumberIsLessThan0Exception extends IllegalArgumentException{
    public void print() {
        System.out.println("Array can't has number which value is under 0");
    }
}
