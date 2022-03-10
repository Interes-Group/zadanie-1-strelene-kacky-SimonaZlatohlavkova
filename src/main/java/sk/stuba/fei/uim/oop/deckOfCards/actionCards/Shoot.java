package sk.stuba.fei.uim.oop.deckOfCards.actionCards;

import sk.stuba.fei.uim.oop.deckOfCards.Cards;
import sk.stuba.fei.uim.oop.deckOfCards.DeckOfLake;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.Objects;

public class Shoot extends Cards {

    public Shoot(String name,int amount,boolean needPosition){
        super(name, amount,needPosition);
    }

    @Override
    public DeckOfLake activate(DeckOfLake lake) {
        this.played=false;
        if(!lake.getAimedList(usedOnPosition)){
            System.out.println("Can´t play this card on this position.");
        }
        else{
                lake.setAimedList(usedOnPosition,false);
                if(Objects.equals(lake.getTile(usedOnPosition).getName(), "Duck")){
                    Player attackedPlayer=lake.getTile(usedOnPosition).getOwner();
                    attackedPlayer.decrementLives();
                    if(attackedPlayer.getLives()==0){
                        attackedPlayer.setActive(false);
                    }
                    lake.getDeckOfLake().remove(usedOnPosition);
                }
            this.played=true;
        }
        return lake;
    }
}
