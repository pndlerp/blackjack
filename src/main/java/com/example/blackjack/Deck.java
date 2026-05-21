package com.example.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
    final private List<Card> deck = new ArrayList<>();

    public Deck(){
        clearDeck();
        createDeckForBlackjack();
        shuffle();
    }


    public void shuffle(){
        Collections.shuffle(deck);
    }

    public void createDeck() {
        for (Suits card : Suits.values()) {
            for (int i = 2; i <= 14; i++) {
                if(i >= 10 && i < 14){
                    deck.add(new Card(10, card));
                }
                else if(i == 14){
                    deck.add(new Card(11, card));
                }
                else deck.add(new Card(i, card));
            }
        }
    }

    public void createDeckForBlackjack(){
        for(int i=0; i<=6; i++){
            createDeck();
        }
    }

    public int deckSize(){
        return deck.size();
    }

    public Card giveCard(){
        return deck.remove(deck.size()-1);
    }
    public void clearDeck() {
        deck.clear();
    }
}