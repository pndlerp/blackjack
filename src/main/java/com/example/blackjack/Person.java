package com.example.blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    protected List<Card> cards = new ArrayList<>();




    public void takeCard(Card card){
        cards.add(card);
    }




    public int getPoints(){
        int points = 0;
        for(Card i : cards){
            points += i.getValue();
        }
        return points;
    }

    public String toString(){
        return "current cards: " + cards + " points: " + getPoints();
    }
    public List<Card> getCards(){
        return cards;
    }
}
