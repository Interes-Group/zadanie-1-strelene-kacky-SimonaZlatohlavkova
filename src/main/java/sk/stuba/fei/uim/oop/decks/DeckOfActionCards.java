package sk.stuba.fei.uim.oop.decks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfActionCards {
    private List<Cards> actionCards;
    private List<Cards> usedCards;
    private Random random;

    public DeckOfActionCards(List<Cards>actionCardsDeck){
        this.actionCards=new ArrayList<>();

        for(int i=0; i<actionCardsDeck.size(); i++){
            for(int j=0; j<actionCardsDeck.get(i).amount; j++){
                this.actionCards.add(actionCardsDeck.get(i));
            }
        }
        Collections.shuffle(this.actionCards);
        this.usedCards=new ArrayList<>();
        this.random = new Random();
    }
    public void tossCard(Cards card){
        this.usedCards.add(card);
    }

    public Cards drawCard(){
        if (this.actionCards.isEmpty()){
            this.actionCards.addAll(usedCards);
            this.usedCards.clear();
        }
        Cards drawed = this.actionCards.get(0);
        this.actionCards.remove(0);
        this.usedCards.add(drawed);
        return drawed;
    }

    public List<Cards> getList(){
        return actionCards;
    }

   /* public void tossCard(Cards card){
        int index = actionCards.indexOf(card);
        if(index==-1) {
            index = usedCards.indexOf(card);
            usedCards.get(index).incrementTossedAmount();
        }
        else{
            actionCards.get(index).incrementTossedAmount();
        }
    }
    public Cards drawCard(){
        if (this.actionCards.isEmpty()){
            for (Cards usedCard : usedCards) {
                usedCard.setAmount(usedCard.tossedAmount);
                usedCard.nullTossedAmount();
            }
            this.actionCards.addAll(usedCards);
            this.usedCards.clear();
        }
        int index= this.random.nextInt(this.actionCards.size());
        if (this.actionCards.get(index).amount==1){
            usedCards.add(actionCards.get(index));
            actionCards.remove(index);
            return usedCards.get(usedCards.size()-1);
        }
        this.actionCards.get(index).setAmount(this.actionCards.get(index).getAmount()-1);
        return this.actionCards.get(index);
    }*/

}
