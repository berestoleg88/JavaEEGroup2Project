<%@ page import="org.example.entities.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: olbe0615
  Date: 19.01.2022
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% List<Student> studentList = (List<Student>) request.getAttribute("studentList");%>
    <% if (studentList != null) {
        for (int i = 0; i < studentList.size(); i++) { %>
        <input type="checkbox" name="students" value="<%= studentList.get(i).getStudentId()%>"/><%= studentList.get(i).getName()%><br/>
    <%  }
      }
    %>

</body>
</html>
