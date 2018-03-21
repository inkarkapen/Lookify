<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
	<a href = "/new">Add new</a>
	<a href = "/topSongs">Top Songs</a>
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
	<form action="/search" method = "POST">
      	<input type="text" placeholder="earch by artist" name="search">
      	<button type="submit"><i class="fa fa-search"></i></button>
    	</form>
</body>
</html>