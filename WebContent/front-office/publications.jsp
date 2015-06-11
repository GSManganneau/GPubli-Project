<jsp:directive.page contentType="text/html;charset=UTF-8" />
		<c:forEach var="publication" items="${publications}">
		EE
		<div class="publications">
			<div class="panel panel-default panel-publication">
				<div class="panel-heading">
					<div class="row">
						<div class="col-sm-11 col-xs-9">
							<h3 class="panel-title"><span class="hide-overflow"><i class="fa <%-- <c:out value="${publication.type.iconeName}"/> --%>" data-toggle="tooltip" data-placement="bottom" title=""></i>&nbsp;<c:out value="${publication.title}"/></span></h3>
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
						<p class="authors col-lg-10 col-sm-9"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; <a href="#"><c:out value="${publication.author.firstname }"/> <c:out value="${publication.author.lastname }" /></a> 
							<c:forEach var="coAuthor" items="${publication.coAuthors }">
							<a href="#">| <c:out value="${coAuthor.firstname }"/> <c:out value="${coAuthor.lastname }" /></a>
							</c:forEach>
							</p>
						<p class="date col-lg-2 col-sm-3 text-right"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>&nbsp; <em style="color: #555;"><c:out value="${publication.date }"/></em></p>
					</div>
					<hr>
					<p class="resume text-justify"><c:out value="${publication.resume}"/></p>
					<hr class="detail">
					<p class="text-center detail"><a href="#">Détail de la publication</a></p>
				</div>
				<table class="table table-striped table-bordered" style="display: none;">
					<c:forEach var="attribute" items="${publication.type.attributes }">
					<tr>
						<td class="text-right col-sm-3"><strong><c:out value="${attribute.attributeName }"/></strong></td><td class="col-sm-9"><c:out value="${attribute.datas }"/></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		</c:forEach>
 		