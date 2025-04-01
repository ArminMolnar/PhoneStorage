<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag dynamic-attributes="params" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <meta charset="UTF-8">
    <title>"${params.get("title")}"</title>
</head>

<body>
<h1>Welcome here!</h1>
<div>
    <a href="${pageContext.request.contextPath}/listServlet">List</a>
</div>
<div>
    <a href="${pageContext.request.contextPath}//addPhone">Add</a>
</div>
<div>
    <jsp:doBody/>
</div>
</body>
</html>
