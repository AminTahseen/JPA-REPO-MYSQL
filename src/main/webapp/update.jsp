<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Update Article</h3>

<form action="update">

<table>
<tr>
<td>Article ID</td>
<td><input type="text" name="a_id" value="${aid}" readonly="readonly"></td>
</tr>

<tr>
<td>Article Title</td>
<td><input type="text" name="a_title" value="${atitle}"></td>
</tr>

<tr>
<td>Article Category</td>
<td><input type="text" name="a_catg" value="${acatg}"></td>
</tr>

<tr>
<td><input type="submit" value="save"></td>
</tr>

</table>

</form>
</body>
</html>