package com.example.blackjack;


public class Card {
    private final int value;
    private final Suits suit;

    public Card(int value, Suits cardSuit) {
        if(value < 1 || value > 11){
            throw new IllegalArgumentException("Неправильне значення карти: " + value + ". Має бути від 1 до 11.");
        }
        this.value = value;
        this.suit = cardSuit;
    }
    public int getValue(){
        return value;
    }

    public Suits getSuit(){
        return suit;
    }
    public String toString(){
       return suit + " " + value;
    }
}