package org.example.questionTypes;

import org.example.Answer;
import org.example.Category;
import org.example.Question;

import java.util.ArrayList;

public class MultipleChoice extends Question {
    Answer option1;
    Answer option2;
    Answer option3;
    Answer option4;
    Answer answer1;
    Answer answer2;

    public MultipleChoice(String text, Category category, Answer option1, Answer option2, Answer option3, Answer option4, Answer answer1) {
        super(text, category);
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer1 = answer1;
    }
    public MultipleChoice(String text, Category category, Answer option1, Answer option2, Answer option3, Answer option4, Answer answer1, Answer answer2) {
        super(text, category);
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer1 = answer1;
        this.answer2 = answer2;
    }

    @Override
    public ArrayList<Answer> getAnswers() {
        ArrayList<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);
        return answers;
    }

    public ArrayList<Answer> getOptions(){
        ArrayList<Answer> options = new ArrayList<>();
        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);
        return options;
    }
}
