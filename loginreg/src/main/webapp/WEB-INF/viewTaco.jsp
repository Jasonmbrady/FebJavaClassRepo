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
    <title>Tacos RULE</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h1><c:out value="${taco.name}" /></h1>
   <h3>Toppings:</h3>
   <ul>
   	<c:forEach var="topping" items="${taco.toppings}">
   		<li><c:out value="${topping.name}"/> <form action="/taco/${taco.id}/removeTopping" method="POST">
   		<input type="hidden" name="toppingId" value="${topping.id}" />
   		<button>Remove</button>
   		</form></li>
   	</c:forEach>
   </ul>
   	<c:if test="${userId == taco.submittedBy.id}">
	   <form action="/taco/${taco.id}" method="POST">
	   <h3>Something Missing? Add a topping!</h3>
	   	<input type="hidden" name="_method" value="PUT"/>
	   	<select name="toppings" id="toppings">
	   		<c:forEach var="topping" items="${allToppings}">
	   			<c:if test="${!taco.toppings.contains(topping)}">
	   				<option value="${topping.id}"><c:out value="${topping.name}"/></option>
	   			</c:if>
	   		</c:forEach>
	   	</select>
	   	
	   	<button>Submit</button>
	   </form>
   	</c:if>
   <form:form action="/taco/${taco.id}/newComment" method="POST" modelAttribute="comment">
   		<h3>Comment here!</h3>
   		<form:textarea path="text" />
   		<button>Submit</button>
   </form:form>
   <c:forEach var="comment" items="${taco.comments}">
   	<p><c:out value="${comment.text}"/> <a href="/taco/${comment.id}/removeComment" class="btn btn-danger">delete</a></p>
   </c:forEach>
   
</body>
</html>

