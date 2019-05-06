package com.quizservlet.helpers;

public  class StringHelper
{
    public static String quizWholeQuestion(int score, String question)
    {
        return "<h1>The Number Quiz </h1>" +
                "<p>Your current score is "+score+" </p>" +
                "Guess the text number in the sequence" +
                "<p>"+ question +"</p>" +
                "<form action='/quiz-servlet' method='post'>" +
                "<p>Your Answer: <input type='text' name='answer' id='answer' size='3' /></p>" +
                "<p><input type='submit' value='Submit' /></p>" +
                "</form>";
    }

    public static String finalMessage(int score)
    {
        return "<h1>The Number Quiz</h1>" +
                "<p>Your current score is "+ score + "</p>" +
                "<p>You have completed the Number Quiz, with a score of " + score + " out of 5</p>" +
                "<p><a href='/quiz-servlet'>Click here to restart the quiz</a></p>";
    }


}
