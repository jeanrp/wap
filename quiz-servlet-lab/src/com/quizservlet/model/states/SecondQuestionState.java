package com.quizservlet.model.states;

import com.quizservlet.model.context.ManageQuiz;

public class SecondQuestionState extends QuizState
{

    public SecondQuestionState(int points, ManageQuiz manageQuiz) {
        super(points, manageQuiz);
        setAnswer("8");
        setQuestion("1, 1, 2, 3, 5");
    }

    @Override
    public void nextQuestion(int answer)
    {
        checkAnswer(answer);
        getManageQuiz().setCurrentState(new ThirdQuestionState(getPoints(),getManageQuiz()));
    }


}
