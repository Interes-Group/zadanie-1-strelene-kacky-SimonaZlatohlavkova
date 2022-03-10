package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.lake.Lake;

public abstract class Cards {
    protected String name;
    protected int amount;
    protected int tossedAmount;
    protected int usedOnPosition;
    protected boolean needPosition;
   // protected abstract void setName();
   /* public abstract void setAmount(int number);
    public abstract int getAmount();
    public abstract String getName();*/

    public Cards(String name, int amount,boolean needPosition){
        this.tossedAmount=0;
        this.name=name;
        this.amount=amount;
        this.needPosition=needPosition;
    }
    public boolean getNeedPosition(){
        return needPosition;
    }
    public void setAmount(int number){
        this.amount=number;
    };
    public void setUsedOnPosition(int number){
        this.usedOnPosition=number-1;
    };
    public  int getUsedOnPosition(){
        return this.usedOnPosition;
    };
    public void incrementTossedAmount(){
        this.tossedAmount++;
    };
    public void nullTossedAmount(){
        this.tossedAmount=0;
    };
    public  int getAmount(){
        return this.amount;
    };
    public  String getName(){
        return this.name;
    }
    public abstract int activate(Lake lake);
}
