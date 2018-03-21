<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Song</title>
</head>
<body>
	<p>Song name: <c:out value = "${song.name}"/></p>
	<p>Artist: <c:out value = "${song.artist}"/></p>
	<p>Rating: <c:out value = "${song.rating}"/></p>
	<a href = "/dashboard">Go back</a>
</body>
</html>