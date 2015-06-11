<jsp:directive.page contentType="text/html;charset=UTF-8" />

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li class="active">Accueil</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-md-3">
		<nav>
			<div class="panel panel-default general-informations">
				<div class="panel-heading">
					<h3 class="panel-title">Informations générales</h3>
				</div>
				<ul class="list-group">
					<li class="list-group-item"><span class="badge">147</span><span class="glyphicon glyphicon-book" aria-hidden="true"></span>&nbsp; Publication(s)</li>
					<li class="list-group-item"><span class="badge">23</span><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; Auteur(s)</li>
					<li class="list-group-item"><span class="badge">3</span><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp; Équipe(s)</li>
				</ul>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Équipe</h3>
				</div>
				<div class="list-group">
					<a href="#" class="list-group-item"><i class="fa fa-desktop"></i>&nbsp; Informatique</a>
					<a href="#" class="list-group-item"><i class="fa fa-wifi"></i>&nbsp; Télécom</a>
					<a href="#" class="list-group-item"><i class="fa fa-plug"></i>&nbsp; Électronique</a>
				</div>
			</div>
		</nav>
	</div>

	<div class="col-md-9">
		<nav class="navbar navbar-default toolbar">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-publications">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<span class="navbar-brand">Barre d'outils</span>
				</div>

				<div class="collapse navbar-collapse" id="navbar-publications">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-export" aria-hidden="true"></span>&nbsp; Exporter <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><span class="glyphicon glyphicon-duplicate" aria-hidden="true"></span>&nbsp; Bibtex</a></li>
								<li><a href="ExportData"><span class="glyphicon glyphicon-text-size" aria-hidden="true"></span>&nbsp; Texte</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-filter" aria-hidden="true"></span>&nbsp; Filtrage par <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>&nbsp; Tous les types</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-book" aria-hidden="true"></span>&nbsp; Publication</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-headphones" aria-hidden="true"></span>&nbsp; Musique</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-tags" aria-hidden="true"></span>&nbsp; Article</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span>&nbsp; Conférence</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-sort" aria-hidden="true"></span>&nbsp; Tri par <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><span class="glyphicon glyphicon-time" aria-hidden="true"></span>&nbsp; Date</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>&nbsp; Type</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp; Équipe</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; Utilisateur</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="publications">
			<c:forEach var="publication" items="${publications}">
				<div class="panel panel-default panel-publication">
					<div class="panel-heading">
						<div class="row">
							<div class="col-sm-11 col-xs-9">
								<h3 class="panel-title"><span class="glyphicon glyphicon-book" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Livre"></span>&nbsp; <c:out value="${ publication.title}"/></h3>
							</div>

							<div class="col-sm-1 col-xs-3 text-right">
								<div class="btn-group">
									<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></button>
									<ul class="dropdown-menu dropdown-menu-right" role="menu">
										<li><a href="#<c:out value="${ publication.publicationId}"/>"><span class="glyphicon glyphicon-duplicate" aria-hidden="true"></span>&nbsp; Export Bibtex</a></li>
										<li><a href="#<c:out value="${ publication.publicationId}"/>"><span class="glyphicon glyphicon-text-size" aria-hidden="true"></span>&nbsp; Export Texte</a></li>
										<li class="divider"></li>
										<li><a href="#<c:out value="${ publication.publicationId}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp; Modifier la publication</a></li>
										<li><a href="#<c:out value="${ publication.publicationId}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp; Supprimer la publication</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<c:out value="${ publication.resume }" />
						<!-- <c:forEach var="attribut" items ="${publication.type.attributes}">
							<p><c:out value="${ attribut.attributeName}"/> : <c:out value="${attribut.datas}" /></p>
						</c:forEach> -->
					</div>
				</div>
			</c:forEach>
			
		</div>

		<nav>
			<jsp:include page="pagination.jsp" /> 
		</nav>
		
	</div>
</div>

























