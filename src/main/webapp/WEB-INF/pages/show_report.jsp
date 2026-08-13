<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Report</title>

<style>
    table {
        border-collapse: collapse;
        width: 80%;
        margin: auto;
    }

    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: center;
    }

    th {
        background-color: lightgray;
    }

    h1 {
        text-align: center;
    }
</style>

</head>
<body>

<h1>Employee Report</h1>

<c:choose>
    <c:when test="${!empty listVO}">
        <table>
            <tr>
                <th>Employee Id</th>
                <th>Employee Name</th>
                <th>Job</th>
                <th>Salary</th>
                <th>Department No</th>
                <th>Operations</th>
            </tr>

            <c:forEach var="emp" items="${listVO}">
                <tr>
                    <td>${emp.empId}</td>
                    <td>${emp.ename}</td>
                    <td>${emp.job}</td>
                    <td>${emp.sal}</td>
                    <td>${emp.deptno}</td>
                    <td>
                    	<a href="edit?id=${emp.empId}"> <img alt="imgNotFound" src="images/edit.jpg" style="width: 20px; height: 30px;"/> </a>
                    	<a href="delete?id=${emp.empId}"; 
                    		onclick="return confirm('Are you sure you want to delete Employee ID ${emp.empId}?');">
                    		<img alt="imgNotFound" src="images/delete.jpg" style="width: 20px; height: 30px;"/>
                    	</a>
                    	
                    </td>
                </tr>
            </c:forEach>

        </table>
    </c:when>

    <c:otherwise>
        <h2 style="text-align:center;color:red">
            No Employees Found
        </h2>
    </c:otherwise>
</c:choose>
<br><br>
<h1 style="text-align:center; color: green;">${resultMsg}</h1>
<br><br>

<h3> <a href="add">Add Employee <img alt="img not found" src="images/add.jpg" style="height:60px; width:50px"/> </a> </h3>

<h1> <a href="./">Home Page <img alt="imgNotFound" src="images/home.jpg"></a> </h1>
</body>
</html>