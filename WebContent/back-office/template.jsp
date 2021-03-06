<jsp:directive.page contentType="text/html;charset=UTF-8" />
<!doctype html>
<html lang="fr">
	<head>
		<title>GAdmin</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="back-office/libraries/bootstrap-3.3.4/css/bootstrap.css">
		<link rel="stylesheet" href="back-office/libraries/font-awesome-4.3/css/font-awesome.css">
		<link rel="stylesheet" href="back-office/libraries/fontawesome-iconpicker/css/fontawesome-iconpicker.css">
		<link rel="stylesheet" href="back-office/libraries/selectize-0.12.1/css/selectize.bootstrap3.css">
		<c:if test="${!empty cssContent }">
			<link rel="stylesheet" href="front-office/css/<c:out value="${cssContent}"/>">
		</c:if>
		<link rel="stylesheet" href="back-office/css/main.css">
		<!-- <link rel="stylesheet" href="back-office/css/{{content}}.css"> -->

		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
		<div id="wrapper">
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-gpubli-admin">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="AdminHome">
						<svg version="1.1" id="logo-gadmin" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" height="30px" fill="#777" viewBox="0 0 907.1 907.1" enable-background="new 0 0 907.1 907.1" xml:space="preserve">
							<path stroke="#000000" stroke-miterlimit="10" d="M400.5,636.6c-29-0.3-53,23-53.3,52c-0.3,29,23,53,52,53.3c29,0.3,53-23,53.3-52
								C452.9,660.8,429.6,636.9,400.5,636.6z"/>
							<path stroke="#000000" stroke-miterlimit="10" d="M665.3,442.2c-35.5,3-62,34.3-59,69.8c3,35.5,34.3,62,69.8,59
								c35.5-3,62-34.3,59-69.8C732.1,465.6,700.8,439.2,665.3,442.2z"/>
							<path stroke="#000000" stroke-miterlimit="10" d="M406.9,318.9c0-43.5-35.4-79-79-79c-43.5,0-79,35.4-79,79c0,43.5,35.4,79,79,79
								C371.4,397.9,406.9,362.4,406.9,318.9z"/>
							<path stroke="#000000" stroke-miterlimit="10" d="M453.5,0.5c-250.2,0-453,202.8-453,453s202.8,453,453,453s453-202.8,453-453
								S703.8,0.5,453.5,0.5z M213.7,494.6c-8.1,6.4-19.6,5.8-26.9-1.5L153,459.3c-7.2-7.3-7.9-18.8-1.5-26.9l19.6-24.7c-6.9-12.2-12.3-25.1-16.2-38.6l-31-3.6c-10.2-1.2-17.9-9.8-17.9-20.1v-47.8c0-10.2,7.7-18.9,17.9-20.1l29.4-3.4c3.7-14.7,9.3-28.9,16.6-42.2l-18.4-23.3c-6.4-8.1-5.8-19.6,1.5-26.9l33.8-33.8c7.3-7.2,18.8-7.9,26.9-1.5l22,17.4c14.1-8.4,29.2-14.8,45-19l3.2-27.4c1.2-10.2,9.8-17.9,20.1-17.9h47.8c10.2,0,18.9,7.7,20.1,17.9l3.2,27.4c15.4,4.2,30.2,10.3,43.9,18.4l21.2-16.8c8.1-6.4,19.6-5.8,26.9,1.5l33.7,33.7c7.2,7.3,7.9,18.8,1.5,26.9l-17.3,21.8c7.4,13.1,13.1,27.1,17,41.8l28.1,3.3c10.2,1.2,17.9,9.8,17.9,20.1v47.8c0,10.2-7.7,18.9-17.9,20.1l-28.5,3.3c-4,14.8-10,29-17.7,42.2l18.5,23.4c6.4,8.1,5.8,19.6-1.5,26.9L467,493.2c-7.3,7.2-18.8,7.9-26.9,1.5l-23.8-18.8c-13.5,7.6-27.9,13.4-43,17.4l-3.5,30.5c-1.2,10.2-9.8,17.9-20.1,17.9h-47.8c-10.2,0-18.9-7.7-20.1-17.9l-3.7-31.6c-14-4-27.4-9.7-40.1-17L213.7,494.6z M546.5,701.6c-0.1,10.2-7.8,18.6-17.9,19.7l-13.3,1.4c-2.8,9.8-6.9,19.2-12.2,28l8.6,11.1c6.2,8.1,5.4,19.4-1.8,26.6l-14.5,14.2c-7.3,7.1-18.6,7.6-26.6,1.2l-11.2-9c-9.1,5-18.7,8.7-28.8,11.2l-1.8,14.6c-1.3,10.1-9.9,17.6-20.1,17.4l-20.2-0.2c-10.2-0.1-18.6-7.8-19.7-17.9l-1.6-15.4c-9.3-2.7-18.2-6.6-26.6-11.6l-11.9,9.2c-8.1,6.2-19.4,5.4-26.6-1.8l-14.2-14.5c-7.1-7.3-7.6-18.6-1.2-26.6l9.6-11.8c-4.6-8.2-8.1-16.8-10.6-25.8l-14.9-1.9c-10.1-1.3-17.6-9.9-17.4-20.1l0.2-20.2c0.1-10.2,7.8-18.6,17.9-19.7l14-1.4c2.6-9.8,6.5-19.2,11.4-28l-8.6-11c-6.2-8.1-5.4-19.4,1.8-26.6l14.6-14.2c7.3-7.1,18.6-7.6,26.6-1.2l10,8.2c9.4-5.4,19.6-9.6,30.2-12.3l1.6-12.5c1.3-10.1,9.9-17.6,20.1-17.4l20.2,0.2c10.2,0.1,18.6,7.8,19.7,17.9l1.3,12.6c10.2,2.9,20,7.1,29.1,12.6l9.7-7.4c8.1-6.2,19.4-5.4,26.6,1.8l14.2,14.5c7.1,7.3,7.6,18.6,1.2,26.6l-8.1,9.9c4.8,8.8,8.5,18.2,11,28l13,1.7c10.1,1.3,17.6,9.9,17.4,20.1L546.5,701.6z M835.6,529.9l-20,4.1c-2.2,12.3-6.2,24.3-11.5,35.7l14.6,15.5c7,7.4,7.3,18.8,0.7,26.6l-21.3,25.2c-6.6,7.8-17.8,9.4-26.3,3.8l-18.2-12c-10.5,7.1-21.8,12.9-33.8,17.1l-0.7,22.1c-0.3,10.2-8.2,18.4-18.3,19.3l-32.9,2.8c-10.1,0.8-19.3-6.1-21.3-16l-4.6-22.6c-11.7-2.2-23-6-33.8-11l-16.5,15.4c-7.4,7-18.8,7.3-26.6,0.7L540,635.2c-7.8-6.6-9.4-17.8-3.8-26.3l12.6-19c-6.5-9.5-11.8-19.7-15.9-30.4l-22.5-0.7c-10.2-0.3-18.4-8.2-19.3-18.3l-2.8-32.9c-0.8-10.1,6.1-19.3,16-21.3l20.8-4.2c2.1-12.2,5.7-24.2,10.7-35.5l-14.6-15.5c-7-7.4-7.3-18.8-0.7-26.6l21.3-25.4c6.6-7.8,17.8-9.4,26.3-3.8l16.6,11c10.9-7.8,22.8-14.1,35.4-18.6l0.6-19.5c0.3-10.2,8.2-18.4,18.3-19.3l32.9-2.8c10.1-0.8,19.3,6.1,21.3,16l3.9,19.2c12.9,2.3,25.4,6.3,37.1,12l13.9-13c7.4-7,18.8-7.3,26.6-0.7l25.2,21.3c7.8,6.6,9.4,17.9,3.6,26.4l-11,16.5c7,10.2,12.6,21.3,16.7,33l20.1,0.6c10.2,0.3,18.4,8.2,19.3,18.3l2.8,32.9C852.4,518.7,845.5,527.9,835.6,529.9z"/>
						</svg>
						GAdmin
					</a>
				</div>
				<ul class="nav navbar-right top-nav">
					<li>
						<a href="#"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>&nbsp; Déconnexion</a>
					</li>
				</ul>
				<div class="collapse navbar-collapse" id="navbar-gpubli-admin">
					<ul class="nav navbar-nav side-nav">
						<li>
							<a href="AdminHome"><span class="glyphicon glyphicon-signal" aria-hidden="true"></span>&nbsp; Dashboard</a>
						</li>
						<li>
							<a href="Types"><span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>&nbsp; Types</a>
						</li>
						<li>
							<a href="Teams"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp; Équipes</a>
						</li>
						<li>
							<a href="Users"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; Utilisateurs</a>
						</li>
					</ul>
				</div>
			</nav>

			<div id="page-wrapper">
				<div class="container-fluid">
					<jsp:include page="${content}" />
				</div>
			</div>
		</div>

		<script src="back-office/libraries/jquery-1.11.3/jquery-1.11.3.js"></script>
		<script src="back-office/libraries/bootstrap-3.3.4/js/bootstrap.js"></script>
		<script src="back-office/libraries/selectize-0.12.1/js/standalone/selectize.js"></script>
		<script src="back-office/libraries/stupidtable/stupidtable.js"></script>
		<script src="back-office/libraries/fontawesome-iconpicker/js/fontawesome-iconpicker.js"></script>
		<script src="back-office/libraries/jquery-validation-1.13.1/jquery.validate.js"></script>
		<script src="back-office/libraries/jquery-validation-1.13.1/additional-methods.js"></script>
		<script src="back-office/libraries/jquery-validation-1.13.1/localization/messages_fr.js"></script>
		<c:if test="${!empty jsContent }">
			<script src="front-office/js/<c:out value="${jsContent}"/>"></script>
		</c:if>
		<script src="back-office/js/jquery-validation-checkform.js"></script>
		<script src="back-office/js/main.js"></script>
		<!-- <script src="back-office/js/{{content}}.js"></script> -->
	</body>
</html>