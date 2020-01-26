package pl.sda.rafal.zientara.tdd.swing.RockPaperScissors;

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
