<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.08.2022
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bazadan olingan malumotlar</title>
</head>
<body>
<h2>All Employees</h2>

<table>
    <tr>

        <th>Ismi</th>
        <th>Familiyasi</th>
        <th>Ish joyi</th>
        <th>Oyligi</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="emp" items="${allEmps}">
        <c:url var="updateButton" value="/updateInfo">
        <c:param name="empId" value="${emp.id}"/>

        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>

        </c:url>

        <tr>

            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <input type="submit" value="Update" onclick="window.location.href='${updateButton}'"/>
                <input type="submit" value="Delete" onclick="window.location.href='${deleteButton}'"/>
            </td>

        </tr>

    </c:forEach>
</table>
<br>
<input type="button" value="ADD" onclick="window.location.href='addNewEmployee'">

</body>
</html>
