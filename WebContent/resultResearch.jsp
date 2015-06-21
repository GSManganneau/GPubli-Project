<html lang="fr">
<head>
<meta charset="utf-8">
<title>Résultat de la recherche</title>
</head>
<body>
	<ul>
        <c:forEach var="Publications" items="${Publications}">
            <li>Id: <c:out value="${ Publications.publicationId }" /><br> 
            <!-- Type: <c:out value="${ Publications.type }" /><br> -->
            Title: <c:out value="${ Publications.title }" /><br>
            Auteur: <c:out value="${ Publications.author.firstname }" /> <c:out value="${ Publications.author.lastname }" /><br>
            Date: <c:out value="${ Publications.date }" /><br>
            Resume: <c:out value="${ Publications.resume }" /><br>
            <!-- Url: <c:out value="${ Publications.url }" /><br></li> -->
        </c:forEach>      
    </ul>
</body>
</html>