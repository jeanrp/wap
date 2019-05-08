package com.quizservlet.model.states;

import com.quizservlet.model.context.ManageQuiz;

public class FourthQuestionState extends QuizState {


    public FourthQuestionState(int points, ManageQuiz manageQuiz) {
        super(points, manageQuiz);
        setAnswer("13");
        setQuestion("2, 3, 5, 7, 9, 11");
        setSequence(4);
    }

    @Override
    public void nextQuestion(int answer)
    {
        checkAnswer(answer);
        getManageQuiz().setCurrentState(new FifthQuestionState(getPoints(), getManageQuiz()));
    }

}
