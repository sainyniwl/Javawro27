package pl.sda.rafal.zientara.RockPaperScissors.Players;

import pl.sda.rafal.zientara.RockPaperScissors.GameAction;
import pl.sda.rafal.zientara.RockPaperScissors.Players.Player;

public class StonedPlayer extends Player {

    public StonedPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction() {
        return GameAction.ROCK;
    }
}
