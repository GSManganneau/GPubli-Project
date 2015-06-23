<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>GPubli</title>
		<link href="libraries/gpubli-0.0.0/css/gpubli.min.css" rel="stylesheet">
	</head>
	<body>
		<c:forEach var ="publication" items="${publications }">
		<div class="panel-publication">
	
			<div class="panel-heading">
				Titre
			</div>
			<div class="panel-content">
				<div class="panel-content-meta">
	
					<div class="authors"><c:forEach var="author" items= "${publication.authors }"><c:out value="${ author.firstname } ${ author.lastname }"/>|</c:forEach></div>
					<div class="date"><em><c:out value="${publication.date }"/></em></div>
				</div>
				<hr>
				<div class="panel-content-resume">
					<c:out value="${publication.resume }"/>
				</div>
			</div>
			<table class="panel-table">
				<tbody>
				
				</tbody>
			</table>
		</div>
		</c:forEach>
	</body>
</html>