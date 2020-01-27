package tdd.RockPaperScissors;

import java.util.Random;

public class RandomPlayer extends Player {
    public RandomPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction() {
        Random randomType = new Random();
        int index = randomType.nextInt(3);
        switch (index) {
            case 0: return GameAction.paper;
            case 1: return GameAction.scissors;
            case 2: return GameAction.rock;
            default: return null;
        }
    }
}
