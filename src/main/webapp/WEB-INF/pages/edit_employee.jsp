<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<html>
<head>
    <title>Employee Form</title>
</head>
<body>
    <h2>Employee Details Form</h2>

    <frm:form method="post" modelAttribute="dvo" >
        <table>
            <tr>
                <td>Employee Number:</td>
                <td><frm:input path="empId" readonly="true" /></td>
            </tr>
            <tr>
                <td>Employee Name:</td>
                <td><frm:input path="ename" /></td>
            </tr>
            <tr>
                <td>Job:</td>
                <td><frm:input path="job" /></td>
            </tr>
            <tr>
                <td>Salary:</td>
                <td><frm:input path="sal" /></td>
            </tr>
            <tr>
                <td>Department Number:</td>
                <td><frm:input path="deptno" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update"/>
                    <input type="reset" value="Cancle">
                </td>
            </tr>
        </table>
    </frm:form>
</body>
</html>
