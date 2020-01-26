package pl.sda.rafal.zientara.RockPaperScissors.players;

import pl.sda.rafal.zientara.RockPaperScissors.GameAction;

public abstract class Player {
    private String nick;
   public abstract GameAction getAction();

    public Player(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }
}
