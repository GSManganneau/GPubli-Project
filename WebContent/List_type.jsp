<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des types</title>
</head>
<body>
	<ul>
        <c:forEach var="Type" items="${Types}">
            <li><c:out value="${ Type.type_id }" /> <c:out value="${ Type.name }" /></li>
        </c:forEach>    
    </ul>
</body>
</html>