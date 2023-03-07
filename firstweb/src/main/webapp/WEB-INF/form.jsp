<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/form" method="POST">
		<div>
			<label>Name:</label>
			<input type="text" name="name">
		</div>
		<div>
			<label>Price:</label>
			<input type="number" name="price" step="0.01">
		</div>
		<button>Submit</button>
	</form>
</body>
</html>