<jsp:directive.page contentType="text/html;charset=UTF-8" />
<c:set var="parameter" value="${paginate.parameter}"/>
<c:if test="${paginate.currentPageNumber > 1}">
	<nav>
		<ul class="pager">
		<c:if test="${ null != parameter}">
			<li class="previous"><a href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${paginate.previousPageNumber }"/>&<c:out value="${parameter }"/>=<c:out value="${parameterValue }"/>"><span aria-hidden="true">&larr;</span> Précédent</a></li>
		</c:if>	
		<c:if test="${ null== parameter }">
			<li class="previous"><a href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${paginate.previousPageNumber }"/>"><span aria-hidden="true">&larr;</span> Précédent</a></li>
		</c:if>	
			<li>
				<div class="pager-select">
				<c:if test="${ null== parameter }">
					<select class="form-control" data-href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=">
				</c:if>
				<c:if test="${null != parameter}">
		<select class="form-control" data-href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?<c:out value="${parameter }"/>=<c:out value="${parameterValue}"/>&page=">
				</c:if>
						<c:forEach var="i" begin="1" end="${paginate.numberOfPages }" step="1">		
							<option value=<c:out value="${i}"/><c:if test="${i== paginate.currentPageNumber }"> selected="selected"</c:if> /><c:out value="${i}"/></option>
						</c:forEach>
					</select>
				</div>
			</li>

			<c:if test="${paginate.nextPageNumber != 0 }">
			<c:if test="${ null != parameter }">
<li class="next"><a href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${paginate.nextPageNumber }"/>&<c:out value="${parameter }"/>=<c:out value="${parameterValue}"/>">Suivant <span aria-hidden="true">&rarr;</span></a></li>
			</c:if>
			<c:if test="${ null== parameter }">
				<li class="next"><a href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${paginate.nextPageNumber }"/>">Suivant <span aria-hidden="true">&rarr;</span></a></li>
			</c:if>
			</c:if>
		</ul>
	</nav>
</c:if>

<c:if
	test="${paginate.nextPageNumber != null  && paginate.currentPageNumber==1 }">
	<nav>
		<ul class="pager">
			<li>
				<div class="pager-select">
					<c:if test="${ null==parameter  }">
					<select class="form-control" data-href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=">
				</c:if>
				<c:if test="${null != parameter}">
					<select class="form-control" data-href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?<c:out value="${parameter }"/>=<c:out value="${parameterValue}"/>&page=">
				</c:if>
						<c:forEach var="i" begin="1" end="${paginate.numberOfPages }" step="1">
							<option value=<c:out value="${i}"/>><c:out value="${i}"/></option>
						</c:forEach>
			
					</select>
				</div>
			</li>
 <c:if test="${paginate.nextPageNumber != 0 }">
			<c:if test="${ null != parameter }">
				<li class="next"><a href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${paginate.nextPageNumber }"/>&<c:out value="${parameter }"/>=<c:out value="${parameterValue}"/>">Suivant<span aria-hidden="true">&rarr;</span></a></li>
			</c:if>
			<c:if test="${ null== parameter}">
				<li class="next"><a href="/GPubli-Project/<c:out value="${paginate.servlet }"/>?page=<c:out value="${paginate.nextPageNumber }"/>">Suivant <span aria-hidden="true">&rarr;</span></a></li>
			</c:if>
			</c:if>
		</ul>
	</nav>
</c:if>