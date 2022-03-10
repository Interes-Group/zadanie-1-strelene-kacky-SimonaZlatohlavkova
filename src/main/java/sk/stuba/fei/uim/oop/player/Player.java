package sk.stuba.fei.uim.oop.player;



import sk.stuba.fei.uim.oop.deckOfCards.Cards;
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
