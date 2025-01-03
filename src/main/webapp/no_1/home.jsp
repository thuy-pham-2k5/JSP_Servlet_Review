<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" href="/css/no_1/home.css">
</head>
<body>
<main>
    <div class="div-parent">
        <div>
            <h1>Employee List</h1>
        </div>
        <div class="div-list-employee">
            <table>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Department</th>
                    <th>Position</th>
                    <th>Salary</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td>${employee.idEmployee}</td>
                        <td>${employee.name}</td>
                        <td>${employee.department}</td>
                        <td>${employee.position}</td>
                        <td>${employee.salary} $</td>
                        <td>${employee.address}</td>
                        <td>
                            <a href="/employees?action=view&id=${employee.idEmployee}"><button>View</button></a>
                            <a href="/employees?action=edit&id=${employee.idEmployee}"><button>Edit</button></a>
                            <a href="/employees?action=delete&id=${employee.idEmployee}"><button>Delete</button></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</main>
</body>
</html>