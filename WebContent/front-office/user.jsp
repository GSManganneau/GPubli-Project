<jsp:directive.page contentType="text/html;charset=UTF-8" />

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Accueil</a></li>
			<li class="active">Utilisateur : Matthieu Puibaraud</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-md-3">
		<nav>
			<div class="panel panel-default panel-profile">
				<div class="panel-heading">
					<div class="profile-picture">
						<div class="thumbnail">
							<a href="img/profile-example.jpg" target="_blank">
								<img src="img/profile-example.jpg" alt="profile-example">
							</a>
						</div>
					</div>
					<h3 class="panel-title text-center">Matthieu Puibaraud</h3>
				</div>
				<div class="list-group">
					<div class="list-group-item"><span class="glyphicon glyphicon-lock" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Login ISEP"></span>&nbsp; mpuibara</div>
					<a href="?page=team" class="list-group-item"><span class="glyphicon glyphicon-list-alt" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Équipe"></span>&nbsp; Informatique</a>
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
		<jsp:include page="pagination.jsp"/>
	</div>
</div>

<jsp:include page="delete-modal.jsp"/>