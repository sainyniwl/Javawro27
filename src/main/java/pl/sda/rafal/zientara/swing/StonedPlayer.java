package pl.sda.rafal.zientara.swing;

public class StonedPlayer extends Player {
    public StonedPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction() {
        return GameAction.ROCK;
    }
}
