<jsp:directive.page contentType="text/html;charset=UTF-8" />

<c:set var="field" scope="session" value="${search}" />

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Accueil</a></li>
			<li class="active">Résultats de recherche pour &laquo; <em><c:out value="${field}" /></em> &raquo;</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-md-3">
		<nav>
			<div class="list-group">
				<a href="Search?search=<c:out value="${field}" />" class="list-group-item active">
					<span class="glyphicon glyphicon-bell" aria-hidden="true"></span>
					&nbsp; Tout
					<span class="badge"><c:out value="${ AuthorCount.count + TeamCount.count + PublicationCount.count }" /></span>
				</a>

				<a href="SearchPublication?search=<c:out value="${field}" />" class="list-group-item">
					<span class="glyphicon glyphicon-book" aria-hidden="true"></span>
					&nbsp; Publication
					<span class="badge"><c:out value="${ PublicationCount.count }" /></span>
				</a>

				<a href="SearchTeam?search=<c:out value="${field}" />" class="list-group-item">
					<span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
					&nbsp; Équipe
					<span class="badge"><c:out value="${ TeamCount.count }" /></span>
				</a>

				<a href="SearchAuthor?search=<c:out value="${field}" />" class="list-group-item">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					&nbsp; Utilisateur
					<span class="badge"><c:out value="${ AuthorCount.count }" /></span>
				</a>
			</div>
		</nav>
	</div>

	<div class="col-md-9">
		<div class="alert alert-info alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<span class="glyphicon glyphicon-alert" aria-hidden="true"></span>&nbsp; Aucun résultat...
		</div>

		<div class="search-results">
			<jsp:include page="publications.jsp" />

			<div class="users">
				<c:forEach var="Author" items="${Authors}">
					<div class="panel panel-default panel-result-element">
						<div class="panel-body">
							<h3 class="panel-title"><span class="glyphicon glyphicon-user" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Utilisateur"></span>&nbsp; <a href="#"><c:out value="${ Author.firstname }" /> <c:out value="${ Author.lastname }" /></a></h3>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="teams">
				<c:forEach var="Team" items="${Teams}">
					<div class="panel panel-default panel-result-element">
						<div class="panel-body">
							<h3 class="panel-title"><span class="glyphicon glyphicon-list-alt" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Équipe"></span>&nbsp; <a href="#"><c:out value="${ Team.name }" /></a></h3>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<jsp:include page="pagination.jsp" />
	</div>
</div>