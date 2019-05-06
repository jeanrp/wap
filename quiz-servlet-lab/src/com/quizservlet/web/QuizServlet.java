package com.quizservlet.web;

import com.quizservlet.helpers.StringHelper;
import com.quizservlet.model.context.ManageQuiz;
import com.quizservlet.model.states.FinishedState;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer = request.getParameter("answer");
        HttpSession session = request.getSession();

        ManageQuiz manageQuiz = (ManageQuiz) session.getAttribute("manageQuiz");
        manageQuiz.change(Integer.parseInt(answer));

        setSession(session, manageQuiz);

        PrintWriter out = response.getWriter();

        if (manageQuiz.getCurrentState() instanceof FinishedState){
            out.print(StringHelper.finalMessage(manageQuiz.getCurrentState().getPoints()));
            session.setAttribute("manageQuiz", new ManageQuiz());
        }else {
            out.print(StringHelper.quizWholeQuestion(manageQuiz.getCurrentState().getPoints(), manageQuiz.getCurrentState().getQuestion()));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer = request.getParameter("answer");
        HttpSession session = request.getSession();

        ManageQuiz manageQuiz = new ManageQuiz();
        setSession(session, manageQuiz);

        PrintWriter out = response.getWriter();

        out.print(StringHelper.quizWholeQuestion(manageQuiz.getCurrentState().getPoints(), manageQuiz.getCurrentState().getQuestion()));
    }

    public void setSession(HttpSession session, ManageQuiz manageQuiz) {
        session.setAttribute("manageQuiz", manageQuiz);
    }
}
