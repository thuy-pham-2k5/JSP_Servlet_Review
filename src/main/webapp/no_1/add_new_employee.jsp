<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add New Employee</title>
</head>
<body>
<c:if test="${param.action == 'view'}">
    <option selected value="" disabled hidden>Choose a department</option>
</c:if>
</body>
</html>
