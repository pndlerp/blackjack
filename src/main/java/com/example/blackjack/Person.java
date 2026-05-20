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
        int aces = 0;
        for(Card i : cards){
            points += i.getValue();
            if(i.getValue() == 11) aces++;
        }
        if(points > 21 && aces != 0) points -= 10;
        return points;
    }

    public String toString(){
        return this.getClass().getSimpleName() + "\ncurrent cards: " + cards + " points: " + getPoints();
    }
    public List<Card> getCards(){
        return cards;
    }
}
