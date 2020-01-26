package pl.sda.rafal.zientara.tdd.swing.RockPaperScissors.players;

import pl.sda.rafal.zientara.tdd.swing.RockPaperScissors.GameAction;
import pl.sda.rafal.zientara.tdd.swing.RockPaperScissors.Player;

public class StonedPlayer extends Player {

    public StonedPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction() {
        return GameAction.ROCK;
    }
}
