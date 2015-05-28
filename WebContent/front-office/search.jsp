<h2>Resultats de la recherche</h2>

<h3>Auteurs</h3>
<ul>
	<c:forEach var="Author" items="${Authors}">
		<li><c:out value="${ Author.firstname }" /> <c:out
				value="${ Author.lastname }" /></li>
	</c:forEach>
</ul>

<h3>Publications</h3>
<ul>
	<c:forEach var="Publication" items="${Publications}">
		<li><c:out value="${ Publication.title }" /></li>
		<li><c:out value="${ Publication.resume }" /></li>
	</c:forEach>
</ul>

<h3>Equipes</h3>
<ul>
	<c:forEach var="Team" items="${Teams}">
		<li><c:out value="${ Team.name }" /></li>
	</c:forEach>
</ul>

<h3>Types</h3>
<ul>
	<c:forEach var="Type" items="${Types}">
		<li><c:out value="${ Type.name }" /></li>
	</c:forEach>
</ul>