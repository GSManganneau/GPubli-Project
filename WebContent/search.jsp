<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultats de la recherche</title>
</head>
<body>
	
	<h2>Resultats de la recherche</h2>
	
	<h3>Auteurs</h3>
	<ul>
        <c:forEach var="Author" items="${Authors}">
            <li><c:out value="${ Author.firstname }"/>  <c:out value="${ Author.lastname }"/></li>
        </c:forEach>    
    </ul>
    
    <h3>Publications</h3>
	<ul>
        <c:forEach var="Publication" items="${Publications}">
            <li><c:out value="${ Publication.title }"/></li>
            <li><c:out value="${ Publication.resume }"/></li>
        </c:forEach>    
    </ul>
    
    <h3>Equipes</h3>
	<ul>
        <c:forEach var="Team" items="${Teams}">
            <li><c:out value="${ Team.name }"/></li>
        </c:forEach>    
    </ul>
    
    <h3>Types</h3>
	<ul>
        <c:forEach var="Type" items="${Types}">
            <li><c:out value="${ Type.name }"/></li>
        </c:forEach>    
    </ul>
</body>
</html>