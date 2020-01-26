package pl.sda.rafal.zientara.RockPaperScissors.Players;

import pl.sda.rafal.zientara.RockPaperScissors.GameAction;

public abstract class Player {

    private String nick;

    public Player(String nick) {
        this.nick = nick;
    }

   public abstract GameAction getAction();

    public String getNick() {
        return nick;
    }
}
