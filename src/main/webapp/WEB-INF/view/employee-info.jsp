<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 08.08.2022
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h2>Employee Info</h2>
<br>

<form:form action="saveEmployee" modelAttribute="employee">
    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Department <form:input path="department"/>
    <br><br>
    Salary  <form:input path="salary"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>

</body>
</html>
