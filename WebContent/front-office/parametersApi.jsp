<jsp:directive.page contentType="text/html;charset=UTF-8" />

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Accueil</a></li>
			<li class="active">Paramètres</li>
			<li class="active">API</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-md-3">
		<nav>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp; Paramètres</h3>
				</div>
				<div class="list-group">
					<a href="?page=parameters-profile" class="list-group-item"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; Profil</a>
					<a href="?page=parameters-api" class="list-group-item active"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>&nbsp; API</a>
				</div>
			</div>
		</nav>
	</div>

	<div class="col-md-9">
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
					<h3 class="panel-title">Autorisation des noms de domaine</h3>
				</div>
				<div class="table-responsive-plus">
					<table class="table table-fixed table-striped table-hover">
						<thead>
							<tr>
								<th class="col-sm-1" data-sort="int" data-alterable-type="id" data-alterable-name="id">Id &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-sm-10" data-sort="string" data-alterable-type="input" data-alterable-name="url" data-alterable-validate="required url">URL &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-sm-1"><!-- Action --></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td data-title="Id">1</td>
								<td data-title="URL"><a href="#">http://www.mapage.fr</a></td>
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
							<tr>
								<td data-title="Id">2</td>
								<td data-title="Url"><a href="#">http://www.lesprofs.fr</a></td>
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
							<tr>
								<td data-title="Id">3</td>
								<td data-title="Url"><a href="#">http://www.test.net</a></td>
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
				<h3 class="panel-title"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp; Ajouter un nom de domaine</h3>
			</div>
			<div class="panel-body">
				<form data-toggle="validator">
					<div class="form-group form-group-alone">
						<div class="input-group">
							<input type="text" class="form-control" name="url" placeholder="Exemple : http://www.ma-page.fr" data-rule-required="true" data-rule-url="true">
							<span class="input-group-btn">
								<button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp; Ajouter</button>
							</span>
						</div>
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