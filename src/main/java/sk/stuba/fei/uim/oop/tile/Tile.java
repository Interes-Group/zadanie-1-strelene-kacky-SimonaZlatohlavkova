package sk.stuba.fei.uim.oop.tile;

import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;

public class Tile extends DeckOfLake {
    protected String name;
    protected boolean aimed;
    protected Player owner;

    public Tile(List<Tile> lakeCards) {
        super(lakeCards);
    }

    public void setAimed(){this.aimed=true;}
    public void setUnaimed(){this.aimed=false;}
    public boolean getAimed(){return this.aimed;}
    public String getName(){return this.name;}
    public Player getOwner(){return this.owner;}
}
