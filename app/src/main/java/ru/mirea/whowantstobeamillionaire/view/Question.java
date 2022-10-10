package ru.mirea.whowantstobeamillionaire.view;

import java.util.List;

public class Question {
    private String question;
    private List<String> wrongAnswers;
    private String rightAnswer;
    private int difficulty;

    public Question(String question, String rightAnswer, List<String> wrongAnswers, int difficulty) {
        this.question = question;
        this.wrongAnswers = wrongAnswers;
        this.rightAnswer = rightAnswer;
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getWrongAnswers() {
        return wrongAnswers;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
