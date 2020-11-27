<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>Edytuj</h1>
    <form:form method="post" action="save">
        <form:hidden path="id" />
        <table >
            <tr>
                <td>Nazwisko : </td>
                <td> <form:input path="nazwisko" /> </td>
            </tr>
            <tr>
                <td>Pensja :</td>
                <td> <form:input path="pensja" /> </td>
            </tr>
            <tr>
                <td>Firma :</td>
                <td> <form:input path="firma" /> </td>
            </tr>
            <tr>
                <td> </td>
                <td> <input type="submit" value="Zapisz" /> </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
