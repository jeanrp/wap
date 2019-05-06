package com.quizservlet.model.states;

import com.quizservlet.model.context.ManageQuiz;

public class ThirdQuestionState extends QuizState {
    public ThirdQuestionState(int points, ManageQuiz manageQuiz) {
        super(points, manageQuiz);
        setAnswer("36");
        setQuestion("1, 4, 9, 16, 25");
    }


    @Override
    public void nextQuestion(int answer)
    {
        checkAnswer(answer);
        getManageQuiz().setCurrentState(new FourthQuestionState(getPoints(),getManageQuiz()));
    }


}
