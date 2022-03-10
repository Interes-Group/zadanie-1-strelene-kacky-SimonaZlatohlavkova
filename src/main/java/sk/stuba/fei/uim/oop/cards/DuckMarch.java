package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.lake.Lake;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tile.Tile;

public class DuckMarch extends Cards{

    public DuckMarch(String name, int amount,boolean needPosition){
        super(name, amount,needPosition);
    }
    @Override
    public int activate(Lake lake) {
        lake.getDeckOfLake().add(lake.getDeckOfLake().get(0));
        lake.getDeckOfLake().remove(0);
       return 1;
    }
}
