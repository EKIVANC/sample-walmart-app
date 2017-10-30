<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>
<title>Walmart Sample Application</title>
</head>
<body>
	<jsp:include page="../views/header.jspx" />
	<h1>Product Listing:</h1>
	<hr>

	<div class="form">
		<form action="hello" method="post" onsubmit="return validate()">

			<c:if test="${not empty errorMessage}">
				<h4>
					<b>Something bad happened, Please Try Again Later, </b> <b>here
						is the detail:</b> <br /> <b style="color: red; font-weight: bold;">${errorMessage}</b>
				</h4>
			</c:if>
			<br />

			<c:if test="${not empty lists}">

				<div class="divTable">
					<div class="divTableBody">

						<c:forEach var="listValue" items="${lists}" varStatus="loop">

							<c:if test="${(loop.count-1) % 4 == 0}">
								<div class="divTableRow">
							</c:if>

							<div class="card" onclick="location.href='productDetail/${listValue.itemId}';">
								<img class="imageOfCard" src="${listValue.mediumImage}" alt="Avatar">
								<div class="container">
									<h4>
										<b>${listValue.name}</b>
									</h4>
									<h4>
										<b name="itemId">${listValue.itemId}</b>
									</h4>
									<p>\$${listValue.salePrice}</p>
									<a href="productDetail/${listValue.itemId}">View Detail</a>
									<%-- <p>${loop.count}</p>
							<p>*******</p> <p>${(loop.count) % 4}</p> --%>
								</div>
							</div>
							<c:if test="${(loop.count) % 4 == 0}">
					</div>
			</c:if>
			</c:forEach>
	</div>
	</div>

	<div id="pagination">

		<c:url value="/" var="prev">
			<c:param name="page" value="${page-1}" />
		</c:url>
		<c:if test="${page > 1}">
			<a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
		</c:if>

		<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
			<c:choose>
				<c:when test="${page == i.index}">
					<span>${i.index}</span>
				</c:when>
				<c:otherwise>
					<c:url value="/" var="url">
						<c:param name="page" value="${i.index}" />
					</c:url>
					<a href='<c:out value="${url}" />'>${i.index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:url value="/" var="next">
			<c:param name="page" value="${page + 1}" />
		</c:url>
		<c:if test="${page + 1 <= maxPages}">
			<a href='<c:out value="${next}" />' class="pn next">Next</a>
		</c:if>
	</div>

	</c:if>
	
	</form>
	</div>

	<jsp:include page="../views/footer.jspx" />
</body>
</html>