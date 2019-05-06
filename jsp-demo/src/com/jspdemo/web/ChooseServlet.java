package com.jspdemo.web;

import com.jspdemo.model.RadioState;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ChooseServlet")
public class ChooseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String attrName = "radioJSPCool";
        String choice = request.getParameter(attrName);

        saveChoice(choice, attrName, session);

        attrName = "JSFwayCool";
        String choice2 = request.getParameter(attrName);

        saveChoice(choice2, attrName, session);

        attrName = "moonCheese";
        String choice3 = request.getParameter(attrName);

        saveChoice(choice3, attrName, session);

        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }

    private void saveChoice(String choice, String name, HttpSession session) {
        RadioState radioState = new RadioState();
        if (choice != null) {
            switch (choice) {
                case "0":
                    radioState.setNoCheck("checked");
                    radioState.setYesCheck("");
                    break;
                case "1":
                    radioState.setNoCheck("");
                    radioState.setYesCheck("checked");
                    break;
            }
        } else {
            radioState.setNoCheck("");
            radioState.setYesCheck("");
        }

        session.setAttribute(name, radioState);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("radio1", new RadioState());
        session.setAttribute("radio2", new RadioState());
        session.setAttribute("radio3", new RadioState());
        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);

    }
}
