package pl.sda.rafal.zientara.tdd.RockPaperScissor.Players;

import pl.sda.rafal.zientara.tdd.RockPaperScissor.GameAction;

public class RandomPlayer implements Player {
    @Override
    public GameAction getAction() {
        double random = Math.random() * 100; // od 0 do 99.(9)
        if (random < 34) {
            return GameAction.SCISSORS;
        } else if (random > 68) {
            return GameAction.ROCK;
        } else {
            return GameAction.PAPER;
        }
    }
}
