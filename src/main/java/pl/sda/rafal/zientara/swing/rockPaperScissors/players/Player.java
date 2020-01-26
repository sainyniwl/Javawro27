package pl.sda.rafal.zientara.swing.rockPaperScissors.players;

import pl.sda.rafal.zientara.swing.rockPaperScissors.GameAction;

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

// interface ma zawsze public
//klasa abstrakcyjna
