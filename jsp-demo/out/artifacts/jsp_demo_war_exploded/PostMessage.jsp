
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> Introduction to JSP demo – postback page </title>
</head>
<body>
<%! int count = 0; %>
The count is now:
<%= ++count %>

<% count = count * 10; %>
The count is now:
<%= count %>
<p>This is the postback message</p>
</body>
</html>