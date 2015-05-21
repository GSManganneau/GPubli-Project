
        <c:forEach var="publication" items="${publications}">
            <p>Titre: <c:out value="${ publication.title}"/></p>
            <p>Type publication: <c:out value="${ publication.type.name}"/></p>
            <p>Date d'ajout: <c:out value="${ publication.date}"/></p>
           	<p>Resume: <c:out value="${ publication.resume }" /></p>
    		<p>Journal de parution: <c:out value="${publication.journal}" /></p>
    		<p>Titre du Livre: <c:out value="${publication.book_title }"></c:out>
            	<br/>
        </c:forEach>
        
