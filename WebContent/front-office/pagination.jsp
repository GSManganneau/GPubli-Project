<jsp:directive.page contentType="text/html;charset=UTF-8" />
<c:if test="${paginate.currentPageNumber > 1}">
	<ul class="pager">
		<li class="previous"><a href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${paginate.previousPageNumber }"/>"><span aria-hidden="true">&larr;</span> Précédent</a></li>
	<li>
		<div class="pager-select">
			<select class="form-control">
	<c:forEach var="i" begin="1" end="${paginate.numberOfPages }" step="1">

						
			<option value=<c:out value="${i}"/><c:if test="${i== paginate.currentPageNumber }"> selected="selected"</c:if> /><c:out value="${i}"/></option>

	</c:forEach>
			</select>
		</div>
	</li>
		<c:if test="${paginate.nextPageNumber != 0 }">
			
				<li class="next"><a href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${paginate.nextPageNumber }"/>">Suivant <span aria-hidden="true">&rarr;</span></a></li>
		</c:if>
	</ul>
</c:if>

<c:if
	test="${paginate.nextPageNumber != 0  && paginate.currentPageNumber==1 }">
	<ul class="pager">
		<li>
			<div class="pager-select">
				<select class="form-control" data-href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=">
		<c:forEach var="i" begin="1" end="${paginate.numberOfPages }" step="1">

							
								<option value=<c:out value="${i}"/>><c:out value="${i}"/></option>

		</c:forEach>
		
				</select>
			</div>
		</li>

		<li class="next"><a href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${paginate.nextPageNumber }"/>">Suivant <span aria-hidden="true">&rarr;</span></a></li>

	</ul>
	
</c:if>

