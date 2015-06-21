<jsp:directive.page contentType="text/html;charset=UTF-8" />

<c:forEach var="author" items="${authors}">
	<c:out value="${ author.firstname }"></c:out>  <c:out value="${ author.lastname }"></c:out><br/>	
</c:forEach>
