package pl.sda.rafal.zientara.RockPaperScissors.players;

import pl.sda.rafal.zientara.RockPaperScissors.GameAction;

public class StonedPlayer implements Player {
    @Override
    public GameAction getAction() {
        return GameAction.ROCK;
    }
}
