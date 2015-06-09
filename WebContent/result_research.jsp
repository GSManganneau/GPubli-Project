<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Résultat de la recherche</title>
</head>
<body>
	<ul>
        <c:forEach var="Publications" items="${Publications}">
            <li>Id: <c:out value="${ Publications.publicationId }" /><br> 
            <!-- Type: <c:out value="${ Publications.type }" /><br> -->
            Title: <c:out value="${ Publications.title }" /><br>
            Date: <c:out value="${ Publications.date }" /><br>
            Resume: <c:out value="${ Publications.resume }" /><br>
            Url: <c:out value="${ Publications.url }" /><br></li> 
        </c:forEach>      
    </ul>
</body>
</html>