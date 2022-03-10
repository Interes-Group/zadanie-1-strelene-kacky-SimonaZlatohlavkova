package sk.stuba.fei.uim.oop.deckOfCards.actionCards;

import sk.stuba.fei.uim.oop.deckOfCards.Cards;
import sk.stuba.fei.uim.oop.deckOfCards.DeckOfLake;
import sk.stuba.fei.uim.oop.tile.Tile;

import java.util.Objects;

public class TurboDuck extends Cards {

    public TurboDuck(String name, int amount,boolean needPosition){
        super(name, amount,needPosition);
    }
    @Override
    public DeckOfLake activate(DeckOfLake lake) {
        this.played=false;
        if(Objects.equals(lake.getTile(usedOnPosition).getName(), "Water")){
            System.out.println("You can´t play this card on water tile");
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
