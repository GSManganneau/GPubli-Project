<jsp:directive.page contentType="text/html;charset=UTF-8" />

<c:set var="field" scope="session" value="${search}" />

<div class="page-header">
	<h1>
		Resultats pour <small>"<c:out value="${field}" />"
		</small>
	</h1>
</div>

<div class="row">
	<div class="col-md-3">
		<nav>
			<div class="list-group">
				<a href="Search?search=<c:out value="${field}" />" class="list-group-item active"><span
					class="glyphicon glyphicon-bell" aria-hidden="true"></span>&nbsp;
					Tout <span class="badge"><c:out value="${ AuthorCount.count + TeamCount.count + PublicationCount.count }" /></span></a>
					

					<a href="SearchPublication?search=<c:out value="${field}" />"
					class="list-group-item"><span class="glyphicon glyphicon-book"
					aria-hidden="true"></span>&nbsp; Publication <span class="badge"><c:out value="${ PublicationCount.count }" /></span></a>

					
					
					<a href="SearchTeam?search=<c:out value="${field}" />" class="list-group-item"><span
					class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp;
					Équipe <span class="badge"><c:out value="${ TeamCount.count }" /></span></a> 

					
 				
					<a href="SearchAuthor?search=<c:out value="${field}" />"
					class="list-group-item"><span class="glyphicon glyphicon-user"
					aria-hidden="true"></span>&nbsp; Utilisateur <span class="badge"><c:out value="${ AuthorCount.count }" /></span></a>

			</div>
		</nav>
	</div>
	<div class="col-md-9">
		<jsp:include page="publications.jsp" /> 
			<c:forEach var="Author" items="${Authors}">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<div class="col-sm-11 col-xs-9">
								<h3 class="panel-title">
									<span class="glyphicon glyphicon-lock" aria-hidden="true"
										data-toggle="tooltip" data-placement="bottom"
										title="Conference"></span>&nbsp;
									<c:out value="${ Author.firstname }" /> <c:out value="${ Author.lastname }" />
								</h3>
							</div>
							<div class="col-sm-1 col-xs-3 text-right">
								<div class="btn-group">
									<button type="button"
										class="btn btn-default btn-xs dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										<span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
									</button>
									<ul class="dropdown-menu dropdown-menu-right" role="menu">
										<li><a href="#"><span
												class="glyphicon glyphicon-duplicate" aria-hidden="true"></span>&nbsp;
												Export Bibtex</a></li>
										<li><a href="#"><span
												class="glyphicon glyphicon-text-size" aria-hidden="true"></span>&nbsp;
												Export Texte</a></li>
										<li class="divider"></li>
										<li><a href="#"><span
												class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;
												Modifier</a></li>
										<li><a href="#"><span
												class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;
												Supprimer</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-body">
						
					</div>
				</div>
			</c:forEach>

			<c:forEach var="Team" items="${Teams}">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<div class="col-sm-11 col-xs-9">
								<h3 class="panel-title">
									<span class="glyphicon glyphicon-lock" aria-hidden="true"
										data-toggle="tooltip" data-placement="bottom"
										title="Conférence"></span>&nbsp;
									<c:out value="${ Team.name }" />
								</h3>
							</div>

							<div class="col-sm-1 col-xs-3 text-right">
								<div class="btn-group">
									<button type="button"
										class="btn btn-default btn-xs dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										<span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
									</button>
									<ul class="dropdown-menu dropdown-menu-right" role="menu">
										<li><a href="#"><span
												class="glyphicon glyphicon-duplicate" aria-hidden="true"></span>&nbsp;
												Export Bibtex</a></li>
										<li><a href="#"><span
												class="glyphicon glyphicon-text-size" aria-hidden="true"></span>&nbsp;
												Export Texte</a></li>
										<li class="divider"></li>
										<li><a href="#"><span
												class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;
												Modifier</a></li>
										<li><a href="#"><span
												class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;
												Supprimer</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-body"></div>
				</div>
			</c:forEach>
		</div>

		<nav>
			<ul class="pager">
				<li class="previous"><a href="#"><span aria-hidden="true">&larr;</span>
						Précédent</a></li>
					<li>
				<div class="pager-select">
				<select class="form-control">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
				</select>
				</div>
				</li>
				<li class="next"><a href="#">Suivant <span
						aria-hidden="true">&rarr;</span></a></li>
			</ul>
		</nav>
	</div>
</div>

























<!-- À toi de jouer Aboubacar ! -->

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="?page=index">Accueil</a></li>
			<li class="active">Résultats de recherche pour &laquo; <em>machin truc</em> &raquo;</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-md-3">
		<nav>
			<div class="list-group">
				<a href="#" class="list-group-item active"><span class="glyphicon glyphicon-bell" aria-hidden="true"></span>&nbsp; Tout <span class="badge">14</span></a>
				<a href="#" class="list-group-item"><span class="glyphicon glyphicon-book" aria-hidden="true"></span>&nbsp; Publication <span class="badge">9</span></a>
				<a href="#" class="list-group-item"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp; Équipe <span class="badge">1</span></a>
				<a href="#" class="list-group-item"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; Utilisateur <span class="badge">4</span></a>
			</div>
		</nav>
	</div>
	<div class="col-md-9">
		<div class="alert alert-info alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<span class="glyphicon glyphicon-alert" aria-hidden="true"></span>&nbsp; Aucun résultat...
		</div>

		<div class="search-results">
			<div class="panel panel-default panel-publication">
				<div class="panel-heading">
					<div class="row">
						<div class="col-sm-11 col-xs-9">
							<h3 class="panel-title"><span class="hide-overflow"><span class="glyphicon glyphicon-headphones" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Musique"></span>&nbsp; Panel title</span></h3>
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

			<div class="panel panel-default panel-result-element">
				<div class="panel-body">
					<h3 class="panel-title"><span class="glyphicon glyphicon-user" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Utilisateur"></span>&nbsp; <a href="#">Aboubacar Bessenga</a></h3>
				</div>
			</div>

			<div class="panel panel-default panel-result-element">
				<div class="panel-body">
					<h3 class="panel-title"><span class="glyphicon glyphicon-list-alt" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Équipe"></span>&nbsp; <a href="#">Informatique</a></h3>
				</div>
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