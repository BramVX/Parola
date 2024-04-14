package org.example;

import org.example.questionTypes.MultipleChoice;
import org.example.questionTypes.Open;
import org.example.scoreStrategy.ScoreWithTime;

import java.util.ArrayList;
import java.util.Random;

public class ParolaController {
    private String taal = "NL";
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Quiz> quizzes = new ArrayList<>();

    public static ParolaController getInstance() {
        Player marco = new Player("Marco", "Barion");
        Player benjamin = new Player("Benjamin", "Van den Tillaart");
        players.add(marco);
        players.add(benjamin);

        Quiz quiz1 = new Quiz("Kaboom");
        Quiz quiz2 = new Quiz("Baboom");
        ArrayList<Question> questions1 = new ArrayList<>();
        Category musicCategory = new Category("Music");
        Category geographyCategory = new Category("Geography");
        questions1.add(new MultipleChoice("Who made the song I'm Blue",
                musicCategory,
                new Answer("Eiffel 61"),
                new Answer("Eiffel 69"),
                new Answer("Eiffel 68"),
                new Answer("Eiffel 65"),
                new Answer("Eiffel 65")));
        questions1.add(new MultipleChoice("What city do the Backstreet Boys originate from?",
                musicCategory,
                new Answer("Orlando, Florida"),
                new Answer("Nebraska, Alaska"),
                new Answer("London, UK"),
                new Answer("Dublin, Ireland"),
                new Answer("Orlando, Florida")));
        questions1.add(new MultipleChoice("How many members does the Korean boyband BTS have?",
                musicCategory,
                new Answer("7"),
                new Answer("4"),
                new Answer("6"),
                new Answer("8"),
                new Answer("7")));
        questions1.add(new MultipleChoice("In Europe, which country has the worst english speakers?",
                geographyCategory,
                new Answer("Bulgaria"),
                new Answer("Belarus"),
                new Answer("Italy"),
                new Answer("Lithuania"),
                new Answer("Italy")));
        questions1.add(new Open("What country is surrounded by Italy?",
                geographyCategory,
                new Answer("Vatican"),
                new Answer("Vatican City"),
                new Answer("vatican city"),
                new Answer("Vatican city")));
        quiz1.setQuestions(questions1);
        quizzes.add(quiz1);
        quizzes.add(quiz2);

        ArrayList<String> gameHistory = new ArrayList<>();
        gameHistory.add("Baboom");
        benjamin.setGameHistory(gameHistory);

        return new ParolaController();
    }

    public Player getPlayer(String name){
        for(Player player : players){
            if(player.getName().equals(name))
                return player;
        }
        return null;
    }

    public void startQuiz(String name){
        Player currentPlayer = getPlayer(name);

        Arraylist<String> gameHistory = currentPlayer.getGameHistory();

        Quiz quiz = selectQuiz(gameHistory);

        int balance = currentPlayer.getBalance();

        if(balance >= quiz.price)
            currentPlayer.payForQuiz(quiz.price);
        else return;

        currentPlayer.setCurrentQuiz(quiz);

        if(name == "Benjamin"){
            ScoreWithTime scoreStrategy = new ScoreWithTime();
            Timer timer = new Timer();
            scoreStrategy.setTimer(timer);
            timer.startTimer();
            quiz.setTimer(timer);
            quiz.setScoreStrategy(scoreStrategy);
        }

        quiz.startQuiz();
    }

    public String nextQuestion(String name){
        Player currentPlayer = getPlayer(name);
        return currentPlayer.getCurrentQuiz().nextQuestion();
    }

    public Quiz selectQuiz(ArrayList<String> history){
        for(Quiz quiz : quizzes){
            if(!history.contains(quiz.getName()))
                return quiz;
        }
        Random r = new Random();
        return quizzes.get(r.nextInt(quizzes.size()));
    }

    public void processAnswer(String name, String answer){
        Player currentPlayer = getPlayer(name);
        Quiz quiz = currentPlayer.getCurrentQuiz();
        quiz.processAnswer(answer);
    }

    public boolean quizFinished(String name){
        Player player = getPlayer(name);
        return player.getCurrentQuiz().isFinished();
    }

    public String getLettersForRightAnswers(String name){
        Player player = getPlayer(name);
        String letters = "";
        for(char c : player.getCurrentQuiz().getLetters()){
            letters += c;
        }
        return letters;
    }

    public int calculateScore(String name, String word){
        Player player = getPlayer(name);
        return player.getCurrentQuiz().calculateScore(word);
    }
}
