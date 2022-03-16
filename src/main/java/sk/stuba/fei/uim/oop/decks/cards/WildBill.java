package sk.stuba.fei.uim.oop.decks.cards;

import sk.stuba.fei.uim.oop.decks.Cards;
import sk.stuba.fei.uim.oop.decks.DeckOfLake;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.Objects;

import static sk.stuba.fei.uim.oop.game.Colors.ANSI_CYAN;
import static sk.stuba.fei.uim.oop.game.Colors.ANSI_RESET;

public class WildBill extends Cards {
    public WildBill(String name,int amount,boolean needPosition){
        super(name, amount,needPosition);
    }

    @Override
    public DeckOfLake activate(DeckOfLake lake) {
        lake.setAimedList(usedOnPosition,false);
        if(Objects.equals(lake.getTile(usedOnPosition).getName(), "Duck")){
            Player attackedPlayer=lake.getTile(usedOnPosition).getOwner();
            attackedPlayer.decrementLives();
            if(attackedPlayer.getLives()==0){
                attackedPlayer.setActive(false);
                System.out.println(ANSI_CYAN+"----------------------------------");
                System.out.println("Player "+attackedPlayer.getName()+" was eliminated");
                System.out.println("----------------------------------"+ ANSI_RESET);
            }
            lake.getDeckOfLake().remove(usedOnPosition);
        }
        this.played=true;
        return lake;
    }
}
