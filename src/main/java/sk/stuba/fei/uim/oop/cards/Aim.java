package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.lake.Lake;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Aim extends Cards {
    /*@Override
    public void setAmount(int number){
        this.amount=number;
    };
    @Override
    public  int getAmount(){
        return this.amount;
    };
    @Override
    public  String getName(){
        return this.name;
    };*/
   /* public Aim(String name, int amount){
        this.name=name;
        this.amount=amount;
    }*/

    public Aim(String name,int amount,boolean needPosition){
        super(name, amount,needPosition);
    }
    @Override
    public int activate(Lake lake) {

        if(){
            System.out.println("Can´t play this card on this position.");
            return 0;
        }
        else{
            lake.getTile(usedOnPosition).setAimed();
            return 1;
        }
    }
}
