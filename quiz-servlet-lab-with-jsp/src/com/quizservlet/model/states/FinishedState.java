package com.quizservlet.model.states;

import com.quizservlet.model.context.ManageQuiz;

public class FinishedState extends QuizState
{


    public FinishedState(int points, ManageQuiz manageQuiz) {
        super(points, manageQuiz);
    }

    @Override
    public void nextQuestion(int answer)
    {
        checkAnswer(answer);
        getManageQuiz().setCurrentState(new FinishedState(getPoints(), getManageQuiz()));
    }


}
