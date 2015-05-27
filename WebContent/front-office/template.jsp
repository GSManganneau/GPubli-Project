<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!Doctype html>
<html lang="fr">
<head>
<title>GPubli</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="front-office/css/bootstrap.css">
<link rel="stylesheet" href="front-office/css/jquery-ui.css">
<link rel="stylesheet" href="front-office/css/main.css">
<c:if test="${!empty cssContent }">
	<link rel="stylesheet"
		href="front-office/css/<c:out value="${cssContent}"/>">
</c:if>
<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
</head>
<body>
	<header>
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar-gpubli">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"> GPubli </a>
				</div>

				<div class="collapse navbar-collapse" id="navbar-gpubli">
					<form class="navbar-form navbar-left" role="search" method="get"
						action="Search">
						<div class="input-group custom-search-form">
							<input type="text" id="tags" class="form-control" name="search"
								placeholder="Search..."> <span class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
								</button>
							</span>
						</div>
					</form>

					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false"> <span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><span class="glyphicon glyphicon-user"
										aria-hidden="true"></span>&nbsp; Profil</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-cog"
										aria-hidden="true"></span>&nbsp; Paramètres</a></li>
								<li class="divider"></li>
								<li><a href="#"><span
										class="glyphicon glyphicon-log-in" aria-hidden="true"></span>&nbsp;
										Déconnexion</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<div id="content">
		<div class="container">
			<jsp:include page="${content}" />

		</div>
	</div>

	<footer>

		<div class="row">
			<div class="col-md-6">
				<ul class="list-inline">
					<li>© 2015 GPubli</li>
					<li><a href="#">Conditions</a></li>
					<li><a href="#">Confidentialité</a></li>
					<li><a href="#">Sécurité</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
			<div class="col-md-6">
				<ul class="list-inline text-right">
					<li><a href="#">À propos</a></li>
					<li><a href="#">Blog</a></li>
				</ul>
			</div>
		</div>
	</footer>

	<script src="front-office/js/jquery-1.11.2.js"></script>
	<script src="front-office/js/jquery-ui.js"></script>
	<script>
		$(function() {

			$('#tags').keypress(function() {
				$.ajax({
					url : "Auto",
					type : "post",
					data : '',
					success : function(data) {
						$("#tags").autocomplete({
							source : data
						});

					},
					error : function(data, status, er) {
						console.log(data + "_" + status + "_" + er);
					},

				});

			});

		});
	</script>
	<script src="front-office/js/jquery-1.11.3.js"></script>
	<script src="front-office/js/bootstrap.js"></script>
	<script src="front-office/js/main.js"></script>
	<c:if test="${!empty jsContent }">
		<script src="front-office/js/<c:out value="${jsContent}"/>"></script>
	</c:if>
</body>
</html>