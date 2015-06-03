


        <c:forEach var="publication" items="${publications}">
            <p>Titre: <c:out value="${ publication.title}"/></p>
            <p>Type publication: <c:out value="${ publication.type.typeName}"/></p>
            <p>Date d'ajout: <c:out value="${ publication.date}"/></p>
           	<p>Resume: <c:out value="${ publication.resume }" /></p>
           	<c:forEach var="attribut" items ="${publication.type.attributes}">
    		<p><c:out value="${ attribut.attributeName}"/> : <c:out value="${attribut.datas}" /></p>
    		</c:forEach>
            	<br/>
        </c:forEach>
        


