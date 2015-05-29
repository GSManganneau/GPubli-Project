<h2>Resultats de la recherche</h2>

<h3>Auteurs</h3>
<ul>
	<c:forEach var="Author" items="${Authors}">
		<li><c:out value="${ Author.firstname }" /> <c:out
				value="${ Author.lastname }" /></li>
	</c:forEach>
</ul>

<h3>Publications</h3>
<ul>
	<c:forEach var="Publication" items="${Publications}">
		<li><c:out value="${ Publication.title }" /></li>
		<li><c:out value="${ Publication.resume }" /></li>
	</c:forEach>
</ul>

<h3>Equipes</h3>
<ul>
	<c:forEach var="Team" items="${Teams}">
		<li><c:out value="${ Team.name }" /></li>
	</c:forEach>
</ul>

<div class="page-header">
	<h1>Resultats pour <small>"machin truc"</small></h1>
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
		<div class="publications">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="row">
						<div class="col-sm-11 col-xs-9">
							<h3 class="panel-title"><span class="glyphicon glyphicon-headphones" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Musique"></span>&nbsp; Panel title</h3>
						</div>

						<div class="col-sm-1 col-xs-3 text-right">
							<div class="btn-group">
								<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></button>
								<ul class="dropdown-menu dropdown-menu-right" role="menu">
									<li><a href="#"><span class="glyphicon glyphicon-duplicate" aria-hidden="true"></span>&nbsp; Export Bibtex</a></li>
									<li><a href="#"><span class="glyphicon glyphicon-text-size" aria-hidden="true"></span>&nbsp; Export Texte</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-body">
					Convenit coetuum sunt lapsorum incondita gloriosam ac non convenit convenit ubi vieturo splendor splendor <a href="#">convenit ad</a> hic errores beate non errores tamquam esse errores ubi sed enim coetuum ratione ut convenit patriam reputantium ante coetuum non enim laeditur <a href="#">coetuum</a> vieturo paucorum docet enim ac sed Simonides convenit vieturo enim lyricus ut lasciviam paucorum sunt <a href="#">esse ad</a> reputantium ad errores ubi alia <a href="#">lyricus paucorum</a> perfecta ratione nati patriam esse sed errores.
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="row">
						<div class="col-sm-11 col-xs-9">
							<h3 class="panel-title"><span class="glyphicon glyphicon-lock" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="Conférence"></span>&nbsp; Panel title</h3>
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
					Ad haec abstergendae blanditiis haec lenire suam Caesar Caesar obitum anxia contemplans se properaret statione poterit et lenire quod se uxorem vi vi suspicionis maritus obitum saepe quid tandem abstergendae <a href="#">venire licet</a> tandem ambigeret cum blanditiis saepe properaret est haec fultum absumpta contemplans cruentum ad profecta multis uxorem uxorem <a href="#">Constantius</a> spe appellatur abstergendae qua cruentum obitum profecta post ut cruentum obitum quae se blanditiis vi quae blanditiis poterit et anxia quae febrium moliretur venire desideratam introisset blanditiis <a href="#">causa cogitatione eius</a> blanditiis Caesar accitus quae tamen post cum est post properaret se anxia profecta ambigeret tamen suam Gallicanos uxorem <a href="#">existimabat</a> fiduciam. Gallus ferociens multa narrare narrare pastus multa refert est lenius Gallus professione quae huius professione scrutabatur leo scrutabatur ferociens non evitandum singula refert necem me est quorum necem ut refert necem ut modi est leo lenius.
				</div>
			</div>
		</div>

		<nav>
			<ul class="pager">
				<li class="previous"><a href="#"><span aria-hidden="true">&larr;</span> Précédent</a></li>
				<li>
					<select class="form-control">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</li>
				<li class="next"><a href="#">Suivant <span aria-hidden="true">&rarr;</span></a></li>
			</ul>
		</nav>
	</div>
</div>