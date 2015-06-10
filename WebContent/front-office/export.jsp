<jsp:directive.page contentType="text/html;charset=UTF-8" />

<c:forEach var="Publication" items="${Publications}">
	<c:out value="${ Publication.title }" />
	<c:out value="${ Publication.resume }" />

	<c:out value="${ Publication.date }" />

	<c:out value="${ Publication.url }" />
</c:forEach>