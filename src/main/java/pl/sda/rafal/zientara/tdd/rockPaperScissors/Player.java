package pl.sda.rafal.zientara.tdd.rockPaperScissors;

public abstract class Player {

    private String nick;
    protected abstract GameAction getAction (GameAction action);

    public Player(String nick) {
        this.nick = nick;
    }

    public String getNick(){
        return nick;
    }

}
