<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="savePage">Create New</a>

<table>
<thead>
<tr>
<th>Article ID</th>
<th>Article Title</th>
<th>Article Category</th>
<th>Actions</th>
</tr>
</thead>

<c:forEach var="s" items="${list}">
<tbody>
<tr>
<td>${s.a_id}</td>
<td>${s.a_title}</td>
<td>${s.a_category}</td>
<td>
<form action="UpdatePage">
<input type="hidden" name="a_id" value="${s.a_id}">
<input type="submit" value="update">
</form>
</td>

<td>
<form action="delete">
<input type="hidden" name="a_id" value="${s.a_id}">
<input type="submit" value="delete">
</form>
</td>

</tr>
</tbody>

</c:forEach>

</table>
</body>


</html>