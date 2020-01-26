package pl.sda.rafal.zientara.tdd.RockPaperScissors;

public class ReturnRandomInt {
    public static int random() {
        // define the range
        int rand=0;
        int max = 3;
        int min = 1;
        int range = max - min + 1;

        // generate random numbers within 1 to 10
        for (int i = 0; i < 3; i++) {
            rand = (int) (Math.random() * range) + min;
        }
        return rand;
    }
}
