<jsp:directive.page contentType="text/html;charset=UTF-8" />

<c:forEach var="publication" items="${Publications}">
	<c:out value="${ publication.title }" />
	<c:out value="${publication.author.firstname }"/> <c:out value="${publication.author.lastname }" />
	
	<c:forEach var="coAuthor" items="${publication.coAuthors }">
			<a href="#">| <c:out value="${coAuthor.firstname }"/> <c:out value="${coAuthor.lastname }" /></a>
	</c:forEach>
	<c:out value="${ publication.date }"/>
	<c:out value="${ publication.resume }" />
	
	<c:forEach var="attribute" items="${publication.type.attributes }">
		<c:out value="${attribute.attributeName }"/>: <c:out value="${attribute.datas }"/>
	</c:forEach>
	<c:out value="${ publication.url }" />
</c:forEach>