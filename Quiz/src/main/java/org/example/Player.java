package org.example;

import java.util.ArrayList;

public class Player {
    String name;
    String password;
    int balance;
    ArrayList<String> gameHistory;
    Quiz currentQuiz;

    public Player(String name, String password) {
        this.name = name;
        this.password = password;
        this.balance = 1000;
        gameHistory = new ArrayList<>();
    }

    public void payForQuiz(int price){
        this.balance -= price;
    }

    public ArrayList<String> getGameHistory(){
        return this.gameHistory;
    }
}
