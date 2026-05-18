package com.example.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
    List<Card> deck = new ArrayList<>();

    public Deck(){
        createDeck();
        randomize();
    }


    public void randomize(){
        Collections.shuffle(deck);
    }

    public void createDeck() {
        for (Suits card : Suits.values()) {
            for (int i = 0; i < 11; i++) {
                deck.add(new Card(i + 1, card));
            }
        }
    }

    public Card giveCard(){
        return deck.remove(0);
    }
    public void newDeck() {
        deck.clear();
        createDeck();
    }
}