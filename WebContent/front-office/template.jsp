<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="fr">
	<head>
		<title>GPubli</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="front-office/libraries/bootstrap-3.3.4/css/bootstrap.css">
		<link rel="stylesheet" href="front-office/libraries/font-awesome-4.3/css/font-awesome.css">
		<link rel="stylesheet" href="front-office/libraries/selectize-0.12.1/css/selectize.bootstrap3.css">
		<link rel="stylesheet" href="front-office/libraries/bootstrap-datetimepicker-4.7.14/css/bootstrap-datetimepicker.css">

		<link rel="stylesheet" href="front-office/css/main.css">
		<c:if test="${!empty cssContent }">
			<link rel="stylesheet" href="front-office/css/<c:out value="${cssContent}"/>">
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
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-gpubli">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="?page=index">
							<svg version="1.1" id="logo-gpubli" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" height="30px" fill="#777" viewBox="0 0 1112.6 1112.6" enable-background="new 0 0 1112.6 1112.6" xml:space="preserve">
								<path d="M556.3,0C249.1,0,0,249.1,0,556.3s249.1,556.3,556.3,556.3s556.3-249.1,556.3-556.3S863.5,0,556.3,0z M194.3,825.3l87-479l63,12l-71,393l378,157L194.3,825.3z M335.3,721.3l85-476l72,29l-72,403l264,190L335.3,721.3z M477.3,645.3l86-475l66,48l-75,414l194.5,209L477.3,645.3z M834,855.3l-221-234l84-468l219,257L834,855.3z">
							</svg>
							GPubli
						</a>
					</div>

					<div class="collapse navbar-collapse" id="navbar-gpubli">
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>&nbsp; Outils <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="?page=add-publication"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp; Ajouter une publication</a></li>
									<li><a href="?page=advanced-search"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp; Recherche avancée</a></li>
									<li><a href="?page=statistics"><span class="glyphicon glyphicon-stats" aria-hidden="true"></span>&nbsp; Statistiques</a></li>
								</ul>
							</li>

							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;<c:out value="${ session.getAttribute(\"name\")}"/> <c:out value="${ session.getAttribute(\"firstname\") }"/> <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; Profil</a></li>
									<li><a href="?page=parameters-profile"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp; Paramètres</a></li>
									<li class="divider"></li>
									<li><a href="#"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>&nbsp; Déconnexion</a></li>
								</ul>
							</li>
						</ul>

						<form class="navbar-form">
							<div class="form-group" style="display: inline;">
								<div class="input-group" style="display: table;">
									<span class="input-group-btn" style="width: 1%;">
										<button class="btn btn-default" type="submit">
											<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
										</button>
									</span>
									<input type="text" class="form-control" placeholder="Chercher...">
								</div>
							</div>
						</form>
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
			<div class="container">
				<div class="row">
					<div class="col-sm-8">
						<ul class="list-inline">
							<li>© 2015 GPubli</li>
							<li><a href="#">Conditions</a></li>
							<li><a href="#">Confidentialité</a></li>
							<li><a href="#">Sécurité</a></li>
							<li><a href="#">Contact</a></li>
						</ul>
					</div>
					<div class="col-sm-4">
						<ul class="list-inline text-right">
							<li><a href="#">À propos</a></li>
							<li><a href="#">Blog</a></li>
						</ul>
					</div>
				</div>
			</div>
		</footer>

		<script src="front-office/libraries/jquery-1.11.3/jquery-1.11.3.js"></script>
		<script src="front-office/libraries/bootstrap-3.3.4/js/bootstrap.js"></script>
		<script src="front-office/libraries/selectize-0.12.1/js/standalone/selectize.js"></script>
		<script src="front-office/libraries/stupidtable/stupidtable.js"></script>
		<script src="front-office/libraries/moment-2.10.3/moment-with-locales.js"></script>
		<script src="front-office/libraries/bootstrap-datetimepicker-4.7.14/js/bootstrap-datetimepicker.js"></script>
		<script src="front-office/libraries/jquery-validation-1.13.1/jquery.validate.js"></script>
		<script src="front-office/libraries/jquery-validation-1.13.1/additional-methods.js"></script>
		<script src="front-office/libraries/jquery-validation-1.13.1/localization/messages_fr.js"></script>
		<script src="front-office/libraries/jquery.dotdotdot-1.7.3/jquery.dotdotdot.js"></script>

		<script src="front-office/js/jquery-validation-checkform.js"></script>
		<script src="front-office/js/main.js"></script>
		<script src="front-office/js/addPublicationForm.js"></script>

		<c:if test="${!empty jsContent }">
			<script src="front-office/js/<c:out value="${jsContent}"/>"></script>
		</c:if>
	</body>
</html>