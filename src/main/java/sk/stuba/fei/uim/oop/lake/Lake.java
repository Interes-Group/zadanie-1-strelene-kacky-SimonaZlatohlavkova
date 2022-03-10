package sk.stuba.fei.uim.oop.lake;

import sk.stuba.fei.uim.oop.cards.Cards;
import sk.stuba.fei.uim.oop.tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lake {
    //private List<Tile> lake;
    private List<Tile> deckOfLake;
    private ArrayList<Boolean> aimedList;
    private Random random;

    public Lake(List<Tile> lakeCards){
        this.deckOfLake=new ArrayList<>(lakeCards);
        this.aimedList=new ArrayList<>(6);
        this.aimedList.addAll(Collections.nCopies(6, Boolean.FALSE));
        /*this.lake=new ArrayList<>();
        for(int i=0; i<6; i++){
            lake.add(deckOfLake.get(i));
        }*/
    }
    public void setDeckOfLake(List <Tile> deckOfLake){
        this.deckOfLake=deckOfLake;
    }

    /*public List<Tile> getLake(){
        return lake;
    }*/
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
