package pl.sda.rafal.zientara.swing;

public abstract class Player { //interface zamieniam na abstract class
    private String nick;

    public Player(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public abstract GameAction getAction(); //wtedy trzeba dopisać abstract
}
