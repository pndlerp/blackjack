package com.example.blackjack;


import java.util.List;

public class Table {
    private Player player;
    private Dealer dealer;
    private Deck deck;

    public Table(){

    }
    public void startNewGame(){
        player = new Player();
        dealer = new Dealer();
        deck = new Deck();


        dealer.setHiddenCard(deck.giveCard());
    }

    public void hitPlayer(){
        player.takeCard(deck.giveCard());
    }
    public void hitDealer(){
        if(dealer.getPoints()<=16) dealer.takeCard(deck.giveCard());
    }

    public Card getPlayerCard(int index){
        return player.getCard(index);
    }
    public Card getDealerCard(int index){
        return dealer.getCard(index);
    }
    public Dealer getDealer(){
        return dealer;
    }
    public Player getPlayer() { return player; }


    public boolean ifCanContinue(){
        int pCount = player.getPoints();
        return pCount < 21;
    }

    public GameResult checkWinCondition(){
        int pCount = player.getPoints();
        int dCount = dealer.getPoints();
        if(pCount == dCount && pCount < 22) return GameResult.DRAW;
        if((pCount > dCount && pCount <= 21) || (dCount > 21 && pCount <= 21)){
            return GameResult.PLAYER_WIN;
        }
        return GameResult.DEALER_WIN;
    }

    public String toString(){
        return player + "\n" + dealer;
    }




}

