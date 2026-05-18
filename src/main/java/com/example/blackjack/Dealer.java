package com.example.blackjack;

public class Dealer extends Hand {

    @Override
    public void takeCards(Deck deck) {
        if(getPoints()<17){
            deck.giveCard();
        }
    }
}
