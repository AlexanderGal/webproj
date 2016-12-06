<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${title}</title>
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" >
		<div class="container" style="display:flex;align-items:center;">
			<div class="navbar-header col-md-11">
				<a class="navbar-brand" href="#">Spring 3 MVC Project #JavaConfig</a>
			</div>
			<div class="pull-right">
				<a class="btn btn-md btn-default" href="/login">Login</a>
			</div>
		</div>
	</nav>
	
	<div class="jumbotron">
		<div class="container">
			<h1>${title}</h1>
			<p>
				<c:if test="${not empty name}">
					Hello ${name}
				</c:if>
				
				<c:if test="${empty name}">
					Welcome Welcome!
				</c:if>
			</p>
			<p>
				<a class="btn btn-promary btn-lg" href="#" role="button">Learn more</a>				
			</p>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>ABC</p>
				<p>
				 	<a class="btn btn-default" href="#" role="button">View details</a>
				 </p>
			</div>
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>ABC</p>
				<p>
				 	<a class="btn btn-default" href="#" role="button">View details</a>
				 </p>
			</div>
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>ABC</p>
				<p>
				 	<a class="btn btn-default" href="#" role="button">View details</a>
				 </p>
			</div>
		</div>
		
		<hr>
		<fotter>
			<p> Testing Spring MVC + Hibernate + JUnit + Log4j </p>
		</fotter>
	</div>
	
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/js/jquery-3.0.0.min.js" var="jquery"/>
<script src="${jquery}"></script>
<script src="${bootstrapJs}"></script>

	
</body>
</html>