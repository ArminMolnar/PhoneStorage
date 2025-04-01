
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <meta charset="UTF-8">
    <title>Phone List</title>
</head>
<body>

<style>
    td{
        border:1px solid black;
    }
</style>

<table>
    <thead>
    <tr>
        <td><h2>ID</h2></td>
        <td><h2>Manufacturer</h2></td>
        <td><h2>Type</h2></td>
        <td><h2>IMEI</h2></td>
        <td><h2>Action</h2></td>
    </tr>
    </thead>

    <tbody>
<c:forEach items="${phoneList}" var="phone">
    <tr>
        <td>
            <c:out value="${phone.id}"/>
        </td>
        <td>
            <c:out value="${phone.manufacturer}"/>
        </td>
        <td>
            <c:out value="${phone.type}"/>
        </td>
        <td>
            <c:out value="${phone.imei}"/>
        </td>
        <td>
            <button type="submit">Delete</button>
        </td>
    </tr>
</c:forEach>
    </tbody>
</table>

</body>
</html>
