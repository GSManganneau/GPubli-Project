<html lang="fr">
<head>
<meta charset="utf-8">
<title>R�sultat de la recherche</title>
</head>
<body>
	<ul>
        <c:forEach var="publicationId" items="${publicationsId}">
            <li>Id: <c:out value="${ publicationId }" /><br> 
        </c:forEach>
        <c:if test="${ publicationsId.isEmpty() }">
        	<li>pas de r�sultat
        </c:if>
    </ul>
</body>
</html>