package pl.sda.rafal.zientara.tdd.RockPaperScissors;

public class StonedPlayer extends Player {
    public StonedPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction() {
        return GameAction.rock;
    }
}
