package pl.sda.rafal.zientara.RockPaperScissors.Players;

import pl.sda.rafal.zientara.RockPaperScissors.GameAction;
import pl.sda.rafal.zientara.RockPaperScissors.Players.Player;

public class StonedPlayer implements Player {
    @Override
    public GameAction getAction() {
        return GameAction.ROCK;
    }
}
