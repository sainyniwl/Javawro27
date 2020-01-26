package pl.sda.rafal.zientara.tdd.rps.players;

import pl.sda.rafal.zientara.tdd.rps.GameAction;
import pl.sda.rafal.zientara.tdd.rps.players.Player;

public class StonedPlayer implements Player {
    @Override
    public GameAction getAction() {
        return GameAction.ROCK;
    }
}
