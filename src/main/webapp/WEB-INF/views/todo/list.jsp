<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2024-10-10
  Time: 오후 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>List Page</h2>
<a href="/todo/register">register</a>
<h2>title:${todoDTO.title}</h2>
<h2>writer:${todoDTO.writer}</h2>
<h2>dueDate:${todoDTO.dueDate}</h2>
<h2>finished:${todoDTO.finished}</h2>
</body>
</html>
