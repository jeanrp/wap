package com.calculator.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "com.calculator.web.CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Calculation Result</title><body>");
        out.print("<form action='calculate' method='post'>");
        String firstNumberSum = request.getParameter("firstNumberSum");
        String secondNumberSum = request.getParameter("secondNumberSum");
        String firstNumberMultiplication = request.getParameter("firstNumberMultiplication");
        String secondNumberMultiplication = request.getParameter("secondNumberMultiplication");
        int firstNumber = 0;
        int secondNumber = 0;
        int result = 0;
        if ((firstNumberSum != null && !firstNumberSum.trim().isEmpty()) && (secondNumberSum != null && !secondNumberSum.trim().isEmpty())) {
            firstNumber = Integer.parseInt(firstNumberSum);
            secondNumber = Integer.parseInt(secondNumberSum);
            result = firstNumber + secondNumber;
            out.print(" <div class='calculate-block'>");
            out.print("<input type='text' value='" + firstNumberSum + "' size='1' pattern='[0-9]'  name='firstNumberSum' id='firstNumberSum'> &nbsp;+&nbsp;" +
                    "  <input type='text' value='" + secondNumberSum + "' size='1' pattern='[0-9]' name='secondNumberSum' id='secondNumberSum'> &nbsp;=&nbsp;" +
                    " <input type='text' value='" + result + "' size='1' name='resultSum' id='resultSum' readonly>");
            out.print("</div>");
            out.print("<br />");
        }

        if ((firstNumberMultiplication != null && !firstNumberMultiplication.trim().isEmpty()) && (secondNumberMultiplication != null && !secondNumberMultiplication.trim().isEmpty())) {
            firstNumber = Integer.parseInt(firstNumberMultiplication);
            secondNumber = Integer.parseInt(secondNumberMultiplication);
            result = firstNumber * secondNumber;
            out.print(" <div class='calculate-block'>");
            out.print("<input type='text' value='" + firstNumberMultiplication + "' size='1' pattern='[0-9]' name='firstNumberMultiplication' id='firstNumberMultiplication'> &nbsp;*&nbsp; " +
                    "<input type='text' value='" + secondNumberMultiplication + "' size='1' pattern='[0-9]' name='secondNumberMultiplication' id='secondNumberMultiplication'> &nbsp;=&nbsp; " +
                    "<input type='text' value='" + result + "' size='1'  name='resultMultiplication' id='resultMultiplication' readonly>");
            out.print("</div>");
        }

        out.print("<br>");
        out.print("<input type='submit' value='Submit'>");
        out.print("</form>");
        out.print("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
