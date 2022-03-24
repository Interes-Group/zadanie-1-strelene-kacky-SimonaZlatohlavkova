package sk.stuba.fei.uim.oop.decks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DeckOfActionCards {
    private  List<Cards> actionCards;
    private List<Cards> usedCards;

    public DeckOfActionCards(List<Cards>actionCardsDeck){
        this.actionCards=new ArrayList<>();
        for(int i=0; i<actionCardsDeck.size(); i++){
            for(int j=0; j<actionCardsDeck.get(i).amount; j++){
                this.actionCards.add(actionCardsDeck.get(i));
            }
        }
        Collections.shuffle(this.actionCards);
        this.usedCards=new ArrayList<>();
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
}
