<%--
  Created by IntelliJ IDEA.
  User: olbe0615
  Date: 19.01.2022
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% request.getSession(true);%>
    <div>
        <form name="userName" action="/JavaEEGroup2Project/dispatcher?action=mainPage" method="post">
            Name: <input type="text" name="username" value="" maxlength="20" placeholder="Type your name"/>
            <input type="submit" value="Enter">
        </form>
    </div>
</body>
</html>
