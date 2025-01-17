<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" href="/no_1/css/home.css">
    <script src="/no_1/js/home.js" defer></script>
</head>
<body>
<main>
<div class="div-parent">
    <div>
        <h1>Employee List</h1>
    </div>
    <div class="div-children">
        <div class="search-add">
            <div class="search">
                <form action="/employees?action=search" method="post">
                    <input type="text" name="keyword" placeholder="Search by name..." />
                    <button type="submit" id="search">Search</button>
                </form>
            </div>
            <div class="add">
                <a href="/employees?action=add"><button type="submit">Add New Employee</button></a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Department</th>
                <th>Position</th>
                <th>Salary</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.idEmployee}</td>
                    <td>${employee.name}</td>
                    <td>${employee.department}</td>
                    <td>${employee.position}</td>
                    <td>${employee.salary} $</td>
                    <td>${employee.address}</td>
                    <td>
                        <a href="/employees?action=view&id=${employee.idEmployee}">
                            <button>View</button>
                        </a>
                        <a href="/employees?action=edit&id=${employee.idEmployee}">
                            <button>Edit</button>
                        </a>
                        <a href="/employees?action=delete&id=${employee.idEmployee}">
                            <button>Delete</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</main>
</body>
</html>