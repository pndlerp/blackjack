package com.example.blackjack;

public class Player extends Hand {

    @Override
    public void takeCards(Deck deck) {
        cards.add(deck.giveCard());
    }
}
