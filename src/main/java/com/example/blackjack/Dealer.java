package com.example.blackjack;

public class Dealer extends Person {
    private Card hiddenCard;

    public void setHiddenCard(Card hiddenCard) {
        this.hiddenCard = hiddenCard;
    }
    public void addHiddenCardToList(){
        getCards().add(hiddenCard);
    }
}
