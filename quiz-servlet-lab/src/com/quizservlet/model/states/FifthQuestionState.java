package com.quizservlet.model.states;

import com.quizservlet.model.context.ManageQuiz;

public class FifthQuestionState extends QuizState
{
    public FifthQuestionState(int points, ManageQuiz manageQuiz) {
        super(points, manageQuiz);
        setAnswer("32");
        setQuestion("1, 2, 4, 8, 16");
    }

    @Override
    public void nextQuestion(int answer)
    {
        checkAnswer(answer);
        getManageQuiz().setCurrentState(new FinishedState(getPoints(),getManageQuiz()));

    }
}
