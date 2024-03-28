package org.example;

import java.util.ArrayList;

public class Quiz {
    String name;
    final int price = 40;
    ArrayList<Character> letters = new ArrayList<>();
    ArrayList<Question> questions;
    int currentQuestion;
    boolean finished;

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
        String questionText = questions.get(currentQuestion).text;
        this.currentQuestion += 1;
        return questionText;
    }

    public void processAnswer(String givenAnswer){
        for(Answer actualAnswer : questions.get(currentQuestion-1).getAnswers()){
            if(givenAnswer.equals(actualAnswer.text))
                letters.add(actualAnswer.letter);
            return;
        }
    }

    public int calculateScore(String word){
        IAdapterDictionary adapterDictionary = new ExternalDictionaryAdapter();
        //Check if woord wel die letters bevat en niet andere
        if(adapterDictionary.checkWord(word))
            return word.length();
        return 0;
    }
}
