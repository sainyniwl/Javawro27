package pl.sda.rafal.zientara.rockpaperscissors.players;

import pl.sda.rafal.zientara.rockpaperscissors.GameAction;

public class RandomPlayer implements Player{


    @Override
    public GameAction getAction() {
        double random = Math.random() * 100;
        if(random < 34){
            return GameAction.SCISSORS;
        }else if(random > 67){
            return GameAction.ROCK;
        }else{
            return GameAction.PAPER;
        }

    }
}
