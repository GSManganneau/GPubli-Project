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
				<a href="Search?search=<c:out value="${field}" />" class="list-group-item"><span
					class="glyphicon glyphicon-bell" aria-hidden="true"></span>&nbsp;
					Tout <span class="badge"><c:out value="${ AuthorCount.count + TeamCount.count + PublicationCount.count }" /></span></a>
					

					<a href="SearchPublication?search=<c:out value="${field}" />"
					class="list-group-item"><span class="glyphicon glyphicon-book"
					aria-hidden="true"></span>&nbsp; Publication <span class="badge"><c:out value="${ PublicationCount.count }" /></span></a>

					
					
					<a href="SearchTeam?search=<c:out value="${field}" />" class="list-group-item active"><span
					class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp;
					Équipe <span class="badge"><c:out value="${ TeamCount.count }" /></span></a> 

					
 				
					<a href="SearchAuthor?search=<c:out value="${field}" />"
					class="list-group-item"><span class="glyphicon glyphicon-user"
					aria-hidden="true"></span>&nbsp; Utilisateur <span class="badge"><c:out value="${ AuthorCount.count }" /></span></a>

			</div>
		</nav>
	</div>
	<div class="col-md-9">
		<div class="publications">
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
				<li><select class="form-control">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
				</select></li>
				<li class="next"><a href="#">Suivant <span
						aria-hidden="true">&rarr;</span></a></li>
			</ul>
		</nav>
	</div>
</div>