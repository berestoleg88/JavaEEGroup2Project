<%--
  Created by IntelliJ IDEA.
  User: olbe0615
  Date: 18.01.2022
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="header">
        Hello, <%=request.getSession().getAttribute("username")%> <br/>
        <a href="/JavaEEGroup2Project/dispatcher?action=logOut">Exit</a>
    </div>
    <div id="menu">
        <ul>
            <li><a href="/JavaEEGroup2Project/dispatcher?action=showAllStudents">Students</a></li>
            <li>Teachers</li>
        </ul>
    </div>
    <p>This is template</p>
    <div id="main">
        <% String includedPage = (String) request.getSession().getAttribute("includedPage");
           if (includedPage != null) {
               System.out.println("includedPage != null");
        %>
            <jsp:include page="<%=includedPage%>" />
        <% }
        %>
    </div>
    <div id="footer">
       @Copyright 1988-2022
    </div>
</body>
</html>
