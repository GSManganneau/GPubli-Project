<html lang="fr">
<head>
<meta charset="utf-8">
<title>Autocomplete Example</title>
<link rel="stylesheet" href="css/jquery-ui.css">
<script src="js/jquery-1.11.2.js"></script>
<script src="js/jquery-ui.js"></script>
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
</head>
<body>
	<form method="get" action="Search">
		<div class="ui-widget">
			<label for="tags"> Recherche :</label> <input type="text" id="tags"
				name="search" /> <input type="submit"
				value="Go" />
		</div>
	</form>
</body>
</html>