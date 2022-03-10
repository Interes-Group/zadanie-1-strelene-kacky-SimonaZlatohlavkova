package sk.stuba.fei.uim.oop.tile;

import sk.stuba.fei.uim.oop.player.Player;

public class Duck extends Tile{

    public Duck(Player owner){
        this.aimed=false;
        this.owner=owner;
        this.name="Duck";
    }



}
