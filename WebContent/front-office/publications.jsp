


        <c:forEach var="publication" items="${publications}">
            <p>Titre: <c:out value="${ publication.title}"/> id=:<c:out value="${ publication.publicationId}"/></p>
            <p>Type publication: <c:out value="${ publication.type.typeName}"/></p>
            <p>Date d'ajout: <c:out value="${ publication.date}"/></p>
           	<p>Resume: <c:out value="${ publication.resume }" /></p>
           	<c:forEach var="attribut" items ="${publication.type.attributes}">
    		<p><c:out value="${ attribut.attributeName}"/> : <c:out value="${attribut.datas}" /></p>
    		</c:forEach>
            	<br/>
        </c:forEach>
       
        <div class="pagination" >
         <jsp:include page="pagination.jsp"/>
        </div>
        


