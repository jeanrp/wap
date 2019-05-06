package com.quizservlet.model.states;

import com.quizservlet.model.context.ManageQuiz;

public class FirstQuestionState extends QuizState
{
    public FirstQuestionState(int points, ManageQuiz manageQuiz) {
        super(points, manageQuiz);
        setAnswer("9");
        setQuestion("3, 1, 4, 1, 5");
    }

    @Override
    public void nextQuestion(int answer)
    {
        checkAnswer(answer);
        getManageQuiz().setCurrentState(new SecondQuestionState(getPoints(), getManageQuiz()));
    }

}
