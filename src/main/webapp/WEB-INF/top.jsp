<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items = "${songs}" var = "song">
		<tr>
			<td><a href = "/songs/${song.id}"><c:out value = "${song.name}"/></a></td>
			<td><c:out value = "${song.artist}"/></td>
			<td><c:out value = "${song.rating}"/></td>
			<td><a href = "/delete/${song.id}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
	<a href = "/dashboard">Go back</a>
</body>
</html>