<!-- À toi de jouer Stéphane ! -->

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li class="active">Accueil</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-md-3">
		<nav>
			<div class="panel panel-default general-informations">
				<div class="panel-heading">
					<h3 class="panel-title">Informations générales</h3>
				</div>
				<ul class="list-group">
					<li class="list-group-item"><span class="badge">147</span><span class="glyphicon glyphicon-book" aria-hidden="true"></span>&nbsp; Publication(s)</li>
					<li class="list-group-item"><span class="badge">23</span><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; Auteur(s)</li>
					<li class="list-group-item"><span class="badge">3</span><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp; Équipe(s)</li>
				</ul>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Équipe</h3>
				</div>
				<div class="list-group">
					<a href="#" class="list-group-item"><i class="fa fa-desktop"></i>&nbsp; Informatique</a>
					<a href="#" class="list-group-item"><i class="fa fa-wifi"></i>&nbsp; Télécom</a>
					<a href="#" class="list-group-item"><i class="fa fa-plug"></i>&nbsp; Électronique</a>
				</div>
			</div>
		</nav>
	</div>

	<div class="col-md-9">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp; Votre publication a bien été ajoutée !
		</div>

		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp; Votre publication a bien été modifiée !
		</div>

		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp; Votre publication a bien été supprimée !
		</div>

		<div class="alert alert-info alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<span class="glyphicon glyphicon-alert" aria-hidden="true"></span>&nbsp; Aucune publication...
		</div>

		<nav class="navbar navbar-default toolbar">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-publications">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<span class="navbar-brand">Barre d'outils</span>
				</div>

				<div class="collapse navbar-collapse" id="navbar-publications">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-export" aria-hidden="true"></span>&nbsp; Exporter <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><span class="glyphicon glyphicon-duplicate" aria-hidden="true"></span>&nbsp; Bibtex</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-text-size" aria-hidden="true"></span>&nbsp; Texte</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-filter" aria-hidden="true"></span>&nbsp; Filtrage par <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><i class="fa fa-asterisk"></i>&nbsp; Tous les types</a></li>
								<li><a href="#"><i class="fa fa-book"></i>&nbsp; Publication</a></li>
								<li><a href="#"><i class="fa fa-headphones"></i>&nbsp; Musique</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-sort" aria-hidden="true"></span>&nbsp; Tri par <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><span class="glyphicon glyphicon-time" aria-hidden="true"></span>&nbsp; Date</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>&nbsp; Type</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp; Équipe</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; Utilisateur</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="publications">
			<div class="panel panel-default panel-publication">
				<div class="panel-heading">
					<div class="row">
						<div class="col-sm-11 col-xs-9">
							<h3 class="panel-title"><span class="hide-overflow"><i class="fa fa-headphones" data-toggle="tooltip" data-placement="bottom" title="Musique"></i>&nbsp; Panel title</span></h3>
						</div>

						<div class="col-sm-1 col-xs-3 text-right">
							<div class="btn-group">
								<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></button>
								<ul class="dropdown-menu dropdown-menu-right" role="menu">
									<li><a href="#"><span class="glyphicon glyphicon-duplicate" aria-hidden="true"></span>&nbsp; Export Bibtex</a></li>
									<li><a href="#"><span class="glyphicon glyphicon-text-size" aria-hidden="true"></span>&nbsp; Export Texte</a></li>
									<li class="divider"></li>
									<li><a href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp; Modifier</a></li>
									<li><a href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp; Supprimer</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<div class="row">
						<p class="authors col-lg-10 col-sm-9"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; <a href="#">Matthieu Puibaraud</a> | <a href="#">Roland Basset-Chercot</a></p>
						<p class="date col-lg-2 col-sm-3 text-right"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>&nbsp; <em style="color: #555;">17/01/2015</em></p>
					</div>
					<hr>
					<p class="resume text-justify">Campensem passim senatores aruspicem <a href="#">religione igni</a> etiam firmarat Campensem supra constrictus sorte quin <a href="#">vellent nullo</a> se puniri hoe validis artibus extinctus sorte et et et ambo validis Cornelius firmarat sorte monetae plumbi est aruspicem vellent quoniam etiam quin pronuntiante validis confessi aruspicem vellent adiecta ferro dedit polluisse sorte passim Campensem Cornelius sunt <a href="#">firmarat plumbi</a> etiam puniri venenorum firmarat puniri polluisse Campensem sunt iussurum pravis cum adiecta passim pravis vellent validis et pravis eius monetae Campensem venenorum quos nominare plumbi sacramento Sericum nominare quoniam pari dedit et Sericum artibus ferro adiecta iussurum Maximino polluisse Maximino pravis polluisse extinctus et est se. Talia eruditos <a href="#">quod haec</a> et nomenclatores enim infaustos et et et quosdam prandiis inutiles ignobiles quosdam ut obscuros talia enim et quod subditicios quosdam eo quoque haec adsueti adsueti obscuros prandiis quoque et et <a href="#">mercede</a> et obscuros mercede <a href="#">adsueti</a> accepta quoque nomenclatores et adsueti haec lucris adsueti et et quosdam et.</p>
					<hr class="detail">
					<p class="text-center detail"><a href="#">Détail de la publication</a></p>
				</div>
				<table class="table table-striped table-bordered" style="display: none;">
					<tr>
						<td class="text-right col-sm-3"><strong>Attribut</strong></td><td class="col-sm-9">Valeur</td>
					</tr>
					<tr>
						<td class="text-right"><strong>Attribut</strong></td><td>Valeur</td>
					</tr>
					<tr>
						<td class="text-right"><strong>Attribut</strong></td><td>Valeur</td>
					</tr>
				</table>
			</div>
		</div>

		<nav>
			<ul class="pager">
				<li class="previous"><a href="#"><span aria-hidden="true">&larr;</span> Précédent</a></li>
				<li>
					<div class="pager-select">
						<select class="form-control">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>
				</li>
				<li class="next"><a href="#">Suivant <span aria-hidden="true">&rarr;</span></a></li>
			</ul>
		</nav>
	</div>
</div>