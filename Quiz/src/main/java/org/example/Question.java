package org.example;

import java.util.ArrayList;

public abstract class Question {
    private String text;
    private Category category;

    public Question(String text, Category category) {
        this.text = text;
        this.category = category;
    }

    public abstract ArrayList<Answer> getAnswers();

    public String getText() {
        return text;
    }
}
