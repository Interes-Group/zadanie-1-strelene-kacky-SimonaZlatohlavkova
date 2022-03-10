package sk.stuba.fei.uim.oop.deckOfCards.actionCards;

import sk.stuba.fei.uim.oop.deckOfCards.Cards;
import sk.stuba.fei.uim.oop.deckOfCards.DeckOfLake;

public class DuckMarch extends Cards {

    public DuckMarch(String name, int amount,boolean needPosition){
        super(name, amount,needPosition);
    }
    @Override
    public DeckOfLake activate(DeckOfLake lake) {
        lake.getDeckOfLake().add(lake.getDeckOfLake().get(0));
        lake.getDeckOfLake().remove(0);
        this.played=true;
       return lake;
    }
}
