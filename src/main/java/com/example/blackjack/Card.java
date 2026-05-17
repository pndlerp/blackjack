package com.example.blackjack;

enum suits{
    HEARTS,
    DIAMONDS,
    CLUBS,
    SPADES,
}

public class Card {
    private final int value;
    private final suits cardSuit;

    public Card(int value, suits cardSuit) throws Exception {
        if(value < 1 || value > 11){
            throw new Exception("неправильне значення карти!");
        }
        this.value = value;
        this.cardSuit = cardSuit;
    }
    public int getValue(){
        return value;
    }

}