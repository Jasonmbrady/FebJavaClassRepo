<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h1>Hello, <c:out value="${user.username}" /></h1>
   <div class="container">
   	<div class="row">   		
	   <p><a href="/logout">logout</a></p>
	   <p><a href="/taco/new">Create a Taco!</a></p>
	   <ul class="col">
	   	<c:forEach var="taco" items="${user.tacosSubmitted}">
	   		<li><a href="/taco/${taco.id}"><c:out value="${taco.name}" /></a></li>
	   	</c:forEach>
	   </ul>
	   <ul class="col">
	   	<c:forEach var="taco" items="${allTacos}">
	   		<c:if test="${taco.submittedBy.id != user.id}">
		   		<li><a href="/taco/${taco.id}"><c:out value="${taco.name}"/></a></li>
	   		</c:if>
	   	</c:forEach>
	   </ul>
   	</div>
   </div>
</body>
</html>

