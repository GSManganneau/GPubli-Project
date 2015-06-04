
<p>Formulaire d'ajout de publication
<form action="addpublications" method="post">
<label>Titre</label><input type=text name="title" id="title" required><br><br>
<label>Résumé de l'article</label> <input type=text name="resume" id="resume" required><br><br>
<label>Date</label><input type=text name="date" id ="date" required><br><br>
<label>Type de la publication</label>
<select id="list" name="typeId" required >
<option>vide
</option>
<c:forEach var="type" items="${types}">
<option value=<c:out value="${type.typeId}"/>> <c:out value="${type.typeName }"/>
</option> 
</c:forEach>
</select><br><br>
<button type=submit >Soumettre</button>
</form>



