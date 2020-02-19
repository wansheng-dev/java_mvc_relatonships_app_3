<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${question.question}"/></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<a href="/questions">Go to Dashboard</a>
	<p>
		<h1><c:out value="${question.question}"/></h1>	
	</p>
	<p>
		<h3>Tags: |
			<c:forEach items="${question.tags}" var="tag">
				<c:out value="${tag.subject}"/> | 
			</c:forEach>
		</h3>
	</p>
	<p>
	<h3>Answers:</h3>
		<ul>
			<c:forEach items="${question.answers}" var="a">
				<li><c:out value="${a.answer}"/></li> 
			</c:forEach>
		</ul>
	</p>
	<p>
		<h3>Add your answer:</h3>
		<form:form action="/questions/${id}/answer" method="post" modelAttribute="newAnswer">
		    <span style="color: red"><form:errors path="*"/>
		    </span>
		    <p>
		        <form:label path="answer">Answer:</form:label>
		        <form:input path="answer"/>
		    </p>
		    <p>
		        <input type="submit" value="Submit"/>
		    </p>
		</form:form>
	</p>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>	
</body>
</html>