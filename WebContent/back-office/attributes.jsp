<jsp:directive.page contentType="text/html;charset=UTF-8" />
<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="AdminHome">Dashboard</a></li>
			<li><a href="Types">Types</a></li>
			<li class="active"><c:out value="${ type.typeName }"/></li>
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
		
		<form data-toggle="validator-form" action="TreatmentAttribute?typeId=<c:out value="${ typeId }"/>" method="post">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title"><i class="fa <c:out value="${ type.iconName }"/>"></i>&nbsp; <c:out value="${ type.typeName }"/></h3>
				</div>
				<div class="table-responsive-plus">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="col-md-1" data-sort="int" data-alterable-type="id" data-alterable-name="id">Id &nbsp;<i class="fa fa-sort"></th>
								<th class="col-md-8" data-sort="string" data-alterable-type="select-create" data-alterable-name="name" data-alterable-choose="Choisissez ou créez un nom d'attribut" data-alterable-value='<c:out value="${ json }"/>' data-alterable-validate="required">Nom &nbsp;<i class="fa fa-sort"></th>
								<th class="col-md-2" data-sort="int" data-alterable-type="input" data-alterable-name="order" data-alterable-validate="required digits">Ordre &nbsp;<i class="fa fa-sort"></th>
								<th class="col-md-1"><!-- Action --></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="attribute" items="${attributes}">
							<tr>
								<td data-title="Id"><c:out value="${ attribute.attributeId }"/></td>
								<td data-title="Nom" data-alterable-option="<c:out value="${ attribute.attributeId }"/>"><c:out value="${ attribute.attributeName }"/></td>
								<td data-title="Ordre"><c:out value="${ attribute.count }"/></td>
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
				<h3 class="panel-title"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp; Ajouter un attribut</h3>
			</div>
			<div class="panel-body">
				<form role="form" data-toggle="validator" action="AddAttribute" method="post">
					<div class="form-group">
						<label for="label-name" class="control-label">Nom *</label>
						<select class="form-control selectize-select-simple-create" id="label-name" name="attributeName" data-rule-required="true">
							<option value="">Choisissez ou créez un nom d'attribut</option>
							
						</select>
						<input type="hidden" name="typeId" value="<c:out value="${typeId}"/>">
					</div>
				

					<hr>

					<div class="form-group form-group-without-margin text-right">
						<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp; Ajouter un attribut</button>
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