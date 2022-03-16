package sk.stuba.fei.uim.oop.decks;

import sk.stuba.fei.uim.oop.tile.Tile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfLake{
    private List<Tile> deckOfLake;
    private ArrayList<Boolean> aimedList;

    public DeckOfLake(List<Tile> lakeCards){
        this.deckOfLake=new ArrayList<>(lakeCards);
        this.aimedList=new ArrayList<>(6);
        this.aimedList.addAll(Collections.nCopies(6, Boolean.FALSE));
    }
    public void setDeckOfLake(List <Tile> deckOfLake){
        this.deckOfLake=deckOfLake;
    }
    public void setAimedList(int index, boolean aimed){
        aimedList.set(index, aimed);
    }
    public boolean getAimedList(int index){
        return aimedList.get(index);
    }

    public List<Tile> getDeckOfLake(){
        return deckOfLake;
    }
    public Tile getTile(int position){
        return this.deckOfLake.get(position);
    }
    public int getAllAimed(){
        int amount=0;
        for (int i=0; i<6; i++) {
            if (this.aimedList.get(i)) {
                amount++;
            }
        }
        return amount;
    }
}
