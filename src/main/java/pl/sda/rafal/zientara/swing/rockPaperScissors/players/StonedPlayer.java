package pl.sda.rafal.zientara.swing.rockPaperScissors.players;

import pl.sda.rafal.zientara.swing.rockPaperScissors.GameAction;
import pl.sda.rafal.zientara.swing.rockPaperScissors.players.Player;

public class StonedPlayer extends Player {
    public StonedPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction() {
        return GameAction.ROCK;
    }
}
