<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des equipe</title>
</head>
<body>
	<ul>
        <c:forEach var="Team" items="${Teams}">
           <li><c:out value="${ Team.name }" /></li>
	    </c:forEach>  
    </ul>
</body>
</html>