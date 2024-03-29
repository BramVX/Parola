package org.example;

import java.util.ArrayList;

public class Player {
    private String name;
    private String password;
    private int balance;
    private ArrayList<String> gameHistory;
    private Quiz currentQuiz;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setGameHistory(ArrayList<String> gameHistory) {
        this.gameHistory = gameHistory;
    }

    public Quiz getCurrentQuiz() {
        return currentQuiz;
    }

    public void setCurrentQuiz(Quiz currentQuiz) {
        this.currentQuiz = currentQuiz;
    }
}
