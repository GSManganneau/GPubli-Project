<jsp:directive.page contentType="text/html;charset=UTF-8" />

<c:forEach var="publication" items="${Publications}">
@<c:out value="${publication.type.typeName }"/>{ publicationId<c:out value="${publication.publicationId}"/>,
author = { <c:forEach var="author" items="${publication.authors }"> <c:out value="${author.firstname }"/> <c:out value="${author.lastname }" /></c:forEach>},
title = {<c:out value="${ publication.title }" />}, 
year = {<c:out value="${ publication.date }"/>},
<c:forEach var="attribute" items="${publication.type.attributes }"><c:out value="${attribute.attributeName }"/>={<c:out value="${attribute.datas }"/>},
</c:forEach>url = {<c:out value="${ publication.url }" />}
}
</c:forEach>
