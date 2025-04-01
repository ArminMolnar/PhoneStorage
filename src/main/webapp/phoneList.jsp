<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page title="Phone List">

<style>
    td {
        border: 1px solid black;
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
                <form method="POST" action="listServlet">
                    <button type="submit" name="action" value="delete">Delete</button>
                    <button type="submit" name="action" value="favorite">Favorite</button>
                    <input type="hidden" name="id" value="${phone.id}"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
</t:page>
