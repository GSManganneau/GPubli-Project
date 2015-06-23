<jsp:directive.page contentType="text/html;charset=UTF-8" />

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Accueil</a></li>
			<li><a href="?page=advanced-search">Recherche avancée</a></li>
			<li class="active">Résultats de la recherche avancée</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-md-3">
		<nav>
			<ul class="list-group">
				<li class="list-group-item"><span class="badge">${ countPubli }</span><span class="glyphicon glyphicon-book" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Nombre de publications"></span>&nbsp; Publication(s)</li>
			</ul>
		</nav>
	</div>

	<div class="col-md-9">
		<jsp:include page="actionInformation.jsp"/>
		<jsp:include page="toolbar.jsp"/>
		<jsp:include page="publications.jsp"/>
		<jsp:include page="pagination.jsp"/>
	</div>
</div>

<jsp:include page="delete-modal.jsp"/>