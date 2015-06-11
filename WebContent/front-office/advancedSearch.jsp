<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Accueil</a></li>
			<li class="active">Recherche avancée</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-sm-12">
		<form class="form-horizontal">
			<div class="form-group">
				<label for="label-keywords" class="col-sm-2 control-label">Mot(s)-clé(s)</label>
				<div class="col-sm-10">
					<select class="form-control selectize-select-multiple-create" id="label-keywords" placeholder="Inscrivez un ou plusieurs mots-clés séparés par une virgule" multiple></select>
				</div>
			</div>
			<div class="form-group">
				<label for="label-title" class="col-sm-2 control-label">Titre</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="label-title" placeholder="Titre de la publication">
				</div>
			</div>
			<div class="form-group">
				<label for="label-authors" class="col-sm-2 control-label">Auteur(s)</label>
				<div class="col-sm-10">
					<select class="form-control selectize-select-multiple" id="label-authors" placeholder="Choisissez un ou plusieurs auteurs" multiple>
						<option value="1">Guy-Stéphane Manganneau</option>
						<option value="2">Roland Basset-Chercot</option>
						<option value="3">Aboubacar Bessenga-Diallo</option>
						<option value="4">Matthieu Puibaraud</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="label-teams" class="col-sm-2 control-label">Équipe(s)</label>
				<div class="col-sm-10">
					<select class="form-control selectize-select-multiple" id="label-teams" placeholder="Choisissez une ou plusieurs équipes" multiple>
						<option value="1">Informatique</option>
						<option value="2">Télécom</option>
						<option value="3">Électronique</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="label-type" class="col-sm-2 control-label">Type</label>
				<div class="col-sm-10">
					<select class="form-control selectize-select-simple" id="label-type">
						<option value="">Tous</option>
						<option value="1">Livre</option>
						<option value="2">Article</option>
						<option value="3">Conférence</option>
						<option value="4">Cours</option>
					</select>
				</div>
			</div>
			<div class="form-group form-group-date">
				<label class="col-sm-2 control-label">Date</label>
				<div class="col-sm-5">
					<div class="input-group date datetimepicker-input-date input-date-begin">
						<input type="text" class="form-control" placeholder="Date de début">
						<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
					</div>
				</div>
				<div class="col-sm-5">
					<div class="input-group date datetimepicker-input-date input-date-end">
						<input type="text" class="form-control" placeholder="Date de fin">
						<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
					</div>
				</div>
			</div>
			<div class="form-group form-group-submit">
				<div class="col-sm-10 col-sm-offset-2">
					<hr>
					<button type="submit" class="btn btn-primary btn-lg btn-block"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp; Lancer la recherche</button>
				</div>
			</div>
		</form>
	</div>
</div>