
<p>Formulaire d'ajout de publication
<form action="addpublications" method="post">
<label>Titre</label><input type=text name="title" id="title" required><br><br>
<label>Résumé de l'article</label> <input type=text name="resume" id="resume" required><br><br>
<label>Date</label><input type=text name="date" id ="date" required><br><br>
<label>Type de la publication</label>
<select id="list" name="typeId" required >
<option>vide
</option>
<c:forEach var="type" items="${types}">
<option value=<c:out value="${type.typeId}"/>> <c:out value="${type.typeName }"/>
</option> 
</c:forEach>
</select><br><br>
<button type=submit >Soumettre</button>
</form>

























<!-- À toi de jouer Stéphane ! -->

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Accueil</a></li>
			<li class="active">Ajouter une publication</li>
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
					<input type="text" class="form-control" name="title" id="label-title" placeholder="Titre de la publication" data-rule-required="true">
				</div>
			</div>
			<div class="form-group">
				<label for="label-resume" class="col-sm-2 control-label">Résumé *</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="4" name="resume" id="label-resume" placeholder="Entrez un résumé de la publication" data-rule-required="true"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="label-authors" class="col-sm-2 control-label">Co-auteur(s)</label>
				<div class="col-sm-10">
					<select class="form-control selectize-select-multiple-create-user" name="authors" id="label-authors" placeholder="Choisissez un ou plusieurs co-auteurs" multiple>
						<option value="1">Guy-Stéphane Manganneau</option>
						<option value="2">Roland Basset-Chercot</option>
						<option value="3">Aboubacar Bessenga-Diallo</option>
						<option value="4">Matthieu Puibaraud</option>
					</select>
				</div>
			</div>
			<div class="form-group form-group-date">
				<label for="label-date" class="col-sm-2 control-label">Date *</label>
				<div class="col-sm-10">
					<div class="input-group date datetimepicker-input-date">
						<input type="text" class="form-control" name="date" id="label-date" placeholder="Date de la publication" data-rule-required="true">
						<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="label-type" class="col-sm-2 control-label">Type *</label>
				<div class="col-sm-10">
					<select class="form-control selectize-select-simple" name="type" id="label-type" data-rule-required="true">
						<option value="">Choisissez un type</option>
						<option value="1">Livre</option>
						<option value="2">Article</option>
						<option value="3">Conférence</option>
						<option value="4">Cours</option>
					</select>
				</div>
			</div>
			
			<div class="form-group form-group-submit">
				<div class="col-sm-10 col-sm-offset-2">
					<hr>
					<button type="submit" class="btn btn-primary btn-lg btn-block"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp; Ajouter la publication</button>
				</div>
			</div>
		</form>
	</div>
</div>