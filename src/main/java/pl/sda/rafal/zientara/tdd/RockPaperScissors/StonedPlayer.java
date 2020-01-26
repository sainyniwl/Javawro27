package pl.sda.rafal.zientara.tdd.RockPaperScissors;

public class StonedPlayer implements Player {
    @Override
    public GameAction getAction() {
        return GameAction.rock;
    }
}
