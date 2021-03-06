package sk.stuba.fei.uim.oop.decks.cards;
import sk.stuba.fei.uim.oop.decks.Cards;
import sk.stuba.fei.uim.oop.decks.DeckOfLake;
import static sk.stuba.fei.uim.oop.game.Colors.ANSI_RED;
import static sk.stuba.fei.uim.oop.game.Colors.ANSI_RESET;

public class Aim extends Cards {
    public Aim(String name,int amount,boolean needPosition){
        super(name, amount,needPosition);
    }

    @Override
    public DeckOfLake activate(DeckOfLake lake) {
        this.played=false;
        if(lake.getAimedList(usedOnPosition)){
            System.out.println(ANSI_RED+"Can´t play this card on this position."+ANSI_RESET);
        }
        else{
            lake.setAimedList(usedOnPosition, true);
            this.played=true;
        }
        return lake;
    }
}
