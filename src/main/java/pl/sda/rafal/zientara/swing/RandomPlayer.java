package pl.sda.rafal.zientara.swing;

public class RandomPlayer extends Player { //trzeba zamienić na extends

    public RandomPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction() {
        double random = Math.random()*100;
        if(random < 34){
            return GameAction.SCISSORS;
        } else  if (random>68){
            return GameAction.ROCK;
        } else {
            return GameAction.PAPER;
        }
    }
}
