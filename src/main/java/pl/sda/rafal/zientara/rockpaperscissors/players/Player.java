package pl.sda.rafal.zientara.rockpaperscissors.players;

import pl.sda.rafal.zientara.rockpaperscissors.GameAction;

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
