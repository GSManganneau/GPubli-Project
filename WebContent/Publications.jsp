<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
        <c:forEach var="publication" items="${Publications}">
            <li><c:out value="${ publication.type }" /> <c:out value="${ publication.resume }" /> <c:out value="${publication.journal}" /></li>
        </c:forEach>
    </ul>    
coucou
</body>
</html>