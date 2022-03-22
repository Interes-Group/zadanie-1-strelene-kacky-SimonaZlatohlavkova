package sk.stuba.fei.uim.oop.decks;

public abstract class Cards{
    protected String name;
    protected int amount;
    protected int usedOnPosition;
    protected boolean needPosition;
    protected boolean played;

    public Cards(String name, int amount,boolean needPosition){
        this.amount=amount;
        this.name=name;
        this.needPosition=needPosition;
        this.played=false;
    }
    public boolean getNeedPosition(){
        return needPosition;
    }
    public void setUsedOnPosition(int number){
        this.usedOnPosition=number-1;
    }
    public  String getName(){
        return this.name;
    }
    public boolean getPlayed(){return played;}
    public abstract DeckOfLake activate(DeckOfLake lake);
}
