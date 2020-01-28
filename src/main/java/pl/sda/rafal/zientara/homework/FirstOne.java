package pl.sda.rafal.zientara.homework;

public class FirstOne {

    private int[] array;

    public FirstOne(int[] array) {
        this.array = array;
    }


    public Integer showFirstEven() {
        int firstEven = 0;
        for (int element : array) {
            if (element % 2 == 0) {
                firstEven = element;
                break;
            }
        }
        return firstEven;
    }


    public Integer sumOfAll() {
        int counter = 0;
        for (int element : array) {
            counter += element;
        }
        return counter;
    }

    public Integer lastEven() {
        int counter = 0;
        for (int element : array) {
            if (element % 2 == 0) {
                counter = element;
            }
        }
        return counter;
    }


    public Integer sumOfEvens() {
        int counter = 0;
        if (array.length == 0) {
            return -1;
        } else {
            for (int element : array) {
                if (element % 2 == 0) {
                    counter += element;
                }
            }
        }
        return counter;
    }


}


