package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.cards.Cards;
import sk.stuba.fei.uim.oop.cards.DeckOfActionCards;
import sk.stuba.fei.uim.oop.lake.Lake;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private String name;
    private boolean active;
    private int lives;
    private List<Cards> cards;

    public Player(String name){
        this.name=name;
        this.lives=5;
        this.active=true;
        this.cards=new ArrayList<Cards>();
    }

    public void takeCard(DeckOfActionCards actionCards){
        this.cards.add(actionCards.drawCard());
    }
    public void tossCard(DeckOfActionCards actionCards, Cards tossedCard){
        this.cards.remove(tossedCard);
        actionCards.tossCard(tossedCard);
    }
    public boolean isActive(){
        return active;
    }
    public void setActive(boolean active){
        this.active=active;
    }
    public void playCard(Lake lake, DeckOfActionCards actionCards){
        int played=0;
        int cardNumber=0;
        int positionNumber;
        while(played==0){
            do {
                cardNumber = ZKlavesnice.readInt("Which card do you want to play?");
            } while (cardNumber<1||cardNumber>3);
            if(cards.get(cardNumber-1).getNeedPosition()){
                do {
                    positionNumber = ZKlavesnice.readInt("On which position?");
                } while (positionNumber < 1 || positionNumber > 6);
                cards.get(cardNumber-1).setUsedOnPosition(positionNumber);
            }

            played=cards.get(cardNumber-1).activate(lake);
        }
        tossCard(actionCards,cards.get(cardNumber-1));
    }
    public String getName() {
        return name;
    }
    public Cards getCard(int position){
        return cards.get(position);
    }
    public void decrementLives(){
        this.lives--;
    }
    public int getLives(){
        return lives;
    }



}
