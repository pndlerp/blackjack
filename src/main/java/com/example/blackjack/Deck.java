package com.example.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
    List<Card> deck = new ArrayList<>();


    public void randomize(){
        Collections.shuffle(deck);
    }

    public void createDeck() throws Exception {
        for (suits card : suits.values()) {
            for (int i = 0; i < 11; i++) {
                deck.add(new Card(i + 1, card));
            }
        }
    }

    public void startCards(){

    }
}