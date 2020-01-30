package pl.sda.rafal.zientara.homework;

public class Maximum {

    private int[] array;

    public Maximum(int[] array) {
        this.array = array;
    }

    public int returnMaxValue(){
        int maxValue = 0;

        if(array.length == 0){
            maxValue = -1;
        }else {
            for (int element : array) {
                if (element > maxValue) {
                    maxValue = element;
                }
            }
        }
       return maxValue;
    }
}
