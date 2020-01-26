package pl.sda.rafal.zientara.tdd.RockPaperScissor.Players;

import pl.sda.rafal.zientara.tdd.RockPaperScissor.GameAction;

public class StonedPlayer extends Player {

    public StonedPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction() {
        return GameAction.ROCK;
    }
}
