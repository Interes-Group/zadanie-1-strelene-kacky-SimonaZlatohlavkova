package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfActionCards {

    private List<Cards> actionCards;
    private List<Cards> usedCards;
    private Random random;

   /* List <Cards> actionCardsDeck=List.of(
            new Aim("Aim",10),
            new Shoot("Shoot",12),
            new WildBill("Wild Bill",2),
            new TurboDuck("Turbo Duck",1),
            new DuckMarch("Duck March",6),
            new Roshambo("Roshambo",2),
            new DuckDance("Duck Dance",1)
    );*/

    public DeckOfActionCards(List<Cards>actionCardsDeck){
        this.actionCards=new ArrayList<>(actionCardsDeck);
        this.usedCards=new ArrayList<>();
        this.random = new Random();
    }

    public void tossCard(Cards card){
        card.incrementTossedAmount();
        if(card.getAmount()==0){
            usedCards.add(card);
        }
    }

    public Cards drawCard(){
        Cards drawed=this.actionCards.get(this.random.nextInt(this.actionCards.size()));
        if (drawed.amount==1){
            actionCards.remove(drawed);
        }
        if (actionCards.size()==0){
            for (Cards usedCard : usedCards) {
                usedCard.setAmount(usedCard.tossedAmount);
                usedCard.nullTossedAmount();
            }
            actionCards.addAll(usedCards);
            usedCards.clear();
        }
        drawed.setAmount(drawed.getAmount()-1);
        return drawed;
    }

}
