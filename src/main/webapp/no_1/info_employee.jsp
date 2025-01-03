<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Employee List</title>
</head>
<body>
<main>
    <div>
        <div>
            <h1>${param.action == 'view' ? 'Employee Information Details' : 'Update Employee Details'}</h1>
        </div>
        <div>
            <p>
                <span>Name</span>
                <label>
                    <input type="text" name="name" value="" required
                        ${param.action == 'view' ? 'readonly' : ''}
                    />
                </label>
            </p>
            <p>
                <span>Department</span>
                <label>
                    <input type="text" name="department" value="" required
                           <c:if test="${param.action == 'view'}">readonly</c:if>
                    />
                </label>
            </p>
            <p>
                <span>Position</span>
                <label>
                    <input type="text" name="position" value="" required
                        ${param.action == 'view' ? 'readonly' : ''}
                    />
                </label>
            </p>
            <p>
                <span>Salary</span>
                <label>
                    <input type="number" name="salary" value="" required
                    ${param.action == 'view' ? 'readonly' : ''}
                    />
                </label>
            </p>
            <p>
                <span>Address</span>
                <label>
                    <input type="text" name="address" value="" required
                        ${param.action == 'view' ? 'readonly' : ''}
                    />
                </label>
            </p>
        </div>
        <div>
            <button>${param.action == 'view' ? "Back" : "Update"}</button>
        </div>
    </div>
</main>
</body>
</html>
