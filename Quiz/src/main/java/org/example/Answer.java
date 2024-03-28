package org.example;

import java.util.Random;

public class Answer {
    String text;
    char letter;

    public Answer(String text) {
        this.text = text;
        Random r = new Random();
        this.letter = (char)(r.nextInt(26) + 'a');
    }

    public String getText() {
        return text;
    }

    public char getLetter() {
        return letter;
    }
}
