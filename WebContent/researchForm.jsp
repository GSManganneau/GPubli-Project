<html lang="fr">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="AdvancedResearch">
		<p>Nom de la publi: <input type="text" name="publiName"></p>
		<p>Resume: <input type="text" name="resume"></p>
		<p>Date from: <input type="date" name="dateFrom"></p>
		<p>Date to: <input type="date" name="dateTo"></p>
		 Auteurs:<select multiple name="authors">
		 	 <option value="1">1</option>
		 	 <option value="2">2</option>
		 	 <option value="3">3</option>
			 <option value="4">4</option>
		</select> 
		<p>Type: <input type="number" name="type"></p>
		<p>Team: <input type="number" name="team"></p>
		<input type="submit">			
	</form>
</body>
</html>