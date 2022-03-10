package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.lake.Lake;
import sk.stuba.fei.uim.oop.player.Player;

public class TurboDuck extends Cards{

    public TurboDuck(String name, int amount,boolean needPosition){
        super(name, amount,needPosition);
    }
    @Override
    public int activate(Lake lake) {
        return -1;

    }
}
