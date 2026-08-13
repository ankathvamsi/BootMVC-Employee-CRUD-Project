<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Employee</title>
</head>
<body>

<h1 style="text-align:center;color:blue">
    Employee Registration Form
</h1>

<frm:form modelAttribute="dvo" method="post">

    <table border="1" style="margin:auto;">

        <tr>
            <td>Employee Name :</td>
            <td>
                <frm:input path="ename"/>
            </td>
        </tr>

        <tr>
            <td>Job :</td>
            <td>
                <frm:input path="job"/>
            </td>
        </tr>

        <tr>
            <td>Salary :</td>
            <td>
                <frm:input path="sal"/>
            </td>
        </tr>

        <tr>
            <td>Department No :</td>
            <td>
                <frm:input path="deptno"/>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Register"/>
                <input type="reset" value="Cancel"/>
            </td>
        </tr>

    </table>

</frm:form>

</body>
</html>

