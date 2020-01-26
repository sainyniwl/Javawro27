package pl.sda.rafal.zientara.RockPaperScissors;

public class StonedPlayer implements Player {
    @Override
    public GameAction getAction() {
        return GameAction.ROCK;
    }
}
