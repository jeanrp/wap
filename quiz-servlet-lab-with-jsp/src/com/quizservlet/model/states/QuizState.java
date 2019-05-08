package com.quizservlet.model.states;

import com.quizservlet.model.context.ManageQuiz;

public abstract class QuizState
{
    private int points;
    private String question;
    private String answer;
    private ManageQuiz manageQuiz;
    private int sequence;

    public QuizState(int points, ManageQuiz manageQuiz) {
        this.points = points;
        this.manageQuiz = manageQuiz;
    }

    public ManageQuiz getManageQuiz() {
        return manageQuiz;
    }

    public void setManageQuiz(ManageQuiz manageQuiz) {
        this.manageQuiz = manageQuiz;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public abstract void nextQuestion(int answer);

    public void checkAnswer(int answer)
    {
            if (answer == Integer.parseInt(this.getAnswer()))
                points++;
    }

}
