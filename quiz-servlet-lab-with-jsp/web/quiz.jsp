<%@ page import="com.quizservlet.model.context.ManageQuiz" %>
<%@ page import="com.quizservlet.model.states.FinishedState" %>
<%
  ManageQuiz manageQuiz = (ManageQuiz)session.getAttribute("manageQuiz");

  if (manageQuiz == null || manageQuiz.getCurrentState() instanceof FinishedState)
      manageQuiz = new ManageQuiz();

%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>
<body>

<h1>The Number Quiz </h1>
<p>Your current score is <%=manageQuiz.getCurrentState().getPoints()%> </p>
Guess the text number in the sequence
<p> <%=manageQuiz.getCurrentState().getQuestion()%> </p>
<form action='/quiz-servlet' method='post'>
  <p>Your Answer: <input type='text' name='answer' id='answer' size='3' pattern="[0-9]" /></p>
  <p><input type='submit' value='Submit' /></p>
</form>
</body>
</html>
