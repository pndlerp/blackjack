package com.example.blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
    protected List<Card> cards = new ArrayList<>();
    private int points = 0;


    public void getStartCards(Deck deck){
        cards.add(deck.giveCard());
        cards.add(deck.giveCard());
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
    public String toString(){
        return "current cards: " + cards + "points: " + getPoints();
    }
    public List<Card> getCards(){
        return cards;
    }
}
