<jsp:directive.page contentType="text/html;charset=UTF-8" />

<c:forEach var="publication" items="${Publications}">
@<c:out value="${publication.type.typeName }"/>{<c:out value="${publication.author.firstname }"/> <c:out value="${publication.author.lastname }" />,
author = {<c:out value="${publication.author.firstname }"/> <c:out value="${publication.author.lastname }" />  <c:forEach var="coAuthor" items="${publication.coAuthors }">| <c:out value="${coAuthor.firstname }"/> <c:out value="${coAuthor.lastname }" /></c:forEach>},
title = {<c:out value="${ publication.title }" />}, 
year = {<c:out value="${ publication.date }"/>},
<c:forEach var="attribute" items="${publication.type.attributes }"><c:out value="${attribute.attributeName }"/>={<c:out value="${attribute.datas }"/>},
</c:forEach>url = {<c:out value="${ publication.url }" />}
}
</c:forEach>
