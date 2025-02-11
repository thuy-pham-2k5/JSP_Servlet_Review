<%@ page import="com.example.jsp_servlet_review.no_1.service.DepartmentService" %>
<%@ page import="com.example.jsp_servlet_review.no_1.service.DepartmentServiceImpl" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" href="/css/no_1/info_employee.css">
</head>
<body>












































<main>
    <div class="div-parent">
        <div class="title">
            <h2>${param.action == 'view' ? 'Employee Information Details' : 'Update Employee Details'}</h2>
        </div>
        <div class="form-container">
            <form action="/employees?action=${param.action}&id=${employee.idEmployee}" method="post">
                <div class="mb-3">
                    <label for="1" class="form-label">Name</label>
                    <input type="text" name="name" class="form-control"
                           id="1" ${param.action == 'view' ? 'readonly disabled' : ''}
                           value="${employee.name}">
                </div>
                <div class="mb-3">
                    <label for="departmentSelect" class="form-label">Department</label>
                    <c:if test="${param.action == 'edit'}">
                        <select name="department" class="form-select" aria-label="Default select example"
                                id="departmentSelect">
                            <%
                                DepartmentService departmentService = new DepartmentServiceImpl();
                                request.setAttribute("departments", departmentService.getAllDepartment());
                            %>
                            <c:forEach var="department" items="${departments}">
                                <option value="${department.id}" ${employee.department == department.name ? 'selected' : ''}>${department.name}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                    <c:if test="${param.action == 'view'}">
                        <input name="department" type="text" class="form-control" id="departmentSelect" readonly disabled
                               value="${employee.department}">
                    </c:if>
                </div>
                <div class="mb-3">
                    <label for="3" class="form-label">Position</label>
                    <input type="text" name="position" class="form-control"
                           id="3" ${param.action == 'view' ? 'readonly disabled' : ''} value="${employee.position}">
                </div>
                <div class="mb-3">
                    <label for="4" class="form-label">Salary</label>
                    <input type="number" name="salary" class="form-control"
                           id="4" ${param.action == 'view' ? 'readonly disabled' : ''} value="${employee.salary}">
                </div>
                <div class="mb-3">
                    <label for="5" class="form-label">Address</label>
                    <input type="text" name="address" class="form-control"
                           id="5" ${param.action == 'view' ? 'readonly disabled' : ''} value="${employee.address}">
                </div>
                <div class="button-submit">
                    <button type="submit" class="btn btn-primary">${param.action == 'view' ? "Back" : "Update"}</button>
                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>
