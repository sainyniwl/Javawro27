package pl.sda.rafal.zientara.tdd.RockPaperScissors;

public abstract class Player {
    private String nick;


    public Player(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    abstract GameAction getAction();
}

