package pl.sda.rafal.zientara.tdd.swing.RockPaperScissors.players;

import pl.sda.rafal.zientara.tdd.swing.RockPaperScissors.GameAction;
import pl.sda.rafal.zientara.tdd.swing.RockPaperScissors.Player;

public class RandomPlayer extends Player {

    public RandomPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction(){
        double random = Math.random()*100;
        if(random <34){
            return GameAction.SCISSORS;
        }
        else if(random > 68){
            return GameAction.ROCK;
        }
        else return GameAction.PAPER;
    }
}
