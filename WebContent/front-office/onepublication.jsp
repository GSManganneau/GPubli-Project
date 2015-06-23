<jsp:directive.page contentType="text/html;charset=UTF-8" />

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="home">Accueil</a></li>
			<li class="active">Publication</li>
		</ol>
		<hr>
	</div>
</div>

<div class="row">
	<div class="col-md-9 col-md-offset-3">
		<jsp:include page="publications.jsp"/>
	</div>
</div>

<jsp:include page="delete-modal.jsp"/>