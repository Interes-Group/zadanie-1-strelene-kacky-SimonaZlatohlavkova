package sk.stuba.fei.uim.oop.game;
import sk.stuba.fei.uim.oop.lake.Lake;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tile.*;
import sk.stuba.fei.uim.oop.cards.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.Collection;
import java.util.List;
import java.util.*;

public class Game {
    private Player[] players;
    private int currentPlayer;
    private DeckOfActionCards actionCards;
    private  Lake lake;
    public Game() {
        int numberPlayers;
        do {
            numberPlayers = ZKlavesnice.readInt("Input number of players (2-6)");
        }while(numberPlayers>6||numberPlayers<2);
        this.players=new Player[numberPlayers];
        for (int i=0; i<numberPlayers; i++){
            this.players[i]=new Player(ZKlavesnice.readString("Enter name of player number "+ (i+1)));
        }
        new Duck(players[1]);
        initializeLake();
        initializeActionCards();
        StartGame();
    }

    private void StartGame(){
        initializePlayersCards();
        while(getNumberOfActive()>1){
            printLake();
            printPlayersCards();
            if(!canPlaySomeCard()){
               int index= ZKlavesnice.readInt("You can´t play any card. Witch card do you want to toss?");
               players[currentPlayer].tossCard(actionCards,players[currentPlayer].getCard(index-1));
            }
            else{
                players[currentPlayer].playCard(lake,actionCards);
            }
            players[currentPlayer].takeCard(actionCards);
        }

    }

    private boolean canPlaySomeCard(){
        if(Objects.equals(players[currentPlayer].getCard(0).getName(), "Shoot") && lake.getAllAimed()==0){
            if(Objects.equals(players[currentPlayer].getCard(1).getName(), "Shoot")){
                if(Objects.equals(players[currentPlayer].getCard(2).getName(), "Shoot")){
                 return false;
                }
            }
        }
        if(Objects.equals(players[currentPlayer].getCard(0).getName(), "Aim") && lake.getAllAimed()==6){
            if(Objects.equals(players[currentPlayer].getCard(1).getName(), "Aim")){
                if(Objects.equals(players[currentPlayer].getCard(2).getName(), "Aim")){
                    return false;
                }
            }
        }
        return true;
    }



    private void initializeLake() {
        List<Tile> lakeCards=new ArrayList<Tile>();
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < 5; j++) {
                lakeCards.add(new Duck(players[i]));
            }
        }
        for (int j=0; j<5; j++){
            lakeCards.add(new Water());
        }
        Collections.shuffle(lakeCards);
        lake=new Lake(lakeCards);
    }

    void initializeActionCards(){
    List <Cards> actionCardsDeck=List.of(
        new Aim("Aim",10,true),
        new Shoot("Shoot",12,true),
        new WildBill("Wild Bill",2,true),
        new TurboDuck("Turbo Duck",1,true),
        new DuckMarch("Duck March",6,false),
        new Roshambo("Roshambo",2,false),
        new DuckDance("Duck Dance",1,false)
    );
    actionCards=new DeckOfActionCards(actionCardsDeck);
    }

    private void initializePlayersCards(){
        for (Player player : players) {
            for (int j = 0; j < 3; j++) {
                player.takeCard(actionCards);
            }
        }
    }


    private int getNumberOfActive(){
        int active=0;
        int i=0;
       while (i<players.length){
           if(players[i].isActive()){
               active++;
           }
           i++;
       }
       return active;
    }

    private void printLake(){

        for(int i=0; i<6; i++){
            if(lake.getTile(i).getOwner()==null){
                System.out.println((i+1)+". "+ lake.getTile(i).getName()+ (!lake.getTile(i).getAimed() ? " -> Not aimed":" -> Aimed"));
            }
            else{
                System.out.println((i+1)+". "+ lake.getTile(i).getName()+ " "+  lake.getTile(i).getOwner().getName()+(!lake.getTile(i).getAimed() ? " -> Not aimed":" -> Aimed"));
            }
        }
    }
    private void printPlayersCards(){
        System.out.println("--------------------");
        System.out.println("PLAYER: "+ players[currentPlayer].getName());
        System.out.println("-----Your Cards-----");
        for(int i=0; i<3; i++){
            System.out.println((i+1)+". "+players[currentPlayer].getCard(i).getName());
        }
    }


}
