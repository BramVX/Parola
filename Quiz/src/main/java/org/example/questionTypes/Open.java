package org.example.questionTypes;

import org.example.Answer;
import org.example.Category;
import org.example.Question;

import java.util.ArrayList;

public class Open extends Question {
    private Answer answer1;
    private Answer answer2;
    private Answer answer3;
    private Answer answer4;

    public Open(String text, Category category, Answer answer1, Answer answer2, Answer answer3, Answer answer4) {
        super(text, category);
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    @Override
    public ArrayList<Answer> getAnswers() {
        ArrayList<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        return answers;
    }
}
