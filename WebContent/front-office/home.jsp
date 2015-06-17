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
	<jsp:include page="leftMenu.jsp"/>

	<div class="col-md-9">
		<jsp:include page="actionInformation.jsp"/>
		<jsp:include page="tools.jsp"/>
		<jsp:include page="publications.jsp"/> 
 		<nav>
			<jsp:include page="pagination.jsp" /> 
		</nav>
	</div>
</div>

<jsp:include page="delete-modal.jsp"/> 