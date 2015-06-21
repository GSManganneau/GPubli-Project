<jsp:directive.page contentType="text/html;charset=UTF-8" />

<%-- <c:forEach var="team" items="${teams}">
	<c:out value="${ team.teamName }"></c:out><br/>	
</c:forEach> --%>

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Accueil</a></li>
			<li class="active">Équipe : Informatique</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-md-3">
		<nav>
			<div class="panel-group" role="tablist">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="collapseHeading">
						<h3 class="panel-title">
							<i class="fa fa-desktop"></i>&nbsp; 
							<a class="collapsed" role="button" data-toggle="collapse" href="#collapseMembers" aria-expanded="false" aria-controls="collapseMembers">
								Informatique
							</a>
							<span class="badge" style="float: right;" data-toggle="tooltip" data-placement="bottom" title="Membre(s)">4 <span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
						</h3>
					</div>
					<div id="collapseMembers" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseHeading" aria-expanded="false" style="height: 0px;">
						<div class="list-group">
							<a href="?page=user" class="list-group-item">Aboubacar Bessenga</a>
							<a href="?page=user" class="list-group-item">Roland Basset-Chercot</a>
							<a href="?page=user" class="list-group-item">Guy-Stéphane Manganneau</a>
							<a href="?page=user" class="list-group-item">Matthieu Puibaraud</a>
						</div>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Chiffres-clés</h3>
				</div>
				<ul class="list-group">
					<li class="list-group-item"><span class="badge">147</span><span class="glyphicon glyphicon-book" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Nombre de publications"></span>&nbsp; Publication(s)</li>
					<li class="list-group-item"><span class="badge">23</span><span class="glyphicon glyphicon-user" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Auteurs de ces publications"></span>&nbsp; Auteur(s)</li>
					<li class="list-group-item"><span class="badge">3</span><span class="glyphicon glyphicon-list-alt" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Équipes de ces publications"></span>&nbsp; Équipe(s)</li>
					<li class="list-group-item"><span class="badge">4</span><span class="glyphicon glyphicon-asterisk" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Types de ces publications"></span>&nbsp; Type(s)</li>
				</ul>
			</div>
		</nav>
	</div>

	<div class="col-md-9">
		<jsp:include page="actionInformation.jsp"/>
		<jsp:include page="toolbar.jsp"/>
		<jsp:include page="publications.jsp"/>
		<jsp:include page="pagination.jsp" />
	</div>
</div>

<jsp:include page="delete-modal.jsp"/>