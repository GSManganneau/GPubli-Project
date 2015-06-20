<jsp:directive.page contentType="text/html;charset=UTF-8" />

<c:forEach var="team" items="${teams}">
	<c:out value="${ team.teamName }"></c:out><br/>	
</c:forEach>
