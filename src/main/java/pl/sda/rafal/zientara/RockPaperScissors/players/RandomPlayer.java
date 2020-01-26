package pl.sda.rafal.zientara.RockPaperScissors.players;

import pl.sda.rafal.zientara.RockPaperScissors.GameAction;

public class RandomPlayer implements Player {
    @Override
    public GameAction getAction() {
        double random = Math.random() * 100; // 0-99
        if (random < 34) return GameAction.SCISSORS;
        else if (random > 68) return GameAction.PAPER;
        else return GameAction.ROCK;
    }
}
