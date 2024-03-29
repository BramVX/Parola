package org.example;

import org.example.questionTypes.MultipleChoice;

import java.util.ArrayList;

public class Quiz {
    String name;
    final int price = 40;
    ArrayList<Character> letters = new ArrayList<>();
    ArrayList<Question> questions;
    int currentQuestion;
    boolean finished;
    ScoreStrategy scoreStrategy;
    Timer timer;

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
                System.out.println(option.text);
            }
        }
        this.currentQuestion += 1;
        return question.text;
    }

    public void processAnswer(String givenAnswer){
        for(Answer actualAnswer : questions.get(currentQuestion-1).getAnswers()){
            if(givenAnswer.equals(actualAnswer.text))
                letters.add(actualAnswer.letter);
            return;
        }
    }


    public int calculateScore(String word){
        this.timer.stopTimer();
        IAdapterDictionary adapterDictionary = new ExternalDictionaryAdapter();
        for(char c : word.toCharArray()){
            if(!letters.contains(c))
                return scoreStrategy.calculateScore(0);
        }
        if(adapterDictionary.checkWord(word))
            return scoreStrategy.calculateScore(word.length());
        return scoreStrategy.calculateScore(0);
    }

    public void setScoreStrategy(ScoreStrategy scoreStrategy) {
        this.scoreStrategy = scoreStrategy;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
