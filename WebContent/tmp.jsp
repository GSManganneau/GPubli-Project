<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script type="text/javascript" src="cityTags.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="Search">
	<div class="ui-widget">
		<label for="tags">Recherche :</label> <input type="text" id="tags"
			name="search" size="20" maxlength="20" /> <input type="submit"
			value="Go" />
	</div>
	</form>
</body>
</html>