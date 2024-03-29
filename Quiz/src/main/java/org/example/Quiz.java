package org.example;

import org.example.dictionary.ExternalDictionaryAdapter;
import org.example.dictionary.IAdapterDictionary;
import org.example.questionTypes.MultipleChoice;
import org.example.scoreStrategy.ScoreStrategy;

import java.util.ArrayList;

public class Quiz {
    private String name;
    final int price = 40;
    private ArrayList<Character> letters = new ArrayList<>();
    private ArrayList<Question> questions;
    private int currentQuestion;
    private boolean finished;
    private ScoreStrategy scoreStrategy;
    private Timer timer;

    public Quiz(String name) {
        this.name = name;
    }

    public void startQuiz(){
        this.finished = false;
        this.currentQuestion = 0;
    }

    public String nextQuestion(){
        if(currentQuestion == questions.size()-1){
            this.finished = true;
        }
        Question question = questions.get(currentQuestion);
        if(question instanceof MultipleChoice){
            System.out.println("For the following question you can choose from these options.");
            for(Answer option : ((MultipleChoice) question).getOptions()){
                System.out.println(option.getText());
            }
        }
        this.currentQuestion += 1;
        return question.getText();
    }

    public void processAnswer(String givenAnswer){
        for(Answer actualAnswer : questions.get(currentQuestion-1).getAnswers()){
            if(givenAnswer.equals(actualAnswer.getText()))
                letters.add(actualAnswer.getLetter());
            return;
        }
    }


    public int calculateScore(String word){
        this.timer.stopTimer();
        IAdapterDictionary adapterDictionary = new ExternalDictionaryAdapter();
        for(char c : word.toCharArray()){
            if(!letters.contains(c))
                return scoreStrategy.calculateScore(0, letters.size());
        }
        if(adapterDictionary.checkWord(word))
            return scoreStrategy.calculateScore(word.length(), letters.size());
        return scoreStrategy.calculateScore(0, letters.size());
    }

    public void setScoreStrategy(ScoreStrategy scoreStrategy) {
        this.scoreStrategy = scoreStrategy;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Character> getLetters() {
        return letters;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public boolean isFinished() {
        return finished;
    }
}
