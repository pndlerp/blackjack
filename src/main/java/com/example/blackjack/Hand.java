package com.example.blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
    private List<Card> cards = new ArrayList<>();
    private int points = 0;


    public void getStartCards(Deck deck){
        deck.giveCard(this);
        deck.giveCard(this);
        countPoints();
    }
    public abstract void takeCards(Deck deck);


    public void countPoints(){
        for(Card i : cards){
            points += i.getValue();
        }
    }
    public int getPoints(){
        return points;
    }
}
