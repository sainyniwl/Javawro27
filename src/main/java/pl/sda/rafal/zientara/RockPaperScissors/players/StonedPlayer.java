package pl.sda.rafal.zientara.RockPaperScissors.players;

import pl.sda.rafal.zientara.RockPaperScissors.GameAction;

public class StonedPlayer extends Player {

    public StonedPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction() {
        return GameAction.ROCK;
    }
}
