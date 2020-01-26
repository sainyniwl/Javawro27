package pl.sda.rafal.zientara.RockPaperScissors.Players;

import pl.sda.rafal.zientara.RockPaperScissors.GameAction;

public class RandomPlayer implements Player {
    @Override
    public GameAction getAction() {
        double random = Math.random() * 100;
        if (random < 34) {
            return GameAction.SCISSORS;
        } else if (random > 68) {
            return GameAction.ROCK;
        } else return GameAction.PAPER;
    }
}
