package com.example.blackjack;

import java.util.Scanner;

public class UserInterface {
    Table table;
    Scanner scanner;

    public UserInterface(Table table, Scanner scanner){
        this.table = table;
        this.scanner = scanner;
    }

    public void startGame(){
        table.startNewGame();
        System.out.println(table);
        System.out.println("1. hit \n2.stand");
        int output = Integer.valueOf(scanner.nextLine());
        if(output == 1){
            System.out.println("player hit!");
            table.hitPlayer();
            System.out.println(table.playerCards());
        }
        System.out.println("dealer hit!");
        table.hitDealer();
        System.out.println(table.dealerCards());
        System.out.println(table.checkWinCondition().getClass() + " wins!");

    }
}
