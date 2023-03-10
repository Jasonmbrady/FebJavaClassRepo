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
	<div class='container'>
	   <h1><c:out value="${String.format(' %s %s', member.firstName,member.lastName)}" /></h1>
	   <div class = "row">
	   	<form action="/member/${id}/checkout" method="POST" class="col-sm">
	   		<label for="books">Check out a book:</label>
	   		<select name="book" id="books">
	   			<c:forEach var="book" items="${allBooks}">
	   			<c:choose>
	   				<c:when test="${book.member == null}">
	   					<option value="${book.id}"><c:out value="${book.title}"/></option>
	   				</c:when>
	   				<c:when test="${book.member.id == myId}">
	   					<option value="${book.id}" class="text-danger"><c:out value="${book.title}"/> You have this book checked out!</option>
	   				</c:when>
	   				<c:otherwise>
	   					<option value="${book.id}">NONE OF THE ABOVE</option>
	   				</c:otherwise>
	   			</c:choose>
	   				<%-- <c:if test="${book.member == null}">
	   					<option value="${book.id}"><c:out value="${book.title}"/></option>
	   				</c:if> --%>
	   				
	   			</c:forEach>
	   		</select>
	   		<button>Check Out</button>
	   	</form>
	   	<div>
	   		<h2>Books Currently Checked Out</h2>
		   	<ul>
		   		<c:forEach var="book" items="${member.booksCheckedOut}">
		   				<li><c:out value="${book.title}" /> <a href="/book/${book.id}/return" class="btn btn-danger">Return</a></li>
		   		</c:forEach>
		   	</ul>
	   	</div>
	   </div>
	</div>
   
</body>
</html>

