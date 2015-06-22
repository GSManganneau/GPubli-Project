<jsp:directive.page contentType="text/html;charset=UTF-8" />
<div class="row">	
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li class="active">Dashboard</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row key-figures">
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class="fa fa-book fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right">
						<h1><c:out value="${ pubCount.count }"/></h1>
					</div>
				</div>
			</div>
			<div class="panel-body text-right">
				Publication(s)
			</div>
		</div>
	</div>
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class="fa fa-user fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right">
						<h1><c:out value="${ authorCount.count }"/></h1>
					</div>
				</div>
			</div>
			<div class="panel-body text-right">
				Utilisateur(s)
			</div>
		</div>
	</div>
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class="fa fa-users fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right">
						<h1><c:out value="${ teamCount.count }"/></h1>
					</div>
				</div>
			</div>
			<div class="panel-body text-right">
				Équipe(s)
			</div>
		</div>
	</div>
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class="fa fa-asterisk fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right">
						<h1><c:out value="${ typeCount.count }"/></h1>
					</div>
				</div>
			</div>
			<div class="panel-body text-right">
				Type(s)
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title"><i class="fa fa-history"></i>&nbsp; Historique</h3>
			</div>
			<div class="panel-body">
				
			</div>
		</div>
	</div>
</div>