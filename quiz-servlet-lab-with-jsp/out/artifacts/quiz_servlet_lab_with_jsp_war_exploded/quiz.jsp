<%@ page import="com.quizservlet.model.context.ManageQuiz" %>
<%@ page import="com.quizservlet.model.states.FinishedState" %>
<%
    ManageQuiz manageQuiz = (ManageQuiz) session.getAttribute("manageQuiz");

    if (manageQuiz == null || manageQuiz.getCurrentState().getSequence() == 6)
        manageQuiz = new ManageQuiz();
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
    >
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="css/quiz.css">
</head>
<body>

<h1>The Number Quiz </h1>

<% if (request.getAttribute("formatErrorMessage") != null)
{%>
<p class="error-message"><%= request.getAttribute("formatErrorMessage")%>
</p>
<%
} else if (request.getAttribute("intervalErrorMessage") != null)
{
%>
<p class="error-message"><%= request.getAttribute("intervalErrorMessage")%>
</p>
<%}%>

<form action='/quiz-servlet' method='post'>
    <p class="form-age">
        <label for="age">Type your Age: </label>
        <input type="text" name="age" id="age" value="${ageValue}" size="2">
    </p>


    <div id="quiz-block">
        <table>
            <tbody>
            <tr>
                <% for (int i = 1; i <= manageQuiz.getNumberOfQuestions(); i++)
                {
                    if (manageQuiz.getCurrentState().getSequence() == i)
                    {
                %>
                <td class="active"><%=i%>
                </td>
                <%
                } else
                {
                %>
                <td><%=i%>
                </td>
                <%
                        }
                    }
                %>
            </tr>
            </tbody>
        </table>

        <p>Your current score is <%=manageQuiz.getCurrentState().getPoints()%>
        </p>
        Guess the text number in the sequence
        <p><%=manageQuiz.getCurrentState().getQuestion()%>
        </p>
        <p>Your Answer: <input type='text' name='answer' id='answer' size='3' pattern="[0-9]"/></p>

        <%
            if (manageQuiz.getCurrentState().getSequence() != 5)
            {
        %>
        <p><input type='submit' class="button" value='Next'/></p>
        <% } else
        { %>
        <p><input type="submit" class="button" value="Finish"/></p>
        <%}%>
    </div>
</form>
</body>
</html>
