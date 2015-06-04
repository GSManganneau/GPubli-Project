
<c:if test="${paginate.currentPageNumber > 1}">
	<a
		href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${paginate.previousPageNumber }"/>">précédent</a>

	<c:forEach var="i" begin="1" end="${paginate.numberOfPages }" step="1">
		<a
			href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${i}"/>"><c:out
				value="${i}" /></a>

	</c:forEach>
	<c:if test="${paginate.nextPageNumber != 0 }">
		<a
			href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${paginate.nextPageNumber }"/>">suivant</a>
	</c:if>
</c:if>

<c:if
	test="${paginate.nextPageNumber != 0  && paginate.currentPageNumber==1 }">
	
	<c:forEach var="i" begin="2" end="${paginate.numberOfPages }" step="1">
		<a
			href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${i}"/>"><c:out
				value="${i}" /></a>

	</c:forEach>
	<a
		href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${paginate.nextPageNumber }"/>">suivant</a>
</c:if>

<p>current page</p>
<c:out value="${paginate.currentPageNumber }" />
