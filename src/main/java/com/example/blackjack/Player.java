package com.example.blackjack;

public class Player extends Hand {

    @Override
    public void takeCards(Deck deck) {
        deck.giveCard(this);
    }
}
