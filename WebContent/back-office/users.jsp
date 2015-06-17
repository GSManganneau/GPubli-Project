<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Dashboard</a></li>
			<li class="active">Utilisateurs</li>
		</ol>
		<hr>
	</div>

	<div class="col-md-12">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp; Modifications effectuées avec succès !
		</div>

		<form data-toggle="validator-form">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; Utilisateurs</h3>
				</div>
				<div class="table-responsive-plus">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="col-md-1" data-sort="int">Id &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-md-2" data-sort="string">Pseudo &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-md-2" data-sort="string">Prénom &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-md-3" data-sort="string">Nom &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-md-3" data-sort="string" data-alterable-type="select" data-alterable-name="team" data-alterable-choose="Choisir une équipe" data-alterable-value='[{"name":"Informatique","value":1},{"name":"Télécom","value":2},{"name":"Électronique","value":3},{"name":"Commerce","value":4}]' data-alterable-validate="required">Équipe &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-md-1"><!-- Action --></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td data-title="Id">1</td>
								<td data-title="Pseudo">gmangann</td>
								<td data-title="Prénom">Guy-Stéphane</td>
								<td data-title="Nom">Manganneau</td>
								<td data-title="Équipe" data-alterable-option="1">Informatique</td>
								<td data-title="Action" class="text-right">
									<div class="btn-group">
										<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></button>
										<ul class="dropdown-menu dropdown-menu-right" role="menu">
											<li><a href="#" class="update"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp; Modifier</a></li>
											<li><a href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp; Supprimer</a></li>
										</ul>
									</div>
								</td>
							</tr>
							<tr>
								<td data-title="Id">2</td>
								<td data-title="Pseudo">rbasset-</td>
								<td data-title="Prénom">Roland</td>
								<td data-title="Nom">Basset-Chercot</td>
								<td data-title="Équipe" data-alterable-option="3">Électronique</td>
								<td data-title="Action" class="text-right">
									<div class="btn-group">
										<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></button>
										<ul class="dropdown-menu dropdown-menu-right" role="menu">
											<li><a href="#" class="update"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp; Modifier</a></li>
											<li><a href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp; Supprimer</a></li>
										</ul>
									</div>
								</td>
							</tr>
							<tr>
								<td data-title="Id">3</td>
								<td data-title="Pseudo">abesseng</td>
								<td data-title="Prénom">Aboubacar</td>
								<td data-title="Nom">Bessenga-Diallo</td>
								<td data-title="Équipe" data-alterable-option="1">Informatique</td>
								<td data-title="Action" class="text-right">
									<div class="btn-group">
										<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></button>
										<ul class="dropdown-menu dropdown-menu-right" role="menu">
											<li><a href="#" class="update"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp; Modifier</a></li>
											<li><a href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp; Supprimer</a></li>
										</ul>
									</div>
								</td>
							</tr>
							<tr>
								<td data-title="Id">4</td>
								<td data-title="Pseudo">mpuibara</td>
								<td data-title="Prénom">Matthieu</td>
								<td data-title="Nom">Puibaraud</td>
								<td data-title="Équipe" data-alterable-option="2">Télécom</td>
								<td data-title="Action" class="text-right">
									<div class="btn-group">
										<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></button>
										<ul class="dropdown-menu dropdown-menu-right" role="menu">
											<li><a href="#" class="update"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp; Modifier</a></li>
											<li><a href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp; Supprimer</a></li>
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
	</div>
</div>