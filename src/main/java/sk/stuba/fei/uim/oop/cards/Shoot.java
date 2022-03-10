package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.lake.Lake;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.Objects;

public class Shoot extends Cards {

    public Shoot(String name,int amount,boolean needPosition){
        super(name, amount,needPosition);
    }

    @Override
    public int activate(Lake lake) {
        if(!lake.getTile(usedOnPosition).getAimed()){
            System.out.println("Can´t play this card on this position.");
            return 0;
        }
        else{
            if(Objects.equals(lake.getTile(usedOnPosition).getName(), "Water")){
                lake.getTile(usedOnPosition).setUnaimed();
            }
            else{
                Player attackedPlayer=lake.getTile(usedOnPosition).getOwner();
                attackedPlayer.decrementLives();
                if(attackedPlayer.getLives()==0){attackedPlayer.setActive(false);
                }
            }
        }
        return 1;
    }
}
