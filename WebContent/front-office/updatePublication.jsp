<jsp:directive.page contentType="text/html;charset=UTF-8" />

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?">Accueil</a></li>
			<li class="active">Modifier la publication &laquo; <em>Titre de la publication</em> &raquo;</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-sm-12">
		<form class="form-horizontal" data-toggle="validator" data-form="sendable"  action="updatepublication" method="post">
			<div class="form-group">
				<label for="label-title" class="col-sm-2 control-label">Titre *</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="title" id="label-title" placeholder="Titre de la publication" data-rule-required="true" value="<c:out value="${publication.title}"/>">
				</div>
			</div>

			<div class="form-group">
				<label for="label-resume" class="col-sm-2 control-label">Résumé *</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="4" name="resume" id="label-resume" placeholder="Entrez un résumé de la publication" data-rule-required="true"><c:out value="${publication.resume}"/></textarea>
				</div>
			</div>

			<div class="form-group">
				<label for="label-authors" class="col-sm-2 control-label">Co-auteur(s)</label>
				<div class="col-sm-10">
				<c:set var="sessionId"  value="${session.getAttribute(\"authorId\")}"/>
					<select class="form-control selectize-select-multiple-create-user" name="authors" id="label-authors" placeholder="Choisissez un ou plusieurs co-auteurs" multiple>
						<c:forEach var="author" items="${publication.authors }">
						<c:if test="${sessionId != author.authorId }">
						<option value="<c:out value="${author.authorId}"/>" selected><c:out value="${author.firstname} ${author.lastname}"/></option>
						</c:if>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group form-group-date">
				<label for="label-date" class="col-sm-2 control-label">Date *</label>
				<div class="col-sm-10">
					<div class="input-group date datetimepicker-input-date">
						<input type="text" class="form-control" name="date" id="label-date" placeholder="Date de la publication" data-rule-required="true" value="<c:out value="${publication.date }"/>">
						<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="label-type" class="col-sm-2 control-label">Type *</label>
				<div class="col-sm-10">
					<select class="form-control selectize-select-simple" name="type" id="label-type" data-rule-required="true">
						<option value="">Choisissez un type</option>
						<c:forEach var="type" items="${types }">
						<option value="<c:out value="${type.typeId }"/>" 
						<c:if test="${type.typeId == publication.type.typeId }"> 
						selected 
						</c:if>>
						<c:out value="${type.typeName }"/>
						</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="type-attributes">
				
				<c:forEach var="attribute" items="${publication.type.attributes}">
				<div class="form-group">
					<label for="label-attribute<c:out value="${attribute.attributeId }"/>" class="col-sm-2 control-label"><c:out value="${attribute.attributeName }"/> *</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="attribute<c:out value="${attribute.attributeId }"/>" id="label-attribute<c:out value="${attribute.attributeId }"/>" data-rule-required="true" value="<c:out value="${attribute.datas }"/>">
					</div>
				</div>
				</c:forEach>

			</div>
			<input type="hidden" name="publicationId" value="<c:out value="${publication.publicationId }"/>">
			<div class="form-group form-group-submit">
				<div class="col-sm-10 col-sm-offset-2">
					<hr>
					<button type="submit" class="btn btn-primary btn-lg btn-block"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp; Modifier la publication</button>
				</div>
			</div>
			
		</form>
	</div>
</div>