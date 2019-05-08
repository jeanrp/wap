package com.quizservlet.model.context;

import com.quizservlet.model.states.FirstQuestionState;
import com.quizservlet.model.states.QuizState;

public class ManageQuiz {

    QuizState currentState;

    public ManageQuiz() {
        this.currentState = new FirstQuestionState(0, this);
    }

    public void change(int answer) {
        currentState.nextQuestion(answer);
    }

    public QuizState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(QuizState currentState) {
        this.currentState = currentState;
    }

    public int getNumberOfQuestions()
    {
        return 5;
    }
}
