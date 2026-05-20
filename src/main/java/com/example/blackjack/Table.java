package com.example.blackjack;


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

        player.takeCard(deck.giveCard());
        dealer.takeCard(deck.giveCard());
        player.takeCard(deck.giveCard());
        dealer.setHiddenCard(deck.giveCard());
    }

    public void hitPlayer(){
        this.player.takeCard(deck.giveCard());
    }
    public void hitDealer(){
        if(this.dealer.getPoints()<=16) this.dealer.takeCard(deck.giveCard());
    }

    public String playerCards(){
        return player.toString();
    }
    public String dealerCards(){
        return dealer.toString();
    }
    public Dealer getDealer(){
        return dealer;
    }


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

