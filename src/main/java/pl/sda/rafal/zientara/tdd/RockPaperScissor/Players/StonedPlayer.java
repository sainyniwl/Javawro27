package pl.sda.rafal.zientara.tdd.RockPaperScissor.Players;

import pl.sda.rafal.zientara.tdd.RockPaperScissor.GameAction;

public class StonedPlayer implements Player {
    @Override
    public GameAction getAction() {
        return GameAction.ROCK;
    }
}
