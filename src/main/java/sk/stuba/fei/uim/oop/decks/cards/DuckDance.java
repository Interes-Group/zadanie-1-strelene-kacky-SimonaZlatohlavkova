package sk.stuba.fei.uim.oop.decks.cards;
import sk.stuba.fei.uim.oop.decks.Cards;
import sk.stuba.fei.uim.oop.decks.DeckOfLake;
import java.util.Collections;

public class DuckDance extends Cards {
    public DuckDance(String name, int amount, boolean needPosition){
        super(name, amount, needPosition);
    }

    @Override
    public DeckOfLake activate(DeckOfLake lake) {
        Collections.shuffle(lake.getDeckOfLake());
        this.played=true;
        return lake;
    }
}
