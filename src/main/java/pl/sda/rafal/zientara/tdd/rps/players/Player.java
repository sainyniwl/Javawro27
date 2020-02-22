package pl.sda.rafal.zientara.tdd.rps.players;

import pl.sda.rafal.zientara.tdd.rps.GameAction;

public abstract class Player {
    private String nick;

    public Player(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public abstract GameAction getAction();
}
