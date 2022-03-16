package sk.stuba.fei.uim.oop.decks.cards;

import sk.stuba.fei.uim.oop.decks.Cards;
import sk.stuba.fei.uim.oop.decks.DeckOfLake;
import sk.stuba.fei.uim.oop.tile.Tile;

import java.util.Objects;

import static sk.stuba.fei.uim.oop.game.Colors.ANSI_RED;
import static sk.stuba.fei.uim.oop.game.Colors.ANSI_RESET;

public class TurboDuck extends Cards {

    public TurboDuck(String name, int amount,boolean needPosition){
        super(name, amount,needPosition);
    }
    @Override
    public DeckOfLake activate(DeckOfLake lake) {
        this.played=false;
        if(Objects.equals(lake.getTile(usedOnPosition).getName(), "Water")){
            System.out.println(ANSI_RED+"You can´t play this card on water tile"+ANSI_RESET);
        }
        else{
            Tile tempTile= lake.getTile(usedOnPosition);
            while(usedOnPosition!=0) {
                lake.getDeckOfLake().set(usedOnPosition, lake.getTile(usedOnPosition - 1));
                usedOnPosition--;
            }
            lake.getDeckOfLake().set(0,tempTile);
            this.played=true;
        }
        return lake;
    }
}
