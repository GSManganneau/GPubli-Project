<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des auteurs</title>
</head>
<body>
	<ul>
        <c:forEach var="Author" items="${Authors}">
            <li><c:out value="${ Author.firstname }" /> <c:out value="${ Author.lastname }" /></li>
        </c:forEach>    
    </ul>
</body>
</html>