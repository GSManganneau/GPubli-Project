<jsp:directive.page contentType="text/html;charset=UTF-8" />
<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Dashboard</a></li>
			<li class="active">Équipes</li>
		</ol>
		<hr>
	</div>

	<div class="col-md-12">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp; Ajout effectué avec succès !
		</div>

		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp; Modifications effectuées avec succès !
		</div>

		<form data-toggle="validator-form">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp; Équipes</h3>
				</div>
				<div class="table-responsive-plus">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="col-md-1" data-sort="int" data-alterable-type="id" data-alterable-name="id">Id &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-md-6" data-sort="string" data-alterable-type="input" data-alterable-name="name" data-alterable-validate="required">Nom &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-md-2" data-alterable-type="icon" data-alterable-name="icon">Icône</th>
								<th class="col-md-2" data-sort="int">Effectif &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-md-1"><!-- Action --></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="team" items="${teams}">
							<tr>
								<td data-title="Id"><c:out value="${ team.teamId }"/></td>
								<td data-title="Nom"><c:out value="${ team.teamName }"/></td>
								<td data-title="Icône"><i class="fa fa-desktop"></i><c:out value="${ team.thumbnail }"/></td>
								<td data-title="Effectif"><c:out value="${ team.count }"/></td>
								<td data-title="Action" class="text-right">
									<div class="btn-group">
										<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></button>
										<ul class="dropdown-menu dropdown-menu-right" role="menu">
											<li><a href="#" class="update"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp; Modifier</a></li>
											<li><a href="#delete-url" data-toggle="modal" data-target="#delete-modal"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp; Supprimer</a></li>
										</ul>
									</div>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="panel-body" style="display: none;">
					<div class="form-group form-group-without-margin text-right">
						<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp; Envoyer les modifications</button>
					</div>
				</div>
			</div>
		</form>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp; Ajouter une équipe</h3>
			</div>
			<div class="panel-body">
				<form role="form" data-toggle="validator" data-form="not-sendable">
					<div class="form-group">
						<label for="label-name" class="control-label">Nom *</label>
						<input type="text" class="form-control" id="label-name" name="name" placeholder="Entrez un nom d'équipe" data-rule-required="true">
					</div>

					<div class="form-group">
						<label for="label-icon" class="control-label">Icône *</label>
						<div class="input-group">
							<div class="btn-group dropup">
								<button type="button" class="btn btn-default iconpicker-component" disabled><i class="fa fa-adjust"></i></button>
								<button type="button" class="icp icp-dd btn btn-default dropdown-toggle" id="label-icon" data-selected="fa-adjust" data-toggle="dropdown">
									<span class="caret"></span>
									<span class="sr-only">Toggle Dropdown</span>
								</button>
								<div class="dropdown-menu"></div>
								<input type="text" name="icon" value="fa-adjust" style="display: none;">
							</div>
						</div>
					</div>

					<hr>

					<div class="form-group form-group-without-margin text-right">
						<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp; Ajouter une équipe</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="delete-modal-label">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-alert" aria-hidden="true"></span>&nbsp; Confirmation de suppression</h4>
			</div>
			<div class="modal-body">
				Êtes-vous sûr de vouloir supprimer cet élément ? Cette action sera irréversible.
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
				<a href="#" class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp; Supprimer</a>
			</div>
		</div>
	</div>
</div>