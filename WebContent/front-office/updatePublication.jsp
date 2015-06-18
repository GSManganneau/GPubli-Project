<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Accueil</a></li>
			<li class="active">Modifier la publication &laquo; <em>Titre de la publication</em> &raquo;</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-sm-12">
		<form class="form-horizontal" data-toggle="validator" data-form="not-sendable">
			<div class="form-group">
				<label for="label-title" class="col-sm-2 control-label">Titre *</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="title" id="label-title" placeholder="Titre de la publication" data-rule-required="true" value="Le titre de la publication">
				</div>
			</div>

			<div class="form-group">
				<label for="label-resume" class="col-sm-2 control-label">Résumé *</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="4" name="resume" id="label-resume" placeholder="Entrez un résumé de la publication" data-rule-required="true">Le résumé de la publication</textarea>
				</div>
			</div>

			<div class="form-group">
				<label for="label-authors" class="col-sm-2 control-label">Co-auteur(s)</label>
				<div class="col-sm-10">
					<select class="form-control selectize-select-multiple-create-user" name="authors" id="label-authors" placeholder="Choisissez un ou plusieurs co-auteurs" multiple>
						<option value="1" selected>Guy-Stéphane Manganneau</option>
						<option value="2" selected>Roland Basset-Chercot</option>
						<option value="3">Aboubacar Bessenga-Diallo</option>
						<option value="4">Matthieu Puibaraud</option>
					</select>
				</div>
			</div>

			<div class="form-group form-group-date">
				<label for="label-date" class="col-sm-2 control-label">Date *</label>
				<div class="col-sm-10">
					<div class="input-group date datetimepicker-input-date">
						<input type="text" class="form-control" name="date" id="label-date" placeholder="Date de la publication" data-rule-required="true" value="2015-02-09">
						<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="label-file" class="col-sm-2 control-label">Fichier à joindre</label>
				<div class="col-sm-10">
					<input type="file" class="form-control" name="file" id="label-file">
				</div>
			</div>
			
			<div class="form-group">
				<label for="label-type" class="col-sm-2 control-label">Type *</label>
				<div class="col-sm-10">
					<select class="form-control selectize-select-simple" name="type" id="label-type" data-rule-required="true">
						<option value="">Choisissez un type</option>
						<option value="1" selected>Livre</option>
						<option value="2">Article</option>
						<option value="3">Conférence</option>
						<option value="4">Cours</option>
					</select>
				</div>
			</div>

			<div class="type-attributes">
				<div class="form-group">
					<label for="label-Éditeur" class="col-sm-2 control-label">Éditeur *</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="Éditeur" id="label-Éditeur" data-rule-required="true" value="L'éditeur de la publication">
					</div>
				</div>

				<div class="form-group">
					<label for="label-Url" class="col-sm-2 control-label">Url *</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="Url" id="label-Url" data-rule-required="true" value="L'url de la publication">
					</div>
				</div>
			</div>
			
			<div class="form-group form-group-submit">
				<div class="col-sm-10 col-sm-offset-2">
					<hr>
					<button type="submit" class="btn btn-primary btn-lg btn-block"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp; Modifier la publication</button>
				</div>
			</div>
		</form>
	</div>
</div>