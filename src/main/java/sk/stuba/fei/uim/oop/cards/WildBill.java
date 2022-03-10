package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.lake.Lake;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.Objects;

public class WildBill extends Cards{
    public WildBill(String name,int amount,boolean needPosition){
        super(name, amount,needPosition);
    }

    @Override
    public int activate(Lake lake) {
        if(Objects.equals(lake.getTile(usedOnPosition).getName(), "Water")){
            lake.getTile(usedOnPosition).setUnaimed();
        }
        else {
            Player attackedPlayer = lake.getTile(usedOnPosition).getOwner();
            attackedPlayer.decrementLives();
            if (attackedPlayer.getLives() == 0) {
                attackedPlayer.setActive(false);
            }
        }
        return 1;
    }
}
