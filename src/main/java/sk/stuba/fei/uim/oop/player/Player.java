package sk.stuba.fei.uim.oop.player;



import sk.stuba.fei.uim.oop.deckOfCards.Cards;
import sk.stuba.fei.uim.oop.deckOfCards.DeckOfActionCards;
import sk.stuba.fei.uim.oop.deckOfCards.DeckOfLake;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.List;

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
    public DeckOfActionCards tossAllCards(DeckOfActionCards actionCards){
        if(!this.cards.isEmpty()){
        actionCards.tossCard(cards.get(2));
        actionCards.tossCard(cards.get(1));
        actionCards.tossCard(cards.get(0));
        this.cards.remove(2);
        this.cards.remove(1);
        this.cards.remove(0);
        }
        return actionCards;
    }
    public void setActive(boolean active){
        this.active=active;
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
    public void takeCard(Cards card){
        this.cards.add(card);
    }
    public void tossCard(int position){
        this.cards.remove(position);
    }
    public boolean isActive(){
        return active;
    }



}
