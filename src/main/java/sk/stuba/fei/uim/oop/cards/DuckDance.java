package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.lake.Lake;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.Collections;

public class DuckDance extends Cards{
    public DuckDance(String name, int amount, boolean needPosition){
        super(name, amount, needPosition);
    }
    @Override
    public int activate(Lake lake) {
        Collections.shuffle(lake.getDeckOfLake());
        return 1;
    }
}