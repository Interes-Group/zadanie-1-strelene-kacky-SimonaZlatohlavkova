package sk.stuba.fei.uim.oop.decks.cards;

import sk.stuba.fei.uim.oop.decks.Cards;
import sk.stuba.fei.uim.oop.decks.DeckOfLake;
import sk.stuba.fei.uim.oop.tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scatter extends Cards {
    public Scatter(String name, int amount, boolean needPosition){
        super(name, amount,needPosition);
    }
    @Override
    public DeckOfLake activate(DeckOfLake lake) {
        List<Tile> lakeTemp= new ArrayList<>();
        for( int i=0; i<6; i++){
            lakeTemp.add(lake.getTile(i));
        }
        Collections.shuffle(lakeTemp);
        for( int i=0; i<6; i++){
            lake.getDeckOfLake().set(i,lakeTemp.get(i));
        }
        this.played=true;
        lakeTemp.clear();
        return lake;
    }
}
