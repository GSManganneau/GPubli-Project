<jsp:directive.page contentType="text/html;charset=UTF-8" />

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li class="active">Accueil</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-md-3">
		<nav>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Chiffres-clés</h3>
				</div>
				<ul class="list-group">
					<li class="list-group-item"><span class="badge"><c:out value="${ pubCount.count }"/></span><span class="glyphicon glyphicon-book" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Nombre de publications"></span>&nbsp; Publication(s)</li>
					<li class="list-group-item"><span class="badge"><c:out value="${ authorCount.count }"/></span><span class="glyphicon glyphicon-user" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Auteurs de ces publications"></span>&nbsp; Auteur(s)</li>
					<li class="list-group-item"><span class="badge"><c:out value="${ teamCount.count }"/></span><span class="glyphicon glyphicon-list-alt" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Équipes de ces publications"></span>&nbsp; Équipe(s)</li>
					<li class="list-group-item"><span class="badge"><c:out value="${ typeCount.count }"/></span><span class="glyphicon glyphicon-asterisk" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Types de ces publications"></span>&nbsp; Type(s)</li>
				</ul>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Équipes</h3>
				</div>
				<div class="list-group">
				<c:forEach var="team" items="${teams}">
					<a href="teampage?teamId=<c:out value="${team.teamId} "/>" class="list-group-item"><i class="fa <c:out value="${team.thumbnail} "/> "></i>&nbsp; <c:out value="${team.teamName} "/></a>
				</c:forEach>
				</div>
			</div>
		</nav>
	</div>

	<div class="col-md-9">
		<jsp:include page="toolbar.jsp"/>
		<jsp:include page="publications.jsp"/>
		<jsp:include page="pagination.jsp"/>
	</div>
</div>

<jsp:include page="delete-modal.jsp"/>