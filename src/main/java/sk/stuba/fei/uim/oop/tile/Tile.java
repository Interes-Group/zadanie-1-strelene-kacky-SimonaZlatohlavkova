package sk.stuba.fei.uim.oop.tile;


import sk.stuba.fei.uim.oop.player.Player;

public class Tile {
    protected String name;
    protected Player owner;
    public String getName(){return this.name;}
    public Player getOwner(){return this.owner;}
}
