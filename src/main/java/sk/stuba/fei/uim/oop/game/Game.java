package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.decks.*;
import sk.stuba.fei.uim.oop.decks.cards.*;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tile.*;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;
import java.util.List;
import java.util.*;

import static sk.stuba.fei.uim.oop.game.Colors.*;


public class Game {
    private Player[] players;
    private int currentPlayer;
    private DeckOfActionCards actionCards;
    private DeckOfLake lake;

    public Game() {
        this.currentPlayer=0;
        int numberPlayers;
        do {
            numberPlayers = KeyboardInput.readInt("Input number of players (2-6)");
        }while(numberPlayers>6||numberPlayers<2);
        this.players=new Player[numberPlayers];
        for (int i=0; i<numberPlayers; i++){
            this.players[i]=new Player(KeyboardInput.readString("Enter name of player number "+ (i+1)));
        }
        new Duck(players[1]);
        initializeLake();
        initializeActionCards();
        startGame();
    }

    private void startGame(){
        initializePlayersCards();
        while(getNumberOfActive()>1){
            if(!players[currentPlayer].isActive()){
                currentPlayer++;
                if(currentPlayer>=players.length){currentPlayer=0;}
                continue;
            }
            System.out.println(WHITE_BACKGROUND_BRIGHT+BLACK_BOLD+"---------------ROUND--------------"+ANSI_RESET);
            printLake();
            printPlayersCards();
            if(!canPlaySomeCard()){
                int index;
                do {
                    index = KeyboardInput.readInt(ANSI_RED+"You can´t play any card. Witch card do you want to toss?"+ANSI_RESET);
                }while(index>3 || index<1);
                tossCard(index-1);
                takeCard(currentPlayer);
            }
            else{
                playCard();
            }
            currentPlayer++;
            if(currentPlayer>=players.length){currentPlayer=0;}
        }
        System.out.println(WHITE_BACKGROUND_BRIGHT+BLACK_BOLD+"------------End of game-----------"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Winner is: "+ getWinner().getName()+ANSI_RESET);
    }

    private void takeCard(int number){
        players[number].takeCard(actionCards.drawCard());
    }
    public void tossCard(int position){
        actionCards.tossCard(players[currentPlayer].getCard(position));
        players[currentPlayer].tossCard(position);
    }

    public void playCard(){
        int cardNumber;
        int positionNumber;
        while(true){
            do {
                cardNumber= KeyboardInput.readInt("Which card do you want to play?")-1;
            } while (cardNumber<0||cardNumber>2);

            if( players[currentPlayer].getCard(cardNumber).getNeedPosition()){
                do {
                    positionNumber = KeyboardInput.readInt("On which position?");
                } while (positionNumber < 1 || positionNumber > 6);
                players[currentPlayer].getCard(cardNumber).setUsedOnPosition(positionNumber);
            }
            updateLake(players[currentPlayer].getCard(cardNumber).activate(this.lake));
            if(players[currentPlayer].getCard(cardNumber).getPlayed()){
              break;
            }
        }
        if(players[currentPlayer].getCard(cardNumber) instanceof Shoot || players[currentPlayer].getCard(cardNumber) instanceof WildBill ){
            for( int i =0; i<players.length; i++){
                if(!players[i].isActive() && !players[i].getAllCards().isEmpty()){
                    actionCards=players[i].tossAllCards(actionCards);
                }
            }
        }
        if(players[currentPlayer].isActive()){
            tossCard(cardNumber);
            takeCard(currentPlayer);
        }

    }
    private boolean canPlaySomeCard(){
        List<String>list=new ArrayList<>(3);
        for(int i=0; i<3; i++){
            list.add(i,players[currentPlayer].getCard(i).getName());
        }
        int shoot= Collections.frequency(list, "Shoot");
        int aim= Collections.frequency(list,"Aim");
        if(shoot==3 && lake.getAllAimed()==0){
            return false;
        }
        if(aim==3 && lake.getAllAimed()==6){
            return false;
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
        lake=new DeckOfLake(lakeCards);
    }
    private void updateLake(DeckOfLake lake){
        this.lake=lake;
    }
    void initializeActionCards(){
        List <Cards> actionCardsDeck=List.of(
            new Aim("Aim",10,true),
            new Shoot("Shoot",12,true),
            new WildBill("Wild Bill",2,true),
            new TurboDuck("Turbo Duck",1,true),
            new DuckMarch("Duck March",6,false),
            new Scatter("Scatter",2,false),
            new DuckDance("Duck Dance",1,false)
        );
        actionCards=new DeckOfActionCards(actionCardsDeck);
    }
    private void initializePlayersCards(){
        for (int i=0; i<players.length;i++) {
            for (int j = 0; j < 3; j++) {
                takeCard(i);
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
            if(lake.getTile(i) instanceof Water){
                System.out.println((i+1)+". "+BLUE_BRIGHT+ lake.getTile(i).getName()+ (!lake.getAimedList(i)? " ➨ Not aimed":" ➨ Aimed ⌖")+ANSI_RESET);
            }
            else{
                System.out.println((i+1)+". "+YELLOW_BRIGHT+ lake.getTile(i).getName()+ " "+  lake.getTile(i).getOwner().getName()+(!lake.getAimedList(i)? " ➨ Not aimed":" ➨ Aimed ⌖")+ANSI_RESET);
            }
        }
    }
    private void printPlayersCards(){
        System.out.println("----------------------------------");
        System.out.println("PLAYER \uD83D\uDC64 : "+ players[currentPlayer].getName());
        System.out.println("PLAYER LIVES: "+ players[currentPlayer].getLives());
        System.out.println("------------Your Cards------------");
        for(int i=0; i<3; i++){
            System.out.println((i+1)+". "+players[currentPlayer].getCard(i).getName());
        }

    }
    private Player getWinner(){
        for(int i=0; i<this.players.length; i++){
            if(this.players[i].isActive()){
                return this.players[i];
            }
        }
        return null;
    }


}
