<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Accueil</a></li>
			<li class="active">Paramètres</li>
			<li class="active">Profil</li>
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
					<a href="?page=parameters-profile" class="list-group-item active"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; Profil</a>
					<a href="?page=parameters-api" class="list-group-item"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>&nbsp; API</a>
				</div>
			</div>
		</nav>
	</div>

	<div class="col-md-9">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp; Modifications effectuées avec succès !
		</div>
		
		<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Vos informations personnelles</h3>
				</div>
				<div class="panel-body">
					<form data-toggle="validator">
						<div class="form-group">
							<label for="label-firstname">Prénom *</label>
							<input type="text" class="form-control" name="firstname" id="label-firstname" value="Matthieu" data-rule-required="true">
						</div>

						<div class="form-group">
							<label for="label-lastname">Puibaraud *</label>
							<input type="text" class="form-control" name="lastname" id="label-lastname" value="Puibaraud" data-rule-required="true">
						</div>

						<hr>
						
						<div class="text-right">
							<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp; Envoyer les modifications</button>
						</div>
					</form>
				</div>
			</div>
	</div>
</div>