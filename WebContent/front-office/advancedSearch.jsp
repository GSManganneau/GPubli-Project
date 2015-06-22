<jsp:directive.page contentType="text/html;charset=UTF-8" />

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
		<form class="form-horizontal" method="POST" action="AdvancedResearch">
			<div class="form-group">
				<label for="label-keywords" class="col-sm-2 control-label">Mot(s)-clé(s)</label>
				<div class="col-sm-10">
					<select name="keyWords" class="form-control selectize-select-multiple-create" id="label-keywords" placeholder="Inscrivez un ou plusieurs mots-clés séparés par une virgule" multiple></select>
				</div>
			</div>

			<div class="form-group">
				<label for="label-title" class="col-sm-2 control-label">Titre</label>
				<div class="col-sm-10">
					<input type="text" name="publiName" class="form-control" id="label-title" placeholder="Titre de la publication">
				</div>
			</div>

			<div class="form-group">
				<label for="label-authors" class="col-sm-2 control-label">Auteur(s)</label>
				<div class="col-sm-10">
					<select name="authors" class="form-control selectize-select-multiple" id="label-authors" placeholder="Choisissez un ou plusieurs auteurs" multiple>
						<c:forEach var="author" items="${authors}">
							<option value=<c:out value="${author.authorId}"/>>
								<c:out value="${author.firstname}"/> <c:out value="${author.lastname}"/>
							</option> 
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="label-teams" class="col-sm-2 control-label">Équipe(s)</label>
				<div class="col-sm-10">
					<select name="team" class="form-control selectize-select-multiple" id="label-teams" placeholder="Choisissez une ou plusieurs équipes" multiple>
						<c:forEach var="team" items="${teams}">
						<option value=<c:out value="${team.teamId}"/>><c:out value="${team.teamName}"/></option> 
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="label-type" class="col-sm-2 control-label">Type</label>
				<div class="col-sm-10">
					<select name="type" class="form-control selectize-select-simple" id="label-type">
						<option value=<c:out value=""/>><c:out value="Tous"/></option> 
						<c:forEach var="type" items="${types}">
						<option value=<c:out value="${type.typeId}"/>><c:out value="${type.typeName}"/></option> 
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group form-group-date">
				<label class="col-sm-2 control-label">Date</label>
				<div class="col-sm-5">
					<div class="input-group date datetimepicker-input-date input-date-begin">
						<input name="dateFrom" type="text" class="form-control" placeholder="Date de début">
						<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
					</div>
				</div>
				<div class="col-sm-5">
					<div class="input-group date datetimepicker-input-date input-date-end">
						<input name="dateTo" type="text" class="form-control" placeholder="Date de fin">
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