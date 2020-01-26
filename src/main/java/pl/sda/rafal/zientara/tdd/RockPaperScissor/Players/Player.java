package pl.sda.rafal.zientara.tdd.RockPaperScissor.Players;

import pl.sda.rafal.zientara.tdd.RockPaperScissor.GameAction;

public abstract class Player {
    private String nick;

    public Player(String nick) {
        this.nick = nick;
    }

    public String getNick(){
        return nick;
    }

    public abstract GameAction getAction();
}

