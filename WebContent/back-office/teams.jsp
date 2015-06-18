<jsp:directive.page contentType="text/html;charset=UTF-8" />
<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Dashboard</a></li>
			<li class="active">Ãquipes</li>
		</ol>
		<hr>
	</div>

	<div class="col-md-12">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp; Ajout effectuÃ© avec succÃ¨s !
		</div>

		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp; Modifications effectuÃ©es avec succÃ¨s !
		</div>

		<form data-toggle="validator-form">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp; Ãquipes</h3>
				</div>
				<div class="table-responsive-plus">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="col-md-1" data-sort="int" data-alterable-type="id" data-alterable-name="id">Id &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-md-6" data-sort="string" data-alterable-type="input" data-alterable-name="name" data-alterable-validate="required">Nom &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-md-2" data-alterable-type="icon" data-alterable-name="icon">IcÃ´ne</th>
								<th class="col-md-2" data-sort="int">Effectif &nbsp;<i class="fa fa-sort"></i></th>
								<th class="col-md-1"><!-- Action --></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td data-title="Id">1</td>
								<td data-title="Nom">Informatique</td>
								<td data-title="IcÃ´ne"><i class="fa fa-desktop"></i></td>
								<td data-title="Effectif">8</td>
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
								<td data-title="Nom">TÃ©lÃ©com</td>
								<td data-title="IcÃ´ne"><i class="fa fa-wifi"></i></td>
								<td data-title="Effectif">6</td>
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
								<td data-title="Nom">Ãlectronique</td>
								<td data-title="IcÃ´ne"><i class="fa fa-plug"></i></td>
								<td data-title="Effectif">7</td>
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

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp; Ajouter une Ã©quipe</h3>
			</div>
			<div class="panel-body">
				<form role="form" data-toggle="validator" data-form="not-sendable">
					<div class="form-group">
						<label for="label-name" class="control-label">Nom</label>
						<input type="text" class="form-control" id="label-name" name="name" placeholder="Entrez un nom d'Ã©quipe" data-rule-required="true">
					</div>

					<div class="form-group">
						<label for="label-icon" class="control-label">IcÃ´ne</label>
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
						<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp; Ajouter une Ã©quipe</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>