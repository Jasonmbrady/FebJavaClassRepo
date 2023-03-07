<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="style.css">
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="app.js"></script>
</head>
<body>
	<div class="container">

		<h1>Hello, World!</h1>
		<table class="table table-striped border">
			<thead>
				<tr>
					<td>Fruit</td>
					<td>Price</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${fruitList}" var="fruit">
					<tr>
						<td><c:out value="${fruit}" /></td>
						<td><c:out value="${priceList.get(fruitList.indexOf(fruit))}" /></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		
	</div>
</body>
</html>